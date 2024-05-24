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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
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
import com.chebby.glamourgrove3.navigation.ROUTE_CONTACTS
import com.chebby.glamourgrove3.navigation.ROUTE_HOME
import com.chebby.glamourgrove3.ui.theme.GlamourGrove3Theme

class ProductsScreenActivity : ComponentActivity() {
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
                                val imageId = arrayOf(
                                    R.drawable.products,
                                    R.drawable.set1,
                                    R.drawable.set2,
                                    R.drawable.set3,
                                    R.drawable.bag1,
                                    R.drawable.brushes,
                                    R.drawable.nykaa
                                )
                                val imageId1 = arrayOf(
                                    R.drawable.shoe1,
                                    R.drawable.shoe2,
                                    R.drawable.shoe3,
                                    R.drawable.shoe4,
                                    R.drawable.ubuy,
                                    R.drawable.gown1,
                                    R.drawable.gown2,
                                    R.drawable.gown3
                                )
                                val imageId2 = arrayOf(
                                    R.drawable.gown4,
                                    R.drawable.acc1,
                                    R.drawable.acc2,
                                    R.drawable.acc3,
                                    R.drawable.acc4,
                                    R.drawable.acc5,
                                    R.drawable.clothes
                                )
                                val imageId3 = arrayOf(
                                    R.drawable.cloth1,
                                    R.drawable.cloth2,
                                    R.drawable.cloth3,
                                    R.drawable.cloth4,
                                    R.drawable.cloth5,
                                    R.drawable.cloth6,
                                    R.drawable.cloth7
                                )
                                ProductsScreen(
                                   imageId,imageId1,imageId2,imageId3,
                                    navController = rememberNavController()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProductsScreen(
    imageId3: Array<Int>,
    imageId2: Array<Int>,
    imageId1: Array<Int>,
    imageId : Array<Int>,
    navController: NavController
) {
   Surface(
       modifier = Modifier
           .fillMaxSize()
   ) {
       Image(
           painter = painterResource(id = R.drawable.butterfly),
           contentDescription = "",
           contentScale = ContentScale.FillBounds,
           modifier = Modifier.fillMaxSize()
       )
       Column {
           Spacer(modifier = Modifier.height(20.dp))
           LazyRow {
               val itemCount = imageId.size
               items(itemCount){item ->
                   ColumnItem(
                       itemIndex = item,
                       painter = imageId
                   )
               }

           }
           LazyRow {
               val itemCount = imageId1.size
               items(itemCount){item ->
                   ColumnItem(
                       itemIndex = item,
                       painter = imageId1
                   )
               }
           }
           LazyRow {
               val itemCount = imageId2.size
               items(itemCount){item ->
                   ColumnItem(
                       itemIndex = item,
                       painter = imageId2
                   )
               }
           }
           LazyRow {
               val itemCount = imageId3.size
               items(itemCount){item ->
                   ColumnItem(
                       itemIndex = item,
                       painter = imageId3
                   )
               }

           }
           Row (
               modifier = Modifier
                   .fillMaxWidth(),
               horizontalArrangement = Arrangement.spacedBy(50.dp)
           ){
               Button(onClick = {
                   navController.navigate(ROUTE_CONTACTS)
               }
               ) {
                   Text(text = "NEXT")
               }
               Button(onClick = {
                   navController.navigate(ROUTE_HOME)
               }) {
                   Text(text = "BACK")
               }
           }
       }

   }
}

@Composable
fun ColumnItem(
    itemIndex: Int,
    painter: Array<Int>
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color.Cyan
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
           Image(
               painter = painterResource(id = painter[itemIndex]),
               contentDescription = "",
               modifier = Modifier.size(140.dp)
               )
        }
    }
}

@Preview
@Composable
fun ProductsScreenPreview(){
    ProductsScreen(imageId = arrayOf(
        R.drawable.products,
        R.drawable.set1,
        R.drawable.set2,
        R.drawable.set3,
        R.drawable.bag1,
        R.drawable.brushes,
        R.drawable.nykaa
    ),
        imageId1 = arrayOf(
            R.drawable.shoe1,
            R.drawable.shoe2,
            R.drawable.shoe3,
            R.drawable.shoe4,
            R.drawable.ubuy,
            R.drawable.gown1,
            R.drawable.gown2,
            R.drawable.gown3
        ),
        imageId2 = arrayOf(
            R.drawable.gown4,
            R.drawable.acc1,
            R.drawable.acc2,
            R.drawable.acc3,
            R.drawable.acc4,
            R.drawable.acc5,
            R.drawable.clothes
        ),
        imageId3 = arrayOf(
            R.drawable.cloth1,
            R.drawable.cloth2,
            R.drawable.cloth3,
            R.drawable.cloth4,
            R.drawable.cloth5,
            R.drawable.cloth6,
            R.drawable.cloth7
        ),
        navController = rememberNavController()
    )
}