//package cat.montilivi.tmdb.ui.pantalles
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import androidx.lifecycle.viewmodel.compose.viewModel
//import cat.montilivi.tmdb.dades.xarxa.theMovieDBClient
//import coil.compose.AsyncImage
//
//@Composable
//fun PantallaLlistaActors(viewModel: LlistaActorsViewModel = viewModel()) {
//    val estat by viewModel.estat.collectAsStateWithLifecycle()
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(MaterialTheme.colorScheme.background) // Un fons més neutre sol quedar millor
//    ) {
//        // Capçalera opcional
//        Text(
//            text = "Repartiment",
//            style = MaterialTheme.typography.headlineLarge,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(16.dp),
//            color = MaterialTheme.colorScheme.onBackground
//        )
//
//        if (estat.estaCarregant) {
//            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                CircularProgressIndicator()
//            }
//        } else {
//            LazyVerticalGrid(
//                columns = GridCells.Adaptive(minSize = 150.dp), // S'adapta segons la mida de pantalla
//                contentPadding = PaddingValues(12.dp),
//                horizontalArrangement = Arrangement.spacedBy(12.dp),
//                verticalArrangement = Arrangement.spacedBy(16.dp),
//                modifier = Modifier.fillMaxSize()
//            ) {
//                items(estat.actors) { actor ->
//                    ElementDActor(actor)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun ElementDActor(actor: Cast) {
//    Card(
//        shape = RoundedCornerShape(12.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.surfaceVariant,
//            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
//        ),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        Column {
//            // Imatge de l'actor amb ràtio d'aspecte de retrat
//            AsyncImage(
//                model = theMovieDBClient.BASE_URL_IMG + actor.profilePath,
//                contentDescription = "Foto de ${actor.name}",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
//                contentScale = ContentScale.Crop
//            )
//
//            // Informació de l'actor
//            Column(
//                modifier = Modifier
//                    .padding(8.dp)
//                    .fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = actor.character,
//                    style = MaterialTheme.typography.titleMedium,
//                    fontWeight = FontWeight.Bold,
//                    textAlign = TextAlign.Center,
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//                Text(
//                    text = actor.name,
//                    style = MaterialTheme.typography.bodyMedium,
//                    color = MaterialTheme.colorScheme.secondary,
//                    textAlign = TextAlign.Center,
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//            }
//        }
//    }
//}