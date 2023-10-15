package com.waterseven.macro.lestari.data.museum

import com.waterseven.macro.lestari.model.museum.Museum

object MuseumsData {
    val museumDummy = listOf(
        Museum(
            id = 1,
            name = "Wayang",
            description = "Wayang adalah seni pertunjukkan tradisional asli Indonesia yang berasal dan berkembang pesat di pulau Jawa dan Bali.",
            imageUrl = "https://www.artgallery.nsw.gov.au/media/collection_images/1/104.2005%23%23S.jpg",
            creator = "Thea Waddell",
            year = 2005,
        ),
        Museum(
            id = 2,
            name = "Batik",
            description = "Batik Indonesia adalah warisan budaya yang sudah diakui oleh UNESCO. Sejarah batik Indonesia sampai diakui UNESCO, melalui perjalanan yang panjang dan tidak mudah. Batik tidak hanya bernilai seni, tetapi penuh dengan makna filosofis.",
            imageUrl = "https://www.artgallery.nsw.gov.au/media/thumbnails/collection_images/2/232.2008%23detail01%23S.jpg.290x400_q85.jpg",
            creator = "John Yu and George Soutter",
            year = 2008,
        ),
        Museum(
            id = 3,
            name = "Barong Bali",
            description = "Barong merupakan salah satu tokoh berwujud singa. Tokoh ini dianggap sebagai Raja Roh yang mewakili kebajikan, atau dikenal juga sebagai ‘malaikat pelindung’. Sementara itu, Rangda (janda dalam bahasa Jawa) merupakan tokoh perlawanan dari Barong.",
            imageUrl = "https://www.indonesia.travel/content/dam/indtravelrevamp/en/destinations/revisi-2020/barong2.jpg",
            creator = "Wonderfull Indonesia",
            year = 2020
        ),
        Museum(
            id = 4,
            name = "Gamelan",
            description = "Salah satu bentuk musik yang paling dikenal adalah gamelan, musik ini dimainkan oleh beberapa orang bersama alat musik perkusi, seperti metalofon, gong dan rebab bersama dengan suling bambu. Pertunjukan seperti ini umum di negara seperti Indonesia dan Malaysia, tetapi gamelan berasal dari pulau Jawa, Bali dan Lombok.",
            imageUrl = "https://gubug-wayang.com/wp-content/uploads/2018/11/GAMELAN-JAWA-Cikal-Bakal-Gema-Bunyi-dari-Masa-Jawa-Kuno.jpg",
            creator = "Museum Gubug Wayang",
            year = 2018
        )
    )
}