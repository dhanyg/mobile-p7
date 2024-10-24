package com.example.profilyoga.data

import com.example.profilyoga.R
import com.example.profilyoga.model.Profil

class Datasource {
    fun loadProfilData(): List <Profil> {
        return listOf<Profil>(
            Profil(
                R.drawable.profil,
                R.string.value_nama,
                R.string.value_alamat
            )
        )
    }
}