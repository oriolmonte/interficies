package com.oriol.classedos.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oriol.classedos.componibles.Comptador

@Composable
fun PantallaPrincipal()
{
    Column (
        modifier = Modifier
            .padding(32.dp)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    )
    {
        var nom by remember{ mutableStateOf("")}
        val onCanviNom: (String) -> Unit = {
            nom=it
        }
        var esHome by remember { mutableStateOf(false) }
        val onCanviSexe: (Boolean) -> Unit = {
            esHome=it
        }
        var nAmpolles by remember { mutableStateOf(0) }
        //S'ha de passar l'estat com a parametre de la funció, a dins s'ha d'alterar l'estat cada
        //Cop que vols canviar l'estat
        val onCanviAmpolles: (Int) -> Unit = {
            nAmpolles=it
        }
        TextField(
            value=nom,
            onValueChange = onCanviNom,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .fillMaxWidth()
                ,
            placeholder= {Text("Entra aqui el teu nom")},
            label = {Text("Label")}
        )
        Text(text="Hola $nom")
        Spacer(modifier=Modifier.height(16.dp))
        Row(
        )
        {
            Text(text=
            if(esHome)
                "Sexe: Home"
            else
                "Sexe: Dona"
                    , modifier = Modifier
                    .padding(end = 16.dp)
                    .align(Alignment.CenterVertically))
            Switch(
                checked = esHome,
                onCheckedChange = onCanviSexe,
                thumbContent = {
                    if(esHome)
                        Icon(
                        imageVector = Icons.Filled.Call,
                        contentDescription = "call icon"
                        )
                    else
                        Icon(
                        imageVector = Icons.Filled.Face,
                        contentDescription = "call icon"
                        )
                })
        }
        Row()
        {
            Text("Quantes ampolles", modifier = Modifier.align(Alignment.CenterVertically))
            Spacer(modifier = Modifier.width(16.dp))
            Comptador(onCanviQuant = onCanviAmpolles)
        }
        Row()
        {
            Text("Hola $nom vols $nAmpolles")
        }
    }


}
@Preview
@Composable
fun PantallaPrincipalPreview()
{
    PantallaPrincipal()
}