package com.ismealdi.hidoc.struct

import com.google.firebase.Timestamp

/**
 * Created by Al
 * on 07/04/19 | 01:29
 */
class Chat(
		var uid: String = "",
		var senderId: String = "",
		var receiverId: String = "",
        var sender: User = User(),
		var conversations: List<Conversation> = listOf(),
		var lastUpdated: Timestamp = Timestamp.now()
)