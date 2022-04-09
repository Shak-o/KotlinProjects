package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import com.example.myapplication.databinding.ActivityMainBinding
import persistence.AppDatabase
import persistence.UserData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val save = binding.save
        val userName = binding.editTextTextPersonName
        val runned = binding.runned;
        val swimmed = binding.swimmed;
        val calories = binding.calories;
        val txtRunned = binding.avgRunned;
        val txtSwimmed = binding.avgSwimmed;
        val txtCalories = binding.AvgCalories;
        val txtSumRunned = binding.sumRunned;

    save?.setOnClickListener {
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "myDatabase"
            ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

            var user: UserData = UserData(
                0,
                userName.text.toString(),
                runned.text.toString().toFloat(),
                swimmed.text.toString().toFloat(),
                calories.text.toString().toFloat()
            );

            db.userDataDao().saveData(user);

            val check : List<UserData> = db.userDataDao().getData();
            var sumRunning : Float = 0.0f
            var sumSwimming : Float = 0.0f
            var sumCalories : Float = 0.0f
            for (item in check) {
                if (sumSwimming != null) {
                    sumSwimming = sumSwimming + item.swimmingDistance!!
                };
                if (sumRunning != null) {
                    sumRunning = sumRunning + item.runningDistance!!
                };
                if (sumCalories != null) {
                    sumCalories = sumCalories + item.caloriesGot!!
                };
            }

            val avgRunned = sumRunning/check.count().toFloat();
            val avgSwimmed = sumSwimming/check.count().toFloat();
            val avgCalories = sumCalories/check.count().toFloat();

            txtRunned.text = "Runned: " + avgRunned.toString() ;
            txtSwimmed.text = "Swimmed: " + avgSwimmed.toString();
            txtCalories.text = "Calories: " + avgCalories.toString();
            txtSumRunned.text = "SumRunned: " + sumRunning.toString();
        }
    }
}