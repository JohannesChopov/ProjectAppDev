package com.example.mobilevax.model

interface VaccineRepository {
    fun load(): List<Vaccine>

    fun save(items: List<Vaccine>)
}