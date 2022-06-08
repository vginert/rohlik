package com.vginert.rohlik.shared.domain

class Cart {

    private val _items: HashMap<Product, Int> = hashMapOf()
    val items: List<Item>
        get() = _items.map { Item(it.key, it.value) }

    data class Item(
        val product: Product,
        val amount: Int,
    )

    fun addProduct(product: Product) {
        _items[product] = _items[product]?.plus(1) ?: 1
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cart

        if (items != other.items) return false

        return true
    }

    override fun hashCode(): Int {
        return items.hashCode()
    }
}
