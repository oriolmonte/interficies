package com.oriol.classedos.componibles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Calculadora()
{
    var currentNumber by remember { mutableStateOf("") }
    var isDecimal by remember { mutableStateOf(false) }
    var isPrimer by remember { mutableStateOf(true) }
    var previousOperacio by remember { mutableStateOf("")}
    var operacio by remember { mutableStateOf(false) }
    var primerEstat by remember { mutableStateOf(false) }
    var primerOperand  by remember { mutableStateOf(0.0) }
    var segonOperand  by remember { mutableStateOf(0.0) }
    var numberSaved by remember{ mutableStateOf((0.0)) }
    val onOperacio: (Char) -> Unit =
        {
            operacio = true
            isDecimal = false
            previousOperacio += currentNumber + it
            if (isPrimer) {
                primerOperand = currentNumber.toDouble()
                currentNumber = ""
                isPrimer = false
            }
            else {
                when (it) {
                    '+' -> {
                        segonOperand = currentNumber.toDouble()
                        currentNumber = (primerOperand + segonOperand).toString()
                        primerEstat=true
                    }
                    '-' -> {
                        segonOperand = currentNumber.toDouble()
                        currentNumber = (primerOperand - currentNumber.toDouble()).toString()
                        primerEstat=true
                    }
                    '*' -> {
                        segonOperand = currentNumber.toDouble()
                        currentNumber = (primerOperand * currentNumber.toDouble()).toString()
                        primerEstat=true

                    }
                    '/' -> {
                        segonOperand = currentNumber.toDouble()
                        currentNumber = (primerOperand / currentNumber.toDouble()).toString()
                        primerEstat=true

                    }
                }
            }
        }
    val onNumberClick: (Int) -> Unit =
    {
        if(primerEstat)
        {
            primerEstat=false
            primerOperand=currentNumber.toDouble()
            currentNumber=""
            currentNumber+=it
        }
        else
            currentNumber+=it
    }
    val onIgual: (Char) -> Unit =
        {
            isDecimal = false
            if (it == '+')
            {
                segonOperand = currentNumber.toDouble()
                previousOperacio += currentNumber
                currentNumber = (primerOperand + segonOperand).toString()
                primerEstat=true
            }
            else if (it == '-') {
                segonOperand = currentNumber.toDouble()
                previousOperacio += currentNumber
                currentNumber = (primerOperand - segonOperand).toString()
                primerEstat=true
            }
            else if (it == '*') {
                segonOperand = currentNumber.toDouble()
                previousOperacio += currentNumber
                currentNumber = (primerOperand * segonOperand).toString()
                primerEstat=true
                }
            else if (it == '/') {
            segonOperand = currentNumber.toDouble()
            previousOperacio += currentNumber
            currentNumber = (primerOperand / segonOperand).toString()
            primerEstat=true
            }
            operacio = false
        }
    var isSegonaPart by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .padding(10.dp, top = 10.dp,bottom = 40.dp))
    {
        Row(modifier = Modifier
            .weight(10f)
            .padding(10.dp))
        {
            Column (modifier = Modifier.background(color = MaterialTheme.colorScheme.primaryContainer))
            {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(25f))
                {
                    Text(previousOperacio)
                }
                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(75f))
                {
                    Text(currentNumber, fontSize = 42.sp)
                }
            }
        }

        Row(modifier = Modifier.weight(80f))
        {

            Column(
                modifier = Modifier
                    .weight(70f)
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(25f)
                        .padding(10.dp)
                )
                {
                    Button(onClick = {
                        currentNumber=""
                        isDecimal=false
                        isSegonaPart=false
                        isPrimer=true
                        primerOperand=0.0
                        operacio=false
                        previousOperacio=""
                        primerEstat=false
                    }, modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                        .weight(33.3f)
                    )
                    {
                        Text("C", fontSize = 50f.sp, textAlign = TextAlign.Center)
                    }
                    Button(onClick = {
                        numberSaved = currentNumber.toDouble()
                        currentNumber=""
                        isDecimal=false
                        isSegonaPart=false
                        isPrimer=true
                        primerOperand=0.0
                        operacio=false
                        previousOperacio=""
                        primerEstat=false
                    },
                        modifier = Modifier
                            .weight(33.3f)
                            .fillMaxSize()
                            .padding(10.dp)) {
                        Text("M", fontSize = 50f.sp, textAlign = TextAlign.Center)

                    }
                    Button(onClick = {
                        currentNumber=numberSaved.toString()
                    },
                         modifier = Modifier
                            .weight(33.3f)
                            .fillMaxSize()
                            .padding(10.dp)) {
                        Text("RM", fontSize = 25f.sp, textAlign = TextAlign.Center)
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(25f)
                        .padding(10.dp)
                )
                {
                    Button(onClick = {
                        onNumberClick(7)
                    }, modifier = Modifier
                        .weight(33.3f)
                        .fillMaxSize()
                        .padding(10.dp))
                    {
                        Text("7", fontSize = 50f.sp, textAlign = TextAlign.Center)
                    }
                    Button(onClick = {
                        onNumberClick(8)
                    }, modifier = Modifier
                        .weight(33.3f)
                        .fillMaxSize()
                        .padding(10.dp))
                    {
                        Text("8", fontSize = 50f.sp, textAlign = TextAlign.Center)
                    }

                    Button(onClick = {
                        onNumberClick(9)
                    }, modifier = Modifier
                        .weight(33.3f)
                        .fillMaxSize()
                        .padding(10.dp))
                    {
                        Text("9", fontSize = 50f.sp, textAlign = TextAlign.Center)
                    }

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(25f)
                        .padding(10.dp)
                )
                {
                    Button(onClick = {
                        onNumberClick(4)
                    }, modifier = Modifier
                        .weight(33.3f)
                        .fillMaxSize()
                        .padding(10.dp))
                    {
                        Text("4", fontSize = 50f.sp, textAlign = TextAlign.Center)
                    }

                    Button(onClick = {
                        onNumberClick(5)

                    }, modifier = Modifier
                        .weight(33.3f)
                        .fillMaxSize()
                        .padding(10.dp))
                    {
                        Text("5", fontSize = 50f.sp, textAlign = TextAlign.Center)
                    }
                    Button(onClick = {
                        onNumberClick(6)
                    }, modifier = Modifier
                        .weight(33.3f)
                        .fillMaxSize()
                        .padding(10.dp))
                    {
                        Text("6", fontSize = 50f.sp, textAlign = TextAlign.Center)
                    }

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(25f)
                        .padding(10.dp)
                )
                {
                    Button(onClick = {
                        onNumberClick(1)

                    }, modifier = Modifier
                        .weight(33.3f)
                        .fillMaxSize()
                        .padding(10.dp))
                    {
                        Text("1", fontSize = 50f.sp, textAlign = TextAlign.Center)
                    }

                    Button(onClick = {
                        onNumberClick(2)
                    }, modifier = Modifier
                        .weight(33.3f)
                        .fillMaxSize()
                        .padding(10.dp))

                    {
                        Text("2", fontSize = 50f.sp, textAlign = TextAlign.Center)
                    }
                    Button(onClick = {
                        onNumberClick(3)
                    }, modifier = Modifier
                        .weight(33.3f)
                        .fillMaxSize()
                        .padding(10.dp))

                    {
                        Text("3", fontSize = 50f.sp, textAlign = TextAlign.Center)
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(25f)
                        .padding(10.dp)
                )
                {
                    Button(onClick = {
                        currentNumber+=0
                    }, modifier = Modifier
                        .weight(80f)
                        .fillMaxSize()
                        .padding(10.dp))
                    {
                        Text("0", fontSize = 50f.sp, textAlign = TextAlign.Center)
                    }
                    Button(onClick = {
                        if(currentNumber=="")
                            onNumberClick(0)
                        if(!isDecimal)
                            if(!currentNumber.contains('.'))
                                currentNumber+="."
                            else
                                currentNumber=currentNumber.substring(0,currentNumber.length-2)
                                isDecimal=true
                    }, modifier = Modifier
                        .weight(30f)
                        .fillMaxSize()
                        .padding(10.dp))
                    {
                        Text(".", fontSize = 50f.sp, textAlign = TextAlign.Center)
                    }
                }
            }
            Column(
                modifier = Modifier.weight(20f)
            )
            {
                Button(onClick = {
                    onOperacio('+')
                }, modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth())
                {
                    Text("+", fontSize = 50f.sp, textAlign = TextAlign.Center)
                }
                Button(onClick = {
                    onOperacio('-')
                }, modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth())
                {
                    Text("-", fontSize = 50f.sp, textAlign = TextAlign.Center)
                }
                Button(onClick = {
                    onOperacio('*')
                }, modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth())
                {
                    Text("*", fontSize = 50f.sp, textAlign = TextAlign.Center)
                }
                Button(onClick = {
                    onOperacio('/')
                }, modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth())
                {
                    Text("/", fontSize = 50f.sp, textAlign = TextAlign.Center)
                }
                Button(onClick = {
                    onIgual(previousOperacio[(previousOperacio.length)-1])
                }, modifier = Modifier
                    .weight(33.3f)
                    .padding(10.dp)
                    .fillMaxWidth())
                {
                    Text("=", fontSize = 50f.sp, textAlign = TextAlign.Center)
                }
            }
        }
    }
}
