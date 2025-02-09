package com.nullinnix.adfootages

import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import com.nullinnix.adfootages.ui.theme.Black
import com.nullinnix.adfootages.ui.theme.DarkBlue
import com.nullinnix.adfootages.ui.theme.MildTranslucentBlack
import com.nullinnix.adfootages.ui.theme.White
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

@Composable
fun SignUpScreen() {
    var previewUpdate by remember {
        mutableIntStateOf(0)
    }

    var blinkCursorUpdate by remember {
        mutableIntStateOf(0)
    }

    val context = LocalContext.current

    val signUpPreviews by remember {
        mutableStateOf(
            listOf(
                SelectedSignUpData(
                    "A stunning teenage Swiss girl with flawless model-like facial features flawless light pale skin",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview1)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Glowing Spongebob Squarepants surrounded by light flares, Pixar style",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview2)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Interior design, large windows, flowerpots and pictures of plants hung on the wall",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview3)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "A haunting ethereal portrait of a cybernetic geisha her face a mesmerizing blend of porcelain skin",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview4)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Cinnamon bun island with frosting as a volcano",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview5)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Marilyn Monroe and Elvis Presley perform a duet in a glamorous retro diner filled with vibrant neon signs",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview6)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "A sleek black panther prowls through a neon-lit jungle its eyes glowing",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview7)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "In a modern brightly lit living room create a surreal scene with five Nazgul standing behind a white couch with a minion from \"Despicable Me\" with 2 blonde ponytails",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview8)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "A large fluffy orange cat playfully climbing a cute tree with colorful leaves and sunlight filtering through the branches",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview9)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Futuristic soldier in (a high-tech armor) standing in a war-torn city, highly detailed",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview11)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "An adorable clay penguin sits in a little clay boat with a clay racoon in a whimsical clay world",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview12)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Very detailed black and white drawing of a large and muscular man with the head of an aurochs. He is furious, he has red eyes and screams in fury",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview14)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "A croissant with jam and milk",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview15)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Cat in a suit",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview17)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Pink fuzzy sheep wearing neon glasses",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview19)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Red headed woman with flowing hair(sunset lighting)",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview20)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Bearded middle-aged man, brown eyes, matte background with focus on the face, high quality",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview21)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Rusty mystical two faced mask with yellow and dark sides and hollow eyes",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview22)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Hyper-realistic split mask of a mystical figure with bright yellow eyes and matted hood",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview23)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Frozen Christmas market, people wearing warm winter clothes walking around with frozen deer",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview24)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Underwater Christmas",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview25)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Frozen forest with a warm, lit house and a mountain in the background",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview26)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Close up view of an eye with pink light flares flying about. Highly detailed",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview30)!!
                        .toBitmap()
                ),
                SelectedSignUpData(
                    "Humanoid holding a giant magical pencil",
                    AppCompatResources.getDrawable(context, R.drawable.cell_preview31)!!
                        .toBitmap()
                )
            )
        )
    }

    var selectedSignUpPreview by remember {
        mutableStateOf(signUpPreviews[Random.nextInt(0, signUpPreviews.size)])
    }

    var showCursor by remember {
        mutableStateOf(false)
    }

    var blinkCursor by remember {
        mutableStateOf(false)
    }

    var allImagesLoaded by remember {
        mutableStateOf(false)
    }

    var prompt by remember {
        mutableStateOf("")
    }

    var cells by remember {
        mutableStateOf(createCells(selectedSignUpPreview.image))
    }

    var spawnDuration by remember {
        mutableLongStateOf(1)
    }

    var delayBeforeSpawningNext by remember {
        mutableLongStateOf(1)
    }

    var blunderChance by remember {
        mutableLongStateOf(16)
    }

    LaunchedEffect(key1 = previewUpdate) {
        //for every even number, we type the prompt, for odds, we clear the prompt
        if (previewUpdate % 2 == 0) {
            //check if the prompt has been completely typed
            if (prompt != selectedSignUpPreview.prompt) {
                val blunderIndexes = mutableListOf<Int>()

                //add random indexes to cause blunders
                selectedSignUpPreview.prompt.indices.forEach { iteration ->
                    //chances for blunder
                    if (Random.nextFloat() < blunderChance.toFloat() / 100f) {
                        blunderIndexes.add(iteration)
                    }
                }

                for (letter in selectedSignUpPreview.prompt.indices) {
                    //if current letter index is in blunders and the images have not been fully spawned in, type prompt with blunders
                    if (blunderIndexes.contains(letter) && !allImagesLoaded) {
                        var blunderSize = Random.nextInt(1, if (Random.nextInt(0, 5) == 5) 6 else 2)

                        for (blunder in 0 until blunderSize) {
                            val capitalize = Random.nextInt(0, 10) == 5

                            //if the current letter is the same as the random letter we get from allowedKeys, we use "69" else we just use the random letter from allowed keys
                            prompt +=
                                if (selectedSignUpPreview.prompt[letter] == if (capitalize) allowedKeys[Random.nextInt(0, allowedKeys.length)].uppercase() else allowedKeys[Random.nextInt(0, allowedKeys.length)]) {
                                    blunderSize += 1
                                    "69"
                                } else {
                                    if (capitalize)
                                        allowedKeys[Random.nextInt(0, allowedKeys.length)].uppercase()
                                    else
                                        allowedKeys[Random.nextInt(0, allowedKeys.length)]
                                }

                            //delay for 80 milli secs
                            delay(80)
                        }

                        //remove all blunders by popping from the prompt for how many blunders we added
                        for (blunder in 0 until blunderSize) {
                            delay(Random.nextLong(180, 330))
                            prompt = prompt.substring(0, prompt.length - 1)
                        }

                        delay(230)

                        //add the letter that triggered the blunders to the prompt
                        prompt += selectedSignUpPreview.prompt[letter]
                    } else {
                        //no blunders for this index or all images are loaded (blunders are ignore), so just type text normally
                        delay(if (allImagesLoaded) 25 else 80)
                        prompt += selectedSignUpPreview.prompt[letter]
                    }
                }

                blinkCursor = true
                blinkCursorUpdate += 1
                //when we're done typing, wait for 1500 milli secs before we proceed with deleting
                delay(1500)
            }
        } else {
            if (allImagesLoaded) {
                blinkCursor = false
                allImagesLoaded = false

                //pop off every letter from the prompt
                for (letter in prompt) {
                    prompt = prompt.substring(0, prompt.length - 1)
                    delay(25)
                }

                //select a random preview
                selectedSignUpPreview = signUpPreviews[Random.nextInt(0, signUpPreviews.size)]

                //set the cells to create which passes on to the composable
                cells = createCells(selectedSignUpPreview.image)

                //start spawning new cells
                withContext(Dispatchers.Main) {
                    reloadCells.value = true
                }
            }
        }

        //increment preview to restart the cycle
        previewUpdate += 1
    }

    LaunchedEffect(key1 = blinkCursorUpdate) {
        if(blinkCursor){
            showCursor = true
            delay(350)
            showCursor = false
            delay(350)

            blinkCursorUpdate += 1
        } else {
            showCursor = true
        }
    }

    Box(Modifier.fillMaxSize()){
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        DarkBlue,
                        Black
                    )
                )
            )
        )
    }

    Box (modifier = Modifier
        .fillMaxSize()
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Column(
                    modifier = Modifier
                        .width(getPercentage(screenWidth(), 98).dp)
                        .clip(corners(15.dp))
                    ,horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GridedImage(
                        cells = cells,
                        spawnSpeed = spawnDuration * 1000,
                        delayBeforeSpawningNext = delayBeforeSpawningNext * 1000,
                        onDone = {
                            allImagesLoaded = true
                        }
                    )
                }

                Box (modifier = Modifier.padding(horizontal = 3.dp)){
                    Text(text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.SemiBold,
                                color = Black,
                                fontSize = 15.sp
                            )
                        ) {
                            append(prompt)
                        }

                        if(showCursor) {
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Black,
                                    background = Black
                                )
                            ) {
                                append(".")
                            }
                        }
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .width(getPercentage(screenWidth(), 95).dp)
                        .border(
                            width = 2.dp,
                            shape = corners(10.dp),
                            brush = Brush.linearGradient(
                                listOf(
                                    Black,
                                    DarkBlue
                                )
                            )
                        )
                        .clip(corners(10.dp))
                        .background(White)
                        .padding(10.dp), textAlign = TextAlign.Start)
                }
            }

            Column {
                SliderUtility(maxValue = 10, currentValue = spawnDuration, info = "Spawn duration", suffix = "second(s)") {
                    spawnDuration = it
                }

                Spacer(modifier = Modifier.height(5.dp))

                SliderUtility(maxValue = 10, currentValue = delayBeforeSpawningNext, info = "Delay before spawning the next cell", suffix = "second(s)") {
                    delayBeforeSpawningNext = it
                }

                Spacer(modifier = Modifier.height(5.dp))

                SliderUtility(maxValue = 100, currentValue = blunderChance, info = "Chance to commit blunder", suffix = "%") {
                    blunderChance = it
                }
            }
        }
    }
}

@Composable
fun GridedImage(spawnSpeed: Long, delayBeforeSpawningNext: Long, cells: List<CellData>, onDone: () -> Unit){
    var cellsLoaded by remember {
        mutableStateOf(listOf<Int>())
    }

    var cellsLeft by remember {
        mutableStateOf(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8))
    }

    var addCell by remember {
        mutableIntStateOf(0)
    }

    val spawnPatterns by remember {
        mutableStateOf(getSpawnPatterns())
    }

    var selectedSpawnPattern by remember {
        mutableStateOf(cellsLeft)
    }

    LaunchedEffect(key1 = addCell) {
        if(reloadCells.value!!){
            cellsLoaded = listOf()

            //use a predefined pattern or randomise spawn
            if (Random.nextFloat() < 0.5) {
                selectedSpawnPattern = spawnPatterns.random()

                for (cell in selectedSpawnPattern.indices) {
                    if (cell == 0) {
                        delay(50)
                    }

                    if (!cellsLoaded.contains(selectedSpawnPattern[cell])) {
                        cellsLoaded += selectedSpawnPattern[cell]
                        delay(delayBeforeSpawningNext + 50)
                    }
                }

                CoroutineScope(Dispatchers.Main).launch {
                    reloadCells.value = false

                    delay(spawnSpeed)
                    onDone()
                }
            } else {
                cellsLeft = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8)

                for (cell in 0..<9) {
                    val selectedCell = cellsLeft[Random.nextInt(0, cellsLeft.size)]

                    if (cell == 0) {
                        delay(50)
                    }

                    cellsLoaded += selectedCell
                    val mutableCells = cellsLeft.toMutableList()
                    mutableCells.remove(selectedCell)
                    cellsLeft = mutableCells.toList()

                    delay(delayBeforeSpawningNext + 50)
                }

                CoroutineScope(Dispatchers.Main).launch {
                    reloadCells.value = false

                    delay(spawnSpeed)
                    onDone()
                }
            }
        }

        addCell += 1
    }

    Box(modifier = Modifier
        .size(getPercentage(screenWidth(), 95).dp)
        .clip(corners(10.dp))
        .border(2.dp, Brush.linearGradient(listOf(White, White)), corners(10.dp))
        .background(MildTranslucentBlack)
    ){
        for (cell in cellsLoaded) {
            Box(modifier = Modifier.align(cells[cell].alignment)) {
                Cell(cells[cell], spawnSpeed)
            }
        }
    }
}

@Composable
fun Cell(cellData: CellData, spawnSpeed: Long){
    val cellSize = (getPercentage(screenWidth().toFloat(), 95f) / 3).dp

    var size by remember {
        mutableStateOf(0.dp)
    }

    val sizeAnim by animateDpAsState(targetValue = size, label = "", animationSpec = tween(spawnSpeed.toInt(), easing = LinearEasing))

    LaunchedEffect(key1 = Unit) {
        size = cellSize
    }

    Box(modifier = Modifier
        .size(cellSize), contentAlignment = Alignment.Center
    ){
        Image(bitmap = cellData.image.asImageBitmap(), contentDescription = "", modifier = Modifier.size(sizeAnim), contentScale = ContentScale.FillBounds)
    }
}