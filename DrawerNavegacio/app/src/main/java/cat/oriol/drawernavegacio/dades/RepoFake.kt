package cat.oriol.drawernavegacio.dades

import cat.oriol.drawernavegacio.model.Gent
import io.github.serpro69.kfaker.Faker
import io.github.serpro69.kfaker.fakerConfig

object RepoFake{

    val configuracio = fakerConfig { locale = "en-US" }
    val faker = Faker(configuracio)
    val llistaA = (1..10).toList().map{
        Gent(
            it,
            faker.finalFantasyXIV.characters(),
        )
    }
    fun obtenLlistaA() = llistaA
}