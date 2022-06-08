package com.vginert.rohlik.shared.domain

data class Cart(
    val items: List<Item>
) {

    companion object {
        fun empty() = Cart(emptyList())
    }

    data class Item(
        val product: Product,
        val amount: Int,
    )

    fun addProduct(product: Product): Cart {
        val item = items.find { it.product.id == product.id }
        if (item == null) {
            val newItem = Item(product, 1)
            val newItemList = items.toMutableList()
            newItemList.add(newItem)
            return this.copy(items = newItemList)
        }

        val newItem = item.copy(amount = item.amount + 1)
        val newItemList = items.toMutableList()
        newItemList[newItemList.indexOf(item)] = newItem
        return this.copy(items = newItemList)
    }

    fun removeProduct(product: Product): Cart {
        val newItemList = items.toMutableList()
        newItemList.removeAll { it.product.id == product.id }
        return this.copy(items = newItemList)
    }

    fun clear(): Cart {
        return this.copy(items = emptyList())
    }
}
