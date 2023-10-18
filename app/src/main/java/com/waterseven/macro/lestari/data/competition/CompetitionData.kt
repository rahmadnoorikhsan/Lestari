package com.waterseven.macro.lestari.data.competition

import com.waterseven.macro.lestari.model.competition.Competition

object CompetitionData {
    val dummyCompetition = listOf(
        Competition(
            id=1,
            title = "Solo Batik Fashion",
            image = "https://assets.pikiran-rakyat.com/crop/13x408:1079x1090/x/photo/2023/08/07/1709844333.jpg",
            date = "Senin, 28-30 september 2023",
            description = "Pada acara Solo Batik Fashion tahun 2023 ini, mengusung tema BIG SIZE - URBAN STYLE Solo Batik Fashion 2023 yang diharapkan bisa menjadi ruang baru di industri fashion.\n" +
                    "\n" +
                    "Lebih lanjut tampilan fashion yang big size tetap bisa cantik dan juga indah dengan menggabungkan tema Urban Style sebagai gambaran gaya hidup perkotaan masa kini yang sifatnya milenial, mandiri, kompetitif, rasional, kritis, praktis, dan mobilitas tinggi.",
            location = "Koridor Gotsu Solo",
            actor = "Pengiat Budaya",
            time = "08:00 s/d Selesai"
        ),
        Competition(
            id=2,
            title = "Tari Gambyong",
            image =  "https://dindik.pekalongankota.go.id/upload/pengumuman/pengumuman_20220608075512.png",
            date = "Kamis, 14 september 2023",
            description = "Menampilkan sajian Pagelaran Wayang Kulit rangka Sosialisasi Peraturan Perundang-undangan tentang Gembur Rokok Ilegal.",
            location = "Solo",
            actor = "Tari Solo",
            time = "08:00"
        )
    )
}