package cat.oriol.drawernavegacio.ui.pantalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.oriol.drawernavegacio.R
import cat.oriol.drawernavegacio.dades.RepoFake.obtenElementLlistaGent
import coil.compose.AsyncImage
import coil.size.Size

@Preview
@Composable
fun detallFF(index: Int) {
    val ffelement = obtenElementLlistaGent(index)
    Box(
        modifier = Modifier.fillMaxSize()

    )
    {
        Image(
            painter = painterResource(R.drawable.ff14bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize(),
        )
    }
    Column {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(percent = 10))
                .padding(4.dp)
                .background(
                    color = Color(0xFF0e1630),
                    shape = RoundedCornerShape(percent = 10)
                ), verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = ffelement.nom,
                style = MaterialTheme.typography.displaySmall,
                fontSize = 28.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
        )
        {
            AsyncImage(
                model = ffelement.foto,
                contentDescription = null,
                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .height(300.dp)
                    .weight(1f)
            )
        }
        Row()
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(percent = 10))
                    .padding(4.dp)
                    .background(
                        color = Color(0xff283a7d),
                        shape = RoundedCornerShape(percent = 10)
                    )
            )
            {
                Row(
                    modifier = Modifier.weight(0.1f).align(Alignment.CenterHorizontally)
                )
                {
                    Text(
                        ffelement.job,
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.White,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .padding(start = 30.dp, end = 30.dp)
                            .align(Alignment.CenterVertically)
                    )
                    val context = LocalContext.current
                    //He fet servir chatgpt per a tenir la id de la imatge a partir del nom aixo, no ho sabia fer...
                    val imageid = context.resources.getIdentifier(
                        ffelement.job.lowercase().replace(" ", ""), "drawable",
                        context.packageName
                    )
                    Image(
                        painter = painterResource(id = imageid),
                        contentDescription = null,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .height(50.dp)

                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                )
                {
                    Text(
                        ffelement.lloc,
                        color = Color.White,
                        textAlign = TextAlign.Left,
                        fontSize = 25.sp,
                        modifier = Modifier
                            .padding(horizontal = 25.dp, vertical = 10.dp)
                    )

                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                )
                {
                    Text(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .padding(start = 30.dp, end = 30.dp, bottom = 30.dp)
                    )

                }
            }
        }
    }
}


