package com.example.llistesgraelles.pagines

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.llistesgraelles.dades.coses
import com.example.llistesgraelles.model.Cosa
import com.example.llistesgraelles.parts.miniVertical

@Preview
@Composable
fun Graella(Coses:List<Cosa> = coses, onClickElement: (Int) -> Unit = {})
{
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(4),
        horizontalArrangement = Arrangement.spacedBy(16.dp)

    )
    {
        items(Coses)
        {
            Column (modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)

            )
            {
                miniVertical(it.id, onClickElement)
            }
            HorizontalDivider(
                color = MaterialTheme.colorScheme.secondary
            )
            VerticalDivider(
                color = MaterialTheme.colorScheme.secondary,
                thickness = 2.dp
            )
        }
    }
}
