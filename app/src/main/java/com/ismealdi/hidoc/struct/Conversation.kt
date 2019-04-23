package com.ismealdi.hidoc.struct

import com.google.firebase.Timestamp

/**
 * Created by Al
 * on 07/04/19 | 01:29
 */
class Conversation(
        var uid: String = "",
        var message: String = "",
        var state: Int = 0,
        var createdOn: Timestamp = Timestamp.now(),
        var readOn: Timestamp = Timestamp.now()
)
