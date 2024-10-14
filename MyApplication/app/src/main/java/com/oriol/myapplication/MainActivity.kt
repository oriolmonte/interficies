package com.oriol.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oriol.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Greeting("Hola")
                }
            }
        }
    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}


@Preview(showSystemUi = true)
@Composable
fun Caixa(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(MaterialTheme.colorScheme.primaryContainer)


    )
    {
        Text(
            text = "hola",
            modifier = Modifier
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.primary)
        )

        Text(
            text = "hola",
            modifier = Modifier
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.primary)
                .align(Alignment.TopEnd)
        )
        Text(
            text = "hola",
            modifier = Modifier
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.primary)
                .align(Alignment.TopEnd)
        )
        Image(painter= painterResource(id = R.drawable.imgsaa), contentDescription = null )

//        Button(modifier = Modifier
//            .align(Alignment.Center), onClick ={ }, content = {Text("Hola")})
    }
}
