package io.github.matthewjones2435.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.github.matthewjones2435.model.Keyword;
import java.util.List;

@Dao
public interface KeywordDao {

    @Insert
    void insert (Keyword keyword);

    @Query("SELECT * FROM keyword")
    LiveData<List<Keyword>> getAll();

    @Query("SELECT * FROM keyword WHERE keyword_id = :id")
    LiveData<Keyword> findById (long id);

}
