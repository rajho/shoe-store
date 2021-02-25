package com.udacity.shoestore.shoedetail

import androidx.databinding.InverseMethod

object Converter {

    @Suppress("RedundantNullableReturnType")
    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(value: Double?): String? {
        value?.let {
            if (it == 0.0)
                return ""
        }

        return value?.toString() ?: ""
    }

    @Suppress("RedundantNullableReturnType")
    @JvmStatic
    fun stringToDouble(value: String?): Double? {
        return value?.toDoubleOrNull() ?: 0.0
    }
}