package org.diyorbek.daggerhiltwithcleanarchandjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.component.CustomToolBar
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.detail.DetailEvent
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.detail.DetailScreen
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.detail.DetailViewModel
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.home.HomeScreen
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.home.HomeViewModel
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.theme.DaggerHiltWithCleanArchAndJetpackComposeTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerHiltWithCleanArchAndJetpackComposeTheme {
                val navController = rememberNavController()
                var title by remember {
                    mutableStateOf("Home")
                }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CustomToolBar(
                            title = title,
                            isBackIconVisible = title != "Home",
                            onBack = {
                                navController.popBackStack()
                                title = "Home"
                            }
                        )
                    }
                ) { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home_screen",
                        modifier = Modifier.padding(padding)
                    ) {
                        composable(route = "home_screen") {
                            val homeViewModel = hiltViewModel<HomeViewModel>()
                            val state by homeViewModel.state.collectAsState()
                            HomeScreen(
                                uiState = state,
                                onClick = {
                                    navController.navigate("detail_screen/$it")
                                    title = "Photo"
                                })
                        }
                        composable(route = "detail_screen/{id}") {
                            val detailViewModel = hiltViewModel<DetailViewModel>()
                            val detailState by detailViewModel.state.collectAsState()
                            val id = it.arguments?.getString("id") ?: "1"
                            DetailScreen(uiState = detailState,
                                onEvent = {
                                    detailViewModel.onEvent(DetailEvent.onGetProduct(id.toInt()))
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

