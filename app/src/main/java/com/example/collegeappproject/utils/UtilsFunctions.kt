package com.example.collegeappproject.utils

import android.view.Window
import android.view.WindowManager
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.collegeappproject.R

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
}