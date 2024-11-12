package cat.oriol.drawernavegacio.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.oriol.drawernavegacio.dades.RepoFake
import cat.oriol.drawernavegacio.model.Pirates
import cat.oriol.drawernavegacio.ui.common.miniPirates


@Preview
@Composable
fun ListPirates(pirates:List<Pirates> = RepoFake.obtenLlistaPirates(), onClickElement: (Int) -> Unit = {})
{
    Column(
        modifier = Modifier.background(Color(0XFF4d2200))
    )
    {
        Row(
            modifier=Modifier
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
                color = MaterialTheme.colorScheme.onPrimary,
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
                miniPirates(it.id,onClickElement)
                HorizontalDivider(
                    color = Color(0XFF4d2200),
                    thickness = 8.dp
                )
            }
        }
    }




}