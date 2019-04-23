package com.ismealdi.hidoc.view.user.home

import com.ismealdi.hidoc.base.AmPresenter
import com.ismealdi.hidoc.base.AmView

/**
 * Created by Al
 * on 06/04/19 | 21:14
 */
interface HomeContract  {
	
	interface View : AmView<Presenter>

    interface Presenter : AmPresenter

}