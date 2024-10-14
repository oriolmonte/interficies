package com.oriol.classedos.componibles

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oriol.classedos.dades.DadesFake
@Composable
fun SelectorVertical(
    dades: List<String>,
    opcioSeleccionada: Int = 0,
    modifier: Modifier = Modifier,
    onCanviSeleccio : (Int) -> Unit = {},
    gruixMarc: Dp = 2.dp,
    colorMarc: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    colorFons: Color = MaterialTheme.colorScheme.background,
    colorText: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    estilText: TextStyle = MaterialTheme.typography.displaySmall,
    colorTextSeleccionat: Color = MaterialTheme.colorScheme.onPrimary,
    colorFonsSelecionat: Color = MaterialTheme.colorScheme.primary,
)
{
    val diesSetmana = DadesFake.diesDeLaSetmana
    var mainClicked by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf(opcioSeleccionada) }

    Column ()
    {

        Row(modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .clickable {
                if (mainClicked == false) {
                    mainClicked = true
               }
                else
                    mainClicked=false
            }
        )
        {
            Text(diesSetmana[selected], fontSize = 20.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onPrimary, modifier = Modifier
                .padding(5.dp)
            )
            Icon(imageVector = Icons.Filled.Add, contentDescription = null,  modifier = Modifier
                .align(Alignment.CenterVertically)
            )
        }
        if(mainClicked)
        {
            dades.forEachIndexed{
                index,s ->
                Row(modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer))
                {
                    Text(dades[index],
                        color = if (selected==index)
                        {
                            colorTextSeleccionat
                        }
                        else
                            colorText,
                        modifier = Modifier
                            .background(
                            if (selected==index)
                                colorFonsSelecionat
                            else
                                colorFons
                            )
                        //PER FER CLICABLE NO BOTONS
                        .clickable {
                            //CANVIEM TANT VARIABLE LOCAL COM ESTAT PARAMETRE
                            selected=index
                            onCanviSeleccio(selected)
                        }
                    )
                }
            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun PreviewSelectorVert()
{
    SelectorVertical(DadesFake.diesDeLaSetmana)


}
