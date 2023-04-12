package com.example.composerdemo1.domain.models.order

data class Order(
    val name: String,
    val phone: String,
    val address: String,
    val cardInformation: CardInformation,
    val summary: SummaryTotals,
)