package cat.institutmontivi.navegaciambtipussegurs.ui.pantalles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import cat.institutmontivi.navegaciambtipussegurs.navegacio.LlistaDeLletres


@Composable
fun PantallaPrincipal (onNumerosClic: () -> Unit, onLletresClic: ()-> Unit)
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Top
        )
        {
            Button(onClick = {
                onLletresClic()
            }) {
                Text (
                    text= "Lletres", Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineLarge)
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {
                onNumerosClic()
            }) {
                Text (
                    text= "Números", Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineLarge)
            }
        }

}