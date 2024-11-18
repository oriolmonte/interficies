package cat.oriol.detallscrollable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cat.oriol.detallscrollable.dades.RepoFake.obtenLlistaGent
import cat.oriol.detallscrollable.dades.RepoFake.obtenLlistaPirates
import cat.oriol.detallscrollable.dades.RepoFake.obtenLlistaPokemons
import cat.oriol.detallscrollable.navegacio.categoriesDeNavegacio
import cat.oriol.detallscrollable.ui.pantalles.detallFF
import cat.oriol.detallscrollable.ui.pantalles.detallPirates
import cat.oriol.detallscrollable.ui.pantalles.detallPokemon
import cat.oriol.detallscrollable.ui.theme.DetallscrollableTheme
import cat.oriol.drawernavegacio.navegacio.GrafDeNavegacio
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DetallscrollableTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {paddingValues ->
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
            controladorDeNavegacio = controladorDeNavegacio,
            paddingValues = innerPadding
        )
    }
}

@Composable
fun ContingutPaginadorAmbTabsFF(innerPadding: PaddingValues) {
    val ambitCorrutina = rememberCoroutineScope()
    val listFF = obtenLlistaGent()
    val estatPaginador = rememberPagerState { listFF.size }
    Column(modifier=Modifier
        .padding(innerPadding)
        .fillMaxSize()
    )
    {
        ScrollableTabRow(selectedTabIndex = estatPaginador.currentPage, edgePadding = 0.dp, modifier = Modifier.padding(horizontal = 8.dp)  ) //edgepadding espai que li guarda! nomes al scrollable!!!
        {
            repeat(listFF.size)
            {
                    pagina ->
                Tab(
                    selected = estatPaginador.currentPage==pagina, //obligatori
                    onClick = { ambitCorrutina.launch {
                        estatPaginador.animateScrollToPage(pagina)
                    }
                    },
                    content = {Text(text= listFF[pagina].nom, style = MaterialTheme.typography.headlineSmall)
                    },
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        HorizontalPager(
            modifier = Modifier
                .weight(1F),
            state = estatPaginador,
            beyondViewportPageCount = 3,
        )
        {
                detallFF(it)
        }
    }
}
@Composable
fun ContingutPaginadorAmbTabsPirates(innerPadding: PaddingValues) {
    val ambitCorrutina = rememberCoroutineScope()
    val listPirates = obtenLlistaPirates()
    val estatPaginador = rememberPagerState { listPirates.size }
    Column(modifier=Modifier
        .padding(innerPadding)
        .fillMaxSize()
    )
    {
        ScrollableTabRow(selectedTabIndex = estatPaginador.currentPage, edgePadding = 0.dp, modifier = Modifier.padding(horizontal = 8.dp)) //edgepadding espai que li guarda! nomes al scrollable!!!
        {
            repeat(listPirates.size)
            {
                    pagina ->
                Tab(
                    selected = estatPaginador.currentPage==pagina, //obligatori
                    onClick = { ambitCorrutina.launch {
                        estatPaginador.animateScrollToPage(pagina)
                    }
                    },
                    content = {Text(text= listPirates[pagina].nom, style = MaterialTheme.typography.headlineSmall)
                    },
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        HorizontalPager(
            modifier = Modifier
                .weight(1F),
            state = estatPaginador,
            beyondViewportPageCount = 3,
        )
        {
            detallPirates(it)
        }
    }
}
@Composable
fun ContingutPaginadorAmbTabsPokemon(innerPadding: PaddingValues) {
    val ambitCorrutina = rememberCoroutineScope()
    val listPokemon = obtenLlistaPokemons()
    val estatPaginador = rememberPagerState { listPokemon.size }
    Column(modifier=Modifier
        .padding(innerPadding)
        .fillMaxSize()
    )
    {
        ScrollableTabRow(selectedTabIndex = estatPaginador.currentPage, edgePadding = 0.dp) //edgepadding espai que li guarda! nomes al scrollable!!!
        {
            repeat(listPokemon.size)
            {
                    pagina ->
                Tab(
                    selected = estatPaginador.currentPage==pagina, //obligatori
                    onClick = { ambitCorrutina.launch {
                        estatPaginador.animateScrollToPage(pagina)
                    }
                    },
                    content = {Text(text= listPokemon[pagina].nom, style = MaterialTheme.typography.headlineSmall)
                    },
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        HorizontalPager(
            modifier = Modifier
                .weight(1F),
            state = estatPaginador,
            beyondViewportPageCount = 3,
        )
        {
            detallPokemon(it)
        }
    }
}
