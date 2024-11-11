package cat.institutmontivi.navegacioniuadaambtipussegurs.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
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
import cat.institutmontivi.navegacioniuadaambtipussegurs.R
import cat.institutmontivi.navegacioniuadaambtipussegurs.dades.GrafDeNavegacio
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.LlistaA
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.LlistaB
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.LlistaC
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.categoriesDeNavegacio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
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
//    Bastida(rutaActual, destinacioActual, controladorDeNavegacio)
}

@Composable
fun CalaixDeNavegacioVersioBasica(
    controladorDeNavegacio: NavHostController,
    rutaActual: NavBackStackEntry?,
    destinacioActual: NavDestination?,
    estatDrawer: DrawerState,
    ambitCorrutina: CoroutineScope
) {

    ModalNavigationDrawer(
        drawerState = estatDrawer,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
                    )
                {
                    Text("Fulla Del Drawer", style = MaterialTheme.typography.displayLarge,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer)
                }
            }
        }
    )
    {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        )
        {
            Text("Contingut Del Drawer", style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground)
        }
    }
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
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxWidth()
                        .width(100.dp)
                        .height(100.dp),
                    contentScale =  ContentScale.FillWidth
                )

                Spacer(Modifier.height(48.dp))

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
                            selectedBadgeColor = MaterialTheme.colorScheme.onSecondary,
                            unselectedBadgeColor = MaterialTheme.colorScheme.onPrimary

                        ),
                        badge = { Icon(imageVector = Icons.Default.Badge, contentDescription = null)},
                        shape = ShapeDefaults.Medium
                    )

                    Spacer(Modifier.height(24.dp))

                }
            }
        },
        gesturesEnabled = listOf(
            LlistaA::class,
            LlistaB::class,
            LlistaC::class,
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
                    if (destinacioActual?.hasRoute(LlistaA::class)
                            ?: true
                    ) {  // <-- Cal actualitzar aquesta condició a la ruta de la pantalla principal
                        IconButton(
                            onClick = {
                                ambitCorrutina.launch {
                                    estatDrawer.open()
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
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

        ) { innerPadding ->
        GrafDeNavegacio(
            controladorDeNavegacio = controladorDeNavegacio,
            paddingValues = innerPadding
        )
    }
}