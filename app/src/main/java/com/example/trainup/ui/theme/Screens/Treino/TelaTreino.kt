package com.example.trainup.ui.theme.Screens.Treino

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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

object TreinoRotas {
    val TELA_LISTAR_TREINO_ROTA = "listar treinos"
    val TELA_INCLUIR_TREINO_ROTA = "incluir treinos"
}

@Composable
fun TelaTreino(
    drawerState: DrawerState,
    navCtrlBottomNav: NavController
){
    var treino = mutableListOf(

        Treino(
        titulo = "Segunda-Feira",
        descricao = "descrição do treino",
        id = 1
        ),
        Treino(
            titulo = "Terça-Feira",
            descricao = "descrição do treino",
            id = 2
        ),
        Treino(
            titulo = "Quarta-Feira",
            descricao = "descrição do treino",
            id = 3
        ),
        Treino(
            titulo = "Quinta-Feira",
            descricao = "descrição do treino",
            id = 3
        ),
        Treino(
            titulo = "Sexta-Feira",
            descricao = "descrição do treino",
            id = 3
        ),

    )

    val navCtrlTreino = rememberNavController()

    Scaffold(
        topBar = { TrainUpTopBar(drawerState) },
        content = {padding ->
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
                        text = "Treinos",
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.poppinsregular)) //
                    )
                    Image(
                        painter = painterResource(id = R.drawable.academia), //
                        contentDescription = "Halter",
                        modifier = Modifier.size(45.dp).padding(start = 8.dp) //
                    )
                }
            }

            NavHost(
                navController = navCtrlTreino,
                startDestination = TreinoRotas.TELA_LISTAR_TREINO_ROTA,
                modifier = Modifier.padding(top = 45.dp)
            )
            {
                composable(TreinoRotas.TELA_LISTAR_TREINO_ROTA){
                    TelaListagemTreino(treino)
                }
                composable(TreinoRotas.TELA_INCLUIR_TREINO_ROTA){
                    Column (modifier = Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.height(200.dp))
                        Text(text = "Tela de incluir treino")
                    }

                }
            }
        },
        floatingActionButton = {FloatButton()},
        bottomBar = { TelaUmBottomBar(navCtrlBottomNav)}
    )

}

@Composable
private fun TelaListagemTreino(treino: MutableList<Treino>) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(treino) { treino ->
            Card(
                modifier = Modifier
                    .padding(16.dp) // Espaço entre os cards
                    .fillMaxWidth(), // Para que o card preencha a largura disponível
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp), // Sombra do card
                shape = RoundedCornerShape(8.dp) // Cantos arredondados
            ) {
                // Conteúdo do Card
                Column(
                    modifier = Modifier.padding(16.dp) // Espaço interno do card
                ) {
                    Text(
                        text = treino.titulo,
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.titleMedium // Estilo de texto do Material
                    )
                    // Aqui você pode adicionar mais informações sobre o treino se quiser
                    Text(
                        text = treino.descricao,
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

data class Treino(
    var titulo: String,
    var descricao: String,
    var concluido: Boolean = false,
    var id: Int? = null
)

@Composable
private fun FloatButton(){
    FloatingActionButton(onClick = {  }) {
        Icon(
            imageVector = Icons.Default.Add ,
            contentDescription = "+" )
        
    }
}

