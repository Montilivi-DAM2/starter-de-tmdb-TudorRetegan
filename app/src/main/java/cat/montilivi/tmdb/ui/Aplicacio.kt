package cat.montilivi.tmdb.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cat.institutmontivi.tmdb.navegacio.DestInstruccions
import cat.institutmontivi.tmdb.navegacio.DestPelisPopulars
import cat.institutmontivi.tmdb.navegacio.DestPelisPopularsString
import cat.institutmontivi.tmdb.navegacio.DestPelisPopularsStringFlow
import cat.institutmontivi.tmdb.navegacio.DestPortada
import cat.institutmontivi.tmdb.navegacio.DestPreferencies
import cat.institutmontivi.tmdb.navegacio.DestQuantA
import cat.institutmontivi.tmdb.navegacio.GrafDeNavegacio
import cat.institutmontivi.tmdb.navegacio.etiquetesDelDrawer
import cat.montilivi.tmdb.R
import cat.montilivi.tmdb.ui.theme.TMDBTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

val pantallesAmbDrawer =listOf(
    DestPortada::class,
    DestPelisPopularsString::class,
    DestPelisPopularsStringFlow::class,
    DestPelisPopulars::class,
    DestInstruccions::class,
    DestPreferencies::class,
    DestQuantA::class)

val pantallesSenseDrawer:List<String> = listOf()

@Composable
fun PantallaDeLAplicacio (content: @Composable ()->Unit)
{
    TMDBTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Aplicacio ()
{
    val controladorDeNavegacio = rememberNavController()
    val ambitCorrutina: CoroutineScope = rememberCoroutineScope()
    var estatDrawer = rememberDrawerState(initialValue = DrawerValue.Closed)
    val rutaActual by controladorDeNavegacio.currentBackStackEntryAsState()
    val destinacioActual = rutaActual?.destination

    CalaixDeNavegacio(controladorDeNavegacio, rutaActual, destinacioActual, estatDrawer, ambitCorrutina)
   // Bastida(controladorDeNavegacio,ambitCorrutina, estatDrawer, rutaActual)
}


@Composable
fun CalaixDeNavegacio(
    controladorDeNavegacio: NavHostController,
    rutaActual: NavBackStackEntry?,
    destinacioActual: NavDestination?,
    estatDrawer: DrawerState,
    ambitCorrutina: CoroutineScope
) {
    ModalNavigationDrawer(
        drawerState = estatDrawer,
        drawerContent = {
            ModalDrawerSheet (
                drawerShape = ShapeDefaults.Small, //fa referència a la mida del corner radius
                drawerContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                drawerContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                drawerTonalElevation = 5.dp,
                windowInsets = WindowInsets(left = 24.dp, right = 24.dp, top = 48.dp) // És el padding
            ) {
                Icon(
                    painter = painterResource(R.drawable.logo_blau),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().aspectRatio(3F),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant)
//                Image (
//                    painterResource(id = R.drawable.logo_blau),
//                    contentDescription = null,
//                    modifier = Modifier.fillMaxWidth(),
//                    contentScale = ContentScale.FillWidth)
                Spacer (Modifier.height(48.dp))
                HorizontalDivider(
                    modifier = Modifier.height(15.dp),
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Spacer (Modifier.height(48.dp))
                etiquetesDelDrawer.forEach { etiqueta ->
                    NavigationDrawerItem(
                        label = { Text(text = etiqueta.titol) },
                        selected =  destinacioActual?.hierarchy?.any {it.hasRoute(etiqueta.ruta::class) } == true,
                        icon = {
                            if (destinacioActual?.hierarchy?.any {it.hasRoute(etiqueta.ruta::class) } == true)
                                Icon(imageVector = etiqueta.iconaSeleccionada, contentDescription = etiqueta.titol)
                            else
                                Icon(imageVector = etiqueta.iconaNoSeleccionada, contentDescription = etiqueta.titol)
                        },

                        onClick = {
                            ambitCorrutina.launch {
                                estatDrawer.close()
                            }
                            controladorDeNavegacio.navigate(etiqueta.ruta) {
                                popUpTo(controladorDeNavegacio.graph.findStartDestination().id){
                                    //guarda l'estat de la pantalla de la que marxem (funciona d'aquella manera,
                                    // No tots els valors es guarden))
                                    saveState = true
                                }
                                launchSingleTop = true
                                //Restaura l'estat de la pantalla i la deixa tal i com estava quan vam navegar a un altre lloc
                                restoreState = true
                            }
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedBadgeColor = MaterialTheme.colorScheme.error,
                            unselectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                            unselectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            unselectedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            selectedBadgeColor = MaterialTheme.colorScheme.error,
                            selectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                            selectedIconColor = MaterialTheme.colorScheme.onTertiaryContainer,
                            selectedTextColor = MaterialTheme.colorScheme.onTertiaryContainer),
                        badge = {if (etiqueta.teBadge) Icon(imageVector = etiqueta.badge, contentDescription = etiqueta.titol, tint = etiqueta.tintBadge)},
                        shape = ShapeDefaults.Medium

                    )
                }
            }
        },
        gesturesEnabled = pantallesAmbDrawer.any{destinacioActual?.hasRoute(it) ?: true}


    ) {
        Bastida(rutaActual, destinacioActual, controladorDeNavegacio, ambitCorrutina, estatDrawer)
    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bastida(
    rutaActual: NavBackStackEntry?,
    destinacioActual: NavDestination?,
    controladorDeNavegacio: NavHostController,
    ambitDeCorrutina: CoroutineScope,
    estatDrawer: DrawerState
)
{
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        ambitDeCorrutina.launch {
                            if (estatDrawer.isClosed)
                                estatDrawer.open()
                            else
                                estatDrawer.close()
                        }
                    }) {

                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
//                    if(destinacioActual?.hasRoute(DestPortada::class) ?: true) {
//                        IconButton(onClick = {
//                            ambitDeCorrutina.launch {
//                                if (estatDrawer.isClosed)
//                                    estatDrawer.open()
//                                else
//                                    estatDrawer.close()
//                            }
//                        }) {
//
//                            Icon(
//                                imageVector = Icons.Default.Menu,
//                                contentDescription = null,
//                                tint = MaterialTheme.colorScheme.onPrimary
//                            )
//                        }
//                    }
//                    else{
//                        IconButton(onClick = { controladorDeNavegacio.navigateUp()}) {
//
//                            Icon(
//                                imageVector = Icons.AutoMirrored.Default.ArrowBack,
//                                contentDescription = null,
//                                tint = MaterialTheme.colorScheme.onPrimary
//                            )
//                        }
//                    }
                })
        }

    )
    {paddingValues ->
        GrafDeNavegacio(controladorDeNavegacio, Modifier.padding(paddingValues))
    }
}

