package com.don.kredivoapp.ui.topup.pulsa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.don.kredivoapp.R
import com.don.kredivoapp.data.TopUpEntity
import java.text.NumberFormat
import java.util.*


/**
 * Created by gideon on 19,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
class PulsaAdapter(
    private var tvList: ArrayList<TopUpEntity>,
    private var context: Context,
    val onClickItem: OnClickItem
) :
    RecyclerView.Adapter<PulsaAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvAmount: TextView =
            itemView.findViewById(R.id.tv_amount) as TextView

        var constraintLayout: ConstraintLayout = itemView.findViewById(R.id.constraint_pulsa)
        var btnPrice: Button = itemView.findViewById(R.id.btn_price) as Button
    }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_price, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tvList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindHolder(holder, tvList[position])
    }

    private fun bindHolder(holder: ViewHolder, item: TopUpEntity) {
        holder.tvAmount.text = formatRupiah(item.amount)
        holder.btnPrice.text = formatRupiah(item.price)
        holder.constraintLayout.setOnClickListener {
            onClickItem.onClickView(item)
        }
        holder.btnPrice.setOnClickListener {
            onClickItem.onClickView(item)
        }
    }

    private fun formatRupiah(money: Double?): String {
        val local = Locale("id", "id")
        val formatter = NumberFormat
            .getCurrencyInstance(local)
        formatter.maximumFractionDigits = 0
        formatter.isParseIntegerOnly = true
        return formatter.format((money))
    }


    interface OnClickItem {
        fun onClickView(item: TopUpEntity)
    }
}