package com.waterseven.macro.lestari.data.watch

import com.waterseven.macro.lestari.model.watch.Watch

object WatchData {

    val dummyWatch = listOf(
        Watch(
            id = 1,
            videoUrl = "https://storage.googleapis.com/my_app_aa/tari.mp4",
            account = "indonesia_kaya",
            description = "Perunjukan tari kipas #TariKipas"
        ),
        Watch(
            id = 2,
            videoUrl = "https://storage.googleapis.com/my_app_aa/festival.mp4",
            account = "pemkabbandung",
            description = "Pesta Kesenian Bali XLV Tahun 2023"
        ),
        Watch(
            id = 3,
            videoUrl = "https://storage.googleapis.com/my_app_aa/batik.mp4",
            account = "indonesia_kaya",
            description = "Selamat Hari Batik"
        ),
        Watch(
            id = 4,
            videoUrl = "https://storage.googleapis.com/my_app_aa/jaran.mp4",
            account = "taksu_bali",
            description = "Semangat ya jaga selalu budaya kita"
        ),
        Watch(
            id = 5,
            videoUrl = "https://storage.googleapis.com/my_app_aa/reog.mp4",
            account = "sugirisancoko",
            description = "Serenade Reog Obyog berjalan lancar"
        )
    )
}