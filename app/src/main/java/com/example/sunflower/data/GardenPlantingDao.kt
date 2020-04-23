package com.example.sunflower.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface GardenPlantingDao {
    @Query("SELECT * FROM garden_planting")
    fun getGardenPlantings(): LiveData<List<GardenPlanting>>

    @Query("SELECT EXISTS(SELECT 1 FROM garden_planting WHERE plant_id = :plantId LIMIT 1)")
    fun isPlanted(plantId: String): LiveData<Boolean>

    @Transaction
    @Query("SELECT * FROM plants WHERE id IN(SELECT DISTINCT(plant_id) FROM garden_planting)")
    fun getPlantedGardens(): LiveData<List<PlantAndGardenPlantings>>

    @Insert
    suspend fun insertGardenPlantings(gardenPlanting: GardenPlanting): Long

    @Delete
    suspend fun deleteGardenPlanting(gardenPlanting: GardenPlanting)
}