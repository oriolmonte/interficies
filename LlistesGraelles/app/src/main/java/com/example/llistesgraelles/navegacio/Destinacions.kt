
package cat.institutmontivi.navegacioniuadaambtipussegurs.navegacio

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AreaChart
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Egg
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.PanoramaHorizontalSelect
import androidx.compose.material.icons.filled.TableRows
import androidx.compose.material.icons.filled.Widgets
import androidx.compose.material.icons.filled.Window
import androidx.compose.material.icons.outlined.AreaChart
import androidx.compose.material.icons.outlined.CatchingPokemon
import androidx.compose.material.icons.outlined.ConfirmationNumber
import androidx.compose.material.icons.outlined.Egg
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Numbers
import androidx.compose.material.icons.outlined.PanoramaHorizontalSelect
import androidx.compose.material.icons.outlined.TableRows
import androidx.compose.material.icons.outlined.Widgets
import androidx.compose.material.icons.outlined.Window
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
        iconaSeleccionada = Icons.Filled.TableRows,
        iconaNoSeleccionada = Icons.Outlined.TableRows,
        titol = "Columna"
    ),
    CategoriaDeNavegacio(
        ruta = CategoriaList,
        iconaSeleccionada = Icons.Filled.Email,
        iconaNoSeleccionada = Icons.Outlined.Email,
        titol = "List"
    ),

    CategoriaDeNavegacio(
        ruta = CategoriaGraella,
        iconaSeleccionada = Icons.Filled.Widgets,
        iconaNoSeleccionada = Icons.Outlined.Widgets,
        titol = "Graella"
    ),
    CategoriaDeNavegacio(
        ruta = CategoriaCompleta,
        iconaSeleccionada = Icons.Filled.Egg,
        iconaNoSeleccionada = Icons.Outlined.Egg,
        titol = "Completa"
    ),
    CategoriaDeNavegacio(
        ruta = CategoriaGrid,
        iconaSeleccionada = Icons.Filled.Window,
        iconaNoSeleccionada = Icons.Outlined.Window,
        titol = "ListGrid"
    )
)


//Definicio de pantalles
@Serializable
object  LlistaVertical
@Serializable
data class  Detall (val id:Int)
@Serializable
data class  Detall2 (val id:Int)
@Serializable
data class  Detall3 (val id:Int)
@Serializable
object LlistaList
@Serializable
object LlistaGraella
@Serializable
object LlistaCompleta
@Serializable
object  LlistaGrid
