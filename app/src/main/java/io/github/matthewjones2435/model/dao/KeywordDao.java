package io.github.matthewjones2435.model.dao;

/*
Copyright [2019] [Matthew Jones]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.github.matthewjones2435.model.Keyword;
import java.util.List;

/**
 * Interface meant to insert words into the keywords data entity {@link Keyword},
 * and query collected from the text edit field in
 * {@link io.github.matthewjones2435.KeywordFragment} and display them in the same
 * fragments list view
 *
 */

@Dao
public interface KeywordDao {

    @Insert
    long insert (Keyword keyword);

    @Query("SELECT * FROM keyword")
    LiveData<List<Keyword>> getAll();

    @Query("SELECT * FROM keyword WHERE keyword_id = :id")
    LiveData<Keyword> findById (long id);

}
