package com.don.kredivoapp.ui.topup.datapackage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.don.kredivoapp.data.TopUpEntity
import java.text.NumberFormat
import java.util.*

/**
 * Created by gideon on 13,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
class DataPackageAdapter(
    private var tvList: ArrayList<TopUpEntity>,
    private var context: Context,
    val onClickItem: OnClickItem
) :
    RecyclerView.Adapter<DataPackageAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvAmount: TextView =
            itemView.findViewById(com.don.kredivoapp.R.id.tv_amount) as TextView
        var tvLabel: TextView =
            itemView.findViewById(com.don.kredivoapp.R.id.tv_label_nominal) as TextView
        var btnPrice: Button = itemView.findViewById(com.don.kredivoapp.R.id.btn_price) as Button
    }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(com.don.kredivoapp.R.layout.item_list_price, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tvList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindHolder(holder, tvList[position])
    }

    private fun bindHolder(holder: ViewHolder, item: TopUpEntity) {
        holder.tvLabel.visibility = View.GONE
        holder.tvAmount.text = item.type
        holder.btnPrice.text = formatRupiah(item.price)
        holder.itemView.setOnClickListener {
            onClickItem.onClickView(item)
        }
    }

    fun formatRupiah(money: Double?): String {
        val local = Locale("id", "id")
        val formatter = NumberFormat
            .getCurrencyInstance(local)
        formatter.maximumFractionDigits = 0
        formatter.isParseIntegerOnly = true
        val formatted = formatter.format((money))
        return formatted
    }


    interface OnClickItem {
        fun onClickView(item: TopUpEntity)
    }
}