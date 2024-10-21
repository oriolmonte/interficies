package cat.oriol.navegacio.pantalles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PantallaPrincipal (onCaraOCreuClic: () -> Unit, onSorteigClic: ()->Unit, onOracleClic: () -> Unit)
{
    Column (
        modifier = Modifier
            .fillMaxSize()
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center

    )
    {
        Button(onClick = {
            onCaraOCreuClic()
        }, modifier = Modifier
            .padding(24.dp)) {
            Text (
                text= "Cara o Creu", Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge)
        }
        Button(onClick = {
            onSorteigClic()
        }, modifier = Modifier
            .padding(24.dp)) {
            Text (
                text= "Sorteig", Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge)
        }
        Button(onClick = {
            onOracleClic()
        }, modifier = Modifier
            .padding(24.dp))
        {
            Text (
                text= "Oracle", Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge)
        }
    }
}

@Preview
@Composable
fun PantallaPrincipalPreview()
{
    PantallaPrincipal({},{},{})
}