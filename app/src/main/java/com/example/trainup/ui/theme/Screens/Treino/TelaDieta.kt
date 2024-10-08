package com.example.trainup.ui.theme.Screens.Dieta

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trainup.R
import com.example.trainup.ui.theme.Screens.util.TelaUmBottomBar
import com.example.trainup.ui.theme.Screens.util.TrainUpTopBar

object DietaRotas {
    val TELA_LISTAR_DIETA_ROTA = "listar dietas"
    val TELA_INCLUIR_DIETA_ROTA = "incluir dietas"
}

@Composable
fun TelaDieta(
    drawerState: DrawerState,
    navCtrlBottomNav: NavController
) {
    val dieta = mutableListOf(
        Dieta(
            titulo = "Café da Manhã",
            descricao = "Descrição da dieta Café da Manhã",
            id = 1
        ),
        Dieta(
            titulo = "Almoço",
            descricao = "Descrição da dieta Almoço",
            id = 2
        ),
        Dieta(
            titulo = "Café da Tarde",
            descricao = "Descrição da dieta para Café da Tarde",
            id = 3
        ),
        Dieta(
            titulo = "Janta",
            descricao = "Descrição da dieta para Janta",
            id = 3
        )
    )

    val navCtrlDieta = rememberNavController()

    Scaffold(
        topBar = { TrainUpTopBar(drawerState) },
        content = { padding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Dieta",
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.poppinsregular)) //
                    )
                    Image(
                        painter = painterResource(id = R.drawable.dieta), //
                        contentDescription = "Halter",
                        modifier = Modifier.size(45.dp).padding(start = 8.dp) //
                    )
                }
            }
            NavHost(
                navController = navCtrlDieta,
                startDestination = DietaRotas.TELA_LISTAR_DIETA_ROTA,
                modifier = Modifier.padding(top = 15.dp)
            ) {
                composable(DietaRotas.TELA_LISTAR_DIETA_ROTA) {
                    TelaListagemDieta(dieta, padding)
                }
                composable(DietaRotas.TELA_INCLUIR_DIETA_ROTA) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {
                        Spacer(modifier = Modifier.height(200.dp))
                        Text(text = "Tela de incluir dieta")
                    }
                }
            }
        },
        floatingActionButton = { FloatButton() },
        bottomBar = { TelaUmBottomBar(navCtrlBottomNav) }
    )
}

@Composable
private fun TelaListagemDieta(dieta: MutableList<Dieta>, modifier: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(dieta) { dietaItem ->
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                // Conteúdo do Card
                Column(
                    modifier = Modifier.padding(16.dp) // Espaço interno do card
                ) {
                    Text(
                        text = dietaItem.titulo,
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.titleMedium // Estilo de texto do Material
                    )
                    Text(
                        text = dietaItem.descricao,
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

data class Dieta(
    var titulo: String,
    var descricao: String,
    var concluido: Boolean = false,
    var id: Int? = null
)

@Composable
private fun FloatButton() {
    FloatingActionButton(onClick = { }) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "+"
        )
    }
}
