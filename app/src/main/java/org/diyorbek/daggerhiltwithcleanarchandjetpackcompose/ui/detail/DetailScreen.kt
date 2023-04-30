package org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.component.Loading

@Composable
fun DetailScreen(
    uiState: DetailState,
    onEvent: (DetailEvent) -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        onEvent(DetailEvent.onGetProduct(0))
    }
    if (uiState.isLoading) {
        Loading()
    }
    uiState.success?.let { photo ->
        val painter = rememberCoilPainter(request = photo.src.portrait)
        Image(
            painter = painter,
            contentDescription = "adas",
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            contentScale = ContentScale.Crop
        )
    }
}