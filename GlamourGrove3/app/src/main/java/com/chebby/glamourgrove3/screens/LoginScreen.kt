package com.chebby.glamourgrove3.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chebby.glamourgrove3.R
import com.chebby.glamourgrove3.components.ButtonComponent
import com.chebby.glamourgrove3.components.ClickableLoginTextComponent
import com.chebby.glamourgrove3.components.DividerTextComponent
import com.chebby.glamourgrove3.components.HeadingTextComponent
import com.chebby.glamourgrove3.components.MyTextFieldComponent
import com.chebby.glamourgrove3.components.NormalTextComponent
import com.chebby.glamourgrove3.components.PasswordFieldComponent
import com.chebby.glamourgrove3.components.UnderlinedNormalTextComponent
import com.chebby.glamourgrove3.navigation.ROUTE_LOGIN
import com.chebby.glamourgrove3.navigation.ROUTE_REGISTER
import com.chebby.glamourgrove3.ui.theme.GlamourGrove3Theme
import com.google.firebase.Firebase
import com.google.firebase.database.database

class LoginActivity : ComponentActivity() {
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
                              LoginScreen(navController = rememberNavController())
                            }
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun LoginScreen(navController: NavController) {
    // Write a message to the database
    val database = Firebase.database
    val myRef = database.getReference()

    myRef.setValue("")

    Surface(
        color = Color.Cyan,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .padding(30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.welcome))

            Spacer(modifier = Modifier.height(20.dp))

            MyTextFieldComponent(labelValue = stringResource(id = R.string.email))
            PasswordFieldComponent(labelValue = stringResource(id = R.string.password))

            Spacer(modifier = Modifier.height(15.dp))

            UnderlinedNormalTextComponent(value = stringResource(id = R.string.forgot_password))

            Spacer(modifier = Modifier.height(40.dp))

            ButtonComponent(value = stringResource(id = R.string.login),
                navController = navController)

            Spacer(modifier = Modifier.height(20.dp))

            DividerTextComponent()

            Spacer(modifier = Modifier.height(20.dp))

            ClickableLoginTextComponent (tryingToLogin = false, onTextSelected = {
                navController.navigate(ROUTE_REGISTER)
            })
        }
    }
}
@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())
}





















