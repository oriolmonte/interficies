package cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AreaChart
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.outlined.AreaChart
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.ConfirmationNumber
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

// Definicio de les categories

@Serializable
object CategoriaA

@Serializable
object CategoriaB

@Serializable
object CategoriaC

data class CategoriaDeNavegacio<T:Any>(
    val ruta: T,
    val iconaNoSeleccionada: ImageVector,
    val iconaSeleccionada: ImageVector,
    val titol : String
)

val categoriesDeNavegacio = listOf(
    CategoriaDeNavegacio(
        ruta = CategoriaA,
        iconaSeleccionada = Icons.Filled.ConfirmationNumber,
        iconaNoSeleccionada = Icons.Outlined.ConfirmationNumber,
        titol = "Categoria A"
    ),

    CategoriaDeNavegacio(
        ruta = CategoriaB,
        iconaSeleccionada = Icons.Filled.AreaChart,
        iconaNoSeleccionada = Icons.Outlined.AreaChart,
        titol = "Categoria B"
    ),

    CategoriaDeNavegacio(
        ruta = CategoriaC,
        iconaSeleccionada = Icons.Filled.Call,
        iconaNoSeleccionada = Icons.Outlined.Call   ,
        titol = "Categoria C"
    )
)

// Definicio de les pantalles de cada categoria
@Serializable
object LlistaA

@Serializable
data class DetallA(val id: Int)

@Serializable
object LlistaB

@Serializable
data class DetallB(val id: Int)

@Serializable
object LlistaC

@Serializable
data class DetallC(val id: Int)