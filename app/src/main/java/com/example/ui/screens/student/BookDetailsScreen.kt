package com.example.ui.screens.student

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailsScreen(
    bookId: String,
    onNavigateToReader: (String) -> Unit,
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("NexusLibrary") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
             modifier = Modifier
                 .fillMaxSize()
                 .padding(paddingValues)
                 .background(MaterialTheme.colorScheme.background)
        ) {
             Text(text = "Details for Book ID: $bookId", style = MaterialTheme.typography.titleLarge)
             Button(onClick = { onNavigateToReader(bookId) }) {
                 Text("Ler E-book")
             }
        }
    }
}
