package cat.institutmontivi.navegacioniuadaambtipussegurs.dades

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
import cat.institutmontivi.navegaciobarrainferior.ui.pantalles.PantallaDetallA
import cat.institutmontivi.navegaciobarrainferior.ui.pantalles.PantallaDetallB
import cat.institutmontivi.navegaciobarrainferior.ui.pantalles.PantallaDetallC
import cat.institutmontivi.navegaciobarrainferior.ui.pantalles.PantallaLlistaA
import cat.institutmontivi.navegaciobarrainferior.ui.pantalles.PantallaLlistaB
import cat.institutmontivi.navegaciobarrainferior.ui.pantalles.PantallaLlistaC
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.CategoriaA
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.CategoriaB
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.CategoriaC
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.DetallA
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.DetallB
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.DetallC
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.LlistaA
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.LlistaB
import cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio.LlistaC

@Composable
fun GrafDeNavegacio(
    controladorDeNavegacio : NavHostController,
    paddingValues: PaddingValues = PaddingValues(0.dp)
)
{
    NavHost(
        navController = controladorDeNavegacio,
        startDestination = CategoriaA,
        modifier = Modifier.padding(paddingValues))
        {
            CategoriaA(controladorDeNavegacio)
            CategoriaB(controladorDeNavegacio)
            CategoriaC(controladorDeNavegacio)
        }



}

fun NavGraphBuilder.CategoriaA(controladorDeNavegacio: NavHostController) {
    navigation<CategoriaA>(startDestination = LlistaA) {
        composable<LlistaA> {
            PantallaLlistaA(
                llista = FakeDataSource.obtenLlistaA(),
                onClickElement = {
                    controladorDeNavegacio.navigate(
                        DetallA(it)
                    )
                }
            )
        }

        composable<DetallA>
        {
            val argument = it.toRoute<DetallA>()
            PantallaDetallA(argument.id)
        }
    }
}

fun NavGraphBuilder.CategoriaB(controladorDeNavegacio: NavHostController) {
    navigation<CategoriaB>(startDestination = LlistaB) {
        composable<LlistaB> {
            PantallaLlistaB(
                llista = FakeDataSource.obtenLlistaB(),
                onClickElement = {
                    controladorDeNavegacio.navigate(
                        DetallB(it)
                    )
                }
            )
        }

        composable<DetallB>
        {
            val argument = it.toRoute<DetallB>()
            PantallaDetallB(argument.id)
        }


    }
}

fun NavGraphBuilder.CategoriaC(controladorDeNavegacio: NavHostController) {
    navigation<CategoriaC>(startDestination = LlistaC) {
        composable<LlistaC> {
            PantallaLlistaC(
                llista = FakeDataSource.obtenLlistaC(),
                onClickElement = { id: Int ->
                    controladorDeNavegacio.navigate(
                        DetallC(id)
                    )
                }
            )
        }

            composable<DetallC> {
                val argument = it.toRoute<DetallC>()
                PantallaDetallC(argument.id)
            }
        }

}