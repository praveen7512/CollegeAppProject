package com.example.collegeappproject.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.collegeappproject.features.webScrapping.WebScrapingViewModel
import com.example.collegeappproject.utils.ResultState
import com.example.collegeappproject.utils.UtilsFunctions.EachRow


@Composable
fun NoticeScreen(webScrapingViewModel: WebScrapingViewModel = hiltViewModel()) {

    Scaffold(

        topBar = { TopAppBarCreated() }
    ) {
        when (val response = webScrapingViewModel.news_response.value) {

            is ResultState.Failure -> {
                Text(text = " ${response.msg}")
            }
            is ResultState.Loading -> {
                CircularProgressIndicator()
            }

            is ResultState.Success -> {

                LazyColumn() {
                    items(response.data) { it ->
                        EachRow(noticeModel = it)
                    }
                }
            }
        }
    }



}
