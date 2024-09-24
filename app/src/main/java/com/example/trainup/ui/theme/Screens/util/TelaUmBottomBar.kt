package com.example.trainup.ui.theme.Screens.util

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.trainup.R
import com.example.trainup.ui.theme.Screens.Treino.TelaUm

@Composable
fun TelaUmBottomBar(navController: NavController){

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar(containerColor = Color(0xFF1B1B1B)) {
        NavigationBarItem(
            selected = currentRoute == TelaUm.TELA_TREINO_HOST ,
            onClick = {
                navController.navigate(TelaUm.TELA_TREINO_HOST)
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.academia) ,
                    contentDescription = "A",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text(text = "Treino", color = Color.White) }
        )
        NavigationBarItem(
            selected = currentRoute == TelaUm.TELA_DIETA_HOST ,
            onClick = {
                navController.navigate(TelaUm.TELA_DIETA_HOST)
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.dieta) ,
                    contentDescription = "A",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text(text = "Dieta", color = Color.White) }
        )
        NavigationBarItem(
            selected = currentRoute == TelaUm.TELA_EVOLUCAO_HOST ,
            onClick = {
                navController.navigate(TelaUm.TELA_EVOLUCAO_HOST)
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.graficobarras),
                    contentDescription = "A",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text(text = "Evolução", color = Color.White) }
        )
    }
}