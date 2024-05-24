package com.chebby.glamourgrove3.components

import android.util.Log
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chebby.glamourgrove3.R
import com.chebby.glamourgrove3.navigation.ROUTE_HOME
import com.chebby.glamourgrove3.navigation.ROUTE_LOGIN
import com.chebby.glamourgrove3.navigation.ROUTE_REGISTER
import com.chebby.glamourgrove3.screens.RegisterScreen

@Composable
fun NormalTextComponent(value : String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = Color.Black,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value : String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(40.dp),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = Color.Black,
        textAlign = TextAlign.Center
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(labelValue: String){

    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        label = { Text(text = labelValue) },
        value = textValue.value,
        colors = TextFieldDefaults.textFieldColors(Color.Black),
        keyboardOptions = KeyboardOptions.Default,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = "")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldComponent(labelValue: String){
    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        label = { Text(text = labelValue) },
        value = textValue.value,
        colors = TextFieldDefaults.textFieldColors(Color.Black),
        keyboardOptions = KeyboardOptions.Default,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Email, contentDescription = "")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldComponent(labelValue: String){
    val password = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        label = { Text(text = labelValue) },
        value = password.value,
        colors = TextFieldDefaults.textFieldColors(Color.Black),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Lock, contentDescription = "")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmPasswordFieldComponent(labelValue: String){

    val password = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        label = { Text(text = labelValue) },
        value = password.value,
        colors = TextFieldDefaults.textFieldColors(Color.Black),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Lock, contentDescription = "")
        }
    )
}

@Composable
fun CheckboxComponent(value: String, onTextSelected: (String) -> Unit){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        val checkedState = remember {
            mutableStateOf(false)
        }

        Checkbox(
            checked = checkedState.value, onCheckedChange = {
                checkedState.value = !checkedState.value
            }
        )
        ClickableTextComponent(value = value) {
        }
    }

}

@Composable
fun ClickableTextComponent(value: String,onTextSelected : (String) -> Unit) {
    val initialText = "By continuing accept our "
    val privacyPolicyText = "Privacy Policy "
    val andText = "and "
    val termsAndConditionstext = " Terms of use "

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Red)) {
            pushStringAnnotation(
                tag = privacyPolicyText,
                annotation = privacyPolicyText
            )
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Color.Red)) {
            pushStringAnnotation(
                tag = termsAndConditionstext,
                annotation = termsAndConditionstext
            )
            append(termsAndConditionstext)
        }
    }
    ClickableText(text = annotatedString, onClick = {offset ->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {span -> 
                Log.d("ClickableTextComponent","{$span}")

                if (span.item == termsAndConditionstext || (span.item == privacyPolicyText)){
                    onTextSelected(span.item)
                }
            }
        }
    )
}

@Composable
fun ButtonComponent(value: String,navController: NavController){
    Button(
        onClick = {
                  navController.navigate(ROUTE_HOME)
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Blue)
    ) {
       Box (
           modifier = Modifier
               .fillMaxWidth()
               .heightIn(48.dp)
               .background(color = Color.Blue, shape = RoundedCornerShape(50.dp)),
           contentAlignment = Alignment.Center
       ){
           Text(text = value,
               fontSize = 18.sp,
               fontWeight = FontWeight.Bold
           )
       }
    }
}


@Composable
fun ButtonComponent1(value: String,navController: NavController){
    Button(
        onClick = {
                  navController.navigate(ROUTE_LOGIN)
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Blue)
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(color = Color.Blue, shape = RoundedCornerShape(50.dp)),
            contentAlignment = Alignment.Center
        ){
            Text(text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun DividerTextComponent(){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            thickness = 1.dp,
            color = Color.DarkGray
        )
        Text(
            modifier = Modifier
                .padding(8.dp),
            text = "or",
            fontSize = 14.sp,
            color = Color.Black)
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            thickness = 1.dp,
            color = Color.DarkGray
        )
        
    }
}


@Composable
fun ClickableLoginTextComponent(tryingToLogin:Boolean = true, onTextSelected : (String) -> Unit) {
    val initialText = if (tryingToLogin)"Already have an Account? " else "Don't have an account yet? "
    val loginText =  if (tryingToLogin)"Login" else "Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Red)) {
            pushStringAnnotation(
                tag = loginText,
                annotation = loginText
            )
            append(loginText)
        }
    }
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString, onClick = {offset ->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {span ->
                Log.d("ClickableTextComponent","{$span}")

                if (span.item == loginText){
                    onTextSelected(span.item)
                }
            }
    }
    )
}

@Composable
fun UnderlinedNormalTextComponent(value : String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = Color.Blue,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}










