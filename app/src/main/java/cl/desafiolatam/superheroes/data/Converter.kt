package cl.desafiolatam.superheroes.data

import androidx.room.TypeConverter

class Converter {

    @TypeConverter
    fun convertListtoString(lista: List<String>): String {
        return lista.joinToString { "," }
    }

    @TypeConverter
    fun convertStringtoList(lista: String): List<String> {

        return lista.split(",").map {it.trim() }
    }
}