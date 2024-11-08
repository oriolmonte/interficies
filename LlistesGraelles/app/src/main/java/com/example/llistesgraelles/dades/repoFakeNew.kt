package com.example.llistesgraelles.dades

import kotlin.random.Random

private val llistaA: List<Int> = (1..100).toList()
private val llistaB: List<Int> = (1..100).toList()
private val llistaC: List<String> = ('A'..'Z').toList()
    .map{
        val element = StringBuilder()
        val lletres = ('A'..'Z').toList()
        for (num in 1..(Random.nextInt(5+1)))
        {
            element.append(lletres[Random.nextInt(26)].toString())
        }
                element.toString()
    }
