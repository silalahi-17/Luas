package com.example.luas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.luas.ui.theme.LuasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuasTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    MainContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    // State untuk menyimpan input dan hasil
    var length by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var result by remember { mutableStateOf(0.0) }

    // Layout
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Hitung Luas Segitiga", style = MaterialTheme.typography.titleLarge)

        // Input panjang alas
        OutlinedTextField(
            value = length,
            onValueChange = { length = it },
            label = { Text("Masukkan panjang alas") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input lebar alas
        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Masukkan tinggi") },
            modifier = Modifier.fillMaxWidth()
        )

        // Tombol hitung luas
        Button(
            onClick = {
                val lengthValue = length.toDoubleOrNull() ?: 0.0
                val heightValue = height.toDoubleOrNull() ?: 0.0
                result = (lengthValue * heightValue) / 2
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Hitung")
        }

        // Menampilkan hasil
        Text(
            text = "Hasil: $result",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    LuasTheme {
        MainContent()
    }
}
