package com.example.stepwalker.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.stepwalker.R
import com.example.stepwalker.screens.generalFunc.TopRow
import com.example.stepwalker.ui.theme.AccentBlue
import com.example.stepwalker.ui.theme.AccentGreen
import com.example.stepwalker.ui.theme.AccentOrange
import com.example.stepwalker.ui.theme.AccentPurple

@Composable
fun ResultScreen(navHostController: NavHostController) {
    return Scaffold {
        Column {
            TopRow("Result", navHostController)
            Result()
        }
    }
}

/*@Composable
fun TopRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            //.border(2.dp, Color.Black)
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Button(
            modifier = Modifier.weight(1f),
            onClick = {}, shape = RoundedCornerShape(50.dp),
            //modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                Color(0xFFF7F7F8)
            )
        ) {
            Image(painterResource(id = R.drawable.back), "back button")
        }
        Box(
            modifier = Modifier
                .weight(3f),
            contentAlignment = Alignment.Center
        ) {
            Text("Results", fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.weight(1f))
    }

}*/

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
                        colorFilter = ColorFilter.tint(AccentGreen)
                    )
                    Text("231 Routes", color = Color(0xFFF7F7F8))
                }

            }
            item {
                Column() {
                    Image(
                        painterResource(id = R.drawable.badge), "badge",
                        colorFilter = ColorFilter.tint(AccentOrange)
                    )
                    Text("Top 5", color = Color(0xFFF7F7F8))
                }

            }
            item {
                Column() {
                    Image(
                        painterResource(id = R.drawable.friends), "friends",
                        colorFilter = ColorFilter.tint(AccentBlue)
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

//    ScrollableTabRow(selectedTabIndex = tabCurrent) {
//        listOfTabs.forEachIndexed { index, title ->
//            Tab(selected = tabCurrent == index,
//                onClick = { tabCurrent = index }, text = { Text("$title") })
//        }
//    }
    CustomScrollableRow(items = listOfTabs)
    //TabsContent(text = listOfTabs[tabCurrent])
}

@Composable
fun CustomScrollableRow(items: List<String>) {
    val state = rememberScrollState()
    var currentTab by remember { mutableStateOf(0) }

    var mapList = mutableMapOf("All Time" to true,"Week" to false, "Month" to false,
        "3 Months" to false, "Half Year" to false
    )
    var itemWithSelected by remember { mutableStateOf(mapList) }

   // var selectedElementColor by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .horizontalScroll(state)
            .padding(horizontal = 20.dp)
    ) {
        itemWithSelected.keys.forEachIndexed { index, title ->
            Tab(modifier = Modifier.width(120.dp).padding(end = 12.dp)
                .background(
                color = if (itemWithSelected[title] == false)
                    Color.White else AccentPurple,
                shape = RoundedCornerShape(40.dp)
            ),
                selected = currentTab == index,
                onClick = {
                    currentTab = index
                    val itemsIterator = itemWithSelected.iterator()
                    while(itemsIterator.hasNext()){
                        val oldValue = itemsIterator.next()
                        if(oldValue.key == title){
                            oldValue.setValue(true)
                        }
                        else
                            oldValue.setValue(false)
                    }

                },
                text = { Text(title) })
        }
    }

    TabsContent(text = items[currentTab])
}

@Composable
fun TabsContent(text: String) {
    Text(text)
    LazyColumn() {
        items(4) {
            ComparisonTab(date = "12 Dec, 2022")
        }
    }
}


@Composable
fun ComparisonTab(date: String) {
    Column(
        modifier = Modifier.padding(horizontal = 40.dp, vertical = 20.dp),
        //.shadow(120.dp,shape = RoundedCornerShape(20))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.border(2.dp, color = Color.Black)
                .shadow(50.dp, shape = RoundedCornerShape(50.dp)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painterResource(id = R.drawable.man2), "man",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
            )
            Row(
                modifier = Modifier
                    //.width(IntrinsicSize.Min)
                    .weight(2f)
                   // .border(2.dp, color = Color.Black)
                    .shadow(21.dp, shape = RoundedCornerShape(30.dp)),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painterResource(id = R.drawable.calendar), "calendar",
                    modifier = Modifier.size(15.dp)
                )
                Text(date, fontSize = 15.sp, modifier = Modifier.padding(start = 10.dp))
            }
            Image(
                painterResource(id = R.drawable.man1), "man",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "9324", fontSize = 30.sp, color = AccentGreen)
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp), color = Color.LightGray
            )
            Text(text = "6823", fontSize = 30.sp)
        }
    }
}