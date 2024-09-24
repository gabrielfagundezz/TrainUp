package com.example.trainup.ui.theme.Screens.util
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainup.R
import com.example.trainup.ui.theme.CorDoTitulo
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainUpTopBar(drawerState: DrawerState){
    val coroutineScope = rememberCoroutineScope()
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {
                    coroutineScope.launch {
                        drawerState.open()
                    }
                }) {
                Icon(
                    painterResource(id = R.drawable.menus),
                    contentDescription = "=",
                    tint = White,
                    modifier = Modifier.size(40.dp))
            }
        },
        title = {
            Text(text = "TrainUp", fontSize = 40.sp,
                color = White,
                fontWeight = FontWeight(600)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(CorDoTitulo)
    )
}
