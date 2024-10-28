package com.example.llistesgraelles.navegacio

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.llistesgraelles.dades.RepoFake
import com.example.llistesgraelles.model.Cosa
import com.example.llistesgraelles.pagines.ListItems
import com.example.llistesgraelles.pagines.PantallaLlistaVertical
import com.example.llistesgraelles.parts.LlistaVertical

@Composable
fun GrafDeNavegacio(
    controladorDeNavegacio: NavHostController,
    paddingValues: PaddingValues = PaddingValues(0.dp)
) {
    NavHost(
        controladorDeNavegacio,
        startDestination = CategoriaList,
        modifier = Modifier.padding(paddingValues)
    )
    {
        CategoriaVertical(controladorDeNavegacio)
        CategoriaList(controladorDeNavegacio)
    }
}

fun NavGraphBuilder.CategoriaVertical(controladorDeNavegacio: NavHostController)
{
    navigation<CategoriaVertical>(startDestination = CategoriaVertical)
    {
        composable<CategoriaVertical>{
            PantallaLlistaVertical(
                coses = RepoFake.obtenirCoses(),
                onClickElement = {
                    controladorDeNavegacio.navigate(Detall(it))
                }
            )
        }
        composable<Detall>{
            val argument = it.toRoute<Detall>()
            Detall(argument.id)
        }
    }
}

fun NavGraphBuilder.CategoriaList(controladorDeNavegacio: NavHostController)
{
    navigation<CategoriaVertical>(startDestination = CategoriaVertical)
    {
        composable<CategoriaList>{
            ListItems(
                coses = RepoFake.obtenirCoses(),
                onClickElement = {
                    controladorDeNavegacio.navigate(Detall(it))
                }
            )
        }
        composable<Detall>{
            val argument = it.toRoute<Detall>()
            Detall(argument.id)
        }
    }
}