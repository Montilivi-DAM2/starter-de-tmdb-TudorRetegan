package cat.institutmontivi.tmdb.navegacio

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import cat.montilivi.tmdb.ui.pantalles.PantallaInstruccions
import cat.montilivi.tmdb.ui.pantalles.PantallaPortada
import cat.montilivi.tmdb.ui.pantalles.PantallaPreferencies
import cat.montilivi.tmdb.ui.pantalles.PantallaQuantA


@Composable
fun GrafDeNavegacio (controladorDeNavegacio: NavHostController = rememberNavController(), modifier: Modifier =Modifier)
{
    NavHost(navController = controladorDeNavegacio, startDestination = DestPortada, modifier = modifier)
    {
        composable<DestPortada>
        {
            PantallaPortada()
        }
        composable<DestInstruccions>
        {
            PantallaInstruccions()
        }
        composable<DestPreferencies>
        {
            PantallaPreferencies()
        }
        composable<DestQuantA>
        {
            PantallaQuantA()
        }
        composable<DestPelisPopularsString>
        {
            //PantallaPelisPopularsString()
        }
        composable<DestPelisPopularsStringFlow>
        {
            //PantallaPelisPopularsStringFlow()
        }
        composable<DestPelisPopulars>
        {
           // PantallaPelisPopulars(onClic = { idPeli:Int -> controladorDeNavegacio.navigate(DestActorsUnaPeli(idPeli))})
        }
        composable<DestActorsUnaPeli>{ backStackEntry ->
            val parametre = backStackEntry.toRoute<DestActorsUnaPeli>()
            //PantallaLlistaActors()
        }
    }
}