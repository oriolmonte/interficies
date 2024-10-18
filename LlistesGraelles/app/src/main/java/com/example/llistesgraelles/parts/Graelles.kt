package com.example.llistesgraelles.parts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.llistesgraelles.R
import com.example.llistesgraelles.dades.RepoFake
import com.example.llistesgraelles.model.Cosa

@Preview
@Composable
fun LlistaVertical(coses:List<Cosa> = RepoFake.obtenirCoses())
{
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 10000.dp)
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

@Preview
@Composable
fun Graella(coses:List<Cosa> = RepoFake.obtenirCoses())
{
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(minSize = 90.dp)
    )
    {
        items(coses)
        {
            Column (modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)

            )
            {
                miniVertical(it)
            }
            HorizontalDivider(
                color = MaterialTheme.colorScheme.secondary
            )
            VerticalDivider(
                color = MaterialTheme.colorScheme.secondary,
                thickness = 2.dp
            )

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun ListItems (coses: List<Cosa> = RepoFake.obtenirCoses())
{
    LazyColumn (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        stickyHeader {
            Text("Coses", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary)
        }
        items(coses)
        {
            ListItem(
                modifier = Modifier,
                colors = ListItemDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    headlineColor = MaterialTheme.colorScheme.primary,
                    supportingColor = MaterialTheme.colorScheme.secondary,
                ),
                headlineContent = {
                    Text(it.nom)
                },
                supportingContent = {
                    Text(it.descripcio,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis)
                },
                trailingContent =
                {
                    Text(it.numero.toString())
                },
                leadingContent = {
                    AsyncImage(model = ImageRequest
                        .Builder(LocalContext.current)
                        .data(it.foto)
                        .crossfade(durationMillis = 2000)
                        .build(),
                        modifier = Modifier
                            .width(75.dp)
                            .height(75.dp),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        placeholder = painterResource(R.drawable.ic_launcher_foreground
                        ))

                }
            )
        }
    }
}
