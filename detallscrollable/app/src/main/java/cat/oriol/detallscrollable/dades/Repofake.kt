package cat.oriol.detallscrollable.dades

import io.github.serpro69.kfaker.Faker
import io.github.serpro69.kfaker.fakerConfig
import kotlin.random.Random
import kotlin.random.nextInt
import cat.oriol.detallscrollable.model.Gent
import cat.oriol.detallscrollable.model.Pirates
import cat.oriol.detallscrollable.model.Pokemon
object RepoFake{

    val configuracio = fakerConfig { locale = "en-US" }
    val faker = Faker(configuracio)
    private val llistaGent: List<Gent> = (0..50).toList().map{
        Gent(
            it,
            faker.finalFantasyXIV.characters(),
            faker.finalFantasyXIV.jobs(),
            faker.finalFantasyXIV.zones(),
            "https://loremflickr.com/320/320/ff14?lock=${Random.nextInt(0..1024)}"
        )
    }
    private val llistaPirates: List<Pirates> = (0..50).toList().map{
        val char = faker.onePiece.characters()
        Pirates(
            it,
            char,
            faker.onePiece.akumaNoMi(),
            Random.nextInt(10000..5000000),
            "https://loremflickr.com/320/320/${char.lowercase().replace(" ","_")}"
        )
    }
    private val llistaPokemon:List<Pokemon> = (0..150).toList().map{
        val char = faker.pokemon.names()
        Pokemon(
            it,
            char,
            Random.nextInt(10..255),
            Random.nextInt(10..255),
            faker.pokemon.moves(),
            faker.pokemon.moves(),
            faker.pokemon.moves(),
            faker.pokemon.moves(),
            "https://loremflickr.com/320/240/${char.lowercase().replace(" ","_")}"
        )
    }
    fun obtenLlistaGent() = llistaGent
    fun obtenLlistaPirates() = llistaPirates
    fun obtenLlistaPokemons() = llistaPokemon
    fun obtenElementLlistaGent(id:Int) = llistaGent[id]
    fun obteneElementLlistaPirates(id: Int) = llistaPirates[id]
    fun obtenElementLlistaPokemons(id: Int) = llistaPokemon[id]
}