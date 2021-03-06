package fr.vdelll.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.vdelll.shoppinglist.data.entities.ShoppingItem

/**
 * Created by vdelll on 18/11/2020.
 */
@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems() : LiveData<List<ShoppingItem>>

}