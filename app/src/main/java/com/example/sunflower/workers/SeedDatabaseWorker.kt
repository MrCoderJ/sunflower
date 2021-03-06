package com.example.sunflower.workers

import android.content.Context
import com.google.gson.stream.JsonReader
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.sunflower.data.AppDatabase
import com.example.sunflower.data.Plant
import com.example.sunflower.utilities.PLANT_DATA_FILENAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.coroutineScope
import java.lang.Exception

class SeedDatabaseWorker(context: Context, workerParams: WorkerParameters): CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope{
        try{
            applicationContext.assets.open(PLANT_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val plantType = object : TypeToken<List<Plant>>() {}.type
                    val plantList: List<Plant> = Gson().fromJson(jsonReader, plantType)

                    val database = AppDatabase.getInstance(applicationContext)
                    database.plantDao().insertAll(plantList)
                    Result.success()
                }
            }
        }catch (ex: Exception){
            Log.e(TAG, "Error seeding Database", ex)
            Result.failure()
        }

    }

    companion object{
        private val TAG = SeedDatabaseWorker::class.java.simpleName
    }
}