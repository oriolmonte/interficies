package com.example.llistesgraelles.pagines

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.llistesgraelles.dades.coses
import com.example.llistesgraelles.model.Cosa
import com.example.llistesgraelles.parts.miniHoritzontal

@Preview
@Composable
fun PantallaLlistaVertical(Coses: List<Cosa> = coses, onClickElement:(Int) -> Unit = {})
{
    LazyColumn (
    )
    {
        items(Coses)
        {
            Column (modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)

            )
            {
                miniHoritzontal(it.id, onClick = onClickElement)
            }
            HorizontalDivider(
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}
