package com.example.first_50_primenumbers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrimeScreen()
        }
    }
}

@Composable
fun PrimeScreen() {
    val primes = remember { mutableStateOf<List<Int>>(emptyList()) }

    LaunchedEffect(Unit) {
        primes.value = findFirst50Primes()
    }

    if (primes.value.isNotEmpty()) {
        Text(text = "First 50 prime numbers: ${primes.value}")
    }
}

private fun findFirst50Primes(): List<Int> {
    val primes = mutableListOf<Int>()
    var number = 2
    while (primes.size < 50) {
        if (isPrime(number)) {
            primes.add(number)
        }
        number++
    }
    return primes
}

private fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return false
    }
    return true
}
