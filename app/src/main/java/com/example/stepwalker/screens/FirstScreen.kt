package com.example.stepwalker.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stepwalker.R

@Composable
fun FirstScreen() {
    return Scaffold(modifier = Modifier.padding(top = 40.dp)) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                UserView()
                AdvancedSettingButton()
            }

            StepsAllStatistic()
            FriendTab()
            Discounts()
        }
    }
}


@Composable
fun UserView() {
    Row(
        modifier = Modifier
            .shadow(5.dp, shape = CircleShape)
            .padding()
            .background(color = Color(0xFFF7F7F8), shape = CircleShape)
/*    border(1.dp, Color.Black, CircleShape)*/
    ) {
        Image(
            painter = painterResource(id = R.drawable.man1),
            contentDescription = "Man face",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(end = 10.dp)
                .size(60.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(top = 3.dp, end = 20.dp)) {
            Text("Brandon")
            Text(modifier = Modifier.padding(top = 3.dp), text = "PRO")
        }
    }
}

@Composable
fun AdvancedSettingButton() {
    IconButton(
        onClick = { /*TODO*/ }, modifier = Modifier
            .background(Color(0xFFF7F7F8))
            .fillMaxHeight()
            .width(60.dp)
            .shadow(5.dp, shape = RoundedCornerShape(18.dp))
        //.border(1.dp, Color.DarkGray, RoundedCornerShape(18.dp))
    ) {
        Icon(
            Icons.Filled.Menu, "Settings"
            //modifier = Modifier.size(5.dp)/*padding(horizontal = 20.dp)*/
        )

    }
}

@Composable
fun StepsAllStatistic() {
    Row(
        modifier = Modifier
            .padding(top = 40.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StepsToday()
        Column() {
            WeekRecord()
            MonthRecord()
        }
    }
}

@Composable
fun StepsToday() {
    Column(
        modifier = Modifier
            .background(
                Color(0xFF7471FF),
                shape = RoundedCornerShape(45.dp)
            )
            .padding(30.dp)
        //.shadow(5.dp, shape = CircleShape)
    ) {
        Row() {
            Image(
                painterResource(id = R.drawable.footsteps_silhouette_variant),
                "steps", modifier = Modifier.size(20.dp)
            )
            Text("Steps today")
        }
        Image(
            painterResource(id = R.drawable.profit),
            "diagram", modifier = Modifier
                .size(80.dp)
                .padding(vertical = 20.dp)
        )
        Text(
            "4296",
            fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold,
            fontSize = 35.sp
        )
        Text("of 9000")
    }
}

@Composable
fun WeekRecord() {
    Column(
        modifier = Modifier
            .background(
                Color(0xFFF7F7F8),
                shape = RoundedCornerShape(45.dp)
            )
            .padding(30.dp)
            .shadow(50.dp, shape = RectangleShape)
    ) {
        Text("Weekly goal")
        Text(
            "25 600", fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Composable
fun MonthRecord() {
    Column(
        modifier = Modifier
            .background(
                Color(0xFFF7F7F8),
                shape = RoundedCornerShape(45.dp)
            )
            .padding(30.dp)
            .shadow(
                50.dp,
                shape = RectangleShape
            )//.border(1.dp, Color.Gray, shape = RoundedCornerShape(45.dp))
    ) {
        Text("Monthly goal")
        Text(
            "44 750", fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Composable
fun FriendTab() {
    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .background(
                Color(0xFFF7F7F8),
                shape = RoundedCornerShape(45.dp)
            )
            //.border(1.dp, Color.Gray, shape = RoundedCornerShape(45.dp))
            .shadow(
                80.dp,
                shape = RoundedCornerShape(50.dp)
            )
    )
    {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Box(Modifier.padding(bottom = 20.dp)) {
                Text("My Friends".uppercase(), fontWeight = FontWeight.Bold)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                /*it's better doing with LazyColumn*/
                Box(
                    modifier = Modifier.width(150.dp)//.border(1.dp, Color.Black)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.man1), "friend",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(45.dp)
                            .clip(CircleShape)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.man1), "friend",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(start = 30.dp)
                            .size(45.dp)
                            .clip(CircleShape)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.man1), "friend",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(start = 60.dp)
                            .size(45.dp)
                            .clip(CircleShape)
                    )

                    Button(
                        onClick = {}, modifier = Modifier
                            .padding(start = 90.dp)
                            .size(45.dp)
                            .clip(CircleShape),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF7F7F8))
                    ) {
                        Text("+4", fontSize = 8.sp, color = Color(0xFF1F262A))
                    }
                }

                Button(
                    onClick = {}, shape = RoundedCornerShape(45.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1F262A))
                ) {
                    Row() {
                        Icon(Icons.Filled.Add, "plus", tint = Color(0xFFF7F7F8))
                        Text("Add new", color = Color(0xFFF7F7F8))
                    }

                }
            }
        }
    }
}

@Composable
fun Discounts() {
    Column(modifier = Modifier.padding(top = 20.dp)) {
        Text("Available discounts", fontWeight = FontWeight.Bold)
        LazyColumn(modifier = Modifier.padding(top = 20.dp)) {
            items(4) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(painterResource(id = R.drawable.mcdonald), "mc")
                    Column(modifier = Modifier.weight(2f).padding(start = 20.dp)) {
                        Text("McDonald's")
                        Text("10% discount", color = Color.LightGray, fontSize = 12.sp)
                    }
                    Button(
                        onClick = {}, shape = RoundedCornerShape(45.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF7F7F8))
                    ) {
                        Text("$12")
                    }
                }
            }
        }
    }
}