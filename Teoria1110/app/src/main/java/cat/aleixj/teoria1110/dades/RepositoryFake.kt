package cat.aleixj.teoria1110.dades

import androidx.compose.ui.graphics.Color
import cat.aleixj.teoria1110.model.Guerrer
import kotlin.random.Random

object repositoryFake
{
    private val Noms = listOf(
        "Joan",
        "Pere",
        "Martí",
        "Conan",
        "Lopez"
    )

    private val Adjectius = listOf(
        "l'Invasor",
        "l'Assasí",
        "el Destripador",
        "el Maleducat",
        "el Magnífic",
        "l'Estalar",
        "el Conqueridor"
    )

    public fun CrearGuerrer(num: Int): Guerrer =
        Guerrer(
            id = num,
            nom ="${Noms.random()} ${Adjectius.random()}",
            foto = "https://loremflickr.com/320/240/warrior?lock=$num",
            color = Color(
                Random.nextInt(256),
                Random.nextInt(256),
                Random.nextInt(256),
                255
            ),
            descripcio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
            velocitat = Random.nextInt(0, 100),
            vida = Random.nextInt(0, 100),
            atac = Random.nextInt(0, 100),
            defensa = Random.nextInt(0, 100)
        )

    fun obtenirDadesDelsGuerrers() =
        (1..100)
            .toList()
            .map { CrearGuerrer(it) }
}