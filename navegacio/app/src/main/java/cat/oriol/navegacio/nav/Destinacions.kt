package cat.oriol.navegacio.nav

import kotlinx.serialization.Serializable
@Serializable
object Principal
@Serializable
object CaraOCreu
@Serializable
object Sorteig
@Serializable
object Oracle
@Serializable
data class Sortejat (val num: Int)
@Serializable
data class Resposta (val preg: String)