package com.example.proxy_mixed.entity

data class CurrencyRateEntity(
    val status: String,
    val message: String,
    val data: Map<String,String>
)