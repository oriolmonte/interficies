package cat.institutmontivi.navegacioniuadaambtipussegurs.dades

import cat.institutmontivi.navegacioniuadaambtipussegurs.model.Cadena
import cat.institutmontivi.navegacioniuadaambtipussegurs.model.Client
import cat.institutmontivi.navegacioniuadaambtipussegurs.model.Lletra
import cat.institutmontivi.navegacioniuadaambtipussegurs.model.Numero
import io.github.serpro69.kfaker.Faker
import io.github.serpro69.kfaker.fakerConfig
import kotlin.random.Random

object FakeDataSource {


    val configuracio = fakerConfig { locale = "ca-ES" }
    val faker = Faker(configuracio)

val a = faker.minecraft.mobs().random()
    private val llistaClients = (1..100).toList().map {
        Client(
            it,
            faker.name.firstName(),
            faker.name.lastName(),
            faker.address.city()
        )
    }

   private val llistaA: List<Numero> = (1..100).toList().map{ Numero(it, it.toString()) }
   private val llistaB: List<Lletra> = (0..26).toList().map { Lletra(it, ('A'+it).toString()) }
   private val llistaC: List<Cadena>  =  (1..100).toList()
        .map {
            val element = StringBuilder()
            val lletres = ('A'..'Z').toList()
            for (num in 1..(Random.nextInt(5) + 1))
            {
                element.append(lletres[Random.nextInt(26)].toString())
            }
            Cadena(it, element.toString())
        }

    fun obtenLlistaA() = llistaA

    fun obtenLlistaB() = llistaB

    fun obtenLlistaC() = llistaC

    fun obtenElementLlistaA(id:Int) = llistaA[id]

    fun obteneElementLlistaB(id: Int) = llistaB[id]

    fun obtenElementLlistaC(id: Int) = llistaC[id]
}