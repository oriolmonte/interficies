package cat.institutmontivi.decissorviewmodel.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ViewmodelTriaNumero:ViewModel()
{
    var estat by mutableStateOf(Estat())
    private set
    init
    {
        estat = estat.copy(
            valorTriat = 0,
            estaSortejant = false
        )
    }
    fun Sorteja(minim:Int, maxim:Int, temps:Long){
        estat = estat.copy(estaSortejant = true)
        viewModelScope.launch {
            delay(temps)
            estat = estat.copy(estaSortejant = false,
                valorTriat = (minim..maxim).random())
        }
    }

    data class Estat(
        val valorTriat:Int=0,
        val estaSortejant:Boolean = false,
    )

}
