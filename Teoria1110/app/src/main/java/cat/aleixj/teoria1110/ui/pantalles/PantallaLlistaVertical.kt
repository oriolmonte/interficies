package cat.aleixj.teoria1110.ui.pantalles

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.aleixj.teoria1110.R
import cat.aleixj.teoria1110.dades.repositoryFake
import cat.aleixj.teoria1110.model.Guerrer
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

@OptIn(ExperimentalFoundationApi::class)
@Preview(showSystemUi = true)
@Composable
fun  PantallaLlistaVertical(guerrers : List<Guerrer> = repositoryFake.obtenirDadesDelsGuerrers(),
                            onClickGuerre : (Int) -> Unit = {})
{
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp)
            , verticalArrangement = Arrangement.spacedBy(16.dp)
    )
    {
        stickyHeader {
            Text("Llista de guerres",
                style = MaterialTheme.typography.displaySmall,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray))

        }
        items(guerrers){
            //Text(it.nom)
            ListItem(
                modifier = Modifier
                    .clickable { onClickGuerre(it.id) },
                colors = ListItemDefaults.colors(
                    containerColor = Color.DarkGray,
                    headlineColor = it.color,
                    supportingColor = Color.White,
                    trailingIconColor = Color.White,
                    leadingIconColor = Color.White
                ),
                headlineContent = { Text(it.nom,
                    style = MaterialTheme.typography.displaySmall)},
                supportingContent = { Text(it.descripcio,
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis) },
                trailingContent = {
                    Text(it.id.toString())
                },

                leadingContent = {
                     AsyncImage(model = ImageRequest
                            .Builder(LocalContext.current)
                            .data(it.foto)
                            .crossfade(durationMillis = 2000)
                            .build(),
                         modifier = Modifier
                         .width(50.dp)
                         .height(50.dp),
                         contentScale = ContentScale.Crop,
                         contentDescription = null,
                         placeholder = painterResource(R.drawable.ic_launcher_foreground
                     ))

                }

            )
           HorizontalDivider(color = Color.White, thickness = 2.dp, modifier = Modifier.height(8.dp))
        }
    }
}