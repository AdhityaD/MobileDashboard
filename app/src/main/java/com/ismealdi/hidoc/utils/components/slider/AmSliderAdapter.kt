package com.ismealdi.hidoc.utils.components.slider

import android.content.Context
import android.os.Parcelable
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.ismealdi.hidoc.R
import com.ismealdi.hidoc.utils.commons.Utils
import kotlinx.android.synthetic.main.component_slider.view.*

/**
 * Created by Al
 * on 06/04/19 | 22:21
 */
class AmSliderAdapter(private val context: Context, private val imageModelArrayList: List<AmImage>) : PagerAdapter() {
	
	private val inflater: LayoutInflater = LayoutInflater.from(context)
	
	override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
		container.removeView(`object` as View)
	}
	
	override fun getCount(): Int {
		return imageModelArrayList.size
	}
	
	override fun instantiateItem(view: ViewGroup, position: Int): Any {
		val data = imageModelArrayList[position]
		val imageLayout = inflater.inflate(R.layout.component_slider, view, false)
		
		Utils().imageRound(imageLayout.image, data.image, context, ImageView.ScaleType.CENTER_CROP)
		
		imageLayout.labelTitle.text = data.title
		imageLayout.labelSubTitle.text = data.subTitle
		
		view.addView(imageLayout, 0)
		
		return imageLayout
	}
	
	override fun isViewFromObject(view: View, obj: Any): Boolean {
		return view == obj
	}
	
	override fun restoreState(state: Parcelable?, loader: ClassLoader?) {}
	
	override fun saveState(): Parcelable? {
		return null
	}
	
}