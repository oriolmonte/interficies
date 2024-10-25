package cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio

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
import cat.institutmontivi.navegaciobarrainferior.ui.pantalles.PantallaLlistaA
import cat.institutmontivi.navegaciobarrainferior.ui.pantalles.PantallaLlistaB
import cat.institutmontivi.navegaciobarrainferior.ui.pantalles.PantallaLlistaC
import cat.institutmontivi.navegacioniuadaambtipussegurs.dades.FakeDataSource


@Composable
fun GrafDeNavegacio(
    controladorDeNavegacio: NavHostController,
    paddingValues: PaddingValues = PaddingValues(0.dp)
) {
    //MARC ON ES POSEN LES PANTALLES
    NavHost(
        controladorDeNavegacio,
        startDestination =  CategoriaA,
        modifier =  Modifier.padding(paddingValues)
    )
    {
        //3 PANTALLES ON ANAR
        CategoriaA(controladorDeNavegacio)
        CategoriaB(controladorDeNavegacio)
        CategoriaC(controladorDeNavegacio)
    }
}

fun NavGraphBuilder.CategoriaA(controladorDeNavegacio: NavHostController)
{
    navigation<CategoriaA>(startDestination = LlistaA)
    {
        composable<LlistaA>{
            PantallaLlistaA(
            llista = FakeDataSource.llistaA,
            onClickElement = {
                controladorDeNavegacio.navigate((LlistaDetallA(it)))
            }
            )
        }
        composable<LlistaDetallA> {
            val argument = it.toRoute<LlistaDetallA>()
            PantallaDetallA(argument.numero)
        }
    }
}

fun NavGraphBuilder.CategoriaB(controladorDeNavegacio: NavHostController)
{
    navigation<CategoriaB>(startDestination = LlistaA)
    {
        composable<LlistaB>{
            PantallaLlistaB(
                llista = FakeDataSource.llistaB,
                onClickElement = { caracter ->
                    controladorDeNavegacio.navigate((LlistaDetallB(caracter)))

                }
            )
        }
        composable<LlistaDetallB> {
            val argument = it.toRoute<LlistaDetallB>()
            PantallaDetallB(argument.caracter)
        }
    }
}

fun NavGraphBuilder.CategoriaC(controladorDeNavegacio: NavHostController)
{
    navigation<CategoriaC>(startDestination = LlistaA)
    {
        composable<LlistaC>{
            PantallaLlistaC(
                llista = FakeDataSource.llistaC,
                onClickElement = { cadena ->
                    controladorDeNavegacio.navigate(LlistaDetallC(cadena))
                }
            )
        }
        composable<LlistaDetallC> {
            val argument = it.toRoute<LlistaDetallC>()
            PantallaDetallB(argument.cadena)
        }
    }
}