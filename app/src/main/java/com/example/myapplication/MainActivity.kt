package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.screens.Screen
import com.example.myapplication.ui.screens.home.Home

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen {
                Home()
            }
        }
    }
}

//region Button example
//@Preview(widthDp = 400, heightDp = 400, showBackground = true)
@Composable
fun ComposableTest() {
    ButtonPreview(buttonText = "Haz Click")
}

@Composable
fun ButtonPreview(buttonText: String) {
    val context = LocalContext.current
    Button(onClick = { Toast.makeText(context, "Hiciste click", Toast.LENGTH_SHORT).show() }) {
        Text(text = buttonText)
    }
}

//endregion
//region Box example
@Preview(widthDp = 400, heightDp = 200, showBackground = true)
@Composable
fun BoxPreview() {
    Surface {
        Box {
            Button(onClick = { /*TODO*/ }, Modifier.align(Alignment.Center)) {
                Text(text = "Soy un boton")
            }
            Text(text = "Hola buenas tardes", Modifier.align(Alignment.BottomStart))
        }
    }
}

//endregion
//region Column example
//@Preview(widthDp = 400, heightDp = 200, showBackground = true)
@Composable
fun ColumnPreview() {
    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TButton("Button1", Modifier.weight(1f))
            TButton("Button2", Modifier.weight(2f))
            TButton("Button3", Modifier.weight(1f))
        }
    }
}

@Composable
fun TButton(text: String, modifier: Modifier = Modifier) {
    Button(onClick = { /*TODO*/ }, modifier = modifier) {
        Text(text = text)
    }
}

//Igual para Row
//endregion
//region Login form
@OptIn(ExperimentalMaterial3Api::class)
@Preview(widthDp = 200, heightDp = 200, showBackground = true)
@Composable
fun LoginForm() {
    Surface {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(value = "User", onValueChange = {})
            TextField(value = "Password", onValueChange = {})
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Login")
            }
        }
    }
}

//endregion
//region Modifiers order
@Preview(widthDp = 200, heightDp = 200, showBackground = true)
@Composable
fun TextButton() {
    Screen {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Pepe pepito pepe", modifier = Modifier
                .clickable { }
                .border(2.dp, Color.Blue)
                .background(Color.Cyan)
                .padding(10.dp)
                .border(2.dp, Color.Red)
                .background(Color.Gray)
                .padding(10.dp))
        }
    }
}
//Al poner clickable al inicio toda el area azul es clickable, al final solo seria
//clickable al area gris
//endregion
