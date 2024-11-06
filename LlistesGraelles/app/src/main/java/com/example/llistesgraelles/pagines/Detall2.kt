package com.example.llistesgraelles.pagines

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.llistesgraelles.R
import com.example.llistesgraelles.dades.RepoFake
import com.example.llistesgraelles.dades.RepoFake.CrearCosa
import com.example.llistesgraelles.dades.RepoFake2
import com.example.llistesgraelles.dades.coses2
import com.example.llistesgraelles.model.Cosa

@Composable
fun detall2(int: Int)
{
    val cosa = coses2[int]
    Column (modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize()
    )
    {
        Row(modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
        )
        {
            Text(cosa.nom,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold,
                fontSize = 65.sp,
                textAlign = Center,
                modifier = Modifier.fillMaxWidth()
            )

        }
        Row (modifier = Modifier)
        {
            AsyncImage(model = ImageRequest
                .Builder(LocalContext.current)
                .data(cosa.foto)
                .crossfade(durationMillis = 2000)
                .build(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                placeholder = painterResource(id=R.drawable.tresor)
            )
        }
        Box(modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .fillMaxSize())
        {
            Column()
            {
                Box(modifier = Modifier
                    .padding(10.dp)

                )
                {
                    Text(int.toString(),
                        color = MaterialTheme.colorScheme.background,
                        fontWeight = FontWeight.Bold,
                        fontSize = 150.sp,
                        textAlign = Center,
                        modifier = Modifier.fillMaxWidth()
                            .align(Alignment.Center)
                    )
                    Text(cosa.descripcio,
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer)

                }

                Box(modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer))
                {

                    if(cosa.veritat) {
                        Text(
                            "Veritat",
                            fontSize = 15.sp,
                            color = Color.Green
                        )
                    }
                    else
                    {
                        Text(
                            "Mentida",
                            fontSize = 15.sp,
                            color = Color.Red
                        )
                    }
                }
                Column (modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer))
                {
                    Text(cosa.numero.toString()+"\n")
                    LinearProgressIndicator(
                        progress = { cosa.numero.toFloat()/100 },
                        trackColor = MaterialTheme.colorScheme.background,
                        modifier = Modifier.fillMaxWidth()

                    )
                }
            }

        }



    }
}
