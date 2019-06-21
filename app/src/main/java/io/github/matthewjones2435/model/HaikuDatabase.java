package io.github.matthewjones2435.model;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Keyword.class, Output.class}, version = 1)
public abstract class HaikuDatabase extends RoomDatabase {

  private static HaikuDatabase INSTANCE;

  public static HaikuDatabase getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
          HaikuDatabase.class, "output_aggregate").build();
    }
    return INSTANCE;

  }
}
