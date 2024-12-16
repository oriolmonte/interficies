package cat.institutmontivi.decissorviewmodel.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ViewmodelCaraOCreu: ViewModel()
{
    var estat by mutableStateOf(EstatCaraOCreu())
     private set
    init {
        estat=estat.copy(
            estaSortejant = false,
            resultat = 0
        )
    }
    fun sorteja(temps: Long) {
        estat=estat.copy(
            estaSortejant = true,
            resultat = 0
        )
        viewModelScope.launch {
            delay(temps)
            estat=estat.copy(
                estaSortejant = false,
                resultat = (1..2).random()
            )
        }

    }

    data class EstatCaraOCreu(
        val estaSortejant:Boolean =false,
        val resultat:Int = 0
    )
    sealed class EventCaraOCreu(
        val estaSortejant:Boolean =false,
        val resultat:Int = 0
    )
}