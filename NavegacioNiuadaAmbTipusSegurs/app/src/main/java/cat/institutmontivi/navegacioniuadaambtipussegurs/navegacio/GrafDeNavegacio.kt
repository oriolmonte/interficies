
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
import cat.institutmontivi.navegaciobarrainferior.ui.pantalles.PantallaDetallC
import cat.institutmontivi.navegaciobarrainferior.ui.pantalles.PantallaLlistaA
import cat.institutmontivi.navegaciobarrainferior.ui.pantalles.PantallaLlistaB
import cat.institutmontivi.navegaciobarrainferior.ui.pantalles.PantallaLlistaC
import cat.institutmontivi.navegacioniuadaambtipussegurs.dades.FakeDataSource


@Composable
fun GrafDeNavegacio(
    controlDeNavegacio: NavHostController,
    paddingValues: PaddingValues = PaddingValues(0.dp)
) {
    NavHost(
        controlDeNavegacio,
        startDestination = CategoriaA,
        modifier = Modifier.padding(paddingValues)
    ){
        CategoriaA(controlDeNavegacio)
        CategoriaB(controlDeNavegacio)
        CategoriaC(controlDeNavegacio)
    }
}


fun NavGraphBuilder.CategoriaA(controlDeNavegacio: NavHostController) {
    navigation<CategoriaA>(startDestination = LlistaA){
        composable<LlistaA> {
            PantallaLlistaA(
                llista = FakeDataSource.llistaA,
                onClickElement = {
                    /*numero -> controlDeNavegacio.navigate(DetallA(numero))*/
                    controlDeNavegacio.navigate(DetallA(it))
                }
            )
        }
        composable<DetallA> {
            val argument = it.toRoute<DetallA>()
            PantallaDetallA(argument.numero)
        }
    }
}
fun NavGraphBuilder.CategoriaB(controlDeNavegacio: NavHostController) {
    navigation<CategoriaB>(startDestination = LlistaB){
        composable<LlistaB> {
            PantallaLlistaB(
                llista = FakeDataSource.llistaB,
                onClickElement = {
                    controlDeNavegacio.navigate(DetallB(it))
                }
            )
        }
        composable<DetallB> {
            val argument = it.toRoute<DetallB>()
            PantallaDetallB(argument.caracter)
        }
    }
}
fun NavGraphBuilder.CategoriaC(controlDeNavegacio: NavHostController) {
    navigation<CategoriaC>(startDestination = LlistaC){
        composable<LlistaC> {
            PantallaLlistaC(
                llista = FakeDataSource.llistaC,
                onClickElement = {
                    controlDeNavegacio.navigate(DetallC(it))
                }
            )
        }
        composable<DetallC> {
            val argument = it.toRoute<DetallC>()
            PantallaDetallC(argument.cadena)
        }
    }
}
