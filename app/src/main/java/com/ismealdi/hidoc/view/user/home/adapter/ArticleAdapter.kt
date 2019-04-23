package com.ismealdi.hidoc.view.user.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ismealdi.hidoc.R
import com.ismealdi.hidoc.struct.Article

/**
 * Created by Al
 * on 07/04/19 | 01:26
 */
class ArticleAdapter(private var data: List<Article>, private val context: Context) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

	class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
		return ViewHolder(view)
	}

	@SuppressLint("ClickableViewAccessibility")
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {


	}

	override fun getItemCount(): Int {
		return data.size
	}
}