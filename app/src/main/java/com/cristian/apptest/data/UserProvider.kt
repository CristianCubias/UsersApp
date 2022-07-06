package com.cristian.apptest.data

import com.cristian.apptest.framework.requestmanager.utils.AddressSerializer
import com.cristian.apptest.framework.requestmanager.utils.UserSerializer

class UserProvider {
    //This is a class that simulates the response of an API.
    var usersResponse: List<UserSerializer> = listOf(
        UserSerializer(0, "Name_1", "Username_1", "Email_1", AddressSerializer("Street 1", "Suite 1", "City 1"), null),
        UserSerializer(1, "Name_2", "Username_2", "Email_2", AddressSerializer("Street 2", "Suite 2", "City 2"), null),
        UserSerializer(2, "Name_3", "Username_3", "Email_3", AddressSerializer("Street 3", "Suite 3", "City 3"), null),
        UserSerializer(3, "Name_4", "Username_4", "Email_4", AddressSerializer("Street 4", "Suite 4", "City 4"), null),
        UserSerializer(4, "Name_5", "Username_5", "Email_5", AddressSerializer("Street 5", "Suite 5", "City 5"), null),
        UserSerializer(5, "Name_6", "Username_6", "Email_6", AddressSerializer("Street 6", "Suite 6", "City 6"), null),
        UserSerializer(6, "Name_7", "Username_7", "Email_7", AddressSerializer("Street 7", "Suite 7", "City 7"), null),
        UserSerializer(7, "Name_8", "Username_8", "Email_8", AddressSerializer("Street 8", "Suite 8", "City 8"), null),
        UserSerializer(8, "Name_9", "Username_9", "Email_9", AddressSerializer("Street 9", "Suite 9", "City 9"), null),
        UserSerializer(9, "Name_10", "Username_10", "Email_10", AddressSerializer("Street 10", "Suite 10", "City 10"), null)
    )



}