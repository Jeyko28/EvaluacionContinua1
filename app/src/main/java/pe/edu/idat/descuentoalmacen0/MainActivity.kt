package pe.edu.idat.descuentoalmacen0

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.idat.descuentoalmacen0.ui.theme.DescuentoAlmacen0Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DescuentoAlmacen0Theme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    CalculadoraDescuento() }
                }
            }
        }
    }

@Composable
fun CalculadoraDescuento(){
    var cantidad by remember {
        mutableStateOf("")
    }
    var precio by remember {
        mutableStateOf("")
    }
    var resultado by remember {
        mutableStateOf("")
    }

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center){
        TextField(value = cantidad,
            onValueChange = {cantidad = it},
            label = { Text(text = "Cantidad")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = precio,
            onValueChange = {precio = it},
            label = { Text(text = "Precio")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val cantidadDouble = cantidad.toDoubleOrNull() ?: 0.0
                val precioDouble = precio.toDoubleOrNull()?:0.0
                val total = cantidadDouble * precioDouble

            resultado = if (total > 200){
                val totalConDescuento = total * 0.8
                "Total a pagar: S/.${"%.2f".format(totalConDescuento)}"
            }else{"Total a pagar: S/.${"%.2f".format(total)}"}
        }, modifier = Modifier.fillMaxWidth()){ Text(text = "Calcular")}

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = resultado,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun CalculadoraDescuentoPreview() {
    DescuentoAlmacen0Theme {
        CalculadoraDescuento()
    }
}