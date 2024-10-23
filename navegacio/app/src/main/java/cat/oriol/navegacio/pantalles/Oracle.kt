package cat.oriol.navegacio.pantalles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable

fun PantallaOracle(onRespostaClic: (String) -> Unit )
{
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    )
    {
        Text("Pregunta-li a l'oracle", fontSize = 30.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(
            modifier = Modifier.padding(50.dp)
        )
        TextField(text, onValueChange = {text=it},
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(height = 100.dp, width=300.dp)
        )
        Spacer(
            modifier = Modifier.padding(50.dp)
        )
        Button(
            onClick = {onRespostaClic(text)},
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Pregunta")
        }
    }

}