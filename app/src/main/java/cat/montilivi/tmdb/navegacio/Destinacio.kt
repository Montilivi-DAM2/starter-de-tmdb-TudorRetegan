package cat.institutmontivi.tmdb.navegacio


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Adb
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.outlined.Adb
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
object DestPortada
@Serializable
object DestPelisPopularsString
@Serializable
object DestPelisPopularsStringFlow

@Serializable
object DestPelisPopulars
@Serializable
data class DestActorsUnaPeli(val idPeli: Int)
@Serializable
object DestPreferencies
@Serializable
object DestInstruccions

@Serializable
object DestQuantA

data class EtiquetaDelDrawer<T:Any>(val ruta:T, val iconaNoSeleccionada:ImageVector, val iconaSeleccionada:ImageVector, val titol:String, val teBadge: Boolean =false, val badge: ImageVector = Icons.Filled.Badge, val tintBadge: Color =  Color.Red)

val etiquetesDelDrawer = listOf(
    EtiquetaDelDrawer(DestPortada, iconaNoSeleccionada = Icons.Outlined.Home, iconaSeleccionada = Icons.Filled.Home, titol = "Portada"),
    EtiquetaDelDrawer(DestPelisPopularsString, iconaNoSeleccionada = Icons.Outlined.Movie, iconaSeleccionada = Icons.Filled.Movie, titol = "Pelis Populars String"),
    EtiquetaDelDrawer(DestPelisPopularsStringFlow, iconaNoSeleccionada = Icons.Outlined.Movie, iconaSeleccionada = Icons.Filled.Movie, titol = "Pelis Populars String Flow"),
    EtiquetaDelDrawer(DestPelisPopulars, iconaNoSeleccionada = Icons.Outlined.Movie, iconaSeleccionada = Icons.Filled.Movie, titol = "Pelis Populars"),
    EtiquetaDelDrawer(DestPreferencies, iconaNoSeleccionada = Icons.Outlined.Build, iconaSeleccionada = Icons.Filled.Build, titol = "Preferències"),
    EtiquetaDelDrawer(DestInstruccions, iconaNoSeleccionada = Icons.Outlined.Info, iconaSeleccionada = Icons.Filled.Info, titol = "Instruccions"),
    EtiquetaDelDrawer(DestQuantA, iconaNoSeleccionada = Icons.Outlined.Adb, iconaSeleccionada = Icons.Filled.Adb, titol = "Quant a ..."),
)
