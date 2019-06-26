package io.github.matthewjones2435.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.github.matthewjones2435.model.Output;
import java.util.List;

@Dao
public interface OutputDao {

  @Insert
  long insert (Output output);

  @Query("SELECT * FROM output")
  LiveData<List<Output>> getAll();
}
