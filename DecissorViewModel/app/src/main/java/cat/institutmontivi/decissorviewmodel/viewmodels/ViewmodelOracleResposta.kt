package cat.institutmontivi.decissorviewmodel.viewmodels

import androidx.lifecycle.SavedStateHandle
import cat.institutmontivi.decissorviewmodel.navegacio.DestinacioOracleResposta

class ViewmodelOracleResposta(savedStateHandle: SavedStateHandle):ViewModel() {
    var estat by mutableStateOf(EstatOracleResposta())
        private set
    init {
        val args = savedStateHandle.toRoute<DestinacioOracleResposta>()
        estat = estat.copy(pregunta = args.pregunta)
    }
    fun respon()
    {
        estat = estat.copy(resposta="NO")
    }

}
data class EstatOracleResposta(
    val resposta:String= "",val pregunta:String = ""
)

