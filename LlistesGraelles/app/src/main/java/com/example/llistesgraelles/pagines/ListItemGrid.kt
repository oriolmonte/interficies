package com.example.llistesgraelles.pagines

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.llistesgraelles.R
import com.example.llistesgraelles.dades.RepoFake
import com.example.llistesgraelles.dades.coses
import com.example.llistesgraelles.dades.coses3
import com.example.llistesgraelles.model.Cosa

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun ListItemsGrid (coses: List<Cosa> = coses3, onClickElement: (Int) -> Unit = {})
{
    LazyColumn (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){

        items(coses)
        {
            ListItem(
                modifier = Modifier
                    .clickable { onClickElement(it.id) },
                colors = ListItemDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    headlineColor = MaterialTheme.colorScheme.onTertiary,
                    supportingColor = MaterialTheme.colorScheme.onTertiary,
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
                        placeholder = painterResource(
                            R.drawable.ic_launcher_foreground
                        )
                    )

                }
            )
        }
    }
}
