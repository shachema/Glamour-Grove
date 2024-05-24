package com.chebby.glamourgrove3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.chebby.glamourgrove3.navigation.AppNavHost
import com.chebby.glamourgrove3.screens.LoginScreen
import com.chebby.glamourgrove3.screens.RegisterScreen
import com.chebby.glamourgrove3.ui.theme.GlamourGrove3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GlamourGrove3Theme {
                AppNavHost()
            }
        }
    }

}
