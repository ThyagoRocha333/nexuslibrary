package com.example.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ui.screens.admin.AdminDashboardScreen
import com.example.ui.screens.admin.AdminMarcScreen
import com.example.ui.screens.shared.LoginScreen
import com.example.ui.screens.student.BookDetailsScreen
import com.example.ui.screens.student.ReaderScreen
import com.example.ui.screens.student.SearchScreen
import com.example.ui.screens.student.StudentDashboardScreen

@Composable
fun NexusNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "login"
) {
    NavHost(navController = navController, startDestination = startDestination) {
        
        // --- Fluxo de Autenticação / Compartilhado ---
        composable("login") {
            LoginScreen(
                onNavigateToStudent = { navController.navigate("student/dashboard") },
                onNavigateToAdmin = { navController.navigate("admin/dashboard") }
            )
        }

        // --- Fluxo do Aluno (Equivalente ao src/app/... e src/app/painel-aluno) ---
        composable("student/dashboard") {
            // Equivalent to src/app/page.tsx or src/app/painel-aluno/page.tsx
            StudentDashboardScreen(
                onNavigateToSearch = { navController.navigate("student/search") },
                onNavigateToBookDetails = { bookId -> navController.navigate("student/book/$bookId") }
            )
        }
        
        composable("student/search") {
            SearchScreen(
                onNavigateToBookDetails = { bookId -> navController.navigate("student/book/$bookId") },
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable("student/book/{bookId}") { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString("bookId") ?: ""
            BookDetailsScreen(
                bookId = bookId,
                onNavigateToReader = { id -> navController.navigate("student/reader/$id") },
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable("student/reader/{bookId}") { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString("bookId") ?: ""
            ReaderScreen(
                bookId = bookId,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // --- Fluxo Administrativo (Equivalente ao src/app/admin/...) ---
        composable("admin/dashboard") {
            AdminDashboardScreen(
                onNavigateToMarc = { navController.navigate("admin/marc") }
            )
        }

        composable("admin/marc") {
            AdminMarcScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
