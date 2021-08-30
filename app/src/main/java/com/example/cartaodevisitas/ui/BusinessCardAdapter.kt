package com.example.cartaodevisitas.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cartaodevisitas.data.BusinessCard
import com.example.cartaodevisitas.databinding.ItemBusinessCountBinding

class BusinessCardAdapter : ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()){
    var listenerShare: (View) -> Unit ={}

    inner class ViewHolder(
        private val binding: ItemBusinessCountBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind (item: BusinessCard) {
            binding.tvNome.text = item.nome
            binding.tvEmail.text = item.email
            binding.tvNomeEmpresa.text = item.empresa
            binding.tvTelefone.text = item.telefone
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.mcvContent.setOnClickListener{
                listenerShare(it)}

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCountBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class DiffCallback: DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem.id == newItem.id


}