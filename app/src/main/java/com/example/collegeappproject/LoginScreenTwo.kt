package com.example.collegeappproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collegeappproject.screens.ImageCircleVector
import com.example.collegeappproject.screens.TextInputField
import com.example.collegeappproject.ui.theme.CollegeAppProjectTheme
import com.example.collegeappproject.ui.theme.LightSkyBlue
import com.example.collegeappproject.ui.theme.SkyBlue
import com.example.collegeappproject.utils.UtilsFunctions

class LoginScreenTwo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        UtilsFunctions.actionBarRemove(window)


        setContent {
            CollegeAppProjectTheme {

                UtilsFunctions.transparentActionBar()
          LoginScreenTwoFun()
            }
        }
    }
}
@Preview(group="Test")
@Composable
fun LoginScreenTwoFun(){
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.SpaceEvenly
//            verticalArrangement = Arrangement.SpaceEvenly
        ){

            Text(modifier = Modifier.fillMaxWidth(),text ="Login Now",
                style = TextStyle(

                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = SkyBlue,


                    )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Please Login to continue using our app ",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.LightGray

                ),
                modifier = Modifier.fillMaxWidth(0.9f)


            )


            Spacer(modifier = Modifier.height(5.dp))
            Text(text ="Enter via social networks ", modifier = Modifier.fillMaxWidth(),style = TextStyle(

                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = SkyBlue




            ) )

            Spacer(modifier = Modifier.height(20.dp))


            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()) {
                ImageCircleVector(imageId = R.drawable.facebook_icon)

                Spacer(modifier = Modifier.padding(start=20.dp))


                ImageCircleVector(imageId = R.drawable.google_icon)


            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(text ="or login with email", modifier = Modifier.fillMaxWidth()
                ,style = TextStyle(

                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center

                ) )
            Spacer(modifier = Modifier.height(30.dp))

            TextInputField("Username" )
            Spacer(modifier = Modifier.height(30.dp))
            TextInputField("Password")
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Forgot Password?",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
//                    color = Color.LightGray
                textAlign = TextAlign.End

                ),
                modifier = Modifier.fillMaxWidth()


            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(backgroundColor = LightSkyBlue),
                shape = RoundedCornerShape(10),
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp),
            ) {
                Text(text = "Login",style = TextStyle(
                    fontSize = 17.sp, color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(buildAnnotatedString {

                append("Dont have an account ?  ")
                withStyle(SpanStyle(color = SkyBlue)) {
                    append ("Sign Up")
                }




            })


        }
    }
}

