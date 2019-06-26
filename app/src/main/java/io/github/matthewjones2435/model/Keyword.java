package io.github.matthewjones2435.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity
public class Keyword {

  @PrimaryKey (autoGenerate = true)
  @ColumnInfo (name = "keyword_id")
  private long id;
  @ColumnInfo (name = "user_input_keyword",index = true)
  private String userInput;
  @ColumnInfo (name = "haiku", index = true)
  private String haiku;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getHaiku() {
    return haiku;
  }

  public void setHaiku(String haiku) {
    this.haiku = haiku;
  }

  public String getUserInput() {
    return userInput;
  }

  public void setUserInput(String userInput) {
    this.userInput = userInput;
  }

  @NonNull
  @Override
  public String toString() {
    return userInput;
  }
}

