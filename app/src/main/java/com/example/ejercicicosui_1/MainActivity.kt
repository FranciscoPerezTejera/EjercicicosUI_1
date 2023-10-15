package com.example.ejercicicosui_1


import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejercicicosui_1.ui.theme.EjercicicosUI_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjercicicosUI_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val contexto: Context = this
                    CambiarnumeroToast(contexto)
                }
            }
        }
    }
}

@Composable
fun CambiarnumeroToast(contexto: Context) {

    var count by remember { mutableStateOf(0) }
    var mensaje by remember { mutableStateOf("El número actual de pulsaciones es: $count") }


    Column (modifier = Modifier
        .background(Color.Yellow)
        .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = { Toast.makeText(contexto, mensaje, Toast.LENGTH_SHORT).show() },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.Magenta),
            shape = RectangleShape) {
            Text(text = "TOAST")
        }

        Text(
            text = count.toString(),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Magenta)


        Button(onClick = {
            count++
            mensaje = "El número de pulsaciones es $count"
                         },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RectangleShape) {
            Text(text = "COUNT")
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    EjercicicosUI_1Theme {
        Column (modifier = Modifier
            .background(Color.Yellow)
            .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Button(onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RectangleShape) {
                Text(text = "TOAST")
            }

            Text(
                text = "0",
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Magenta,
            )

            Button(onClick = {
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RectangleShape) {
                Text(text = "COUNT")
            }

        }
    }
}