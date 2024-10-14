package com.example.llistesgraelles.parts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.BitmapImage
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.llistesgraelles.R
import com.example.llistesgraelles.dades.RepoFake
import com.example.llistesgraelles.dades.RepoFake.CrearCosa
import com.example.llistesgraelles.model.Cosa


@Composable
fun miniHoritzontal(cosa: Cosa)
{
    Row (modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
    )

    {
        Box (modifier = Modifier
            .align(Alignment.CenterVertically)
            .padding(5.dp)

        ){
            Image(painter = painterResource(id = R.drawable.tresor),"A", modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                )

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
            .wid
        ){

            Text(cosa.nom, color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.align(Alignment.Center)
            )
        }

    }
}

@Preview
@Composable
fun miniHoritzontalPreview()
{
    val c:Cosa = CrearCosa(2)
    miniHoritzontal(c);
}