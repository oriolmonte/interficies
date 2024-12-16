package cat.institutmontivi.decissorviewmodel.dades

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

class PreferenciesDataStore(private val context:Context) {
    companion object {
        private val Context.dataStore by preferencesDataStore("preferencies")
        private val TEMPS_CARA_O_CREU = longPreferencesKey("tempsCaraOCreu")
        private val TEMPS_TRIA_NUMERO = longPreferencesKey("tempsTriaNumero")
        private val MINIM_TRIA_NUMERO = intPreferencesKey("minimTriaNumero")
        private val MAX_TRIA_NUMERO = intPreferencesKey("maxTriaNumero")
    }
    val getTempsCaraOCreu = context.dataStore.data.map{
        preferencies->preferencies[TEMPS_CARA_O_CREU] ?: 1000 //1000 SI NULL
    }
    suspend fun setTempsCaraOCreu(temps:Long)
    {
        context.dataStore.edit{
            preferencies->preferencies[TEMPS_CARA_O_CREU] = temps
        }
    }
    val getMinimTriaNumero = context.dataStore.data.map{
            preferencies->preferencies[MINIM_TRIA_NUMERO] ?: 0 //1000 SI NULL
    }
    suspend fun setMinimTriaNumero(min:Int) {
        context.dataStore.edit { preferencies ->
            preferencies[MINIM_TRIA_NUMERO] = min
        }
    }
    val getMaxTriaNumero = context.dataStore.data.map{
            preferencies->preferencies[MINIM_TRIA_NUMERO] ?: 1000 //1000 SI NULL
    }
    suspend fun setMaxTriaNumero(max:Int) {
        context.dataStore.edit { preferencies ->
            preferencies[MINIM_TRIA_NUMERO] = max
        }
    }

    val getTempsTriaNumero = context.dataStore.data.map{
            preferencies->preferencies[TEMPS_TRIA_NUMERO] ?: 1000 //1000 SI NULL
    }
    suspend fun setTempsTriaNumero(temps:Long) {
        context.dataStore.edit { preferencies ->
            preferencies[TEMPS_TRIA_NUMERO] = temps
        }
    }




}