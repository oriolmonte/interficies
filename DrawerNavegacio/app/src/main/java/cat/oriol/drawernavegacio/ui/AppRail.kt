package cat.oriol.drawernavegacio.ui

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cat.oriol.drawernavegacio.navegacio.GrafDeNavegacio
import cat.oriol.drawernavegacio.navegacio.categoriesDeNavegacio
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.window.core.layout.WindowHeightSizeClass
import cat.oriol.drawernavegacio.dades.RepoFake.obtenLlistaPirates
import cat.oriol.drawernavegacio.navegacio.CategoriaFinal
import cat.oriol.drawernavegacio.navegacio.GrafDeNavegacioSimple
import cat.oriol.drawernavegacio.navegacio.categoriesDeNavegacioNavegacioSimple
import cat.oriol.drawernavegacio.ui.pantalles.detallPirates
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun AppRail() {
    val controladorDeNavegacio = rememberNavController();
    val rutaActual by controladorDeNavegacio.currentBackStackEntryAsState()
    val destinacioActual = rutaActual?.destination
    val midaFinestra = currentWindowAdaptiveInfo().windowSizeClass
    val compacte = midaFinestra.windowHeightSizeClass == WindowHeightSizeClass.COMPACT
    val activitat = LocalContext.current as Activity
    Scaffold(
        topBar = {
            BarraSuperior(destinacioActual, controladorDeNavegacio)
         },
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if(!compacte) {
                BarraInferior(destinacioActual, controladorDeNavegacio)
            }
        },
        floatingActionButton = {
            if (!compacte) {
                IconButton(
                    onClick = { activitat.finish() },
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF0e1630))
                        .padding(16.dp)

                ) {
                    Icon(
                        imageVector = Icons.Default.ExitToApp,
                        contentDescription = "Home",
                        tint = Color.White,
                        modifier = Modifier.shadow(8.dp, shape = CircleShape) // Adds elevation
                    )
                }
            }

        }

    ) { innerPadding ->
        //EL RAIL HA D'ANAR DINS EL CONTINGUT
        Row( modifier = Modifier.padding(innerPadding).fillMaxSize())
        {
            if(compacte)
            {
                NavigationRail(
                    header ={
                        IconButton(
                            onClick = { activitat.finish() },
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF0e1630))
                                .padding(16.dp)

                        ) {
                            Icon(
                                imageVector = Icons.Default.ExitToApp,
                                contentDescription = "Home",
                                tint = Color.White,
                                modifier = Modifier.shadow(8.dp, shape = CircleShape) // Adds elevation
                            )
                        }
                    }
                ){
                    //ATENCIO!!! NAVEGACIO SIMPLE!!!!
                    categoriesDeNavegacioNavegacioSimple.forEach()
                    { categoria ->
                        NavigationRailItem(
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
            GrafDeNavegacioSimple(
                controladorDeNavegacio = controladorDeNavegacio,
            )
        }

    }
}

@Composable
private fun BarraInferior(
    destinacioActual: NavDestination?,
    controladorDeNavegacio: NavHostController
) {
    NavigationBar {
        categoriesDeNavegacioNavegacioSimple.forEach()
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

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun BarraSuperior(
    destinacioActual: NavDestination?,
    controladorDeNavegacio: NavHostController
) {
    TopAppBar(
        title = {
            Text(
                "Navegació amb rail"
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        navigationIcon = {
            if (destinacioActual?.hasRoute(CategoriaFinal::class)
                    ?: true
            ) {  // <-- Cal actualitzar aquesta condició a la ruta de la pantalla principal
                IconButton(
                    onClick = {
                    }
                )
                {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Pantalla principal",
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
}


