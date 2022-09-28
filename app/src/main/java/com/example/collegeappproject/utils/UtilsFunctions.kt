package com.example.collegeappproject.utils

import android.view.Window
import android.view.WindowManager
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.collegeappproject.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController

object UtilsFunctions {
    fun actionBarRemove(window : Window){
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    @Composable
    fun LottieAnimationTheme(){



        val compositionResult: LottieCompositionResult =
            rememberLottieComposition(spec= LottieCompositionSpec.RawRes(R.raw.splashscreen_animation))

        val progress by animateLottieCompositionAsState(
            compositionResult.value,
            isPlaying = true,
            iterations = LottieConstants.IterateForever,
            speed = 1.0f
        )

        LottieAnimation(compositionResult.value, progress, modifier = Modifier.padding(80.dp) )
    }



    @Composable
    fun transparentActionBar() {


        val systemUiController = rememberSystemUiController()
        val useDarkIcons = !isSystemInDarkTheme()


        DisposableEffect(systemUiController, useDarkIcons) {
            // Update all of the system bar colors to be transparent, and use
            // dark icons if we're in light theme
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = useDarkIcons
            )

            // setStatusBarColor() and setNavigationBarColor() also exist

            onDispose {}
        }

    }

}