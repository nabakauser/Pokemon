package com.example.pokemon.utils

import androidx.annotation.StringRes

sealed class StringType{
    class StringResource(@StringRes val  id : Int) : StringType()
    class StringRaw(val message : String) : StringType()
}