package com.example.ui.screens.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminDashboardScreen(
    onNavigateToMarc: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Visão Geral (Admin)") }
            )
        }
    ) { paddingValues ->
        Column(
             modifier = Modifier
                 .fillMaxSize()
                 .padding(paddingValues)
                 .background(MaterialTheme.colorScheme.background)
        ) {
            Button(onClick = onNavigateToMarc) {
                Text("Ir para Cadastro MARC")
            }
        }
    }
}
