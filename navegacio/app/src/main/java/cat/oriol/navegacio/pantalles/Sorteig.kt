package cat.oriol.navegacio.pantalles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
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
import kotlin.random.Random
import kotlin.random.nextInt


//@Preview
@Composable
fun PantallaSorteig(onSorteigClick: (Int)->Unit)
{
    var sliderPos by remember { mutableStateOf(0f..50f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text("${sliderPos.start.toInt()}" + " fins a " +"${sliderPos.endInclusive.toInt()}", fontSize = 50.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(
            modifier = Modifier.padding(50.dp)
        )
        RangeSlider(
        value = sliderPos,
        onValueChange = { range -> sliderPos = range},
        steps = 49,
        valueRange = 0f..50f,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(
            modifier = Modifier.padding(50.dp)
        )
        Button(

            onClick = {
                val r:Int = Random.nextInt(sliderPos.start.toInt()..sliderPos.endInclusive.toInt())
                onSorteigClick(r)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Sort!")
        }

    }
}