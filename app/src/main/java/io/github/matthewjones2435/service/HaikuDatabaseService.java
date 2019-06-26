package io.github.matthewjones2435.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class HaikuDatabaseService extends SQLiteOpenHelper {

  public HaikuDatabaseService(@Nullable Context context) {
    super(context, "Output.db",
        null, 1);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {

      db.execSQL("CREATE TABLE Output ("
          + "id LONG PRIMARY KEY, "
          + "Keyword TEXT, "
          + "Filename TEXT, "
          + "Haiku TEXT, "
          + "Timestamp LONG,"
          + "");

    }


    @Override
    public void onUpgrade (SQLiteDatabase db,int oldVersion, int newVersion){
      // Do nothing.

    }

}
