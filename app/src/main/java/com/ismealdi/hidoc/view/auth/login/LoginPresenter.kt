package com.ismealdi.hidoc.view.auth.login

import android.content.Context

/**
 * Created by Al
 * on 06/04/19 | 20:59
 */
class LoginPresenter(private val view: LoginContract.View, private val context: Context) :
    LoginContract.Presenter {

	init {
		view.presenter = this
	}
	
	override fun checkSession() {
		view.showMain()
	}

	override fun signIn() {
        view.onError("Apalah apalah")
	}
	
}