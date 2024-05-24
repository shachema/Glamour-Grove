package com.chebby.glamourgrove3.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chebby.glamourgrove3.R
import com.chebby.glamourgrove3.screens.ContactsScreen
import com.chebby.glamourgrove3.screens.HomeScreen
import com.chebby.glamourgrove3.screens.LoginScreen
import com.chebby.glamourgrove3.screens.MembersScreen
import com.chebby.glamourgrove3.screens.ProductsScreen
import com.chebby.glamourgrove3.screens.RegisterScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_REGISTER
){
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ){
        composable(ROUTE_LOGIN){ LoginScreen(navController) }
        composable(ROUTE_REGISTER){ RegisterScreen(navController) }
        composable(ROUTE_HOME){ HomeScreen(products = listOf("Make-Up", "Skin-Care Products",
            "Women Clothes", "Purses", "Handbags", "Women's Shoes","Accessories"),
            navController)}
        composable(ROUTE_PRODUCTS){ ProductsScreen(
            imageId3 = arrayOf(
                R.drawable.cloth1,
                R.drawable.cloth2,
                R.drawable.cloth3,
                R.drawable.cloth4,
                R.drawable.cloth5,
                R.drawable.cloth6,
                R.drawable.cloth7
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
            imageId = arrayOf(
                R.drawable.products,
                R.drawable.set1,
                R.drawable.set2,
                R.drawable.set3,
                R.drawable.bag1,
                R.drawable.brushes,
                R.drawable.nykaa
            ),
            navController
        )}
        composable(ROUTE_CONTACTS){ ContactsScreen(navController = navController)}
        composable(ROUTE_MEMBERS){ MembersScreen(navController = navController) }
    }
}