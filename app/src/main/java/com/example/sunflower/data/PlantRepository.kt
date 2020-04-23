package com.example.sunflower.data

class PlantRepository private constructor(private val plantDao: PlantDao){

    fun getPlants() = plantDao.getPlants()

    fun getPlant(plantId: String) = plantDao.getPlant(plantId)

    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int) = plantDao.getPlantWithGrowZoneNumber(growZoneNumber)


    companion object{
        // For singleton instantiation

        @Volatile private var instance: PlantRepository? = null

        fun getInstance(plantDao: PlantDao) = instance?: synchronized(this){
            instance ?: PlantRepository(plantDao).also { instance = it }
        }
    }
}