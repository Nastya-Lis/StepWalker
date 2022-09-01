package com.example.stepwalker.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stepwalker.R

@Composable
fun ResultScreen() {
    return Scaffold {
        Column(){
            TopRow()
            UserInfo()
        }

    }
}

@Composable
fun TopRow(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 20.dp)){

        Button(onClick = {}, shape = RoundedCornerShape(50.dp),
            //modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
            Color(0xFFF7F7F8)
        )){
            Image(painterResource(id = R.drawable.back), "back button")
        }
        Box(modifier = Modifier.weight(2f)//.border(1.dp, Color.Black)
        ){
            Text("Results", fontWeight = FontWeight.Bold )
        }
        //Spacer(modifier = Modifier)
    }

}

@Composable
fun UserInfo(){
    Column(modifier = Modifier.padding(20.dp)){
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween){
            Image(painterResource(id = R.drawable.man2), "man2",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape))
            Column(modifier = Modifier.weight(2f).padding(start = 20.dp)) {
                Text(text = "Elizabeth")
                Text("BEGINNER", fontSize = 12.sp)
            }
            Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(45.dp), colors  = ButtonDefaults.buttonColors(
                Color(0xFFF7F7F8)) ) {
                Image(painterResource(id = R.drawable.add_user), "add account")
            }

        }
    }
}