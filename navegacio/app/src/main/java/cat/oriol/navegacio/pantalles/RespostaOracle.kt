package cat.oriol.navegacio.pantalles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlin.random.Random
import kotlin.random.nextInt

@Preview
@Composable
fun PantallaRespostaOracle() {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    )
    {
        var num = Random.nextInt(0..3)
        when(num) {
            0 -> text = "Si"
            1 -> text = "No"
            2 -> text = "Pot ser"
            3 -> text = "Ni de conya"
        }
        Text(text, fontSize = 45.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
    }

}