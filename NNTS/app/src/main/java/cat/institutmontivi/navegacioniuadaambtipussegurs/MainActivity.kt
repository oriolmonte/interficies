package cat.institutmontivi.navegacioniuadaambtipussegurs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.PopUpToBuilder
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.CaixaDeNavegacioVersioBasica
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.CategoriaA
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.GrafDeNavegacio
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.LlistaA
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.categoriesDeNavegacio
import cat.institutmontivi.navegacioniuadaambtipussegurs.ui.theme.NavegacioNiuadaAmbTipusSegursTheme
import kotlinx.coroutines.CoroutineScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacioNiuadaAmbTipusSegursTheme {
                App()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    private fun App() {
        val controladorDeNavegacio = rememberNavController();
        val rutaActual by controladorDeNavegacio.currentBackStackEntryAsState()
        val destinacioActual = rutaActual?.destination
        val estatDrawer = rememberDrawerState(initialValue = DrawerValue.Closed)
        val ambitCorrutina: CoroutineScope = rememberCoroutineScope()

        CaixaDeNavegacioVersioBasica(controladorDeNavegacio, rutaActual, destinacioActual, estatDrawer, ambitCorrutina )
    }
}

