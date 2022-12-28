package com.keyutshah.news_app.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.keyutshah.news_app.R
import com.keyutshah.news_app.data.Article


class AllNewsAdapter(val context: Context): RecyclerView.Adapter<AllNewsAdapter.ArticleViewHolder>(){

    var articles: ArrayList<Article> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.single_all_news,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article:Article = articles[position]
        holder.title.text = article.title
        holder.date.text=article.publishedAt
        if(article.author != null){
            holder.author.text = article.author.toString()
        }else{
            holder.author.text = "UnKnown"
        }

        //change
        holder.itemView.setOnClickListener {
            val url= article.url
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        }
        //change

        Glide.with(context)
            .load(article.urlToImage)
            .into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return articles.size
    }


    class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView  = itemView.findViewById<ImageView>(R.id.imageView_singleAllNews)
        var title = itemView.findViewById<TextView>(R.id.title_singleAllNews)
        val author = itemView.findViewById<TextView>(R.id.author_singleAllNews)
        val date = itemView.findViewById<TextView>(R.id.date_singleAllNews)
    }

    fun clear() {
        articles.clear()
        notifyDataSetChanged()
    }

    fun addAll(art: List<Article>) {
        articles.addAll(art)
        notifyDataSetChanged()
    }

}