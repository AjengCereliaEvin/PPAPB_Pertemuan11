package com.example.fruitbox

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitbox.databinding.ItemFruitBinding

typealias OnClickFruit = (Fruit) ->Unit

class FruitAdapter(private val listsFruit: List<Fruit>,
                     private val onClickFruit: OnClickFruit) :


    RecyclerView.Adapter<FruitAdapter.ItemFruitViewHolder>() {

    inner class ItemFruitViewHolder(private val binding: ItemFruitBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data : Fruit) {
            with(binding) {
                nameTxt.text = data.name
                jenisTxt.text = data.type
                statusTxt.text = data.status
                hargaTxt.text = data.price

                imgFruit.setImageResource(data.imageFruitId)

                // Mengganti latar image berdasarkan ketersediaan
                if (data.status == "TERSEDIA") {
                    statusTxt.setBackgroundResource(R.drawable.fruit_label_avail)
                } else
                    statusTxt.setBackgroundResource(R.drawable.fruit_label_sold)

                itemView.setOnClickListener {
                    onClickFruit(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitAdapter.ItemFruitViewHolder {
        val binding = ItemFruitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemFruitViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listsFruit.size
    }

    override fun onBindViewHolder(holder: ItemFruitViewHolder, position: Int) {
        holder.bind(listsFruit[position])
    }
}