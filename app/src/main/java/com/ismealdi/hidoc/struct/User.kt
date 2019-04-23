package com.ismealdi.hidoc.struct

import com.google.firebase.Timestamp

/**
 * Created by Al
 * on 07/04/19 | 01:29
 */
class User(
		var uid: String = "",
		var displayName: String = "",
		var specialist: String = "",
		var photoUrl: String = "",
		var email: String = "",
		var userName: String = "",
		var phoneNumber: String = "",
		var emailVerified: Boolean = false,
		var category: Int = 2,
		var pushId: String = "",
		var onlineUser: Boolean = false,
		var lastUpdated: Timestamp = Timestamp.now()
)