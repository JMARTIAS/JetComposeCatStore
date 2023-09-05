package com.example.jettest.data.model

import android.net.Uri
import androidx.compose.runtime.Immutable

@Immutable
data class MyModel(
    val title: String,
    val description: String,
    val uri: Uri? = null
)