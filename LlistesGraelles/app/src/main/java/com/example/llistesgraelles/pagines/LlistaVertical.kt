package com.example.llistesgraelles.pagines

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Right
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.llistesgraelles.R
import com.example.llistesgraelles.model.Cosa
import com.example.llistesgraelles.navegacio.LlistaVertical
import com.example.llistesgraelles.parts.miniHoritzontal

@Composable
fun PantallaLlistaVertical(coses:List<Cosa>, onClickElement:(Int) -> Unit = {})
{
    LazyColumn (
    )
    {
        items(coses)
        {
            Column (modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)

            )
            {
                miniHoritzontal(it)
            }
            HorizontalDivider(
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}
