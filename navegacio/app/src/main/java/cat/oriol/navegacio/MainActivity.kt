package cat.oriol.navegacio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cat.oriol.navegacio.nav.CaraOCreu
import cat.oriol.navegacio.nav.GrafDeNavegacio
import cat.oriol.navegacio.pantalles.PantallaCaraOcreu
import cat.oriol.navegacio.pantalles.PantallaOracle
import cat.oriol.navegacio.pantalles.PantallaSorteig
import cat.oriol.navegacio.ui.theme.NavegacioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacioTheme {
                Aplicacio()
            }
            }
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview ()
@Composable
fun Aplicacio () {
    val navController = rememberNavController()
    val rutaActual by navController.currentBackStackEntryAsState()
    val destinacioActual = rutaActual?.destination
    Scaffold (
        modifier=Modifier
            .fillMaxSize(),
        topBar= {
            TopAppBar(
                title = { Text("Navegacio") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )

        }
    )
    {
        paddingValues ->
        GrafDeNavegacio(navController, paddingValues)
    }
}
@Composable
fun TemaDeLaAplicacio(content: @Composable ()->Unit)
{
    NavegacioTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}
