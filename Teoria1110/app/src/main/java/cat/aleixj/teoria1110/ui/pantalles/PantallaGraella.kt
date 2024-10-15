package cat.aleixj.teoria1110.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.aleixj.teoria1110.R
import cat.aleixj.teoria1110.dades.repositoryFake
import cat.aleixj.teoria1110.model.Guerrer
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

@Preview
@Composable
fun PantallaGraella(guerrers : List<Guerrer> = repositoryFake.obtenirDadesDelsGuerrers(),
                    onClickGuerre : (Int) -> Unit = {})
{
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(minSize = 150.dp)
        //columns = GridCells.Adaptive(minSize = 150.dp)
    )
    {
        items(guerrers) {
            Column(modifier = Modifier.background(Color.Yellow)) {
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
                    placeholder = painterResource(
                        R.drawable.ic_launcher_foreground
                    )
                )

                Text(it.nom)
                HorizontalDivider(
                    color = Color.Blue,
                    thickness = 2.dp,
                    modifier = Modifier.height(8.dp))
            }
        }
    }
}