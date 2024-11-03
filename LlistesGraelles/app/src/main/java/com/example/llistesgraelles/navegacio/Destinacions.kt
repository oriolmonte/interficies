
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
object CategoriaVertical
@Serializable
object CategoriaList
@Serializable
object CategoriaGraella
@Serializable
object CategoriaCompleta
@Serializable
object CategoriaGrid

data class CategoriaDeNavegacio<T:Any>(
    val ruta:T,
    val iconaNoSeleccionada: ImageVector,
    val iconaSeleccionada: ImageVector,
    val titol:String
)

val categoriesDeNavegacio = listOf(
    CategoriaDeNavegacio(
        ruta = CategoriaVertical,
        iconaSeleccionada = Icons.Filled.ConfirmationNumber,
        iconaNoSeleccionada = Icons.Outlined.ConfirmationNumber,
        titol = "CategoriaVertical"
    ),
    CategoriaDeNavegacio(
        ruta = CategoriaList,
        iconaSeleccionada = Icons.Filled.AreaChart,
        iconaNoSeleccionada = Icons.Outlined.AreaChart,
        titol = "CategoriaList"
    ),

    CategoriaDeNavegacio(
        ruta = CategoriaGraella,
        iconaSeleccionada = Icons.Filled.Call,
        iconaNoSeleccionada = Icons.Outlined.AreaChart,
        titol = "CategoriaGraella"
    ),
    CategoriaDeNavegacio(
        ruta = CategoriaCompleta,
        iconaSeleccionada = Icons.Filled.Call,
        iconaNoSeleccionada = Icons.Outlined.AreaChart,
        titol = "CategoriaCompleta"
    ),
    CategoriaDeNavegacio(
        ruta = CategoriaGrid,
        iconaSeleccionada = Icons.Filled.Call,
        iconaNoSeleccionada = Icons.Outlined.AreaChart,
        titol = "CategoriaGrid"
    )
)


//Definicio de pantalles
@Serializable
object  LlistaVertical
@Serializable
data class  Detall (val numero:Int)
@Serializable
object LlistaList
@Serializable
object LlistaGraella
@Serializable
object LlistaCompleta
@Serializable
object  LlistaGrid
