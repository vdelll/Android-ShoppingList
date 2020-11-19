package fr.vdelll.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.vdelll.shoppinglist.R
import fr.vdelll.shoppinglist.data.entities.ShoppingItem
import fr.vdelll.shoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.item_shopping.view.*
import kotlinx.coroutines.processNextEventInCurrentThread

/**
 * Created by vdelll on 19/11/2020.
 */
class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {


    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shopping, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.itemView.tv_name.text = curShoppingItem.name
        holder.itemView.tv_amount.text = "${curShoppingItem.amount}"

        holder.itemView.iv_delete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.itemView.iv_bigger.setOnClickListener {
            curShoppingItem.amount++
            viewModel.upsert(curShoppingItem)
        }

        holder.itemView.iv_minus.setOnClickListener {
            if(curShoppingItem.amount > 0) {
                curShoppingItem.amount--
                viewModel.upsert(curShoppingItem)
            }
        }

    }
}