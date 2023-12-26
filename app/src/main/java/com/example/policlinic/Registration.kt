package com.example.policlinic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.policlinic.ui.theme.PoliclinicTheme

class Registration : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PoliclinicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    var loginValue by remember { mutableStateOf(TextFieldValue("")) }
    var passwordValue by remember { mutableStateOf(TextFieldValue("")) }
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {



        Column(verticalArrangement = Arrangement.Center, modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            Surface(color = Color.White, modifier = Modifier.padding(8.dp)) {

                Text(text = "Регистрация", modifier = Modifier.padding(10.dp))

            }
            Surface(color = Color.White, modifier = Modifier.padding(8.dp)) {

                OutlinedTextField(
                    value = loginValue,
                    onValueChange = { loginValue = it },
                    label = { Text(text = stringResource(id = R.string.sign_in_email)) },
                    placeholder = { Text(text = stringResource(id = R.string.sign_in_email)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Surface(color = Color.White, modifier = Modifier.padding(8.dp)) {
                OutlinedTextField(
                    value = passwordValue,
                    onValueChange = { passwordValue = it },
                    label = { Text(text = stringResource(id = R.string.sign_in_password)) },
                    placeholder = { Text(text = stringResource(id = R.string.sign_in_password)) },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Button(

                onClick = {




                },
                colors = ButtonDefaults.buttonColors( Color.Red),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()) {
                Text(text = stringResource(id = R.string.sign_in_submit), modifier = Modifier.padding(8.dp))
            }
            Column()
            {

                Row (horizontalArrangement = Arrangement.End, modifier = Modifier
                    .padding(10.dp, 10.dp, 10.dp, 10.dp)
                    .fillMaxWidth()) {
                    Text(text = "Registration")

                }


            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    PoliclinicTheme {
        Greeting2("Android")
    }
}