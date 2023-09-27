package com.example.authblueclient.View

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.authblueclient.Util.BarcodeScanner
import kotlinx.coroutines.launch

@Composable
fun ClickLinkScreen(
) {
    val context = LocalContext.current
    val url = remember {
        mutableStateOf("https://authblueprod.page.link/agreement?client_name=TestClient1&client_id=vGSKhQRk0aSzVB1HJ2TlZLmk&query_id=1&uid=8b1bc946-9a12-4ef9-80b1-cac7a01d35bb\n")
    }

    Box(
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth(.70f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            onClick = {
                val urlIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(url.value)
                )
                context.startActivity(urlIntent)

            }) {
            Text(
                text = "Open Link",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayMedium,
                //color = lightestGray,
                //style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }
    }
}