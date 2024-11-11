package cat.oriol.drawernavegacio.dades

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cat.oriol.drawernavegacio.R
import cat.oriol.drawernavegacio.model.Gent
import cat.oriol.drawernavegacio.model.Pirates
import cat.oriol.drawernavegacio.model.Pokemon
import coil.compose.AsyncImage
import io.github.serpro69.kfaker.Faker
import io.github.serpro69.kfaker.fakerConfig
import kotlin.random.Random
import kotlin.random.nextInt

object RepoFake{

    val configuracio = fakerConfig { locale = "en-US" }
    val faker = Faker(configuracio)
    private val llistaGent: List<Gent> = (1..50).toList().map{
        Gent(
            it,
            faker.finalFantasyXIV.characters(),
            faker.finalFantasyXIV.jobs(),
            faker.finalFantasyXIV.zones(),
            "https://loremflickr.com/320/240/ff14"
            )
    }
    private val llistaPirates: List<Pirates> = (1..50).toList().map{
        Pirates(
            it,
            faker.onePiece.characters(),
            faker.onePiece.akumaNoMi(),
            Random.nextInt(10000..5000000),
            "https://loremflickr.com/320/240/one_piece"
        )
    }
    private val llistaPokemon:List<Pokemon> = (1..150).toList().map{
        Pokemon(
            it,
            faker.pokemon.names(),
            Random.nextInt(10..255),
            Random.nextInt(10..255),
            faker.pokemon.moves(),
            faker.pokemon.moves(),
            faker.pokemon.moves(),
            faker.pokemon.moves(),
            "https://loremflickr.com/320/240/pokemon"
        )
    }
    fun obtenLlistaGent() = llistaGent
    fun obtenLlistaPirates() = llistaPirates
    fun obtenLlistaPokemons() = llistaPokemon
    fun obtenElementLlistaGent(id:Int) = llistaGent[id]
    fun obteneElementLlistaPirates(id: Int) = llistaPirates[id]
    fun obtenElementLlistaPokemons(id: Int) = llistaPokemon[id]
}