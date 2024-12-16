package cat.oriol.drawernavegacio.navegacio

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
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
import cat.oriol.drawernavegacio.ui.pantalles.ListPiratesSheet
import cat.oriol.drawernavegacio.ui.pantalles.ListPokemon
import cat.oriol.drawernavegacio.ui.pantalles.ListPokemonSheet
import cat.oriol.drawernavegacio.ui.pantalles.PantallaLlistaFF
import cat.oriol.drawernavegacio.ui.pantalles.PantallaLlistaFFBottomSheet
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GrafDeNavegacioSimple(
    controladorDeNavegacio : NavHostController,
    paddingValues: PaddingValues = PaddingValues(0.dp)
)
{
    NavHost(
        navController = controladorDeNavegacio,
        startDestination = LlistaFF,
        modifier = Modifier.padding(paddingValues))
    {
        composable<LlistaFF>()
        {
            PantallaLlistaFFBottomSheet(RepoFake.obtenLlistaGent(), onClickElement = {id:Int -> controladorDeNavegacio.navigate(DetallFF(id))})
        }
        composable<LlistaPirates> {
            ListPiratesSheet(RepoFake.obtenLlistaPirates(), onClickElement = {id:Int -> controladorDeNavegacio.navigate(DetallPirates(id))})
        }
        composable<LlistaPokemon> {
            ListPokemonSheet(RepoFake.obtenLlistaPokemons(), onClickElement = {})
        }
        composable<DetallFF> {
            val argument = it.toRoute<DetallFF>()
            detallFF(argument.id)
        }
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