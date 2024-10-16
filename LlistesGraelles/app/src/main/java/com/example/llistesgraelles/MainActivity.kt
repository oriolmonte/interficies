package com.example.llistesgraelles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.llistesgraelles.dades.RepoFake
import com.example.llistesgraelles.dades.RepoFake.CrearCosa
import com.example.llistesgraelles.model.Cosa
import com.example.llistesgraelles.parts.Graella
import com.example.llistesgraelles.parts.ListItems
import com.example.llistesgraelles.parts.LlistaVertical
import com.example.llistesgraelles.parts.fullCarta
import com.example.llistesgraelles.parts.miniHoritzontal
import com.example.llistesgraelles.parts.miniVertical
import com.example.llistesgraelles.ui.theme.LlistesGraellesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LlistesGraellesTheme {
                val coses = RepoFake.obtenirCoses()
                fullCarta(coses[1])
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LlistesGraellesTheme {
        Greeting("Android")
    }
}