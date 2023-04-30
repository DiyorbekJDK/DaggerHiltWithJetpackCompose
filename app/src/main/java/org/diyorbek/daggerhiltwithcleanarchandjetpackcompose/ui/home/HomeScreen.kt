package org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.component.Loading
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.component.PhotoItem


@Composable
fun HomeScreen(
    uiState: HomeState,
    onClick: (Int) -> Unit
) {
    if (uiState.isLoading) {
        Loading()
    }
    println("@@@$uiState")
    LazyColumn(
        contentPadding = PaddingValues(8.dp)
    ) {
        items(
            uiState.success,
            key = { it.id }
        ) { photo ->
            PhotoItem(
                photo = photo,
                onClick = {
                    onClick(photo.id)
                }
            )
        }
    }

}