package com.example.trainup.ui.theme.Screens.Treino

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.ui.res.painterResource
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
            padding
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Tela EVOLUÇÃO",
                    Modifier.padding(30.dp),
                    fontSize = 40.sp
                )
                Row {
                    Image(painter = painterResource(id = R.drawable.bodybuilder),
                        contentDescription = "Foto exemplo", modifier = Modifier.size(210.dp).clip(RoundedCornerShape(40.dp)) )
                    Image(painter = painterResource(id = R.drawable.bodybuilder),
                        contentDescription = "Foto exemplo", modifier = Modifier.size(210.dp).clip(RoundedCornerShape(40.dp)) )
                }
            }
        },
        floatingActionButton = {FloatButton()},
        bottomBar = { TelaUmBottomBar(navCtrlBottomNav) }
    )
}

@Composable
private fun FloatButton(){
    FloatingActionButton(onClick = {  }) {
        Icon(
            imageVector = Icons.Default.Add ,
            contentDescription = "+" )

    }
}