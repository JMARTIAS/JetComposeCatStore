package com.example.jettest.presentation

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.jettest.data.model.MyModel

class MyViewModel {
    class MyViewModel : ViewModel() {
        val items = mutableStateListOf<MyModel>()
            .apply {
                repeat(15) {
                    add(MyModel(title = "Title$it", description = "Description$it"))
                }
            }

        fun update(index: Int, uri: Uri) {
            val item = items[index].copy(uri = uri)
            items[index] = item
        }
    }



}