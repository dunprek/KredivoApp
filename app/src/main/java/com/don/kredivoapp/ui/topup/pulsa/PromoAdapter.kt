package com.don.kredivoapp.ui.topup.pulsa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.don.kredivoapp.R
import com.don.kredivoapp.data.PromoEntity
import com.don.kredivoapp.utils.GlideUtils


/**
 *  Created by gideon on 19,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
class PromoAdapter(
    private var tvList: ArrayList<PromoEntity>,
    private var context: Context,
    val onClickItem: OnClickItem
) :
    RecyclerView.Adapter<PromoAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView = itemView.findViewById(R.id.iv) as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_list_promo, parent, false)
        val layoutParams = itemView.layoutParams
        layoutParams.width = (parent.width * 0.8).toInt()
        itemView.layoutParams = layoutParams
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return tvList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindHolder(holder, tvList[position])
    }

    private fun bindHolder(holder: ViewHolder, item: PromoEntity) {
        GlideUtils.glideWithPlaceHolder(context, item.imageUrl, holder.imageView)
        holder.itemView.setOnClickListener {
            onClickItem.onClickView(item)
        }
    }

    interface OnClickItem {
        fun onClickView(item: PromoEntity)
    }
}