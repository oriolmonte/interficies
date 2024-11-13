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
import androidx.navigation.toRoute
import cat.oriol.drawernavegacio.dades.RepoFake
import cat.oriol.drawernavegacio.ui.pantalles.ListPirates
import cat.oriol.drawernavegacio.ui.pantalles.ListPokemon
import cat.oriol.drawernavegacio.ui.pantalles.PantallaLlistaFF
import cat.oriol.drawernavegacio.ui.pantalles.detallFF
import cat.oriol.drawernavegacio.ui.pantalles.detallPirates
import cat.oriol.drawernavegacio.ui.pantalles.detallPokemon

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
        CategoriaFinal(controladorDeNavegacio)
        CategoriaPirates(controladorDeNavegacio)
        CategoriaPokemon(controladorDeNavegacio)
    }

}

fun NavGraphBuilder.CategoriaFinal(controladorDeNavegacio: NavHostController)
{
    navigation<CategoriaFinal>(startDestination=LlistaFF)
    {
        composable<LlistaFF>{
            PantallaLlistaFF(
                llista = RepoFake.obtenLlistaGent(),
                onClickElement = {
                    controladorDeNavegacio.navigate(
                        DetallFF(it)
                    )
                }
            )
        }
        composable<DetallFF>
        {
            val argument = it.toRoute<DetallFF>()
            detallFF(argument.id)
        }
    }
}

fun NavGraphBuilder.CategoriaPirates(controladorDeNavegacio: NavHostController)
{
    navigation<CategoriaPirates>(startDestination=LlistaPirates)
    {
        composable<LlistaPirates>{
            ListPirates(
                pirates = RepoFake.obtenLlistaPirates(),
                onClickElement = {
                    controladorDeNavegacio.navigate(
                        DetallPirates(it)
                    )
                }
            )
        }
        composable<DetallPirates>
        {
            val argument = it.toRoute<DetallPirates>()
            detallPirates(argument.id)
        }
    }
}

fun NavGraphBuilder.CategoriaPokemon(controladorDeNavegacio: NavHostController)
{
    navigation<CategoriaPokemon>(startDestination=LlistaPokemon)
    {
        composable<LlistaPokemon>{
            ListPokemon(
                pokemon = RepoFake.obtenLlistaPokemons(),
                onClickElement = {
                    controladorDeNavegacio.navigate(
                        DetallPokemon(it)
                    )
                }
            )
        }
        composable<DetallPokemon>
        {
            val argument = it.toRoute<DetallPirates>()
            detallPokemon(argument.id)
        }
    }
}