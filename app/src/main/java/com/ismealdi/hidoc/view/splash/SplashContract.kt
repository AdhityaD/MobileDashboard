package com.ismealdi.hidoc.view.splash

import com.ismealdi.hidoc.base.AmPresenter
import com.ismealdi.hidoc.base.AmView

/**
 * Created by Al
 * on 06/04/19 | 20:59
 */
interface SplashContract {
	
	interface View : AmView<Presenter> {
		fun showMain()
	}
	
	interface Presenter : AmPresenter {
		fun checkSession()
	}
	
}