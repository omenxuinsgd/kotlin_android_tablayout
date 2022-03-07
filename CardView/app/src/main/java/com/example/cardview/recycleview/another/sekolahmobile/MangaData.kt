package com.example.cardview.recycleview.another.sekolahmobile

import com.example.cardview.R

object MangaData {
    private val image = arrayOf(
        R.drawable.manga1,
        R.drawable.manga2,
        R.drawable.manga3,
        R.drawable.manga4,
        R.drawable.manga5,
        R.drawable.manga6,
        R.drawable.manga7,
        R.drawable.manga8,
        R.drawable.manga9,
        R.drawable.manga10
    )
    private val title = arrayOf(
        "Domestic na Kanojo",
        "Kanojo, Okarishimasu",
        "Real Girl",
        "The Promise Neverland",
        "One Piece",
        "Yahari Ore no Seishun Love Come wa Machigatteiru",
        "Uzaki-chan Wants to Hang Out!",
        "Rascal Does Not Dream of Bunny Girl Senpai",
        "Kakushigoto",
        "Sing Yesterday for Me"
    )
    private val author = arrayOf(
        "Kei Sasuga",
        "Reiji Miyajima",
        "Mao Nanami",
        "Kaiu Shirai",
        "Eiichiro Oda",
        "Wataru Watari",
        "Take",
        "Hajime Kamoshida",
        "Kōji Kumeta",
        "Kei Toume"
    )
    private val genre = arrayOf(
        "Romance",
        "Romantic comedy",
        "Romantic comedy",
        "Science fiction",
        "Adventure",
        "Slice of Life",
        "Comedy",
        "Supernatural",
        "Slice of Life",
        "Coming of Age"
    )

    val listData: ArrayList<Manga>
        get(){
            val list: ArrayList<Manga> = arrayListOf<Manga>()
            for(i in list.indices){
                val manga = Manga()
                manga.coverImage = image[i]
                manga.title = title[i]
                manga.author = author[i]
                manga.genre = genre[i]
                list.add(manga)
            }
            return list
        }
}