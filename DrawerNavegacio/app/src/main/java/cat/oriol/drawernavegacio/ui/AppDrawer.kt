package cat.oriol.drawernavegacio.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cat.oriol.drawernavegacio.navegacio.CategoriaFinal
import cat.oriol.drawernavegacio.navegacio.GrafDeNavegacio
import cat.oriol.drawernavegacio.navegacio.LlistaFF
import cat.oriol.drawernavegacio.navegacio.LlistaPirates
import cat.oriol.drawernavegacio.navegacio.LlistaPokemon
import cat.oriol.drawernavegacio.navegacio.categoriesDeNavegacio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Preview
@Composable
fun AppDrawer() {
    val controladorDeNavegacio = rememberNavController();
    val rutaActual by controladorDeNavegacio.currentBackStackEntryAsState()
    val destinacioActual = rutaActual?.destination

    val estatDrawer = rememberDrawerState(initialValue = DrawerValue.Closed)
    val ambitCorrutina : CoroutineScope = rememberCoroutineScope()

    CalaixDeNavegacio(
        controladorDeNavegacio,
        rutaActual,
        destinacioActual,
        estatDrawer,
        ambitCorrutina
    )
}

@Composable
fun CalaixDeNavegacio(
    controladorDeNavegacio: NavHostController,
    rutaActual: NavBackStackEntry?,
    destinacioActual: NavDestination?,
    estatDrawer: DrawerState,
    ambitCorrutina: CoroutineScope
) {

    ModalNavigationDrawer(
        drawerState = estatDrawer,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.primary,
                drawerContentColor = MaterialTheme.colorScheme.onPrimary,
                drawerTonalElevation = 5.dp,
                drawerShape = ShapeDefaults.Medium,
                windowInsets = WindowInsets(left = 24.dp, top = 48.dp, right = 24.dp, bottom = 48.dp)            )
            {

                HorizontalDivider(
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.height(15.dp)
                )

                Spacer(Modifier.height(48.dp))


                categoriesDeNavegacio.forEach { categoria ->
                    NavigationDrawerItem(
                        label = { Text(categoria.titol) },
                        selected = destinacioActual?.hierarchy?.any { it.hasRoute(categoria.ruta::class) } == true,
                        icon = {
                            Icon(
                                imageVector = if (destinacioActual?.hierarchy?.any { it.hasRoute(categoria.ruta::class) } == true) categoria.iconaSeleccionada else categoria.iconaNoSeleccionada,
                                contentDescription = categoria.titol
                            )
                        },
                        onClick = {
                            ambitCorrutina.launch {
                                estatDrawer.close()
                            }
                            controladorDeNavegacio.navigate(categoria.ruta) {
                                popUpTo(controladorDeNavegacio.graph.findStartDestination().id) {
                                    inclusive = false
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
                            unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
                            selectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            selectedTextColor = MaterialTheme.colorScheme.onSecondary,
                            selectedContainerColor = MaterialTheme.colorScheme.secondary,
                            unselectedContainerColor = MaterialTheme.colorScheme.primary,

                        ),
                        shape = ShapeDefaults.Medium
                    )

                    Spacer(Modifier.height(24.dp))

                }
            }
        },
        gesturesEnabled = listOf(
            LlistaFF::class,
            LlistaPirates::class,
            LlistaPokemon::class,
        ).any{ destinacioActual?.hasRoute(it) == true }
    )
    {
        Bastida(rutaActual, destinacioActual, controladorDeNavegacio, estatDrawer, ambitCorrutina)
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun Bastida(
    rutaActual: NavBackStackEntry?,
    destinacioActual: NavDestination?,
    controladorDeNavegacio: NavHostController,
    estatDrawer: DrawerState,
    ambitCorrutina: CoroutineScope
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Navegació amb drawer"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                navigationIcon = {
                    if (destinacioActual?.hasRoute(CategoriaFinal::class)?: true ) {  // <-- Cal actualitzar aquesta condició a la ruta de la pantalla principal
                        IconButton(
                            onClick = {
                                ambitCorrutina.launch {
                                    estatDrawer.open()
                                }
                            }
                        )
                        {  Icon(imageVector = Icons.Default.Menu,contentDescription = "Pantalla principal",) }
                    }
                    else {
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

        ) { innerPadding ->
        GrafDeNavegacio(
            controladorDeNavegacio = controladorDeNavegacio,
            paddingValues = innerPadding
        )
    }
}
