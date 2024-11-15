package cat.oriol.detallscrollable.ui.pantalles

import cat.oriol.detallscrollable.dades.RepoFake.obtenElementLlistaPokemons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.oriol.detallscrollable.R
import coil.compose.AsyncImage
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun detallPokemon(index: Int) {
    val pokemon = obtenElementLlistaPokemons(index)
    val colors = listOf(
        Color.Red,
        Color.Blue,
        Color.Green,
        Color.Magenta,
        Color.DarkGray,
    )
    Box(modifier=Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background))
    {
        Column(
        )
        {
            Row(
            )
            {
                AsyncImage(
                    model = pokemon.foto,
                    contentDescription = null,
                    placeholder = painterResource(R.drawable.ic_launcher_foreground),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(300.dp)
                )
            }
            Row(
            )
            {
                Text(
                    text = pokemon.nom,
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(
            )
            {
                Text(
                    text = "Atac: ${pokemon.atac} Def: ${pokemon.defensa}",
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 25.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(
                modifier=Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(percent=10))
                    .padding(4.dp)
                    .background(
                        color = colors[Random.nextInt(0..colors.size-1)],
                        shape = RoundedCornerShape(percent=10)
                    )
                , verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = pokemon.move1,
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 20.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(
                modifier=Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(percent=10))
                    .padding(4.dp)
                    .background(
                        color = colors[Random.nextInt(0..colors.size-1)],
                        shape = RoundedCornerShape(percent=10)
                    )
                , verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = pokemon.move2,
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 20.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(
                modifier=Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(percent=10))
                    .padding(4.dp)
                    .background(
                        color = colors[Random.nextInt(0..colors.size-1)],
                        shape = RoundedCornerShape(percent=10)
                    )
                , verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = pokemon.move3,
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 20.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(
                modifier=Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(percent=10))
                    .padding(4.dp)
                    .background(
                        color = colors[Random.nextInt(0..colors.size-1)],
                        shape = RoundedCornerShape(percent=10)
                    )
                , verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = pokemon.move4,
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 20.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

