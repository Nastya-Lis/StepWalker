package com.example.stepwalker.screens

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.stepwalker.screens.generalFunc.TopRow
import com.example.stepwalker.ui.theme.AccentBlack
import com.example.stepwalker.ui.theme.AccentWhite
import com.example.stepwalker.R
import com.example.stepwalker.ui.theme.AccentPurple
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToInt
import kotlin.math.roundToLong

@Composable
fun StatisticsScreen(navHostController: NavHostController) {
    Scaffold() {
        Column(modifier = Modifier.background(AccentBlack)) {
            GraphStatistics(navHostController)
        }
    }
}

@Composable
fun GraphStatistics(navHostController: NavHostController) {
    Column {
        TopRow("Statistics", navHostController)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("43 263", color = AccentWhite, fontSize = 56.sp)
            Text("Steps last week", color = AccentWhite)
        }
        /*Image(painterResource(id = R.drawable.greenline), "wave"
            ,modifier = Modifier.fillMaxWidth())*/
        Spacer(modifier = Modifier.weight(2f))
        TimingChoose()
        DetailedStatistics()
    }

}


@Composable
fun TimingChoose() {
    val scroll = rememberScrollState()
    val listOfTabs = listOf("2 Hours", "Day", "Week", "Month", "Year")
    var currentTab by remember { mutableStateOf(0) }
    Row(modifier = Modifier.horizontalScroll(scroll)) {
        listOfTabs.forEachIndexed { index, title ->
            Tab(modifier = Modifier
                .width(120.dp)
                .padding(end = 12.dp)
                .background(
                    Color.White,
                    shape = RoundedCornerShape(40.dp)
                ),
                selected = currentTab == index,
                onClick = {
                    currentTab = index
                },
                text = { Text(title) })
        }
    }
}


@Composable
fun DetailedStatistics(){
    val finalCountSteps = 7618
    val bestCount = 10000
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = AccentWhite, RoundedCornerShape(40.dp))) {
        Text(text = "DETAILED STATISTICS", fontSize = 15.sp, fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 15.dp, start = 15.dp))
        LazyColumn(modifier = Modifier
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            items(4){
                val percent = countPercent(finalCountSteps,bestCount)
                Row(modifier = Modifier.padding(top = 10.dp)){
                    Column(modifier = Modifier
                        .background(AccentWhite, RoundedCornerShape(35.dp))
                        .border(1.dp, Color.LightGray, RoundedCornerShape(15.dp))
                        .padding(horizontal = 15.dp, vertical = 7.dp)
                    ){
                        Text(text = "12", fontSize = 20.sp)
                        Text(text = "Dec", fontSize = 13.sp)
                    }
                    ProgressBar(finalCountSteps, bestCount, percent)
                    Row(Modifier.border(1.dp,Color.Black)){
                        Text(" ${(percent*100).toInt()}%", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }

}

@Composable
fun ProgressBar(valueResult: Int, valueBest: Int, progress:Float) {
    Column(modifier = Modifier.size(200.dp, 50.dp).padding(horizontal = 20.dp),
    verticalArrangement = Arrangement.Bottom) {
        Row(){
            Icon(painterResource(id = R.drawable.footsteps_silhouette_variant)
                , contentDescription = "steps")
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp)){
                        append(" $valueResult ")
                    }
                    withStyle(style = SpanStyle(color = Color.LightGray, fontSize = 15.sp)){
                        append("of $valueBest")
                    }
                }
            )
        }
        LinearProgressIndicator(progress, color = AccentPurple)
    }
}

/*TODO finish logic of percent count
   when percent of day walking is bigger than planning score*/
fun countPercent(valueResult: Int, valueBest: Int):Float{
    val dcFormat = DecimalFormat("0.##")
    dcFormat.roundingMode = RoundingMode.CEILING
    val result = ((valueResult.toFloat() * 100)/valueBest.toFloat()).roundToInt()
    return result.toFloat()/100
}



