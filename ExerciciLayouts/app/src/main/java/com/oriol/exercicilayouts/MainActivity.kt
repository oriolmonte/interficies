package com.oriol.exercicilayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.oriol.exercicilayouts.ui.theme.ExerciciLayoutsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExerciciLayoutsTheme {

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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainWindow()
    {
    Box()
    {
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .fillMaxSize()
            .verticalScroll(rememberScrollState(),true)
        )
        {
                Button(onClick = {}, modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)

                ) {
                    Text("Calculadora", fontSize = 20.sp)
                }
                Button(onClick = {}, modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                ) {
                    Text("Dibuix", fontSize = 20.sp)
                }
                Button(onClick = {}, modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                ) {
                    Text("Formulari", fontSize = 20.sp)
                }
                Button(onClick = {}, modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                ) {
                    Text("Tria de Colors", fontSize = 20.sp)
                }
                Button(onClick = {}, modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                ) {
                    Text("Text", fontSize = 20.sp)
                }

            Button(onClick = {}, modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
            ) {
                Text("Text amb menu", fontSize = 20.sp)
            }
        }
    }
    }
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Calculadora()
{
    Box(modifier = Modifier
        .padding(10.dp, top = 10.dp,bottom = 40.dp))
    {
        Row()
        {

            Column(
                modifier = Modifier
                    .weight(70f)
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(25f)
                        .padding(10.dp)
                )
                {
                    Button(onClick = {}, modifier = Modifier.weight(33.3f).fillMaxSize().padding(10.dp))
                    {
                        Text("7", fontSize = 50f.sp)
                    }
                    Button(onClick = {}, modifier = Modifier.weight(33.3f).fillMaxSize().padding(10.dp))
                    {
                        Text("8", fontSize = 50f.sp)
                    }

                    Button(onClick = {}, modifier = Modifier.weight(33.3f).fillMaxSize().padding(10.dp))
                    {
                        Text("9", fontSize = 50f.sp)
                    }

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(25f)
                        .padding(10.dp)
                )
                {
                    Button(onClick = {}, modifier = Modifier.weight(33.3f).fillMaxSize().padding(10.dp))
                    {
                        Text("4", fontSize = 50f.sp)
                    }

                    Button(onClick = {}, modifier = Modifier.weight(33.3f).fillMaxSize().padding(10.dp))
                    {
                        Text("5", fontSize = 50f.sp)
                    }
                    Button(onClick = {}, modifier = Modifier.weight(33.3f).fillMaxSize().padding(10.dp))
                    {
                        Text("6", fontSize = 50f.sp)
                    }

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(25f)
                        .padding(10.dp)
                )
                {
                    Button(onClick = {}, modifier = Modifier.weight(33.3f).fillMaxSize().padding(10.dp))
                    {
                        Text("1", fontSize = 50f.sp)
                    }

                    Button(onClick = {}, modifier = Modifier.weight(33.3f).fillMaxSize().padding(10.dp))

                    {
                        Text("2", fontSize = 50f.sp)
                    }
                    Button(onClick = {}, modifier = Modifier.weight(33.3f).fillMaxSize().padding(10.dp))

                    {
                        Text("3", fontSize = 50f.sp)
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(25f)
                        .padding(10.dp)
                )
                {
                    Button(onClick = {}, modifier = Modifier.weight(33.3f).fillMaxSize().padding(10.dp))
                    {
                        Text("0", fontSize = 50f.sp)
                    }
                }
            }
            Column(
                modifier = Modifier
            )
            {
                Button(onClick = {}, modifier = Modifier.weight(33.3f).padding(10.dp))
                {
                    Text("+", fontSize = 50f.sp)
                }
                Button(onClick = {}, modifier = Modifier.weight(33.3f).padding(10.dp))
                {
                    Text("C", fontSize = 50f.sp)
                }
                Button(onClick = {}, modifier = Modifier.weight(33.3f).padding(10.dp))
                {
                    Text("=", fontSize = 50f.sp)
                }
            }
        }
    }
}
