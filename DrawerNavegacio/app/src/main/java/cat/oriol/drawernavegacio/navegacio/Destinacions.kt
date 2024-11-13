package cat.oriol.drawernavegacio.navegacio

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AreaChart
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.outlined.AreaChart
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.CatchingPokemon
import androidx.compose.material.icons.outlined.ConfirmationNumber
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Flag
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
object CategoriaFinal
@Serializable
object CategoriaPirates
@Serializable
object CategoriaPokemon

data class CategoriaDeNavegacio<T:Any>(
    val ruta: T,
    val iconaNoSeleccionada: ImageVector,
    val iconaSeleccionada: ImageVector,
    val titol : String
)

val categoriesDeNavegacio = listOf(
    CategoriaDeNavegacio(
        ruta = CategoriaFinal,
        iconaSeleccionada = Icons.Filled.Face,
        iconaNoSeleccionada = Icons.Outlined.Face,
        titol = "Final Fantasy 14"
    ),

    CategoriaDeNavegacio(
        ruta = CategoriaPirates,
        iconaSeleccionada = Icons.Filled.Flag,
        iconaNoSeleccionada = Icons.Outlined.Flag,
        titol = "Pirates"
    ),

    CategoriaDeNavegacio(
        ruta = CategoriaPokemon,
        iconaSeleccionada = Icons.Filled.CatchingPokemon,
        iconaNoSeleccionada = Icons.Outlined.CatchingPokemon,
        titol = "Pokemon"
    )
)

@Serializable
object LlistaFF

@Serializable
data class DetallFF(val id: Int)

@Serializable
object LlistaPirates

@Serializable
data class DetallPirates(val id: Int)

@Serializable
object LlistaPokemon

@Serializable
data class DetallPokemon(val id: Int)
