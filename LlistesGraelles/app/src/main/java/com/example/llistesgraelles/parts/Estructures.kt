package com.example.llistesgraelles.parts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.text.style.TextAlign.Companion.Right
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.BitmapImage
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.llistesgraelles.R
import com.example.llistesgraelles.dades.RepoFake
import com.example.llistesgraelles.dades.RepoFake.CrearCosa
import com.example.llistesgraelles.model.Cosa


@Composable
fun miniHoritzontal(int: Int, onClick: (Int) -> Unit)
{
    val cosa:Cosa = CrearCosa(int)
    Row (modifier = Modifier
        .background(MaterialTheme.colorScheme.primaryContainer)
        .width(1000.dp)
        .clickable(onClick = { onClick(cosa.numero) })
    )

    {
        Box (modifier = Modifier
            .align(Alignment.CenterVertically)
            .padding(5.dp)

        ){

            AsyncImage(model = ImageRequest
                .Builder(LocalContext.current)
                .data(cosa.foto)
                .crossfade(durationMillis = 2000)
                .build(),
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                placeholder = painterResource(id=R.drawable.tresor)
                )

        }
        Box (modifier = Modifier
            .align(Alignment.CenterVertically)
            .padding(5.dp)
            .fillMaxWidth()
        ){

            Column(modifier = Modifier.fillMaxWidth())
            {
                Text(cosa.nom, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.End)

                )
                Text(cosa.numero.toString(), fontSize = 10.sp, color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.align(Alignment.End)
                )

            }
        }

    }
}
@Preview
@Composable
fun miniHoritzontalPreview()
{
    val c:Cosa = CrearCosa(2)
}
@Composable
fun miniVertical(int: Int, onClick: (Int) -> Unit = {})
{
    val cosa:Cosa = CrearCosa(int)
    Row (modifier = Modifier
        .background(MaterialTheme.colorScheme.primaryContainer)
        .width(85.dp)
        .height(150.dp)
        .clickable(onClick = { onClick(cosa.numero) })
    )
    {
        Column (modifier = Modifier
            .padding(5.dp)
            .fillMaxSize()
        ){
            AsyncImage(model = ImageRequest
                .Builder(LocalContext.current)
                .data(cosa.foto)
                .crossfade(durationMillis = 2000)
                .build(),
                modifier = Modifier
                    .width(75.dp)
                    .height(75.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                placeholder = painterResource(id=R.drawable.tresor)
            )
            Box(modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxSize()
                )
            {
                Column(modifier = Modifier.align(Alignment.BottomCenter))
                {
                    Text(cosa.nom, color = MaterialTheme.colorScheme.primary, textAlign = Right, fontWeight = FontWeight.Bold,
                        modifier = Modifier
                    )
                    Text(cosa.numero.toString(), fontSize = 10.sp, color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }

            }
            }
        }
    }
@Composable
fun cartaClicable(int: Int, onClick: (Int) -> Unit = {})
{
    val cosa:Cosa = CrearCosa(int)
    Column (modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize()
        .clickable { onClick(int) }
    )
    {
        Row(modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
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
