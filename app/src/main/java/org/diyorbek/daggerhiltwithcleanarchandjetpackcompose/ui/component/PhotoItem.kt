package org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.model.Photo

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PhotoItem(
    photo: Photo,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(220.dp),
        shape = RoundedCornerShape(15.dp),
        onClick = onClick
    ) {
        val painter = rememberCoilPainter(request = photo.src.original)
        Image(
            painter = painter,
            contentDescription = "loading_img",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

    }
}
