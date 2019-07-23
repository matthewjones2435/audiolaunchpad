package io.github.matthewjones2435.model;

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

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import io.github.matthewjones2435.model.dao.KeywordDao;
import io.github.matthewjones2435.model.dao.OutputDao;

/**
 * Creates Instance of the Room Persistance Database for the app, to store
 * keywords {@link Keyword} and output {@link Output} information.
 */

@Database(entities = {Keyword.class, Output.class}, version = 1)
public abstract class HaikuDatabase extends RoomDatabase {

  public abstract KeywordDao keywordDao();
  public abstract OutputDao outputDao();


  private static HaikuDatabase INSTANCE;

  /**
   * Creates the database Instance
   * @param context
   * @return Instance of database
   */

  public static HaikuDatabase getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
          HaikuDatabase.class, "haiku_database").build();
    }
    return INSTANCE;

  }
}
