package cat.oriol.drawernavegacio.ui.pantalles

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cat.oriol.drawernavegacio.R
import cat.oriol.drawernavegacio.model.Gent
import cat.oriol.drawernavegacio.navegacio.DetallFF
import cat.oriol.drawernavegacio.ui.common.ElementHoritzontalFF
import cat.oriol.drawernavegacio.ui.common.ElementHoritzontalFFSimple

@ExperimentalMaterial3Api
@OptIn(ExperimentalFoundationApi::class)
//@Preview(showSystemUi = true)
@Composable
fun PantallaLlistaFFBottomSheet (
    llista: List<Gent>,
    onClickElement: (Int) -> Unit = {},
)
{
    var mostraFullaInferior: Boolean by remember { mutableStateOf(false) }
    val estatFullaInferior = rememberModalBottomSheetState()
    var elementActual by remember{ mutableStateOf(0) }

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

                ElementHoritzontalFFSimple(index, onClick = {
                    elementActual=index
                    mostraFullaInferior = true
                })
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
    if(mostraFullaInferior)
    {
        ModalBottomSheet(
            onDismissRequest = {mostraFullaInferior=false},
            sheetState = estatFullaInferior
        ) {
            Column {
                ElementHoritzontalFF(elementActual, onClick = {onClickElement(elementActual)})
            }
        }
     }
}