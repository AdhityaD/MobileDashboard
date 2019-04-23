package com.ismealdi.hidoc.view.auth.forgot

import android.content.Context

/**
 * Created by Al
 * on 20/04/19 | 02:09
 */
class ForgotPasswordPresenter(private val view: ForgotPasswordContract.View, private val context: Context) :

    ForgotPasswordContract.Presenter {

    init {
        view.presenter = this
    }

    override fun checkSession() {
        view.showMain()
    }

    override fun resetPassword() {
        view.onError("Apalah apalah")
    }

}