package org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp


@Composable
fun CustomToolBar(
    title: String,
    isBackIconVisible: Boolean,
    onBack: () -> Unit
) {
    Surface(
        color = Color.Green,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedVisibility(visible = isBackIconVisible) {
                IconButton(onClick = onBack) {
                    Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "dada")
                }
            }
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}