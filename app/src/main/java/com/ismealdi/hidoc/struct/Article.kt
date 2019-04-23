package com.ismealdi.hidoc.struct

import com.google.firebase.Timestamp

/**
 * Created by Al
 * on 07/04/19 | 01:29
 */
class Article(
		var uid: String = "",
		var title: String = "",
		var lastUpdated: Timestamp = Timestamp.now()
)