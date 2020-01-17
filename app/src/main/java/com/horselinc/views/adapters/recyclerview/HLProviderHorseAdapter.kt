package com.horselinc.views.adapters.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import com.horselinc.R
import com.horselinc.loadImage
import com.horselinc.models.data.HLHorseModel
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.makeramen.roundedimageview.RoundedImageView


class HLProviderHorseAdapter(context: Context?) : RecyclerArrayAdapter<HLHorseModel>(context) {

    override fun OnCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<*> {
        return HLProviderHorseViewHolder (parent, R.layout.item_provider_horse)
    }

    class HLProviderHorseViewHolder(parent: ViewGroup?, res: Int) : BaseViewHolder<HLHorseModel>(parent, res) {

        private val horseImageView: RoundedImageView = itemView.findViewById(R.id.horseImageView)
        private val barnNameTextView: TextView = itemView.findViewById(R.id.barnNameTextView)
        private val displayNameTextView: TextView = itemView.findViewById(R.id.displayNameTextView)
        private val trainerTextView: TextView = itemView.findViewById(R.id.trainerTextView)
        private val trainerBarnTextView: TextView = itemView.findViewById(R.id.trainerBarnTextView)

        @SuppressLint("SetTextI18n")
        override fun setData(data: HLHorseModel?) {

            horseImageView.loadImage(data?.avatarUrl, R.drawable.ic_horse_placeholder)
            barnNameTextView.text = data?.barnName
            displayNameTextView.text = "\"${data?.displayName ?: ""}\""
            trainerTextView.text = "Trainer: ${data?.trainer?.name ?: ""}"
            trainerBarnTextView.text = "(${data?.trainer?.barnName ?: ""})"
        }
    }
}