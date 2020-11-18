package fr.vdelll.shoppinglist.data.repositories

import androidx.lifecycle.LiveData
import fr.vdelll.shoppinglist.data.db.ShoppingDatabase
import fr.vdelll.shoppinglist.data.entities.ShoppingItem

/**
 * Created by vdelll on 18/11/2020.
 */
class ShoppingRepository(
    private val db: ShoppingDatabase
) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}