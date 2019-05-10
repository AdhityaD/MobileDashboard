package com.ismealdi.hidoc.view.user.profile

import com.ismealdi.hidoc.base.AmPresenter
import com.ismealdi.hidoc.base.AmView
import com.ismealdi.hidoc.struct.User

/**
 * Created by Al
 * on 06/04/19 | 20:59
 */
interface ProfileContract {

    interface View : AmView<Presenter> {
        fun showSignIn()
        fun displayUserInfo(user: User)
    }

    interface Presenter : AmPresenter {
        fun signOut()
        fun user()
    }

}