package com.udacity.shoestore.shoedetail

import androidx.databinding.InverseMethod

object Converter {

    @Suppress("RedundantNullableReturnType")
    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(value: Double?): String? {
        return value?.toString() ?: ""
    }

    @Suppress("RedundantNullableReturnType")
    @JvmStatic
    fun stringToDouble(value: String?): Double? {
        return value?.toDouble() ?: 0.0
    }
}