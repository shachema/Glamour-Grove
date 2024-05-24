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
import com.chebby.glamourgrove3.components.ButtonComponent1
import com.chebby.glamourgrove3.components.CheckboxComponent
import com.chebby.glamourgrove3.components.ClickableLoginTextComponent
import com.chebby.glamourgrove3.components.ConfirmPasswordFieldComponent
import com.chebby.glamourgrove3.components.DividerTextComponent
import com.chebby.glamourgrove3.components.HeadingTextComponent
import com.chebby.glamourgrove3.components.MyTextFieldComponent
import com.chebby.glamourgrove3.components.NormalTextComponent
import com.chebby.glamourgrove3.components.PasswordFieldComponent
import com.chebby.glamourgrove3.components.TextFieldComponent
import com.chebby.glamourgrove3.navigation.ROUTE_LOGIN
import com.chebby.glamourgrove3.navigation.ROUTE_REGISTER
import com.chebby.glamourgrove3.ui.theme.GlamourGrove3Theme
import com.google.firebase.Firebase
import com.google.firebase.database.database

class SignUpActivity : ComponentActivity() {
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
                                RegisterScreen(navController = rememberNavController())
                            }
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun RegisterScreen(navController: NavController) {
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
            HeadingTextComponent(value = stringResource(id = R.string.create_account))

            TextFieldComponent(labelValue = stringResource(id = R.string.first_name))

            TextFieldComponent(labelValue = stringResource(id = R.string.last_name))

            MyTextFieldComponent(labelValue = stringResource(id = R.string.email))
            PasswordFieldComponent(labelValue = stringResource(id = R.string.password))
            ConfirmPasswordFieldComponent(
                labelValue = stringResource(id = R.string.confirm_password)
            )
            CheckboxComponent(value = stringResource(id = R.string.terms_and_conditions),
                onTextSelected = {
                }
            )
            Spacer(modifier = Modifier.height(40.dp))

            ButtonComponent1(value = stringResource(id = R.string.register),
                navController = navController)

            DividerTextComponent()

            ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                navController.navigate(ROUTE_LOGIN)
            })
        }
    }
}


@Preview
@Composable
fun RegisterScreenPreview(){
    RegisterScreen(rememberNavController())
}