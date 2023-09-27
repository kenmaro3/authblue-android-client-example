package com.example.authblueclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.authblueclient.ui.theme.AuthblueClientTheme

import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.authblueclient.Util.BarcodeScanner
import com.example.authblueclient.View.BottomBar
import com.example.authblueclient.View.ClickLinkScreen
import com.example.authblueclient.View.QRScanScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    lateinit var barcodeScanner: BarcodeScanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val context = LocalContext.current
            barcodeScanner = BarcodeScanner(context)

            AuthblueClientTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "qrscan"
                    ){

                        composable(route = "qrscan") {
                            Scaffold(
                                bottomBar = {
                                    BottomBar(
                                        navController = navController
                                    )
                                },
                            ) { contentPadding ->

                                QRScanScreen()
                            }

                        }

                        composable(route="link"){
                            Scaffold(
                                bottomBar = {
                                    BottomBar(
                                        navController = navController
                                    )
                                },
                            ) { contentPadding ->
                                ClickLinkScreen()
                            }
                        }
                    }

                }
            }
        }
    }
}

