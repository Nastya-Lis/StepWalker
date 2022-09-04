package com.example.stepwalker.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stepwalker.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@Composable
fun ResultScreen() {
    return Scaffold {
        Column {
            TopRow()
            Result()

        }
    }
}

@Composable
fun TopRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {

        Button(
            onClick = {}, shape = RoundedCornerShape(50.dp),
            //modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                Color(0xFFF7F7F8)
            )
        ) {
            Image(painterResource(id = R.drawable.back), "back button")
        }
        Box(
            modifier = Modifier.weight(2f)//.border(1.dp, Color.Black)
        ) {
            Text("Results", fontWeight = FontWeight.Bold)
        }
        //Spacer(modifier = Modifier)
    }

}

@Composable
fun Result() {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .background(Color(0xFFF7F7F8), shape = RoundedCornerShape(45.dp))
    ) {
        UserInfo()
        Timing()
    }
}

@Composable
fun UserInfo() {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .background(Color(0xFF1F262A), shape = RoundedCornerShape(45.dp))
            .shadow(
                100.dp,
                shape = RectangleShape
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Image(
                painterResource(id = R.drawable.man2), "man2",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(start = 20.dp)
            ) {
                Text(text = "Elizabeth", color = Color(0xFFF7F7F8))
                Text("BEGINNER", fontSize = 12.sp, color = Color(0xFFF7F7F8))
            }
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(45.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF1F262A)
                ),
                border = BorderStroke(1.dp, Color(0xFFF7F7F8))
            ) {
                Image(
                    painterResource(id = R.drawable.add_user), "add account",
                    colorFilter = ColorFilter.tint(Color(0xFFF7F7F8))
                )
            }

        }
        /*TODO make list of data in User data class*/
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            item {
                Column() {
                    Image(
                        painterResource(id = R.drawable.destination), "travel",
                        colorFilter = ColorFilter.tint(Color.Green)
                    )
                    Text("231 Routes", color = Color(0xFFF7F7F8))
                }

            }
            item {
                Column() {
                    Image(
                        painterResource(id = R.drawable.badge), "badge",
                        colorFilter = ColorFilter.tint(Color.Yellow)
                    )
                    Text("Top 5", color = Color(0xFFF7F7F8))
                }

            }
            item {
                Column() {
                    Image(
                        painterResource(id = R.drawable.friends), "friends",
                        colorFilter = ColorFilter.tint(Color.Blue)
                    )
                    Text("23 Friends", color = Color(0xFFF7F7F8))
                }

            }
        }
    }
}

@Composable
fun Timing() {
    val listOfTabs = listOf("All Time", "Week", "Month", "3 Months", "Half Year")
    var tabCurrent by remember { mutableStateOf(0) }
    ScrollableTabRow(selectedTabIndex = tabCurrent) {
        listOfTabs.forEachIndexed { index, title ->
            Tab(selected = tabCurrent == index,
                onClick = { tabCurrent = index }, text = { Text("$title") })
        }
    }
    TabsContent(text = listOfTabs[tabCurrent])
}

@Composable
fun TabsContent(text: String) {
    Column {
        Text("$text")
    }
}
