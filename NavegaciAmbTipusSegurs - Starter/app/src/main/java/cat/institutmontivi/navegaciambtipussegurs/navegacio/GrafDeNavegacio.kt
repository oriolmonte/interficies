package cat.institutmontivi.navegaciambtipussegurs.navegacio

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import cat.institutmontivi.navegaciambtipussegurs.ui.pantalles.PantallaElement
import cat.institutmontivi.navegaciambtipussegurs.ui.pantalles.PantallaLletres
import cat.institutmontivi.navegaciambtipussegurs.ui.pantalles.PantallaNumeros
import cat.institutmontivi.navegaciambtipussegurs.ui.pantalles.PantallaPrincipal

@Composable
fun GrafDeNavegacio (
    navController:NavHostController,
    paddingValues: PaddingValues = PaddingValues(0.dp)
)
{
    val navController = navController
    NavHost(
        navController = navController,
        startDestination = Principal,
        modifier = Modifier.padding(paddingValues)
    )
    {
        composable<Principal>{
            PantallaPrincipal(
                onLletresClic={
                navController.navigate(LlistaDeLletres)
                },
                onNumerosClic = {
                    navController.navigate(LlistaDeNumeros)
                },
                )
        }
        composable<LlistaDeLletres>{
            PantallaLletres(
                onCasellaClick ={lletra:String->
                    navController.navigate(Element(text = lletra))
                }
            )
        }
        composable<LlistaDeNumeros>{
            PantallaNumeros(
                onCasellaClick = { numero: String ->
                    navController.navigate(Element(text = numero))
                    {
                        popUpTo(Principal){
                            inclusive = false
                        }
                    }
                }
            )
                }
        composable<Element> {backStackEntry ->
            val element = backStackEntry.toRoute<Element>()
            PantallaElement(element.text)
        }
        }


}