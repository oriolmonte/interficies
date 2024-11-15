package cat.oriol.detallscrollable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cat.oriol.detallscrollable.navegacio.categoriesDeNavegacio
import cat.oriol.detallscrollable.ui.theme.DetallscrollableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DetallscrollableTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun App() {
    val controladorDeNavegacio = rememberNavController();
    val rutaActual by controladorDeNavegacio.currentBackStackEntryAsState()
    val destinacioActual = rutaActual?.destination

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Navegacio Amb Pager"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                navigationIcon = {
                        IconButton(
                            onClick = { }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Pantalla principal",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    },
            )
        },
        bottomBar = {
            NavigationBar {
                categoriesDeNavegacio.forEach()
                { categoria ->
                    NavigationBarItem(
                        selected = destinacioActual?.hierarchy?.any {
                            it.hasRoute(categoria.ruta::class)
                        } == true,
                        onClick = {
                            controladorDeNavegacio.navigate(categoria.ruta) {
                                popUpTo(controladorDeNavegacio.graph.findStartDestination().id)
                                {
                                    inclusive = false
                                    saveState = true

                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            if (destinacioActual?.hierarchy?.any {
                                    it.hasRoute(categoria.ruta::class)
                                } == true) {
                                Icon(
                                    imageVector = categoria.iconaSeleccionada,
                                    contentDescription = categoria.titol,
                                )

                            } else {
                                Icon(
                                    imageVector = categoria.iconaNoSeleccionada,
                                    contentDescription = categoria.titol,
                                )
                            }
                        },
                        label = { Text(categoria.titol) }
                    )
                }
            }
        }

    ) { innerPadding ->
        GrafDeNavegacio(
            controlDeNavegacio = controladorDeNavegacio,
            paddingValues = innerPadding
        )


    }
}