package cat.oriol.navegacio.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import cat.oriol.navegacio.pantalles.PantallaCaraOcreu
import cat.oriol.navegacio.pantalles.PantallaOracle
import cat.oriol.navegacio.pantalles.PantallaPrincipal
import cat.oriol.navegacio.pantalles.PantallaRespostaOracle
import cat.oriol.navegacio.pantalles.PantallaSorteig
import cat.oriol.navegacio.pantalles.PantallaSortejat

@Composable
fun GrafDeNavegacio(
    navController: NavHostController,
    paddingValues: PaddingValues = PaddingValues(0.dp)
)
{
    val navController = navController

    NavHost(
        navController=navController,
        startDestination = Principal,
        modifier = Modifier.padding(0.dp)
    )
        {
            composable<Principal>{
                PantallaPrincipal(
                    onCaraOCreuClic = {
                        navController.navigate(CaraOCreu)
                    },
                    onOracleClic = {
                        navController.navigate(Oracle)
                    },
                    onSorteigClic = {
                        navController.navigate(Sorteig)
                    }
                )
            }
            composable<CaraOCreu>
            {
                PantallaCaraOcreu()
            }
            composable<Sorteig>
            {
                PantallaSorteig(
                    onSorteigClick = { numero: Int ->
                        navController.navigate(Sortejat(num = numero))
                        {
                            popUpTo(Principal){
                                inclusive=false
                            }
                        }
                    }
                )
            }
            composable<Sortejat>
            {
                backStackEntry -> val element = backStackEntry.toRoute<Sortejat>().num
                PantallaSortejat(element)
            }
            composable<Oracle>
            {
                PantallaOracle(
                    onRespostaClic =
                    {
                            pregunta: String -> navController.navigate(Resposta(preg=pregunta))
                    }
                )
            }
            composable<Resposta>
            {
                backStackEntry -> val str = backStackEntry.toRoute<Resposta>().preg
                PantallaRespostaOracle(str)
            }
        }
}