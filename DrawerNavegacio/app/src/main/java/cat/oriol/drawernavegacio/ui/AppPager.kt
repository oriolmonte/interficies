package cat.oriol.drawernavegacio.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import cat.oriol.drawernavegacio.dades.RepoFake
import cat.oriol.drawernavegacio.navegacio.CategoriaFinal
import cat.oriol.drawernavegacio.navegacio.GrafDeNavegacio
import cat.oriol.drawernavegacio.navegacio.categoriesDeNavegacio
import cat.oriol.drawernavegacio.ui.pantalles.ListPirates
import cat.oriol.drawernavegacio.ui.pantalles.ListPokemon
import cat.oriol.drawernavegacio.ui.pantalles.PantallaLlistaFF
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppPager()
{
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Navegació amb Pager"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            //Res
                        }
                    )
                    {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Pantalla principal",
                        )
                    }
                }
            )

        }
    )
    {
        innerPadding -> ContingutPaginadorAmbTabs(innerPadding)
    }
}

@Composable
fun ContingutPaginador(innerPadding: PaddingValues) {
    val estatPaginador = rememberPagerState { 3 } //lo ideal seria una llista
    Column(modifier=Modifier
        .padding(innerPadding)
        .fillMaxSize()
    )
    {
        HorizontalPager(
            modifier = Modifier
                .weight(1F),
            state = estatPaginador,
            beyondViewportPageCount = 3,
        )
        {
                pagina ->
            when(pagina){
                0-> PantallaLlistaFF(llista=RepoFake.obtenLlistaGent())
                1-> ListPirates(pirates =RepoFake.obtenLlistaPirates())
                else-> ListPokemon(pokemon = RepoFake.obtenLlistaPokemons())
            }

        }
        IndicadorPager(estatPaginador)
    }
}

//A LES PESTANYES I OBVIAMENT EL PERCENTATGE FORA
@Composable
fun IndicadorPager(estatPaginador: PagerState,
                   colorIndicador: Color=Color.DarkGray,
                   percentatgeSeleccionat:Float =2F,
                   percentatgeAlfaNoSeleccionats: Float = 0.3f)
{
    Row(
        horizontalArrangement = Arrangement.Center
    )
    {
        repeat(estatPaginador.pageCount)
        { pagina ->
            var color = colorIndicador;
            var percentatgePes = 1F;
            var percentScroll = estatPaginador.currentPageOffsetFraction.absoluteValue //de 0 a 0.5 cambia a la pag seg canvia de pagina quan arriba a la pagina objectiu current into target!
                                                                                       //de -0.5 a 0 la pag fins al mig target ja es current
            if (estatPaginador.currentPage == pagina) {
                color = colorIndicador.copy(alpha = (1-percentatgeAlfaNoSeleccionats)*(1-percentScroll))
                percentatgePes = 1+(percentatgeSeleccionat-1F)*(1-percentScroll);
                
            } else if (estatPaginador.targetPage == pagina)
            {
                color = colorIndicador.copy(alpha = (1-percentatgeAlfaNoSeleccionats)*(percentScroll))
                percentatgePes=1+(percentatgeSeleccionat-1F)*(percentScroll);

            }
            else
            {
                color = color.copy(alpha = percentatgeAlfaNoSeleccionats)
                percentatgePes=1F
            }
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .height(10.dp)
                    .background(color)
                    .clip((RoundedCornerShape(8.dp)))
                    .weight(percentatgePes)
                    .padding(2.dp)
            )
        }
    }
        Text(text= estatPaginador.currentPageOffsetFraction.toString()) //de 0 a 0.5 cambia a la pag seg
                                                                        //de -0.5 a 0 la pag fins al mig
}


@Composable
fun ContingutPaginadorAmbTabs(innerPadding: PaddingValues) {
    val ambitCorrutina = rememberCoroutineScope()
    val estatPaginador = rememberPagerState { 3 } //lo ideal seria una llista
    Column(modifier=Modifier
        .padding(innerPadding)
        .fillMaxSize()
    )
    {
        ScrollableTabRow(selectedTabIndex = estatPaginador.currentPage, edgePadding = 0.dp) //edgepadding espai que li guarda! nomes al scrollable!!!
        {
            repeat(20)
            {
                pagina ->
                    Tab(
                        selected = estatPaginador.currentPage==pagina, //obligatori
                        onClick = { ambitCorrutina.launch {
                            estatPaginador.animateScrollToPage(pagina)
                        }
                        },
                        content = {Text(text= categoriesDeNavegacio[pagina%3].titol, style = MaterialTheme.typography.headlineSmall)
                        }
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
                pagina ->
            when(pagina){
                0-> PantallaLlistaFF(llista=RepoFake.obtenLlistaGent())
                1-> ListPirates(pirates =RepoFake.obtenLlistaPirates())
                else-> ListPokemon(pokemon = RepoFake.obtenLlistaPokemons())
            }

        }
        IndicadorPager(estatPaginador)
    }
}

