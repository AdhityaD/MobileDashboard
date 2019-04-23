package com.ismealdi.hidoc.base

import android.annotation.SuppressLint
import android.content.IntentFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.ismealdi.hidoc.R
import com.ismealdi.hidoc.utils.commons.Logs
import com.ismealdi.hidoc.utils.commons.Utils
import com.ismealdi.hidoc.utils.interfaces.AmConnectionInterface
import com.ismealdi.hidoc.utils.interfaces.AmNetworkInterface
import com.ismealdi.hidoc.utils.services.ConnectionReceiver
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.component_toolbar.*

/**
 * Created by Al
 * on 06/04/19 | 02:01
 */
@SuppressLint("Registered")
abstract class AmActivity(@LayoutRes var layout: Int) : AppCompatActivity(), AmConnectionInterface, AmNetworkInterface {

    private var connectionReceiver: ConnectionReceiver? = null
    private var isRegisteredReceiver: Boolean = false

    protected abstract fun initView()

    protected open fun initListener() {}

    fun initToolbar(
        back: Boolean = false,
        pageName: String = "",
        primary: Boolean = false
    ) {
        setSupportActionBar(toolbar)

        setPageName(pageName)

        supportActionBar?.let { actionBar ->
            actionBar.setDisplayShowTitleEnabled(false)
            actionBar.setDisplayHomeAsUpEnabled(back)

            val backIcon = ContextCompat.getDrawable(this, R.drawable.ic_chevron)
            val iconColor = PorterDuffColorFilter(ContextCompat.getColor(this,
                if(primary) R.color.colorTextAccent else R.color.colorTextPrimary), PorterDuff.Mode.MULTIPLY)

            backIcon?.let {
                it.colorFilter = iconColor
                toolbar.overflowIcon?.colorFilter = iconColor
            }

            actionBar.setHomeAsUpIndicator(backIcon)
        }
    }

    fun setTitleGravity(gravity: Int) {
        val layoutParams = toolbarTitle.layoutParams as Toolbar.LayoutParams

        layoutParams.gravity = gravity

        toolbarTitle.layoutParams = layoutParams
    }

    fun setToolbarSearch(state: Boolean) {
        toolbarSearch.visibility = if(state) View.VISIBLE else View.GONE
    }

    fun setPageName(pageName: String, line: Boolean = true) {
        toolbarTitle.text = pageName
        lineDivider.setBackgroundColor(ContextCompat.getColor(this,
            if(line) R.color.colorDivider else R.color.colorBackgroundSecondary))
    }

    override fun onDestroy() {
        super.onDestroy()
        if(isRegisteredReceiver) {
            unregisterReceiver(connectionReceiver)
            isRegisteredReceiver = false
        }
    }

    override fun onPause() {
        super.onPause()
        if(isRegisteredReceiver) {
            unregisterReceiver(connectionReceiver)
            isRegisteredReceiver = false
        }
    }

    private fun initData(receiver: AmConnectionInterface) {
        if(connectionReceiver == null) {
            connectionReceiver = ConnectionReceiver()
            connectionReceiver?.let {
                val mIntentFilter = IntentFilter()

                it.registerReceiver(receiver)
                mIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")

                registerReceiver(connectionReceiver, mIntentFilter)
                isRegisteredReceiver = true
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initData(this)

        super.onCreate(savedInstanceState)
        setContentView(layout)

        initView()
        initListener()
    }

    override fun onConnectionChange(message: String) {
        Logs.e(message)
    }
    
    override fun onAlert(message: String, actionText: String, actionListener: Runnable) {
        layoutParent?.let {
            Utils().showSnackBar(this, it, message, Snackbar.LENGTH_INDEFINITE, actionText, actionListener)
        }
    }

    override fun onError(message: String) {
        layoutParent?.let {
            Utils().showSnackBar(this, it, message)
        }
    }

    override fun onSuccess(message: String) {
        layoutParent?.let {
            Utils().showSnackBar(this, it, message, Snackbar.LENGTH_LONG)
        }
    }

    override fun onInfo(message: String) {
        layoutParent?.let {
            Utils().showSnackBar(this, it, message)
        }
    }

}