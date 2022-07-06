package com.cristian.apptest.data

import com.cristian.apptest.framework.requestmanager.utils.ImageSerializer

class ImageProvider {
    //This is a class that simulates the response of an API.
    var imageResponse: List<ImageSerializer> = listOf(
        ImageSerializer(0, "https://picsum.photos/100", "Title 1"),
        ImageSerializer(1, "https://picsum.photos/100", "Title 2"),
        ImageSerializer(2, "https://picsum.photos/100", "Title 3"),
        ImageSerializer(3, "https://picsum.photos/100", "Title 4"),
        ImageSerializer(4, "https://picsum.photos/100", "Title 5"),
        ImageSerializer(5, "https://picsum.photos/100", "Title 6"),
        ImageSerializer(6, "https://picsum.photos/100", "Title 7"),
        ImageSerializer(7, "https://picsum.photos/100", "Title 8"),
        ImageSerializer(8, "https://picsum.photos/100", "Title 9"),
        ImageSerializer(9, "https://picsum.photos/100", "Title 10"),
    )
}