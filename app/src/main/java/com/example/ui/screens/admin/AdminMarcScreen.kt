package com.example.ui.screens.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminMarcScreen(
    onNavigateBack: () -> Unit
) {
    Scaffold(
         topBar = {
              TopAppBar(
                  title = { Text("Cadastro MARC") },
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
              Text(text = "Formulário MARC 21...")
         }
    }
}
