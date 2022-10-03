package com.example.collegeappproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collegeappproject.R
import com.example.collegeappproject.models.NavigationItem


@Composable
fun DashBoardScreen() {

    Scaffold(
          modifier = Modifier
              .background(Color.White)
              .fillMaxSize(),
        topBar = { TopAppBarCreated()},
        bottomBar = {
            BottomNavigationBar()
        }
    ) {
        

        Column(modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.SpaceEvenly) {
            Spacer(modifier = Modifier.height(20.dp))
            SearchBar(hint = "Search anything you want")
            Spacer(modifier = Modifier.height(20.dp))

            Row(modifier= Modifier

                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                Spacer(modifier = Modifier.width(10.dp))
                CardViewDashBoard()
                Spacer(modifier = Modifier.width(20.dp))

                CardViewDashBoard()
                Spacer(modifier = Modifier.width(20.dp))

                CardViewDashBoard()
                Spacer(modifier = Modifier.width(20.dp))

                CardViewDashBoard()
                Spacer(modifier = Modifier.width(20.dp))







            }
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                text = "Latest Updates", style = TextStyle(
                fontWeight = FontWeight.Bold,

                fontSize = 25.sp))

            Spacer(modifier = Modifier.height(30.dp))

            Row(modifier= Modifier

                .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Spacer(modifier = Modifier.width(10.dp))
                CardViewDashBoardNews()
                Spacer(modifier = Modifier.width(20.dp))

                CardViewDashBoardNews()
                Spacer(modifier = Modifier.width(20.dp))

                CardViewDashBoardNews()
                Spacer(modifier = Modifier.width(20.dp))

                CardViewDashBoardNews()
                Spacer(modifier = Modifier.width(20.dp))







            }







        }
    }


}

@Composable
fun BottomNavigationBar() {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Movies,
        NavigationItem.Books,
        NavigationItem.Profile
    )
    BottomNavigation(
        elevation = 0.dp,

        backgroundColor = colorResource(id = R.color.white),
        contentColor = Color.Black
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    /* Add code later */
                }
            )
        }
    }
}


@Composable
fun SearchBar(hint :String){

    var name by remember {
        mutableStateOf("")
    }


    TextField(
        value = name,
        onValueChange = {
            name = it
        },
        label = { Text(text = hint) },
        modifier = Modifier

            .shadow(10.dp, shape = RoundedCornerShape(10))
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White

        ),
        leadingIcon = {
            Icon(Icons.Default.Search,"")
        },
        trailingIcon = {
            Icon(Icons.Default.Star,"")
        }




        )
}

@Composable
fun CardViewDashBoard() {
    Card(shape = RoundedCornerShape(5),
    elevation = 10.dp,
        backgroundColor = Color.White,
        modifier = Modifier
            .height(170.dp)
            .width(105.dp)
        ) {


//        ImageCircleVectorDashBoard(imageId = R.drawable.undraw_professor)

    }
}


@Composable
fun ImageCircleVectorDashBoard(imageId :Int){

    Box(
        Modifier
            .shadow(
                elevation = 10.dp,
                shape = CircleShape, clip = true
            )
            .size(30.dp)
            .background(Color.White)) {
        Image(
            contentScale = ContentScale.Crop,
            painter = painterResource(imageId),
            contentDescription = "imageContent",
//            contentScale = ContentScale.Crop, // crop the image

            modifier = Modifier
                .size(100.dp)
                .shadow(shape = CircleShape, elevation = 0.dp)
                .align(Alignment.Center)        // clip to the circle shape
        )
    }
}

@Composable
fun CardViewDashBoardNews() {
    Card(shape = RoundedCornerShape(10),
        elevation = 10.dp,
        backgroundColor = Color.White,
        modifier = Modifier
            .height(300.dp)
            .width(250.dp)
    ) {


//        ImageCircleVectorDashBoard(imageId = R.drawable.undraw_professor)

    }
}

