package com.ismealdi.hidoc.view.user.chat

import com.ismealdi.hidoc.base.AmPresenter
import com.ismealdi.hidoc.base.AmView
import com.ismealdi.hidoc.struct.Chat
import com.ismealdi.hidoc.struct.User

/**
 * Created by Al
 * on 06/04/19 | 21:14
 */
interface ChatContract  {

	interface View : AmView<Presenter> {
        fun displayActive(user: User)
        fun updateActive(user: User)
        fun displayUser(users: User)
        fun displayRecent(chat: Chat)
        fun updateRecent(chat: Chat)
    }

    interface Presenter : AmPresenter {
        fun chats()
        fun users()
        fun active()
    }

}