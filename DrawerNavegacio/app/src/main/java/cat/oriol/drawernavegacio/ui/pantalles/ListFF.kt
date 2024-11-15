package cat.oriol.drawernavegacio.ui.pantalles

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.oriol.drawernavegacio.R
import cat.oriol.drawernavegacio.dades.RepoFake.obtenLlistaGent
import cat.oriol.drawernavegacio.model.Gent
import cat.oriol.drawernavegacio.ui.common.ElementHoritzontalFF

@OptIn(ExperimentalFoundationApi::class)
//@Preview(showSystemUi = true)
@Composable
fun PantallaLlistaFF (
    llista: List<Gent>,
    onClickElement: (Int) -> Unit = {},
)
{
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.ff14bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)

        ) {
            stickyHeader {
                Text(
                    text = "Characters",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF0e1630))
                        .padding(16.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.displaySmall,
                    textAlign = TextAlign.Center
                )
            }
            itemsIndexed(llista)
            { index, _ ->

                ElementHoritzontalFF(index, onClick = { onClickElement(index) })
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}