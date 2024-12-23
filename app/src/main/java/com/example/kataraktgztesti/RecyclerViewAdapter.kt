package com.example.kataraktgztesti

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val context: Context,
    private val itemList: List<CardItem>,
    private val onClick: (CardItem) -> Unit // OnClick listener
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.secenek_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: CardItem = itemList[position]

        // Başlık ve açıklama ayarı
        holder.itemTitle.text = item.title
        holder.itemDescription.text = item.description

        // Fotoğrafları ayarlama
        when (item.title) {
            "Katarakt Nedir? Nasıl Anlaşılır" -> {
                holder.itemImage.setImageResource(R.drawable.katarakt1) // Görsel kaynağı
            }
            "Renk Körü Testi" -> {
                holder.itemImage.setImageResource(R.drawable.renkkorlugu)
            }
            "Gözleriniz Ne Kadar İyi Görüyor" -> {
                holder.itemImage.setImageResource(R.drawable.miyoptesti)
            }
            else -> {
                holder.itemImage.setImageResource(R.drawable.hemsire1) // Varsayılan görsel
            }
        }

        // Click listener ayarlama
        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTitle: TextView = itemView.findViewById(R.id.itemTitle)
        var itemDescription: TextView = itemView.findViewById(R.id.itemDescription)
        var itemImage: ImageView = itemView.findViewById(R.id.itemImage) // Başlangıç görseli
        var itemEndImage: ImageView = itemView.findViewById(R.id.itemEndImage) // Son görsel (isteğe bağlı)
    }
}
