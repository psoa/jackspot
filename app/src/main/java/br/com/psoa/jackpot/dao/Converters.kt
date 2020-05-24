package br.com.psoa.jackpot.dao

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {

    @TypeConverter
    fun intArrayToString (intArray: IntArray) : String  {
        return Gson().toJson(intArray)
    }
    @TypeConverter
    fun listIntToString (listInt:  List<Int>) : String  {
        return Gson().toJson(listInt)
    }

    @TypeConverter
    fun stringToListInt (string : String) : List<Int> {
        return  Gson().fromJson(string, object : TypeToken<ArrayList<Int>>() {}.type)
    }

    @TypeConverter
    fun stringToIntArray (string : String) : IntArray {
        return  Gson().fromJson(string, IntArray::class.java)
    }

    @TypeConverter
    fun doubleArrayToString (doubleArray: DoubleArray) : String  {
        return Gson().toJson(doubleArray)
    }

    @TypeConverter
    fun stringToDoubleArray (string : String) : DoubleArray {
        return Gson().fromJson(string, DoubleArray::class.java)
    }

    @TypeConverter
    fun stringArrayToString (doubleArray: Array<String>) : String  {
        return Gson().toJson(doubleArray)
    }

    @TypeConverter
    fun stringToArrayString (string : String) : Array<String> {
        return Gson().fromJson(string, Array<String>::class.java)
    }

    @TypeConverter
    fun stringArrayArrayToString (doubleArray: Array<Array<String>>) : String  {
        return Gson().toJson(doubleArray)
    }

    @TypeConverter
    fun stringToArrayArrayString (string : String) :Array<Array<String>> {
        return Gson().fromJson(string, Array<Array<String>>::class.java)
    }

}