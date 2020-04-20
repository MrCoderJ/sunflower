package com.example.sunflower.data

import androidx.room.*
import java.util.*


@Entity(tableName = "garden_planting",
    foreignKeys = [ForeignKey(entity = Plant::class, parentColumns = ["id"], childColumns = ["plant_id"])],
    indices = [Index("plant_id")])

data class GardenPlanting(
    @ColumnInfo(name = "plant_id") val plantId: String,

    /*
    * Indicate when the [plant] is planted
    * */
    @ColumnInfo(name = "plant_date") val plantDate: Calendar = Calendar.getInstance(),


    /*
    * It indicate when the plant was watered last
    * */

    @ColumnInfo(name = "last_watering_date") val lastWateringDate: Calendar = Calendar.getInstance()
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var gardenPlantingId: Long = 0
}