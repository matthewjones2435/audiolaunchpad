package io.github.matthewjones2435.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Keyword {

  @PrimaryKey (autoGenerate = true)
  @ColumnInfo (name = "keyword_id")
  private long keywordId;

  @ColumnInfo (name = "user_input_one",index = true)
  private String userInputOne;
  @ColumnInfo (name = "user_input_two", index = true)
  private String userInputTwo;


  public String getUserInputOne() {
    return userInputOne;
  }

  public void setUserInputOne(String userInputOne) {
    this.userInputOne = userInputOne;
  }

  public String getUserInputTwo() {
    return userInputTwo;
  }

  public void setUserInputTwo(String userInputTwo) {
    this.userInputTwo = userInputTwo;
  }
}

