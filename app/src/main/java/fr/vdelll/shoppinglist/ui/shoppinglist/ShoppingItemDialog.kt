package fr.vdelll.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import fr.vdelll.shoppinglist.R
import fr.vdelll.shoppinglist.data.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

/**
 * Created by vdelll on 19/11/2020.
 */
class ShoppingItemDialog(
    context: Context,
    var addDialogListener: AddDialogListener
) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tv_add.setOnClickListener {
            val name = et_name.text.toString()
            val amount = et_amount.text.toString()

            if (name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context, "Please enter all the informations", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tv_cancel.setOnClickListener {
            cancel()
        }
    }

}