package com.example.jettest.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettest.R


@Composable
fun DetailItem(
    text: String,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            style = TextStyle(color = Color.Black, fontSize = 42.sp, fontWeight = FontWeight.Black)
        )

        // Botón para volver a Pantalla1
        Button(
            onClick = { onBackClick() },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text("Volver a Pantalla 1")
        }
    }
}

@Composable
fun ProductDetail(product: CatProduct, route: String) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(Float.MAX_VALUE)
            .fillMaxHeight(Float.MAX_VALUE)
    ) {
        Image(
            painter = painterResource(id = R.drawable.cat_banner),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Text(
            text = product.name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            fontFamily = FontFamily.SansSerif
        )
        MyText(
            product.description,
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.body2,
            Int.MAX_VALUE)
        Text(
            product.price,
            color = Color.Black,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )
    }
}