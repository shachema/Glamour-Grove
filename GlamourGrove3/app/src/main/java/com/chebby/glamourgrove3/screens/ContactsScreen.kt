package com.chebby.glamourgrove3.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chebby.glamourgrove3.R
import com.chebby.glamourgrove3.navigation.ROUTE_MEMBERS
import com.chebby.glamourgrove3.navigation.ROUTE_PRODUCTS


@Composable
fun ContactsScreen(navController: NavController){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Magenta
    ) {
        Image(
            painter = painterResource(id = R.drawable.adorable),
            contentDescription = "background Image")
        Column (
            modifier = Modifier
                .fillMaxSize()
        ){
            Text(
                text = "FIND US ON:",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                color = Color.Blue
                )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Snapchat:@GlamourGrove_3",
                fontSize = 24.sp,
                fontWeight = FontWeight.W900,
                fontFamily = FontFamily.Monospace,
                color = Color.Blue
                )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Instagram:@GlamourGrove_3",
                fontSize = 24.sp,
                fontWeight = FontWeight.W900,
                fontFamily = FontFamily.Monospace,
                color = Color.Blue
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Facebook:@GlamourGrove_3",
                fontSize = 24.sp,
                fontWeight = FontWeight.W900,
                fontFamily = FontFamily.Monospace,
                color = Color.Blue
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Email:glamourgrove@gmail.com",
                fontSize = 24.sp,
                fontWeight = FontWeight.W900,
                fontFamily = FontFamily.Monospace,
                color = Color.Blue
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "........... for more fashion inspiration",
                fontSize = 24.sp,
                fontWeight = FontWeight.W900,
                fontFamily = FontFamily.Serif,
                color = Color.Blue
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Become one of us by clicking the button below:",
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                          navController.navigate(ROUTE_MEMBERS)
                },
                colors = ButtonDefaults.buttonColors(Color.Magenta),
                shape = RoundedCornerShape(16.dp),
                ) {
                Text(
                    text = "JOIN NOW",
                    color = Color.Black,
                    textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "As a member,you get to enjoy the " +
                        "exclusive perks of becoming our very own brand influencer " +
                        "and sharing your own ideas and fashion inspos",
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                          navController.navigate(ROUTE_MEMBERS)
                },
                colors = ButtonDefaults.buttonColors(Color.Cyan),
                shape = RoundedCornerShape(16.dp),
            ) {
                Text(
                    text = "JOIN TODAY",
                    color = Color.Black,
                    textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                          navController.navigate(ROUTE_PRODUCTS)
                },
                colors = ButtonDefaults.buttonColors(Color.Cyan),
                shape = RoundedCornerShape(16.dp),
            ) {
                Text(
                    text = "BACK",
                    color = Color.Black,
                    textAlign = TextAlign.Center)
            }
        }
    }
}

@Preview
@Composable
fun ContactsScreenPreview(){
    ContactsScreen(rememberNavController())
}