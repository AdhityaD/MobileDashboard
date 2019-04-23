package com.ismealdi.hidoc.view.splash

import android.content.Context

/**
 * Created by Al
 * on 06/04/19 | 20:59
 */
class SplashPresenter(private val view: SplashContract.View, private val context: Context) : SplashContract.Presenter {
	
	init {
		view.presenter = this
	}
	
	override fun checkSession() {
		view.showMain()
	}
	
}