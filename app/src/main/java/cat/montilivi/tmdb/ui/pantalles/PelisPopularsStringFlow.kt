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
//import androidx.compose.runtime.State
//import androidx.compose.runtime.collectAsState
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import androidx.lifecycle.viewmodel.compose.viewModel
//import cat.institutmontivi.tmdb.ui.pantalles.comu.Carregant
//
//
//@Preview
//@Composable
//fun PantallaPelisPopularsStringFlow (viewModel: PelisPopularsStringFlowViewModel = viewModel())
//{
//    // collectAsStateWithLifecycle() evita que el flux segueixi actiu si l'app passa a segon pla, estalviant recursos.
//    val estat = viewModel.estat.collectAsStateWithLifecycle()
//    Column (
//        Modifier
//            .padding(8.dp)
//            .fillMaxSize()
//    ) {
//
//
//        PaginadorStringFlow(estat, viewModel)
//        Spacer(modifier = Modifier.height(8.dp))
//        Box(
//            Modifier
//                .fillMaxSize()
//                .background(color = MaterialTheme.colorScheme.surfaceVariant)
//        )
//        {
//            if (estat.value.estaCarregant) {
//                Carregant(estat.value.missatge)
//            } else {
//                Text(
//                    text = estat.value.stringJson,
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
//
//@Composable
//fun PaginadorStringFlow(
//    estat: State<PelisPopularsStringFlowViewModel.PelisPopularsStringFlowEstat>,
//    viewModel: PelisPopularsStringFlowViewModel
//) {
//    Row(
//        horizontalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = MaterialTheme.colorScheme.secondary),
//        verticalAlignment = Alignment.CenterVertically
//    )
//    {
//        if (estat.value.plana != 1) {
//            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
//                "",
//                tint = MaterialTheme.colorScheme.onSecondary,
//                modifier = Modifier
//                    .size(32.dp)
//                    .clickable {
//                        viewModel.obtenPelisPopulars(estat.value.plana - 1)
//                    })
//        } else {
//            Spacer(modifier = Modifier.width(32.dp))
//        }
//        Text(
//            text = "Plana ${estat.value.plana} de ${estat.value.totalPlanes}",
//            color = MaterialTheme.colorScheme.onSecondary,
//            fontSize = 24.sp
//        )
//        if (estat.value.plana != estat.value.totalPlanes) {
//            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, "",
//                tint = MaterialTheme.colorScheme.onSecondary,
//                modifier = Modifier
//                    .size(32.dp)
//                    .clickable {
//                        viewModel.obtenPelisPopulars(estat.value.plana + 1)
//                    })
//        } else {
//            Spacer(modifier = Modifier.width(32.dp))
//        }
//    }
//}