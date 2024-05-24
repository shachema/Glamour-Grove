package com.chebby.glamourgrove3.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chebby.glamourgrove3.R
import com.chebby.glamourgrove3.navigation.ROUTE_LOGIN
import com.chebby.glamourgrove3.navigation.ROUTE_PRODUCTS
import com.chebby.glamourgrove3.ui.theme.GlamourGrove3Theme

class HomeScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            class ScrollActivity : ComponentActivity() {
                override fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)
                    setContent {
                        GlamourGrove3Theme{
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize(),
                                color = MaterialTheme.colorScheme.primary
                            ) {
                                val products = listOf(
                                    "Make-Up", "Skin-Care Products",
                                    "Women Clothes", "Purses", "Handbags", "Women's Shoes",
                                    "Accessories"
                                )
                                HomeScreen(products, navController = rememberNavController())
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun RowCards(name: String) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(100.dp)
            .aspectRatio(3f),
        colors = CardDefaults.cardColors(containerColor = Color.Magenta)
    ) {
        Box(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = name)

        }
    }

}
@Composable
fun HomeScreen(products: List<String>, navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.jewels),
            contentDescription = "background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()

        )

    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = stringResource(id = R.string.offers),
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Serif,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(contentPadding = PaddingValues(20.dp)) {
            items(items = products) { item ->
                RowCards(name = item)
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(50.dp)
        ){
            Button(onClick = {
                navController.navigate(ROUTE_PRODUCTS)
            }
            ) {
                Text(text = "NEXT")
            }
            Button(onClick = {
                navController.navigate(ROUTE_LOGIN)
            }
            ) {
                Text(text = "BACK")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        products = listOf("Make-Up", "Skin-Care Products",
            "Women Clothes", "Purses", "Handbags", "Women's Shoes","Accessories"),
        navController = rememberNavController())
}