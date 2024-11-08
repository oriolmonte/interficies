package cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cat.institutmontivi.navegacioniuadaambtipussegurs.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CaixaDeNavegacioVersioBasica(
    controladorDeNavegacio: NavHostController,
    rutaActual: NavBackStackEntry?,
    destinacioActual: NavDestination?,
    estatDrawer: DrawerState,
    ambitCorrutina: CoroutineScope
) {
    ModalNavigationDrawer(
        drawerState = estatDrawer,
        drawerContent = {
            ModalDrawerSheet (
                drawerContainerColor = MaterialTheme.colorScheme.primaryContainer,
                drawerContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                drawerTonalElevation = 5.dp,
                drawerShape = ShapeDefaults.Medium,
                windowInsets = WindowInsets(24.dp,24.dp,24.dp,24.dp)
            )
            {
                Image(
                    painterResource(R.drawable.drac),
                    contentDescription = "lloogo",
                    modifier =  Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                categoriesDeNavegacio.forEach{
                    categoria -> NavigationDrawerItem(
                        label = {Text(categoria.titol)},
                        selected =  destinacioActual?.hierarchy?.any {
                            it.hasRoute(categoria.ruta::class)
                        } ?: true,
                        icon = {Icon(imageVector = categoria.icona, null)},
                        onClick = {
                            ambitCorrutina.launch {
                                estatDrawer.close()
                            }
                            controladorDeNavegacio.navigate(categoria.ruta)
                            {
                                popUpTo(controladorDeNavegacio.graph.findStartDestination().id)
                                {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }

                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
                            unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
                            selectedTextColor = MaterialTheme.colorScheme.onSecondary,
                            selectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            selectedContainerColor = MaterialTheme.colorScheme.primary,
                            unselectedContainerColor =MaterialTheme.colorScheme.onPrimary,
                            unselectedBadgeColor=MaterialTheme.colorScheme.onPrimary,
                            selectedBadgeColor =MaterialTheme.colorScheme.onPrimary,
                        ),
                        badge = {Icon(imageVector = Icons.Default.Badge, null)},
                        shape = ShapeDefaults.Medium
                    )

                }
            }
        }
    ){
        Bastida(controladorDeNavegacio,rutaActual,destinacioActual)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bastida(controladorDeNavegacio: NavHostController, rutaActual: NavBackStackEntry?,destinacioActual:NavDestination?)
{
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
                    if (destinacioActual?.hasRoute(LlistaA::class) ?: true) {
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
                categoriesDeNavegacio.forEach { categoria ->
                    NavigationBarItem(
                        selected = destinacioActual?.hierarchy?.any { it.hasRoute(categoria.ruta::class) } == true,
                        onClick = {
                            if (destinacioActual?.hasRoute(CategoriaA::class) == false) {
                                controladorDeNavegacio.popBackStack()
                            }
                            controladorDeNavegacio.navigate(categoria.ruta) {
                                //No sé perquè, això no funciona amb navegació amb tipus segurs
                                popUpTo(controladorDeNavegacio.graph.findStartDestination().id) {
                                    inclusive = false
                                    //Desa l'estat de la ruta de navegació on som
                                    saveState = true
                                }
                                //Si piquem diverses vegades sobre la barra de navegació, només es tornarà a carregar la pantalla si no és la mateixa
                                launchSingleTop = true
                                //Restaura l'estat de la pantalla de la que venim
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = categoria.icona,
                                contentDescription = categoria.titol
                            )
                        },
                        label = { Text(text = categoria.titol) }
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
