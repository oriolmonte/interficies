
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
import com.example.llistesgraelles.dades.RepoFake
import com.example.llistesgraelles.pagines.Graella
import com.example.llistesgraelles.pagines.GraellaFull
import com.example.llistesgraelles.pagines.ListItems
import com.example.llistesgraelles.pagines.ListItemsGrid
import com.example.llistesgraelles.pagines.PantallaLlistaVertical
import com.example.llistesgraelles.pagines.detall


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
                coses = RepoFake.obtenirCoses(),
                onClickElement = {
                    controlDeNavegacio.navigate(Detall(it))
                }
            )
        }
        composable<Detall> {
            val argument = it.toRoute<Detall>()
            detall(argument.numero)
        }
    }
}
fun NavGraphBuilder.CategoriaList(controlDeNavegacio: NavHostController) {
    navigation<CategoriaList>(startDestination = LlistaList){
        composable<LlistaList> {
            ListItems(
                coses = RepoFake.obtenirCoses(),
                onClickElement = {
                    /*numero -> controlDeNavegacio.navigate(DetallA(numero))*/
                    controlDeNavegacio.navigate(Detall(it))
                }
            )
        }
        composable<Detall> {
            val argument = it.toRoute<Detall>()
            detall(argument.numero)
        }
    }
}fun NavGraphBuilder.CategoriaGraella(controlDeNavegacio: NavHostController) {
    navigation<CategoriaGraella>(startDestination = LlistaGraella){
        composable<LlistaGraella> {
            Graella(
                coses = RepoFake.obtenirCoses(),
                onClickElement = {
                    controlDeNavegacio.navigate(Detall(it))
                }
            )
        }
        composable<Detall> {
            val argument = it.toRoute<Detall>()
            detall(argument.numero)
        }
    }
}
fun NavGraphBuilder.CategoriaCompleta(controlDeNavegacio: NavHostController) {
    navigation<CategoriaCompleta>(startDestination = LlistaCompleta) {
        composable<LlistaCompleta> {
            GraellaFull(
                coses = RepoFake.obtenirCoses(),
                onClickElement = {
                    controlDeNavegacio.navigate(Detall(it))
                }
            )
        }
        composable<Detall> {
            val argument = it.toRoute<Detall>()
            detall(argument.numero)
        }
    }
}

fun NavGraphBuilder.CategoriaGrid(controlDeNavegacio: NavHostController) {
    navigation<CategoriaGrid>(startDestination = LlistaGrid) {
        composable<LlistaGrid> {
            ListItemsGrid(
                coses = RepoFake.obtenirCoses(),
                onClickElement = {
                    controlDeNavegacio.navigate(Detall(it))
                }
            )
        }
        composable<Detall> {
            val argument = it.toRoute<Detall>()
            detall(argument.numero)
        }
    }
}


