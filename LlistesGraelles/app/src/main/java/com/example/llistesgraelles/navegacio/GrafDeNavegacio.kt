
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
import com.example.llistesgraelles.dades.*
import com.example.llistesgraelles.pagines.Graella
import com.example.llistesgraelles.pagines.GraellaFull
import com.example.llistesgraelles.pagines.ListItems
import com.example.llistesgraelles.pagines.ListItemsGrid
import com.example.llistesgraelles.pagines.PantallaLlistaVertical
import com.example.llistesgraelles.pagines.detall
import com.example.llistesgraelles.pagines.detall2
import com.example.llistesgraelles.pagines.detall3


@Composable
fun GrafDeNavegacio(
    controlDeNavegacio: NavHostController,
    paddingValues: PaddingValues = PaddingValues(0.dp)
) {
    NavHost(
        controlDeNavegacio,
        startDestination = CategoriaVertical,
        modifier = Modifier.padding(paddingValues)
    ){
        CategoriaVertical(controlDeNavegacio)
        CategoriaList(controlDeNavegacio)
        CategoriaGraella(controlDeNavegacio)
        CategoriaCompleta(controlDeNavegacio)
        CategoriaGrid(controlDeNavegacio)
    }
}


fun NavGraphBuilder.CategoriaVertical(controlDeNavegacio: NavHostController) {
    navigation<CategoriaVertical>(startDestination = LlistaVertical){
        composable<LlistaVertical> {
            PantallaLlistaVertical(
                Coses = RepoFake.obtenirCoses(),
                onClickElement = {
                    controlDeNavegacio.navigate(Detall(it))
                }
            )
        }
        composable<Detall> {
            val argument = it.toRoute<Detall>()
            detall(argument.id)
        }
    }
}
fun NavGraphBuilder.CategoriaList(controlDeNavegacio: NavHostController) {
    navigation<CategoriaList>(startDestination = LlistaList){
        composable<LlistaList> {
            ListItems(
                Coses = coses,
                onClickElement = {
                    /*numero -> controlDeNavegacio.navigate(DetallA(numero))*/
                    controlDeNavegacio.navigate(Detall(it))
                }
            )
        }
        composable<Detall> {
            val argument = it.toRoute<Detall>()
            detall(argument.id)
        }
    }
}fun NavGraphBuilder.CategoriaGraella(controlDeNavegacio: NavHostController) {
    navigation<CategoriaGraella>(startDestination = LlistaGraella){
        composable<LlistaGraella> {
            Graella(
                Coses = coses,
                onClickElement = {
                    controlDeNavegacio.navigate(Detall(it))
                }
            )
        }
        composable<Detall> {
            val argument = it.toRoute<Detall>()
            detall(argument.id)
        }
    }
}
fun NavGraphBuilder.CategoriaCompleta(controlDeNavegacio: NavHostController) {
    navigation<CategoriaCompleta>(startDestination = LlistaCompleta) {
        composable<LlistaCompleta> {
            GraellaFull(
                coses = coses2,
                onClickElement = {
                    controlDeNavegacio.navigate(Detall2(it))
                }
            )
        }
        composable<Detall2> {
            val argument = it.toRoute<Detall2>()
            detall2(argument.id)
        }
    }
}

fun NavGraphBuilder.CategoriaGrid(controlDeNavegacio: NavHostController) {
    navigation<CategoriaGrid>(startDestination = LlistaGrid) {
        composable<LlistaGrid> {
            ListItemsGrid(
                coses = coses3,
                onClickElement = {
                    controlDeNavegacio.navigate(Detall3(it))
                }
            )
        }
        composable<Detall3> {
            val argument = it.toRoute<Detall3>()
            detall3(argument.id)
        }
    }
}


