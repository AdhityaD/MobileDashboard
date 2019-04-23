package com.ismealdi.hidoc.view.auth.signup

import android.content.Context
import com.ismealdi.hidoc.R

/**
 * Created by Al
 * on 20/04/19 | 02:09
 */
class SignUpPresenter(private val view: SignUpContract.View, private val context: Context) : SignUpContract.Presenter {

    init {
        view.presenter = this
    }

    override fun checkSession() {
        view.showMain()
    }

    override fun validate(fullName: String, email: String, password: String, phone: String): Boolean {
        val passwordLengthMin = context.resources.getInteger(R.integer.validation_password_min)
        return if (
            fullName.isNotEmpty() && 
            email.isNotEmpty() && 
            password.isNotEmpty() && 
            password.length > passwordLengthMin && 
            phone.isNotEmpty()) {
            
            true
            
        }else{

            if(password.length < passwordLengthMin)
                view.onError("Password length is less than $passwordLengthMin")
            else
                view.onError("Please fill in all the input")

            false
        }
    }

    override fun signUp(fullName: String, email: String, password: String, phone: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}