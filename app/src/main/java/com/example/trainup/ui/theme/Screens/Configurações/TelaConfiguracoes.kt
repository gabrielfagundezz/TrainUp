package com.example.trainup.ui.theme.Screens.Configurações

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainup.ui.theme.Screens.util.TrainUpTopBar

@Composable
fun TelaConfiguracoes(drawerState: DrawerState){

    Scaffold(
        topBar = {
            TrainUpTopBar(drawerState)
        },
        content = { padding ->
            padding
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Tela de Configurações",
                    Modifier.padding(30.dp),
                    fontSize = 40.sp
                )
            }

        }
    )

}