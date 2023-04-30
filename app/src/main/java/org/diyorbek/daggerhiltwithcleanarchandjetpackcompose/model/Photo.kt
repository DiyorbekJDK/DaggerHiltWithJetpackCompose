package org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Photo(
    val alt: String,
    val avg_color: String,
    val height: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val liked: Boolean,
    val photographer: String,
    val photographer_id: Int,
    val photographer_url: String,
    @Embedded
    val src: Src,
    val url: String,
    val width: Int
): Parcelable