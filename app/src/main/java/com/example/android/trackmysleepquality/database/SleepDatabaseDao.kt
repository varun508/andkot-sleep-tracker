/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.trackmysleepquality.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SleepDatabaseDao {

    @Insert
    fun insert(sleepNight: SleepNight)

    @Update
    fun update(sleepNight: SleepNight)

    @Query("Select * from daily_sleep_quality_table where nightId = :key")
    fun get(key: Int): SleepNight

    @Query("Delete from daily_sleep_quality_table")
    fun clear()

    @Query("Select * from daily_sleep_quality_table order by nightId DESC")
    fun getAllNights(): LiveData<List<SleepNight>>

    @Query("Select * from daily_sleep_quality_table order by nightId DESC limit 1")
    fun getTonight(): SleepNight
}
