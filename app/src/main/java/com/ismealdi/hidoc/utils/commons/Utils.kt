package com.ismealdi.hidoc.utils.commons

import android.content.Context
import android.graphics.Typeface
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ismealdi.hidoc.R
import com.ismealdi.hidoc.utils.components.AmNoSwipe

/**
 * Created by Al
 * on 06/04/19 | 22:22
 */
class Utils {

  fun imageRound(imageView: ImageView, url: String?, context: Context, scaleType: ImageView.ScaleType? = null) {
    url?.let {
      val radius = context.resources.getDimensionPixelSize(R.dimen.radius)
      var requestOptions = RequestOptions()

      requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(radius))
      requestOptions = requestOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

      if(scaleType == ImageView.ScaleType.CENTER_INSIDE) {
        requestOptions = requestOptions.centerInside()
      }

      Glide.with(context)
        .load(it)
        .apply(requestOptions)
        .into(imageView)
    }
  }

  fun showSnackBar(context: Context, layoutParent: View, message: String, duration: Int = Snackbar.LENGTH_SHORT, actionText: String = "", actionListener: Runnable? = null) {
    val mSnackBar = Snackbar.make(layoutParent, message, duration)

    if(message.contains("Unable to resolve")) mSnackBar.behavior = AmNoSwipe()

    mSnackBar.view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))

    val textViewAction = mSnackBar.view.findViewById(android.support.design.R.id.snackbar_action) as TextView
    val textView = mSnackBar.view.findViewById(android.support.design.R.id.snackbar_text) as TextView

    textView.setTypeface(Typeface.createFromAsset(context.assets, Constants.View.Name[0] + Constants.View.Style[0] + Constants.View.Type), Typeface.NORMAL)
    textView.setTextColor(ContextCompat.getColor(context, R.color.colorTextPrimary))
    textView.gravity = Gravity.CENTER
    textView.textSize = 11.5f
    textView.maxLines = 2

    if(actionText != "") {

      textViewAction.setTypeface(Typeface.createFromAsset(context.assets, Constants.View.Name[0] + Constants.View.Style[1] + Constants.View.Type), Typeface.NORMAL)
      textViewAction.setTextColor(ContextCompat.getColor(context, R.color.colorTextPrimary))
      textViewAction.gravity = Gravity.CENTER
      textViewAction.background = ContextCompat.getDrawable(context, R.drawable.button_primary)
      textViewAction.textSize = 11.5f

      mSnackBar.setAction(actionText) { actionListener?.run() }
    }

    Handler().postDelayed({
      mSnackBar.show()
    }, (if(actionText != "") 500 else 0).toLong())
  }

}