package cat.oriol.drawernavegacio.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.text.style.TextAlign.Companion.Right
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.oriol.drawernavegacio.R
import cat.oriol.drawernavegacio.dades.RepoFake.obteneElementLlistaPirates
import coil.compose.AsyncImage

@Preview
@Composable
fun miniPirates(index: Int, onClick: (Int) -> Unit = {})
{
    val pirata = obteneElementLlistaPirates(index)
    Box(
        modifier = Modifier
            .width(85.dp)
            .height(150.dp)
            .clickable(onClick = { onClick(pirata.id) })
    )
    {
        Image(painter = painterResource(R.drawable.bgpirates),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize(),
        )
        Column(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxSize()
        ) {
            AsyncImage(
                model = pirata.foto,
                contentDescription = null,
                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
            )

            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            {
                Column(modifier = Modifier.align(Alignment.BottomCenter))
                {
                    Text(
                        pirata.nom,
                        color = Color(0XFF4d2200),
                        textAlign = Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .align(
                                Alignment.CenterHorizontally
                            )
                    )
                    Text(
                        pirata.recompensa.toString()+"$",
                        color = Color(0XFF4d2200),
                        textAlign = Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(
                                Alignment.CenterHorizontally
                            )
                    )
                }

            }
        }
    }
}

