package com.example.llistesgraelles.dades

import com.example.llistesgraelles.dades.RepoFake2.obtenirCoses
import com.example.llistesgraelles.model.Cosa
import kotlin.random.Random
import kotlin.random.nextInt


val namess = listOf<String>("Pepe","Pipo","Papo","Pupo")
val surnamess = listOf<String>("Holi", "Loli", "Menoli","Manoli")

object RepoFake2 {
    public fun CrearCosa(idd: Int): Cosa = Cosa(
        id = idd,
        numero = Random.nextInt(until = 100),
        nom = namess[Random.nextInt(until = 4)] + " " + surnamess[Random.nextInt(until = 4)],
        veritat = Random.nextBoolean(),
        foto = "https://loremflickr.com/320/240/lampista?lock=$idd"
    )

    fun obtenirCoses() = (0..100).toList().map { CrearCosa(it) }

}
    val coses2 = obtenirCoses();

