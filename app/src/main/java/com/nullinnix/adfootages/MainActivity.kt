package com.nullinnix.adfootages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.toArgb
import com.nullinnix.adfootages.ui.theme.Transparent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge(navigationBarStyle = SystemBarStyle.light(scrim = Transparent.toArgb(), darkScrim = Transparent.toArgb()))
            SignUpScreen()
        }
    }
}