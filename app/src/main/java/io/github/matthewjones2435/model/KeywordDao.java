package io.github.matthewjones2435.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

public class KeywordDao {

  @Dao
  public interface OutputDao {

    @Insert
    long insert (Keyword keyword);
    @Query("SELECT * FROM keyword")
    LiveData<List<Keyword>> getAll();
  }

}
