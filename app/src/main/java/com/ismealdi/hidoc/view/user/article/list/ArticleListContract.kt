package com.ismealdi.hidoc.view.user.article.list

import com.ismealdi.hidoc.base.AmPresenter
import com.ismealdi.hidoc.base.AmView
import com.ismealdi.hidoc.struct.Article

/**
 * Created by Al
 * on 06/04/19 | 21:14
 */
interface ArticleListContract {

    interface View : AmView<Presenter> {

        fun displayArticles(articles: List<Article>)

    }

    interface Presenter : AmPresenter {

        fun articles()

    }

}