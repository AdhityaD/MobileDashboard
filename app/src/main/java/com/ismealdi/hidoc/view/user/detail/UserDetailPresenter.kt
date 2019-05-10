package com.ismealdi.hidoc.view.user.detail

import android.content.Context
import com.google.android.gms.tasks.OnFailureListener

/**
 * Created by Al
 * on 06/04/19 | 21:14
 */
class UserDetailPresenter(private val view: UserDetailContract.View, private val context: Context) : UserDetailContract.Presenter {

    init {
        view.presenter = this
    }

    private val onFailureListener = OnFailureListener {
        view.onError(it.message.toString())
    }


}