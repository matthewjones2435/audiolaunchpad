package io.github.matthewjones2435.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import io.github.matthewjones2435.model.dao.KeywordDao;
import io.github.matthewjones2435.model.dao.OutputDao;

@Database(entities = {Keyword.class, Output.class}, version = 1)
public abstract class HaikuDatabase extends RoomDatabase {

  public abstract KeywordDao keywordDao();
  public abstract OutputDao outputDao();


  private static HaikuDatabase INSTANCE;

  public static HaikuDatabase getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
          HaikuDatabase.class, "haiku_database").build();
    }
    return INSTANCE;

  }
}
