package cl.desafiolatam.superheroes.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*
import cl.desafiolatam.superheroes.api.SuperHeroes

@Dao

interface SuperDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSuper (superList: List<SuperHeroes>)

    @Query ("SELECT * FROM superheroes")
    fun getSuper(): LiveData<List<SuperHeroes>>

    @Query ("SELECT * FROM superheroes")
    fun getDetailSuper (idSuper: Int): LiveData<List<SuperHeroes>>
}

@Database (entities = [SuperHeroes::class], version = 1)
@TypeConverters (Converter::class)
abstract class SuperDataBase : RoomDatabase() {
    abstract fun superDao(): SuperDao
}
class SuperApplication : Application() {
    companion object{
        var superDataBase : SuperDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        superDataBase = Room.databaseBuilder(this,SuperDataBase::class.java, "databaseSuper").build()
    }
}

