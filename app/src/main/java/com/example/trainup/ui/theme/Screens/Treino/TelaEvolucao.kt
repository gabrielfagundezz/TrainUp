package com.example.trainup.ui.theme.Screens.Treino

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trainup.R
import com.example.trainup.ui.theme.Screens.util.TelaUmBottomBar
import com.example.trainup.ui.theme.Screens.util.TrainUpTopBar

@Composable
fun TelaEvolucao(
    drawerState: DrawerState,
    navCtrlBottomNav: NavController
){

    Scaffold(
        topBar = { TrainUpTopBar(drawerState) },
        content = { padding ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "EVOLUÇÃO",
                        Modifier.padding(30.dp),
                        fontSize = 30.sp,
                        fontFamily = FontFamily(Font(R.font.poppinsregular))
                    )
                    Image(painter = painterResource(id = R.drawable.graficobarras),
                        contentDescription = "Icone Evolução",
                        modifier = Modifier.size(45.dp)
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxSize()
                )
                {
                    ImageWithRoundedCorners(R.drawable.bodybuilder)
                    ImageWithRoundedCorners(R.drawable.bodybuilder)
                }
            }
        },
        floatingActionButton = {FloatButton()},
        bottomBar = { TelaUmBottomBar(navCtrlBottomNav) }
    )
}

@Composable
fun ImageWithRoundedCorners(imageRes: Int) {
    Card(
        modifier = Modifier
            .size(180.dp) // Tamanho fixo da imagem
            .clip(RoundedCornerShape(20.dp)) // Cantos arredondados
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Foto de evolução",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun FloatButton(){
    FloatingActionButton(onClick = {  }) {
        Icon(
            imageVector = Icons.Default.Add ,
            contentDescription = "+" )

    }
}