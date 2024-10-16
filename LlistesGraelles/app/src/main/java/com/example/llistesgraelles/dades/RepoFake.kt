package com.example.llistesgraelles.dades
import com.example.llistesgraelles.model.Cosa
import kotlin.random.Random
import kotlin.random.nextInt


object RepoFake
{
    public fun CrearCosa(idd: Int) : Cosa = Cosa(
        id = idd,
        numero = Random.nextInt(until = 100),
        nom = getRandomString(Random.nextInt(5..8)),
        veritat = Random.nextBoolean(),
        foto = "https://loremflickr.com/320/240/person?lock=$idd"
    )

    fun obtenirCoses()=(1..100).toList().map{ CrearCosa(it) }


}
fun getRandomString(length: Int) : String {
    val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
    return (1..length)
        .map { allowedChars.random() }
        .joinToString("")
}
