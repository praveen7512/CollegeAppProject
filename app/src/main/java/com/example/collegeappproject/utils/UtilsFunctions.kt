package com.example.collegeappproject.utils

import android.view.Window
import android.view.WindowManager
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.collegeappproject.R
import com.example.collegeappproject.models.NoticeModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

object UtilsFunctions {



    fun actionBarRemove(window : Window){
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    @Composable
    fun EachRow(noticeModel: NoticeModel) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.clickable {

        }
            .padding(4.dp)
            .background(Color.White)
            .fillMaxWidth().border(width =1.dp,shape = RoundedCornerShape(10),color=Color.LightGray)
            ,
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.undraw_newspaper_icon),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.border(1.dp, Color.Gray, shape = RoundedCornerShape(10)).
                     size(84.dp)
                    .background(Color.White)
                    .padding(20.dp)

            )



            Text(noticeModel.noticeText,
                modifier = Modifier
                    .background(
                        Color.White

                    )
                    .padding(start = 10.dp))

        }

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