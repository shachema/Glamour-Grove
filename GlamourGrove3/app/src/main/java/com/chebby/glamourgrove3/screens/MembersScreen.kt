package com.chebby.glamourgrove3.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chebby.glamourgrove3.R

@Composable
fun MembersScreen(navController: NavController){
    Surface (
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Cyan
    ){
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "background image")
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Congratulations!!!",
                fontSize = 50.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Magenta
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "You are now officially a member of Glamour Grove.",
                fontSize = 50.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Blue
            )
            Spacer(modifier = Modifier.height(250.dp))
            Text(
                text = "Message us on our social media to become" +
                        " our official influencer for a good fee :)",
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

@Preview
@Composable
fun MembersScreenPreview(){
    MembersScreen(rememberNavController())
}