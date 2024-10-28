package com.example.llistesgraelles.navegacio

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.outlined.ConfirmationNumber
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavBackStackEntry
import com.example.llistesgraelles.model.Cosa
import kotlinx.serialization.Serializable

//Definicio Categories
@Serializable
object CategoriaVertical
@Serializable
object CategoriaList
@Serializable
object CategoriaGraella


data class CategoriaNavegacio<T:Any>(
    val ruta:T,
    val titol:String,
    val iconaNoSeleccionada: ImageVector,
    val iconaSeleccionada: ImageVector,
    )

val categoriesDeNavegacio = listOf(
    CategoriaNavegacio(
        ruta = CategoriaVertical,
        titol = "Vertical",
        iconaSeleccionada = Icons.Filled.ConfirmationNumber,
        iconaNoSeleccionada = Icons.Outlined.ConfirmationNumber,
    ),

    CategoriaNavegacio(
        ruta = CategoriaList,
        titol = "List",
        iconaSeleccionada = Icons.Filled.ConfirmationNumber,
        iconaNoSeleccionada = Icons.Outlined.ConfirmationNumber,
    ),

    CategoriaNavegacio(
        ruta = CategoriaGraella,
        titol = "Graella",
        iconaSeleccionada = Icons.Filled.ConfirmationNumber,
        iconaNoSeleccionada = Icons.Outlined.ConfirmationNumber,
    )
)

//Definicio de pantalles
@Serializable
object LlistaVertical
@Serializable
object ListItems
@Serializable
object Graella
@Serializable
data class Detall(val id: Int)