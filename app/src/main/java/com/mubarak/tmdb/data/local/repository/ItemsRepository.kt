/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mubarak.tmdb.data.local.repository

import com.mubarak.tmdb.domain.model.movieModel.MovieItem
import kotlinx.coroutines.flow.Flow

interface ItemsRepository {
    fun getAllItemsStream(): Flow<List<MovieItem>>
    fun getItemStream(id: Int): Flow<MovieItem?>
    fun isExists(id: Int): Flow<Boolean>
    suspend fun insertItem(item: MovieItem?)
    suspend fun deleteItem(item: MovieItem)
}
