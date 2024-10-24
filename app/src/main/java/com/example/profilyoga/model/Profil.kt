package com.example.profilyoga.model;

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Profil(
    @DrawableRes val profilImageId: Int,
    @StringRes val namaResourceId: Int,
    @StringRes val alamatResourceId: Int,
)
