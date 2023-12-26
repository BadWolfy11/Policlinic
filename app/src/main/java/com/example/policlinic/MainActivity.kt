package com.example.policlinic

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.policlinic.ui.theme.PoliclinicTheme
import java.sql.Connection

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PoliclinicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {  var loginValue = remember { mutableStateOf("") }
    var passwordValue = remember { mutableStateOf("") }

    var errorState = remember { mutableStateOf(false) }
    var arrorMessage = remember { mutableStateOf("") }

    var column1Value = ""


    try {
        val connection = Connect()
        val some = connection.getConnection()

        val statement = some.createStatement()
        val resultSet = statement.executeQuery("SELECT * FROM user")


        while (resultSet.next()) {
             column1Value = resultSet.getString("column1")
            val column2Value = resultSet.getInt("column2")

        }
        resultSet.close()
        statement.close()
        some.close()
    } catch (e: Exception) {

    }

    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {



        Text(text = column1Value)
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(8.dp)) {

                Text(text = "Войти", modifier = Modifier.padding(10.dp))

            }
            Surface(color = Color.White, modifier = Modifier.padding(8.dp)) {

                TextField(
                    value = loginValue.value,
                    onValueChange = { loginValue.value = it },
                    label = { Text(text = stringResource(id = R.string.sign_in_email)) },
                    placeholder = { Text(text = stringResource(id = R.string.sign_in_email)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Surface(color = Color.White, modifier = Modifier.padding(8.dp)) {
                TextField(
                    value = passwordValue.value,
                    onValueChange = {
                        passwordValue.value = it
                        when {
                            passwordValue.value == "" -> {
                                errorState.value = true
                                arrorMessage.value = "Password should not blank"
                            }
                            else -> {
                                errorState.value  = false
                                arrorMessage.value  = ""
                            }
                        }
                    },
                    label = { Text(
                        text = if (errorState.value) arrorMessage.value
                        else "Password"
                    ) },
                    isError = errorState.value,
                    placeholder = { Text(text = stringResource(id = R.string.sign_in_password)) },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),

                    )
            }
            Button(

                onClick = {



                },
                colors = ButtonDefaults.buttonColors( Color.Red),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()) {
                Text(text = "Login", modifier = Modifier.padding(8.dp))
            }
            val mContext = LocalContext.current

            Column()
            {

                Row (horizontalArrangement = Arrangement.End, modifier = Modifier
                    .padding(10.dp, 10.dp, 10.dp, 10.dp)
                    .fillMaxWidth()) {
                    Button(

                        onClick = {


                            mContext.startActivity(Intent(mContext, Registration::class.java))

                        },
                        colors = ButtonDefaults.buttonColors( Color.Red),
                        modifier = Modifier
                            .padding(8.dp)) {
                        Text(text = "Registr", modifier = Modifier.padding(8.dp))
                    }

                }


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PoliclinicTheme {
        Greeting("Android")
    }
}