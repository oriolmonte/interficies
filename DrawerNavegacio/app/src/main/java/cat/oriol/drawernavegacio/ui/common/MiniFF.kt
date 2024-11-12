package cat.oriol.drawernavegacio.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
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
import cat.oriol.drawernavegacio.model.Gent
import coil.compose.AsyncImage

@Composable
fun ElementHoritzontalFF (id: Int, onClick:(Int) -> Unit = {})
{
    val ffelement = obtenElementLlistaGent(id)
    Row(
        modifier=Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(percent=10))
            .padding(4.dp)
            .background(
                color = Color(0xff283a7d),
                shape = RoundedCornerShape(percent=10)
            )
            .clickable(onClick = {onClick(id)})
        , verticalAlignment = Alignment.CenterVertically
    )
    {
        AsyncImage(
            model = ffelement.foto,
            contentDescription = null,
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(1f)
                .height(150.dp)
                .weight(1f)
        )
        Text(
            text = ffelement.nom,
            style = MaterialTheme.typography.displaySmall,
            fontSize = 28.sp,
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(3f)
        )
        val context = LocalContext.current
        //He fet servir chatgpt per a tenir la id de la imatge a partir del nom aixo, no ho sabia fer...
        val imageid = context.resources.getIdentifier(ffelement.job.lowercase().replace(" ","")
            ,"drawable",
            context.packageName)
        Image(
            painter = painterResource(id=imageid),
            contentDescription=null,
            modifier = Modifier
                .aspectRatio(1f)
                .height(150.dp)
                .weight(1f)
        )
    }
}

@Preview
@Composable
fun MiniFFPreview()
{

    ElementHoritzontalFF(25)
}
