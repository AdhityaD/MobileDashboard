package com.ismealdi.hidoc.view.auth.forgot

import android.view.Gravity
import com.ismealdi.hidoc.R
import com.ismealdi.hidoc.base.AmActivity

/**
 * Created by Al
 * on 20/04/19 | 02:07
 */
class ForgotPasswordActivity: AmActivity(R.layout.activity_forgot_password), ForgotPasswordContract.View {

    override var presenter: ForgotPasswordContract.Presenter? =
        ForgotPasswordPresenter(this, this)
    
    override fun initView() {
        initToolbar(pageName = getString(R.string.title_forgot_password), back = true)
        setTitleGravity(Gravity.CENTER)
    }

    override fun showMain() {
        
    }
}