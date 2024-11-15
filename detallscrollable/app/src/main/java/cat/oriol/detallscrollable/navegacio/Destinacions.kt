package cat.oriol.detallscrollable.navegacio

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.outlined.CatchingPokemon
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
data class DetallFF(val id: Int)
@Serializable
data class DetallPirates(val id: Int)
@Serializable
data class DetallPokemon(val id: Int)
