package com.ismealdi.hidoc.view.user.home

import android.content.Context

/**
 * Created by Al
 * on 06/04/19 | 21:14
 */
class HomePresenter(private val view: HomeContract.View, private val context: Context) : HomeContract.Presenter {
	
	init {
		view.presenter = this
	}
	
}