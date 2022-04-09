package persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserData(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "UserName") val userName: String,
        @ColumnInfo(name = "RunningDistance") val runningDistance: Float?,
        @ColumnInfo(name = "SwimmingDistance") val swimmingDistance: Float?,
        @ColumnInfo(name = "CaloriesGot") val caloriesGot: Float?
        )