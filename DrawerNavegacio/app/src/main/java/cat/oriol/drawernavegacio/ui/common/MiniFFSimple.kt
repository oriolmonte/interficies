package cat.oriol.drawernavegacio.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.oriol.drawernavegacio.dades.RepoFake.obtenElementLlistaGent

@Composable
fun ElementHoritzontalFFSimple (id: Int, onClick:(Int) -> Unit = {})
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
        , verticalAlignment = Alignment.CenterVertically
    )
    {
        IconButton(onClick={onClick(id)})
        {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "more")
        }
        Text(
            text = ffelement.nom,
            style = MaterialTheme.typography.displaySmall,
            fontSize = 28.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(3f)
        )

    }
}

@Preview
@Composable
fun MiniFFSimplePreview()
{

    ElementHoritzontalFFSimple(25)
}
