package cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AreaChart
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.outlined.AreaChart
import androidx.compose.material.icons.outlined.ConfirmationNumber
import androidx.compose.material.icons.outlined.Numbers
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

//Definicio Categories
@Serializable
object CategoriaA
@Serializable
object CategoriaB
@Serializable
object CategoriaC


data class CategoriaDeNavegacio<T:Any>(
    val ruta:T,
    val iconaNoSeleccionada: ImageVector,
    val iconaSeleccionada: ImageVector,
    val titol:String
)

val categoriesDeNavegacio = listOf(
    CategoriaDeNavegacio(
        ruta = CategoriaA,
        iconaSeleccionada = Icons.Filled.ConfirmationNumber,
        iconaNoSeleccionada = Icons.Outlined.ConfirmationNumber,
        titol = "CategoriaA"
    ),
    CategoriaDeNavegacio(
        ruta = CategoriaB,
        iconaSeleccionada = Icons.Filled.AreaChart,
        iconaNoSeleccionada = Icons.Outlined.AreaChart,
        titol = "CategoriaB"
    ),

    CategoriaDeNavegacio(
        ruta = CategoriaC,
        iconaSeleccionada = Icons.Filled.Call,
        iconaNoSeleccionada = Icons.Outlined.AreaChart,
        titol = "CategoriaC"
)
)


//Definicio de pantalles
@Serializable
object  LlistaA
@Serializable
data class  LlistaDetallA (val numero:Int)
@Serializable
object LlistaB
@Serializable
data class  LlistaDetallB (val caracter:String)
@Serializable
object LlistaC
@Serializable
data class  LlistaDetallC (val cadena:String)


