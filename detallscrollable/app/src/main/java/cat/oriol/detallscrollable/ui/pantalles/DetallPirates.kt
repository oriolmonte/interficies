package cat.oriol.detallscrollable.ui.pantalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.oriol.detallscrollable.R
import cat.oriol.detallscrollable.dades.RepoFake.obteneElementLlistaPirates
import coil.compose.AsyncImage

@Composable
fun detallPirates(index: Int) {
    val pirates = obteneElementLlistaPirates(index)
    Box(modifier= Modifier.fillMaxSize())
    {
        Image(
            painter = painterResource(R.drawable.bgpirates),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize(),
        )
        Column(

        )
        {
            Row(
            )
            {
                AsyncImage(
                    model = pirates.foto,
                    contentDescription = null,
                    placeholder = painterResource(R.drawable.ic_launcher_foreground),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .height(300.dp)
                        .weight(1f)
                )
            }
            Row (

            )
            {
                Text(
                    text = "WANTED!",
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 70.sp,
                    color = Color(0XFF4d2200),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(
            )
            {
                Text(
                    text = pirates.nom,
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 40.sp,
                    color = Color(0XFF4d2200),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(
                modifier = Modifier.weight(0.3f)

            )
            {
                Text(
                    text = pirates.recompensa.toString() + " $",
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 40.sp,
                    color = Color(0XFF4d2200),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row (
            )
            {
                Text(
                    text = "DEAD OR ALIVE",
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 30.sp,
                    color = Color(0XFF4d2200),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }
}
