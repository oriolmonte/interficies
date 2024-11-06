package com.example.llistesgraelles.dades

import com.example.llistesgraelles.dades.RepoFake3.obtenirCoses
import com.example.llistesgraelles.model.Cosa
import kotlin.random.Random
import kotlin.random.nextInt
val names = listOf<String>("Menganito","Lolito","Manito","Manolete")
val surnames = listOf<String>("Menardo", "Compadre", "Tormenta","Palotes")

object RepoFake3 {
    public fun CrearCosa(idd: Int) : Cosa = Cosa(
        id = idd,
        numero = Random.nextInt(until = 100),
        nom = names[Random.nextInt(until = 4)] + " " + surnames[Random.nextInt(until = 4)],
        veritat = Random.nextBoolean(),
        foto = "https://loremflickr.com/320/240/policia?lock=$idd"
    )
    fun obtenirCoses()=(0..100).toList().map{ CrearCosa(it) }

}
val coses3 = obtenirCoses();

