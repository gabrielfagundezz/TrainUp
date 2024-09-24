package com.example.trainup.ui.theme.Screens.Treino

import android.content.Context
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trainup.ui.theme.Screens.Dieta.TelaDieta

object TelaUm {
    val TELA_TREINO_HOST =  "treino"
    val TELA_DIETA_HOST =  "dieta"
    val TELA_EVOLUCAO_HOST =  "evolucao"
}

@Composable
fun TreinoNavHost(drawerState: DrawerState){

    val navCtrlBottomNav = rememberNavController()
    NavHost(navController = navCtrlBottomNav,
        startDestination = TelaUm.TELA_TREINO_HOST
    ){
        composable(TelaUm.TELA_TREINO_HOST){
            TelaTreino(drawerState, navCtrlBottomNav)
        }
        composable(TelaUm.TELA_DIETA_HOST){
           TelaDieta(drawerState, navCtrlBottomNav)
        }
        composable(TelaUm.TELA_EVOLUCAO_HOST){
            TelaEvolucao(drawerState, navCtrlBottomNav)
        }
        }
    }