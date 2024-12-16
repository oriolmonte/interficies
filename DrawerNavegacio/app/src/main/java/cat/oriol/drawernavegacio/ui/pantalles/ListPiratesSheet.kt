package cat.oriol.drawernavegacio.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.oriol.drawernavegacio.dades.RepoFake.obtenLlistaPirates
import cat.oriol.drawernavegacio.model.Pirates
import cat.oriol.drawernavegacio.navegacio.DetallPirates
import cat.oriol.drawernavegacio.ui.common.ElementHoritzontalFF
import cat.oriol.drawernavegacio.ui.common.miniPirates

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ListPiratesSheet(pirates:List<Pirates>, onClickElement: (Int) -> Unit = {})
{
    var mostraFullaInferior: Boolean by remember { mutableStateOf(false) }
    val estatFullaInferior = rememberModalBottomSheetState()
    var elementActual by remember{ mutableStateOf(0) }

    Column(
        modifier = Modifier.background(Color(0XFF4d2200))
    )

    {
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(percent=10))
                .padding(4.dp)
                .background(
                    color = Color(0XFF4d2200),
                    shape = RoundedCornerShape(percent=10)
                )
            , verticalAlignment = Alignment.CenterVertically
        )
        {
            Text("PIRATES",
                color = Color.White,
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()

            )
        }
        LazyVerticalStaggeredGrid (
            columns = StaggeredGridCells.Fixed(4),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        )
        {
            items(pirates)
            {
                miniPirates(it.id, onClick={
                    mostraFullaInferior = true
                    elementActual = it
                }

                )
                HorizontalDivider(
                    color = Color(0XFF4d2200),
                    thickness = 8.dp
                )
            }
        }
        if(mostraFullaInferior)
        {
            ModalBottomSheet(
                onDismissRequest = {mostraFullaInferior=false},
                sheetState = estatFullaInferior
            ) {
                Column {
                    ContingutPaginadorAmbTabsPirates(PaddingValues(0.dp), elementActual)
                }
            }
        }
    }
}
@Composable
fun ContingutPaginadorAmbTabsPirates(innerPadding: PaddingValues, initialPage: Int = 0) {
    val ambitCorrutina = rememberCoroutineScope()
    val listPirates = obtenLlistaPirates()
    val estatPaginador = rememberPagerState(initialPage=initialPage) { listPirates.size }
    Column(modifier=Modifier
        .padding(innerPadding)
        .fillMaxSize()
    )
    {
        HorizontalPager(
            modifier = Modifier
                .weight(1F),
            state = estatPaginador,
            beyondViewportPageCount = 3,
        )
        {
            detallPirates(it)
        }
    }
}


