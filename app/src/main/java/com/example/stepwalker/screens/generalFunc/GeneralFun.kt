package com.example.stepwalker.screens.generalFunc

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.stepwalker.R
import com.example.stepwalker.navhost.NavigationHosting

@Composable
fun TopRow(title: String, navHostController: NavHostController) {
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
            onClick = {
                      navHostController.popBackStack()
            }, shape = RoundedCornerShape(50.dp),
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
            Text(title, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.weight(1f))
    }

}