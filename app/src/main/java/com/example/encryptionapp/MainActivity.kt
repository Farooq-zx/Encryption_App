package com.example.encryptionapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.encryptionapp.navigations.Nav
import com.example.encryptionapp.navigations.Screens
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            var selectedBarButton by remember {
                mutableStateOf(Screens.EncryptionScreen.route)
            }

            // For Navigation Drawer
            val coroutineScope = rememberCoroutineScope()
            val drawerState = rememberDrawerState(DrawerValue.Closed)

            ModalNavigationDrawer(
                drawerState = drawerState,
                gesturesEnabled = drawerState.isOpen,
                drawerContent = {
                    ModalDrawerSheet(
                        modifier = Modifier.width(300.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(150.dp)
                                .background(MaterialTheme.colorScheme.secondaryContainer)
                        )
                        NavigationDrawerItem(
                            label = { Text(text = "Encryption Method") },
                            icon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
                            selected = false,
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.close()
                                }
                                selectedBarButton = Screens.EncryptionScreen.route
                                navController.navigate(Screens.EncryptionScreen.route) {
                                    popUpTo(0)
                                }
                            }
                        )
                        NavigationDrawerItem(
                            label = { Text(text = "Decryption Method") },
                            icon = { Icon(imageVector = Icons.Default.Build, contentDescription = null) },
                            selected = false,
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.close()
                                }
                                selectedBarButton = Screens.DecryptionScreen.route
                                navController.navigate(Screens.DecryptionScreen.route) {
                                    popUpTo(0)
                                }
                            }
                        )
                        NavigationDrawerItem(
                            label = { Text(text = "About") },
                            icon = { Icon(imageVector = Icons.Default.Info, contentDescription = null) },
                            selected = false,
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.close()
                                }
                                selectedBarButton = Screens.AboutScreen.route
                                navController.navigate(Screens.AboutScreen.route) {
                                    popUpTo(0)
                                }
                            }
                        )
                    }

                }
            ) {


                Scaffold(
                    containerColor = Color.White,
                    topBar = {

                        TopAppBar(
                            title = { Text(text = if (selectedBarButton == Screens.EncryptionScreen.route) "Encryption Method" else if  (selectedBarButton == Screens.DecryptionScreen.route) "Decryption Method" else "About" )},
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            navigationIcon = {
                                IconButton(onClick = {
                                    coroutineScope.launch {
                                        drawerState.open()
                                    }
                                }) {

                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = null
                                    )
                                }
                            }
                        )
                    },
                    bottomBar = {
                        BottomAppBar() {
                            NavigationBarItem(
                                selected = selectedBarButton == Screens.EncryptionScreen.route,
                                onClick = {
                                    selectedBarButton = Screens.EncryptionScreen.route
                                    navController.navigate(Screens.EncryptionScreen.route) {
                                        popUpTo(0)
                                    }
                                },
                                label = { Text(text = "Encrypt") },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Lock,
                                        contentDescription = null
                                    )
                                }
                            )
                            NavigationBarItem(
                                selected = selectedBarButton == Screens.DecryptionScreen.route,
                                onClick = {
                                    selectedBarButton = Screens.DecryptionScreen.route
                                    navController.navigate(Screens.DecryptionScreen.route) {
                                        popUpTo(0)
                                    }
                                },
                                label = { Text(text = "Decrypt") },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Build,
                                        contentDescription = null
                                    )
                                }
                            )
                        }
                    }
                ) {

                    Nav(navController)

                }
            }


        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}