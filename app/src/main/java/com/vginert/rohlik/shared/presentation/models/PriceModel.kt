package com.vginert.rohlik.shared.presentation.models

import android.icu.text.NumberFormat
import android.os.Build
import com.vginert.rohlik.shared.domain.models.Price
import java.text.DecimalFormat
import java.util.*

private const val MAX_FRACTION_DIGITS = 2
private const val MIN_FRACTION_DIGITS = 0

data class PriceModel(
    val amount: Double,
    val currency: Currency,
) {
    override fun toString(): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            NumberFormat.getCurrencyInstance(Locale.getDefault()).apply {
                currency = this.currency
                maximumFractionDigits = MAX_FRACTION_DIGITS
                minimumFractionDigits = MIN_FRACTION_DIGITS
            }.format(amount)
        } else {
            val formatter = DecimalFormat().apply {
                maximumFractionDigits = MAX_FRACTION_DIGITS
                minimumFractionDigits = MIN_FRACTION_DIGITS
            }
            "${formatter.format(amount)} ${currency.symbol}"
        }
    }
}

fun Price.asPresentation() = PriceModel(
    amount = amount,
    currency = currency
)
