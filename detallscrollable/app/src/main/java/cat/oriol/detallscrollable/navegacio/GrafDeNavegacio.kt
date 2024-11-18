package cat.oriol.drawernavegacio.navegacio

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import cat.oriol.detallscrollable.ContingutPaginadorAmbTabsFF
import cat.oriol.detallscrollable.ContingutPaginadorAmbTabsPirates
import cat.oriol.detallscrollable.ContingutPaginadorAmbTabsPokemon
import cat.oriol.detallscrollable.navegacio.CategoriaFinal
import cat.oriol.detallscrollable.navegacio.CategoriaPirates
import cat.oriol.detallscrollable.navegacio.CategoriaPokemon
import cat.oriol.detallscrollable.ui.pantalles.detallFF
import cat.oriol.detallscrollable.ui.pantalles.detallPirates
import cat.oriol.detallscrollable.ui.pantalles.detallPokemon

@Composable
fun GrafDeNavegacio(
    controladorDeNavegacio : NavHostController,
    paddingValues: PaddingValues = PaddingValues(0.dp)
)
{
    NavHost(
        navController = controladorDeNavegacio,
        startDestination = CategoriaFinal,
        modifier = Modifier.padding(paddingValues))
    {
        composable<CategoriaFinal>{
            ContingutPaginadorAmbTabsFF(innerPadding = PaddingValues(0.dp) )
        }
        composable<CategoriaPirates>{
            ContingutPaginadorAmbTabsPirates(innerPadding = PaddingValues(0.dp) )
        }
        composable<CategoriaPokemon>{
            ContingutPaginadorAmbTabsPokemon(innerPadding = PaddingValues(0.dp) )
        }
    }

}
