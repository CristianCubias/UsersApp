package com.cristian.apptest.data

import com.cristian.apptest.framework.requestmanager.ImageSerializer

class ImageProvider {
    //This is a class that simulates the response of an API.
    var imageResponse: List<ImageSerializer> = listOf(
        ImageSerializer(0, "ImageURL1", "Title 1"),
        ImageSerializer(1, "ImageURL2", "Title 2"),
        ImageSerializer(2, "ImageURL3", "Title 3"),
        ImageSerializer(3, "ImageURL4", "Title 4"),
        ImageSerializer(4, "ImageURL5", "Title 5"),
        ImageSerializer(5, "ImageURL6", "Title 6"),
        ImageSerializer(6, "ImageURL7", "Title 7"),
        ImageSerializer(7, "ImageURL8", "Title 8"),
        ImageSerializer(8, "ImageURL9", "Title 9"),
        ImageSerializer(9, "ImageURL10", "Title 10"),
    )
}