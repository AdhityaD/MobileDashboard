package com.ismealdi.hidoc.view.user.article.detail

import android.content.Context
import com.google.android.gms.tasks.OnFailureListener

/**
 * Created by Al
 * on 06/04/19 | 21:14
 */
class ArticleDetailPresenter(private val view: ArticleDetailContract.View, private val context: Context) : ArticleDetailContract.Presenter {

    init {
        view.presenter = this
    }

    private val onFailureListener = OnFailureListener {
        view.onError(it.message.toString())
    }


}