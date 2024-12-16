package cat.institutmontivi.decissorviewmodel.ui.pantalles


import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.institutmontivi.decissorviewmodel.dades.PreferenciesDataStore
import kotlinx.coroutines.launch


@Preview
@Composable
fun PantallaPreferencies ()
{
    val preferencies = PreferenciesDataStore(LocalContext.current)
    val tempsCaraOCreu by preferencies.getTempsCaraOCreu.collectAsState(initial = 0)
    val tempsTriaNumero by preferencies.getTempsTriaNumero.collectAsState(initial = 0)
    val minimTriaNumero by preferencies.getMinimTriaNumero.collectAsState(initial = 0)
    val maximTriaNumero by preferencies.getMaxTriaNumero.collectAsState(initial = 0)
    val ambitCorrutines = rememberCoroutineScope()
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(Modifier.height(24.dp))
        Text(
            text="Preferènccies",
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Divider(Modifier.fillMaxWidth().height(10.dp). padding(start = 16.dp, end = 16.dp),
            color = MaterialTheme.colorScheme.onSurfaceVariant)
        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(start = 16.dp, end = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(16.dp))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onSurface
                )
            )
            {
                Text(
                    text="Cara o creu",
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Divider(Modifier.fillMaxWidth()
                    .height(3.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(Modifier.height(16.dp))
                Text(
                    text="Temps de la tirada en mil·lisegons",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Row ()
                {
                    Slider(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                            .weight(1F),
                        value = tempsCaraOCreu.toFloat(),
                        onValueChange = {
                            ambitCorrutines.launch {
                                preferencies.setTempsCaraOCreu(it.toLong())
                            }

                        }
                    )
                }
            }

        }
    }
}