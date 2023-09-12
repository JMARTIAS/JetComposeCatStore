package com.example.jettest.presentation

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jettest.R

@Composable
fun Dashboard(
    navegarDetailItem: (String) -> Unit
) {
    var textValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Dashboard",
            style = TextStyle(color = Color.DarkGray, fontSize = 42.sp, fontWeight = FontWeight.W500)
        )

        TextField(
            value = textValue,
            onValueChange = { textValue = it },
            label = { Text("Introducir Texto") }
        )

        Button(onClick = { navegarDetailItem(textValue) }) {
            Text("Enviar")
        }
    }
}

// Modelo de datos para los artículos
data class CatProduct(val id: Int, val name: String,  val price: String, val imageUrl: String,val description:String)

// Datos de ejemplo
val catProducts = listOf(
    CatProduct(
        1,
        "Juguete para gatos",
        "$10",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRq91idNTwb7S1dh4Hf0IVNUyp7-LR3Ka__Kg&usqp=CAU",
        "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500"
    ),
    CatProduct(
        2,
        "Rascador de sisal",
        "$25",
        "https://ae01.alicdn.com/kf/Sf0699f0488c04e71b623283ed2addda9x/Rascador-de-Sisal-para-gatos-alfombrilla-cl-sica-para-interiores.jpg_.webp",
        "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500"
    ),
    CatProduct(
        3,
        "Arena sisal",
        "$15",
        "https://ae01.alicdn.com/kf/Sf0699f0488c04e71b623283ed2addda9x/Rascador-de-Sisal-para-gatos-alfombrilla-cl-sica-para-interiores.jpg_.webp",
        "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500"
    ),
    CatProduct(
        4,
        "Caña de pescar",
        "$10",
        "https://ae01.alicdn.com/kf/Sf0699f0488c04e71b623283ed2addda9x/Rascador-de-Sisal-para-gatos-alfombrilla-cl-sica-para-interiores.jpg_.webp",
        "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500"
    ),
    CatProduct(
        5,
        "Collar sisal",
        "$10",
        "https://ae01.alicdn.com/kf/Sf0699f0488c04e71b623283ed2addda9x/Rascador-de-Sisal-para-gatos-alfombrilla-cl-sica-para-interiores.jpg_.webp",
        "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500"
    ),
    CatProduct(
        6,
        "Churu sisal",
        "$3",
        "https://ae01.alicdn.com/kf/Sf0699f0488c04e71b623283ed2addda9x/Rascador-de-Sisal-para-gatos-alfombrilla-cl-sica-para-interiores.jpg_.webp",
        "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500"
    ),
    CatProduct(
        7,
        "Llavero",
        "$3",
        "https://ae01.alicdn.com/kf/Sf0699f0488c04e71b623283ed2addda9x/Rascador-de-Sisal-para-gatos-alfombrilla-cl-sica-para-interiores.jpg_.webp",
        "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500"
    ),
    CatProduct(
        8,
        "Tijera para uñas",
        "$5",
        "https://ae01.alicdn.com/kf/Sf0699f0488c04e71b623283ed2addda9x/Rascador-de-Sisal-para-gatos-alfombrilla-cl-sica-para-interiores.jpg_.webp",
        "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500"
    )
)

@Composable
fun Dashboard(navController: NavController,navegarDetailItem: (String) -> Unit) {
    Spacer(modifier = Modifier.height(20.dp))
    var filteredProducts by remember { mutableStateOf(catProducts) }
    Column(
        modifier = Modifier.padding(16.dp).fillMaxHeight(Float.MAX_VALUE).fillMaxHeight(Float.MAX_VALUE)
    ) {
        Text(
            text = "Tienda de Artículos para Gatos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            fontFamily = FontFamily.SansSerif
        )
        Spacer(modifier = Modifier.height(356.dp))
        CatProductList(filteredProducts, navController,navegarDetailItem)
    }
}

@Composable
fun MyComposableContent(item: Any, modifier: Modifier) {
    TODO("Not yet implemented")
}

fun BasicTextField(
    value: String,
    onValueChange: () -> Unit,
    textStyle: TextStyle,
    placeholder: () -> Unit,
    modifier: Modifier
) {}

@Composable
fun CatProductList(products: List<CatProduct>,navController: NavController,navegarDetailItem: (String) -> Unit) {
    var expanded=false
    var arguments = Bundle()
    LazyColumn() {
        this.items(products) { product ->
            CatProductItem(product,navController, arguments,navegarDetailItem)
            Divider(color = Color.Gray)
        }
    }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle, lines: Int= Int.MAX_VALUE) =
    Text(text=text, color = color, style=style, maxLines = lines ?: Int.MAX_VALUE)

@Composable
fun CatProductItem(product: CatProduct, navController: NavController, arguments: Bundle,navegarDetailItem: (String) -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }
    val productDetailRoute = "product-detail"
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .fillMaxHeight()
    ) {
        // Carga de la imagen: Image(product.imageUrl, ...)
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp)
                .clickable {
                    expanded = !expanded
                }
        ) {
            Text(
                text = product.name,
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
            MyText(
                product.description,
                MaterialTheme.colors.onBackground,
                MaterialTheme.typography.body2,
                if (expanded)Int.MAX_VALUE else 1)
            Text(
                product.price,
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        }
        Button(onClick = { navegarDetailItem }) {
            Text("Enviar")
        }
    }
}


@Composable
fun Banner() {
    Image(
        painter = painterResource(id = R.drawable.cat_banner),
        contentDescription = "",
        modifier = Modifier
            .background(Color.White)
    )
}