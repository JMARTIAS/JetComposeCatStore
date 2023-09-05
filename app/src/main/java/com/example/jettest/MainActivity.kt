package com.example.jettest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Banner()

            Dashboard()
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
fun Dashboard() {
    var filteredProducts by remember { mutableStateOf(catProducts) }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight(Float.MAX_VALUE)
            .fillMaxHeight(Float.MAX_VALUE)

    ) {
        Spacer(modifier = Modifier.height(140.dp))
        Text(
            text = "Tienda de Artículos para Gatos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            fontFamily = FontFamily.SansSerif
        )
        CatProductList(filteredProducts)
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
fun CatProductList(products: List<CatProduct>) {
    var expanded=false
    LazyColumn() {
        this.items(products) { product ->
            CatProductItem(product)
            Divider(color = Color.Gray)
        }
    }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle, lines: Int= Int.MAX_VALUE) =
    Text(text=text, color = color, style=style, maxLines = lines ?: Int.MAX_VALUE)

@Composable
fun CatProductItem(product: CatProduct) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .fillMaxWidth()
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
        Button(onClick = {

        },modifier=Modifier.padding(start=4.dp)) {
            Text(text = "Ver")
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

@Preview
@Composable
fun DefaultPreview() {
    Column {
        Banner()

        Dashboard()
    }
}