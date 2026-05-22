package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme =
  darkColorScheme(
    primary = nlPrimary,
    onPrimary = nlOnPrimary,
    primaryContainer = nlPrimaryContainer,
    onPrimaryContainer = nlOnPrimaryContainer,
    secondary = nlSecondary,
    onSecondary = nlOnSecondary,
    secondaryContainer = nlSecondaryContainer,
    onSecondaryContainer = nlOnSecondaryContainer,
    tertiary = nlTertiary,
    onTertiary = nlOnTertiary,
    tertiaryContainer = nlTertiaryContainer,
    onTertiaryContainer = nlOnTertiaryContainer,
    error = nlError,
    onError = nlOnError,
    errorContainer = nlErrorContainer,
    onErrorContainer = nlOnErrorContainer,
    background = nlBackground,
    onBackground = nlOnBackground,
    surface = nlSurface,
    onSurface = nlOnSurface,
    surfaceVariant = nlSurfaceVariant,
    onSurfaceVariant = nlOnSurfaceVariant,
    outline = nlOutline,
    outlineVariant = nlOutlineVariant,
  )

private val LightColorScheme =
  lightColorScheme(
    primary = nlPrimary,
    onPrimary = nlOnPrimary,
    primaryContainer = nlPrimaryContainer,
    onPrimaryContainer = nlOnPrimaryContainer,
    secondary = nlSecondary,
    onSecondary = nlOnSecondary,
    secondaryContainer = nlSecondaryContainer,
    onSecondaryContainer = nlOnSecondaryContainer,
    tertiary = nlTertiary,
    onTertiary = nlOnTertiary,
    tertiaryContainer = nlTertiaryContainer,
    onTertiaryContainer = nlOnTertiaryContainer,
    error = nlError,
    onError = nlOnError,
    errorContainer = nlErrorContainer,
    onErrorContainer = nlOnErrorContainer,
    background = nlBackground,
    onBackground = nlOnBackground,
    surface = nlSurface,
    onSurface = nlOnSurface,
    surfaceVariant = nlSurfaceVariant,
    onSurfaceVariant = nlOnSurfaceVariant,
    outline = nlOutline,
    outlineVariant = nlOutlineVariant,
  )

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Dynamic color is available on Android 12+
  dynamicColor: Boolean = false, // Forced to false to maintain the specific brand identity

  content: @Composable () -> Unit,
) {
  val colorScheme =
    when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }

      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
