package persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDataDao {
    @Insert
    fun saveData(vararg userData: UserData);

    @Query("SELECT * FROM userdata")
    fun getData(): List<UserData>
}