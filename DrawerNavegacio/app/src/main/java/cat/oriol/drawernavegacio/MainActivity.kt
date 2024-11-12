package cat.oriol.drawernavegacio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.oriol.drawernavegacio.dades.RepoFake
import cat.oriol.drawernavegacio.navegacio.DetallFF
import cat.oriol.drawernavegacio.ui.pantalles.PantallaLlistaFF
import cat.oriol.drawernavegacio.ui.pantalles.detallFF
import cat.oriol.drawernavegacio.ui.pantalles.detallPirates
import cat.oriol.drawernavegacio.ui.theme.DrawerNavegacioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DrawerNavegacioTheme {
                detallPirates(14)
            }
        }
    }
}
