//package cat.montilivi.tmdb.ui.pantalles
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
//import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import cat.institutmontivi.tmdb.ui.pantalles.comu.Carregant
//
//@Preview
//@Composable
//fun PantallaPelisPopularsString (viewModel: PelisPopularsStringViewModel = viewModel())
//{
//    val estat = viewModel.estat
//    Column (
//        Modifier
//            .padding(8.dp)
//            .fillMaxSize()
//    ) {
//
//
//        PaginadorString(estat, viewModel)
//        Spacer(modifier = Modifier.height(8.dp))
//        Box(
//            Modifier
//                .fillMaxSize()
//                .background(color = MaterialTheme.colorScheme.surfaceVariant)
//        )
//        {
//            if (viewModel.estat.estaCarregant) {
//                Carregant(viewModel.estat.missatge)
//            } else {
//                Text(
//                    text = viewModel.estat.stringJson,
//                    modifier = Modifier
//                        .align(Alignment.Center)
//                        .verticalScroll(rememberScrollState()),
//                    style = MaterialTheme.typography.bodySmall,
//                    color = MaterialTheme.colorScheme.onSurfaceVariant,
//                    textAlign = TextAlign.Center
//                )
//            }
//        }
//    }
//}
//
//@Composable
//private fun PaginadorString(
//    estat: PelisPopularsStringViewModel.PelisPopularsStringEstat,
//    viewModel: PelisPopularsStringViewModel
//) {
//    Row(
//        horizontalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = MaterialTheme.colorScheme.secondary),
//        verticalAlignment = Alignment.CenterVertically
//    )
//    {
//        if (estat.plana != 1) {
//            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
//                "",
//                tint = MaterialTheme.colorScheme.onSecondary,
//                modifier = Modifier
//                    .size(32.dp)
//                    .clickable {
//                        viewModel.obtenPelisPopulars(estat.plana - 1)
//                    })
//        } else {
//            Spacer(modifier = Modifier.width(32.dp))
//        }
//        Text(
//            text = "Plana ${estat.plana} de ${estat.totalPlanes}",
//            color = MaterialTheme.colorScheme.onSecondary,
//            fontSize = 24.sp
//        )
//        if (estat.plana != estat.totalPlanes) {
//            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, "",
//                tint = MaterialTheme.colorScheme.onSecondary,
//                modifier = Modifier
//                    .size(32.dp)
//                    .clickable {
//                        viewModel.obtenPelisPopulars(estat.plana + 1)
//                    })
//        } else {
//            Spacer(modifier = Modifier.width(32.dp))
//        }
//    }
//}