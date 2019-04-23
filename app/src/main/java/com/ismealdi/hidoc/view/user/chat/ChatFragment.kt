package com.ismealdi.hidoc.view.user.chat

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.ismealdi.hidoc.R
import com.ismealdi.hidoc.base.AmFragment
import com.ismealdi.hidoc.struct.Chat
import com.ismealdi.hidoc.struct.User
import com.ismealdi.hidoc.view.user.chat.adapter.ChatAdapter
import com.ismealdi.hidoc.view.user.chat.adapter.SuggestionAdapter
import kotlinx.android.synthetic.main.fragment_chat.*

/**
 * Created by Al
 * on 06/04/19 | 03:27
 */
class ChatFragment : AmFragment(R.layout.fragment_chat, R.string.title_chat) {

	private var suggestionAdapter: SuggestionAdapter? = null
	private var chatAdapter: ChatAdapter? = null
	
	override fun initView() {
		amActivity?.let {
			initAdapter(it)	
			initLists(it)	
		}
	}

	private fun initAdapter(context: Context) {
		suggestionAdapter = SuggestionAdapter(listOf(User(), User(), User()), context)
        chatAdapter = ChatAdapter(listOf(Chat(), Chat(), Chat(), Chat(), Chat(), Chat(), Chat(), Chat()), context)
	}
    
    private fun initLists(context: Context) {
        gridSuggestion.layoutManager = LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)
        gridSuggestion.adapter = suggestionAdapter
        
        listChat.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        listChat.adapter = chatAdapter
    }

}