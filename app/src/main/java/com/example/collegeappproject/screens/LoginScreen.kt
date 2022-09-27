package com.example.collegeappproject.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collegeappproject.R
import com.example.collegeappproject.ui.theme.CollegeAppProjectTheme
import com.example.collegeappproject.ui.theme.SkyBlue

class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CollegeAppProjectTheme {

                LoginScreenFun()
            }
        }
    }
}

@Composable
fun LoginScreenFun(){
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
                .background(Color.White),
//            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Spacer(modifier = Modifier.height(40.dp))
            Text(modifier = Modifier.fillMaxWidth(),text ="Welcome",
                style = TextStyle(

                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = SkyBlue,


                    )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Please login and signup to continue using this app ",
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

            TextInputField()


        }
    }
}

@Composable
fun TextInputField(){

    var name by remember{
        mutableStateOf("")
    }

    TextField(value =name , onValueChange ={
        name = it
    },  label = { Text(text = "Username")},
        modifier = Modifier.background(Color.White).shadow(10.dp, shape= CircleShape),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        ),
        leadingIcon = {Icon(Icons.Default.Person,"")}




    )
}
