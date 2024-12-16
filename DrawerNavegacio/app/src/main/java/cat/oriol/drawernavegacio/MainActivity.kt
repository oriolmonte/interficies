package cat.oriol.drawernavegacio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cat.oriol.drawernavegacio.ui.AppDrawer
import cat.oriol.drawernavegacio.ui.AppPager
import cat.oriol.drawernavegacio.ui.AppRail
import cat.oriol.drawernavegacio.ui.theme.DrawerNavegacioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DrawerNavegacioTheme {
                //AppDrawer()
                //AppPager()
                AppRail()
            }
        }
    }
}
