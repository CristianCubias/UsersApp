package com.cristian.apptest.data

import com.cristian.apptest.framework.requestmanager.UserSerializer

class UserProvider {
    //This is a class that simulates the response of an API.
    var usersResponse: List<UserSerializer> = listOf(
        UserSerializer(0, "Name_1", "Username_1", "Email_1"),
        UserSerializer(1, "Name_2", "Username_2", "Email_2"),
        UserSerializer(2, "Name_3", "Username_3", "Email_3"),
        UserSerializer(3, "Name_4", "Username_4", "Email_4"),
        UserSerializer(4, "Name_5", "Username_5", "Email_5"),
        UserSerializer(5, "Name_6", "Username_6", "Email_6"),
        UserSerializer(6, "Name_7", "Username_7", "Email_7"),
        UserSerializer(7, "Name_8", "Username_8", "Email_8"),
        UserSerializer(8, "Name_9", "Username_9", "Email_9"),
        UserSerializer(9, "Name_10", "Username_10", "Email_10"),
    )



}