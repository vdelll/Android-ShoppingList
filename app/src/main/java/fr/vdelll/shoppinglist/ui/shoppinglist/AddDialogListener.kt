package fr.vdelll.shoppinglist.ui.shoppinglist

import fr.vdelll.shoppinglist.data.entities.ShoppingItem

/**
 * Created by vdelll on 19/11/2020.
 */
interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}