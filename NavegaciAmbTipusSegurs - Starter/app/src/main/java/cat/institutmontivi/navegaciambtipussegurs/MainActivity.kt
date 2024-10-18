package cat.institutmontivi.navegaciambtipussegurs

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cat.institutmontivi.navegaciambtipussegurs.navegacio.GrafDeNavegacio
import cat.institutmontivi.navegaciambtipussegurs.navegacio.Principal
import cat.institutmontivi.navegaciambtipussegurs.ui.pantalles.PantallaPrincipal
import cat.institutmontivi.navegaciambtipussegurs.ui.theme.NavegacióAmbTipusSegursTheme

//Define destinations using composable<T> (or navigation<T> for nested graphs)
//Navigate to a destination using navigate(route = T) for object routes or navigate(route = T(…)) for class instance routes
//Obtain a route from a NavBackStackEntry or SavedStateHandle using toRoute<T>
//Check whether a destination was created using a given route using hasRoute(route = T::class)


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacióAmbTipusSegursTheme {
               Aplicacio()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview ()
@Composable
fun Aplicacio ()
{
    val navController = rememberNavController()
    val rutaActual by navController.currentBackStackEntryAsState()
    val destinacioActual = rutaActual?.destination
    Scaffold(
        modifier=Modifier
            .fillMaxSize()
            ,
            topBar = {
                TopAppBar(
                    title = {Text("Navegacio")},
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    navigationIcon = {
                        if (destinacioActual?.hasRoute(Principal::class)?:true) {
                            IconButton(onClick = {})
                            {
                                Icon(
                                    imageVector = Icons.Default.Home,
                                    contentDescription = "Home"
                                )
                            }
                        }
                        else
                        {
                            IconButton(onClick = {
                                navController.navigateUp()
                            })
                            {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        }
                    }
                )
            }
    ) {
        paddingValues ->
        GrafDeNavegacio(paddingValues)
    }   
}

@Composable
fun TemaDeLaAplicacio(content: @Composable ()->Unit)
{
    NavegacióAmbTipusSegursTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun DefaultPreview() {
    Text("Hola")
}

@Preview(showBackground = true)
@Composable
fun TemaDeLaAplicacioPreview() {
    TemaDeLaAplicacio {
        Text("Hola")
    }
}