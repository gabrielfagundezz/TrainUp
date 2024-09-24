package com.example.trainup.ui.theme.Screens.Configurações

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainup.ui.theme.Screens.util.TrainUpTopBar

@Composable
fun TelaConfiguracoes(drawerState: DrawerState) {
    Scaffold(
        topBar = { TrainUpTopBar(drawerState) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "Configurações",
                    fontSize = 32.sp,
                    modifier = Modifier.padding(16.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        imageVector = Icons.Default.AccountCircle ,
                        contentDescription = "Conta",
                        modifier = Modifier.size(40.dp)
                    )
                    // Seção de Conta
                    Text(text = "Conta", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
                    ConfigItem("Email")
                }




                // Seção de Notificações
                Text(text = "Notificações", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
                SwitchItem("Notificações Ativadas")

                // Seção de Aparência
                Text(text = "Aparência", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
                SwitchItem("Tema Escuro")
            }
        }
    )
}

@Composable
fun ConfigItem(title: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(text = title, modifier = Modifier.padding(16.dp), fontSize = 18.sp)
    }
}

@Composable
fun SwitchItem(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, fontSize = 18.sp)
        Switch(checked = true, onCheckedChange = {  })
    }
}
