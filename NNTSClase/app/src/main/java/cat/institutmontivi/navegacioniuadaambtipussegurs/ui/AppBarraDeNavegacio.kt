package cat.institutmontivi.navegacioniuadaambtipussegurs.ui

import androidx.compose.foundation.layout.fillMaxSize
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
import cat.institutmontivi.navegacioniuadaambtipussegurs.dades.GrafDeNavegacio
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.LlistaA
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.categoriesDeNavegacio

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppBarraDeNavegacio() {
    val controladorDeNavegacio = rememberNavController();
    val rutaActual by controladorDeNavegacio.currentBackStackEntryAsState()
    val destinacioActual = rutaActual?.destination

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Navegació amb tipus segurs - ${
                            rutaActual?.destination?.route?.substringAfterLast(
                                "."
                            ) ?: "Principal"
                        }"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                navigationIcon = {
                    if (destinacioActual?.hasRoute(LlistaA::class) ?: true) {  // <-- Cal actualitzar aquesta condició a la ruta de la pantalla principal
                        IconButton(
                            onClick = { }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Pantalla principal",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    } else {
                        IconButton(
                            onClick = { controladorDeNavegacio.navigateUp() }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Navega enrera",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {

                categoriesDeNavegacio.forEach{ categoria ->
                    NavigationBarItem(
                        selected =
                        destinacioActual?.hierarchy?.any { it.hasRoute(categoria.ruta::class) } == true,
                        onClick = {
                            controladorDeNavegacio.navigate(categoria.ruta) {
                                popUpTo(controladorDeNavegacio.graph.findStartDestination().id) {
                                    inclusive = false
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = if (destinacioActual?.hierarchy?.any { it.hasRoute(categoria.ruta::class) } == true) categoria.iconaSeleccionada else categoria.iconaNoSeleccionada,
                                contentDescription = categoria.titol
                            )
                        },
                        label = {
                            Text(categoria.titol)
                        }
                    )

                }

            }
        }

    ) { innerPadding ->
        GrafDeNavegacio(
            controladorDeNavegacio = controladorDeNavegacio,
            paddingValues = innerPadding
        )
    }
}