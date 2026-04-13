//package cat.montilivi.tmdb.ui.pantalles
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
//import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
//import androidx.compose.material.icons.filled.Star
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
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
//fun PantallaPelisPopulars(
//    viewModel: PelisPopularsViewModel = viewModel(),
//    onClic: (Int) -> Unit = {}
//) {
//    val estat by viewModel.estat.collectAsStateWithLifecycle()
//
//    Scaffold(
//        topBar = {
//            PaginadorPelis(
//                plana = estat.plana,
//                totalPlanes = estat.totalPlanes,
//                onAnterior = { viewModel.obtenPelisPopulars(estat.plana - 1) },
//                onSeguent = { viewModel.obtenPelisPopulars(estat.plana + 1) }
//            )
//        },
//        containerColor = MaterialTheme.colorScheme.background
//    ) { paddingValues ->
//        Box(modifier = Modifier.padding(paddingValues)) {
//            if (estat.estaCarregant) {
//                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//            } else {
//                LazyVerticalGrid(
//                    columns = GridCells.Adaptive(minSize = 160.dp),
//                    contentPadding = PaddingValues(12.dp),
//                    horizontalArrangement = Arrangement.spacedBy(12.dp),
//                    verticalArrangement = Arrangement.spacedBy(16.dp),
//                    modifier = Modifier.fillMaxSize()
//                ) {
//                    items(estat.pelis) { peli ->
//                        ElementDePelicula(peli = peli) {
//                            onClic(peli.id)
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun ElementDePelicula(peli: Pelicula, onclick: () -> Unit) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable { onclick() },
//        shape = RoundedCornerShape(12.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//    ) {
//        Box {
//            // Pòster de la pel·lícula
//            AsyncImage(
//                model = theMovieDBClient.BASE_URL_IMG + peli.posterPath,
//                contentDescription = peli.title,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(240.dp)
//            )
//
//            // Badge de puntuació (Top-right)
//            Surface(
//                color = Color.Black.copy(alpha = 0.7f),
//                modifier = Modifier
//                    .align(Alignment.TopEnd)
//                    .padding(8.dp),
//                shape = RoundedCornerShape(8.dp)
//            ) {
//                Row(
//                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(Icons.Default.Star, null, tint = Color.Yellow, modifier = Modifier.size(14.dp))
//                    Spacer(Modifier.width(4.dp))
//                    Text(
//                        text = peli.voteAverage.toString(),
//                        style = MaterialTheme.typography.labelMedium,
//                        color = Color.White
//                    )
//                }
//            }
//
//            // Títol amb degradat inferior per llegibilitat
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .align(Alignment.BottomCenter)
//                    .background(
//                        Brush.verticalGradient(
//                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.9f))
//                        )
//                    )
//                    .padding(8.dp)
//            ) {
//                Text(
//                    text = peli.title,
//                    color = Color.White,
//                    style = MaterialTheme.typography.titleSmall,
//                    fontWeight = FontWeight.Bold,
//                    maxLines = 2,
//                    overflow = TextOverflow.Ellipsis,
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier.fillMaxWidth()
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun PaginadorPelis(
//    plana: Int,
//    totalPlanes: Int,
//    onAnterior: () -> Unit,
//    onSeguent: () -> Unit
//) {
//    Surface(
//        tonalElevation = 4.dp,
//        shadowElevation = 8.dp,
//        color = MaterialTheme.colorScheme.surface
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp, vertical = 8.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            IconButton(onClick = onAnterior, enabled = plana > 1) {
//                Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, "Anterior")
//            }
//
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Text(
//                    text = "PEL·LÍCULES POPULARS",
//                    style = MaterialTheme.typography.labelLarge,
//                    color = MaterialTheme.colorScheme.primary,
//                    fontWeight = FontWeight.ExtraBold
//                )
//                Text(
//                    text = "Plana $plana de $totalPlanes",
//                    style = MaterialTheme.typography.bodySmall
//                )
//            }
//
//            IconButton(onClick = onSeguent, enabled = plana < totalPlanes) {
//                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, "Següent")
//            }
//        }
//    }
//}