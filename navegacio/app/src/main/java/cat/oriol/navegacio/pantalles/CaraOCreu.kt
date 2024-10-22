package cat.oriol.navegacio.pantalles

import android.graphics.drawable.Drawable
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cat.oriol.navegacio.R
import kotlin.random.Random
import kotlin.random.nextInt

@Preview
@Composable
fun PantallaCaraOcreu()
{
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    )
    {
        var rand = Random.nextInt(0..1)
        var cara by remember{mutableStateOf(R.drawable.cara)}
        var txt by remember { mutableStateOf("") }
        if (cara==R.drawable.cara)
        {
            txt = "Cara"
        }
        else{
            txt = "Creu"
        }
        Text("$txt", fontSize = 50.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        Image(
            painter = painterResource(cara)
            ,contentDescription = "creu",
            modifier = Modifier.clickable{
                rand = Random.nextInt(0..1)
                if(rand==0)
                {
                    cara=R.drawable.cara

                }
                else
                {
                    cara=R.drawable.creu
                }
            }
        )
    }
}
