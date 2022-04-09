package persistence

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserData :: class], version = 2 )
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDataDao() : UserDataDao;
}