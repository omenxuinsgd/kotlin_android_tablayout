package com.example.cardview.recycleview.another.sekolahmobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.cardview.R
import kotlinx.android.synthetic.main.item_list_manga.view.*

class MangaAdapter (private var listManga: ArrayList<Manga>): RecyclerView.Adapter<MangaAdapter.ViewHolder>() {
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(manga: Manga){
            Glide.with(itemView.context)
                .load(manga.coverImage)
                .apply(RequestOptions().override(90, 120))
                .into(itemView.image_manga)
            itemView.text_title.text = manga.title
            itemView.text_author.text = manga.author
            itemView.text_genre.text = manga.genre
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaAdapter.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_manga, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(listManga[position])

    override fun getItemCount() = listManga.size

}