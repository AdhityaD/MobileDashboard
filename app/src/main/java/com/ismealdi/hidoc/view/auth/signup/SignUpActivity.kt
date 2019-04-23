package com.ismealdi.hidoc.view.auth.signup

import android.app.DatePickerDialog
import com.ismealdi.hidoc.R
import com.ismealdi.hidoc.base.AmActivity
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.*

/**
 * Created by Al
 * on 20/04/19 | 02:07
 */
class SignUpActivity: AmActivity(R.layout.activity_sign_up), SignUpContract.View {

    override var presenter: SignUpContract.Presenter? = SignUpPresenter(this, this)
    
    private lateinit var datePicker: DatePickerDialog
    
    override fun initView() {
        initCalendarDialog()
        initToolbar(back = true)
        setPageName("", false)
    }

    override fun initListener() {
        buttonJoin.setOnClickListener {
            presenter?.let {
                val fullName = inputFullName.text.toString()
                val email = inputEmailAddress.text.toString()
                val password = inputPassword.text.toString()
                val phone = inputPhoneNumber.text.toString()
                
                if(it.validate(fullName, email, password, phone)) {
                    it.signUp(fullName, email, password, phone)
                }
            }
        }
        
        inputDateOfBirth.setOnClickListener {
            datePicker.show()
        }
    }

    override fun showMain() {
        
    }
    
    private fun initCalendarDialog() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, y, m, d ->
            val mm = m + 1
            inputDateOfBirth.setText("$d/$mm/$y")
        }, year, month, day)

        datePicker.setOnCancelListener {
            inputDateOfBirth.setText("")
        }
    }
}