package com.nullinnix.adfootages

import android.graphics.Bitmap
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import com.nullinnix.adfootages.ui.theme.Background
import com.nullinnix.adfootages.ui.theme.DarkBlue

data class SelectedSignUpData(val prompt: String, val image: Bitmap)
data class CellData(val image: Bitmap, val alignment: Alignment)
const val allowedKeys = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 ()-"
val reloadCells = MutableLiveData(true)

fun corners(
    radius: Dp = 15.dp
) = RoundedCornerShape(
    topStart = CornerSize(radius),
    topEnd = CornerSize(radius),
    bottomEnd = CornerSize(radius),
    bottomStart = CornerSize(radius)
)

@Composable
fun screenHeight(): Int {
    return LocalConfiguration.current.screenHeightDp
}

@Composable
fun screenWidth(): Int {
    return LocalConfiguration.current.screenWidthDp
}

val diagonalFromLeft = listOf(0, 4, 8)
val diagonalFromRight = listOf(2, 4, 6)

val vertical1 = listOf(0, 3, 6)
val vertical2 = listOf(1, 4, 7)
val vertical3 = listOf(2, 5, 8)

val horizontal1 = listOf(0, 1, 2)
val horizontal2 = listOf(3, 4, 5)
val horizontal3 = listOf(6, 7, 8)

val edgesClockWise = listOf(0, 2, 8, 6)
val edgesCounterClockWise = listOf(2, 0, 6, 8)

val cross = listOf(1, 3, 4, 5, 7)

val center = listOf(4)

val getSpawnPatterns = {
    val crossV1andV3 = mutableListOf<Int>()
    crossV1andV3.addAll(cross)
    crossV1andV3.addAll(vertical1)
    crossV1andV3.addAll(vertical3)

    val v1andV2andV3 = mutableListOf<Int>()
    v1andV2andV3.addAll(vertical1)
    v1andV2andV3.addAll(vertical2.reversed())
    v1andV2andV3.addAll(vertical3)

    val h1andH2andH3 = mutableListOf<Int>()
    h1andH2andH3.addAll(horizontal1)
    h1andH2andH3.addAll(horizontal2.reversed())
    h1andH2andH3.addAll(horizontal3)

    val v1andV2andV3Reversed = mutableListOf<Int>()
    v1andV2andV3Reversed.addAll(vertical3)
    v1andV2andV3Reversed.addAll(vertical2)
    v1andV2andV3Reversed.addAll(vertical1)

    val h1andH2andH3Reversed = mutableListOf<Int>()
    h1andH2andH3Reversed.addAll(horizontal3)
    h1andH2andH3Reversed.addAll(horizontal2)
    h1andH2andH3Reversed.addAll(horizontal1)

    val edgesAndV2AndH2 = mutableListOf<Int>()
    edgesAndV2AndH2.addAll(edgesCounterClockWise)
    edgesAndV2AndH2.addAll(vertical2)
    edgesAndV2AndH2.addAll(horizontal2)

    val letterTAndFill = mutableListOf<Int>()
    letterTAndFill.addAll(horizontal1)
    letterTAndFill.addAll(vertical2)
    letterTAndFill.addAll(listOf(3, 5, 6, 8))

    val letterHAndFill = mutableListOf<Int>()
    letterHAndFill.addAll(vertical1)
    letterHAndFill.addAll(vertical3)
    letterHAndFill.addAll(horizontal2)
    letterHAndFill.addAll(vertical2)

    val clockwiseAndCenter = mutableListOf<Int>()
    clockwiseAndCenter.addAll(horizontal1)
    clockwiseAndCenter.addAll(vertical3)
    clockwiseAndCenter.addAll(horizontal3.reversed())
    clockwiseAndCenter.addAll(vertical1.reversed())
    clockwiseAndCenter.addAll(center)

    val diagonalsThenFill = mutableListOf<Int>()
    diagonalsThenFill.addAll(diagonalFromLeft)
    diagonalsThenFill.addAll(diagonalFromRight)
    diagonalsThenFill.addAll(cross)

    listOf(crossV1andV3, v1andV2andV3, h1andH2andH3, v1andV2andV3Reversed, h1andH2andH3Reversed, edgesAndV2AndH2, letterTAndFill, letterHAndFill, clockwiseAndCenter)
}

fun createCells(image: Bitmap): List<CellData>{
    val cellSize = image.width / 3

    return listOf(
        CellData(image = Bitmap.createBitmap(image, 0, 0, cellSize, cellSize), Alignment.TopStart),
        CellData(image = Bitmap.createBitmap(image, cellSize, 0, cellSize, cellSize), Alignment.TopCenter),
        CellData(image = Bitmap.createBitmap(image, cellSize * 2, 0, cellSize, cellSize), Alignment.TopEnd),
        CellData(image = Bitmap.createBitmap(image, 0, cellSize, cellSize, cellSize), Alignment.CenterStart),
        CellData(image = Bitmap.createBitmap(image, cellSize, cellSize, cellSize, cellSize), Alignment.Center),
        CellData(image = Bitmap.createBitmap(image, cellSize * 2, cellSize, cellSize, cellSize), Alignment.CenterEnd),
        CellData(image = Bitmap.createBitmap(image, 0, cellSize * 2, cellSize, cellSize), Alignment.BottomStart),
        CellData(image = Bitmap.createBitmap(image, cellSize, cellSize * 2, cellSize, cellSize), Alignment.BottomCenter),
        CellData(image = Bitmap.createBitmap(image, cellSize * 2, cellSize * 2, cellSize, cellSize), Alignment.BottomEnd),
    )
}

@Composable
fun SliderUtility(currentValue: Long, maxValue: Long, info: String, suffix: String, onChange: (updatedValue: Long) -> Unit){
    var value by remember {
        mutableFloatStateOf(currentValue.toFloat() / 100)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp)
            .clip(corners(15.dp))
            .background(Background)
            .padding(3.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = info, fontWeight = FontWeight.SemiBold, color = DarkBlue)
            Text(text = "${(currentValue)} $suffix", fontWeight = FontWeight.SemiBold, color = DarkBlue)
        }

        Slider(value = value, colors = SliderDefaults.colors(thumbColor = DarkBlue, inactiveTickColor = DarkBlue, activeTickColor = DarkBlue, inactiveTrackColor = DarkBlue, activeTrackColor = DarkBlue), onValueChange = {
            value = it
            onChange((value * maxValue).toLong())
        })
    }
}

fun getPercentage(total: Int, percent: Int): Int {
    return (total * percent) / 100
}

fun getPercent(total: Int, valueFromTotal: Int, getMinimum: Int? = null): Int {
    try {
        return if (getMinimum != null && ((valueFromTotal * 100) / total) <= getMinimum) getMinimum else ((valueFromTotal * 100) / total)
    } catch (e: ArithmeticException) {
        e.printStackTrace()
    }

    return 0
}

fun getPercentage(total: Float, percent: Float): Float {
    try {
        return (total * percent) / 100f
    } catch (e: ArithmeticException) {
        e.printStackTrace()
    }

    return 0f
}

fun getPercent(total: Float, valueFromTotal: Float): Float {
    try {
        return ((valueFromTotal * 100f) / total)
    } catch (e: ArithmeticException) {
        e.printStackTrace()
    }

    return 0f
}