package cat.institutmontivi.decissorviewmodel.ui.pantalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.unit.dp
import cat.institutmontivi.decissorviewmodel.R
import cat.institutmontivi.decissorviewmodel.dades.PreferenciesDataStore
import cat.institutmontivi.decissorviewmodel.ui.common.Boto
import cat.institutmontivi.decissorviewmodel.viewmodels.ViewmodelCaraOCreu

@Preview
@Composable
fun PantallaCaraOCreu (viewModel: ViewmodelCaraOCreu = viewModel())
{
    val estat = viewModel.estat
    val temps by PreferenciesDataStore(LocalContext.current).getTempsCaraOCreu.collectAsState(initial=0)
    Column(
        Modifier
            .padding(32.dp)
            .fillMaxSize())
    {
        var imatge = R.drawable.question
        if (viewModel.estat.resultat == 0) {
            imatge = R.drawable.question

        } else if (viewModel.estat.resultat == 1)
            imatge = R.drawable.carapng
        else if (viewModel.estat.resultat == 2)
            imatge = R.drawable.creupng
        Image(
            painter = painterResource(id = R.drawable.question), contentDescription = null,
            modifier = Modifier
                .weight(5f)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally), contentScale = ContentScale.Fit
        )


        if (!viewModel.estat.estaSortejant) {

            Boto(
                modifier = Modifier
                    .weight(0.75F)
                    .fillMaxHeight(),
                text = "Sorteja",
                clic = { viewModel.sorteja(1500) })
        }
        else{
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
