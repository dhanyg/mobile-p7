package com.example.profilyoga

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilyoga.data.Datasource
import com.example.profilyoga.model.Profil
import com.example.profilyoga.ui.theme.ProfilYogaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilYogaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfilApp()
                }
            }
        }
    }
}

@Composable
fun ProfilApp() {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection)
            )
    ) {
        ProfilList(
            profileList =  Datasource().loadProfilData()
        )
    }
}

@Composable
fun ProfilList(profileList: List<Profil>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(profileList) {
                profil -> ProfilCard(
                    profil = profil,
                    modifier = Modifier.padding(8.dp)
                )
        }
    }
}

@Composable
fun ProfilCard(profil: Profil ,modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(12.dp)) {
        Image(
            painter = painterResource(profil.profilImageId),
            contentDescription = "Profil picture",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
       Column (
           modifier = Modifier.padding(16.dp)
       ) {
           Text(
               text = LocalContext.current.getString(profil.namaResourceId),
               modifier = Modifier.padding(bottom = 8.dp),
               style = MaterialTheme.typography.titleLarge
           )
           Text(
               text = LocalContext.current.getString(profil.alamatResourceId),
               modifier = Modifier.padding(0.dp),
               style = MaterialTheme.typography.bodyMedium
           )
       }
    }
}

@Preview(showBackground = false)
@Composable
private fun ProfileAppPreview() {
    ProfilCard(Profil(R.drawable.profil, R.string.value_nama, R.string.value_alamat))
}