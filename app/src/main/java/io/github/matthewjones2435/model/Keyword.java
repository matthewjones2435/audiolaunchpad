package io.github.matthewjones2435.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity
public class Keyword {

  @PrimaryKey (autoGenerate = true)
  @ColumnInfo (name = "keyword_id")
  private long id;
  @ColumnInfo (name = "user_input_one",index = true)
  private String userInputOne;
  @ColumnInfo (name = "user_input_two", index = true)
  private String userInputTwo;
  @ColumnInfo (name = "aggregate_word", index = true)
  private String aggregateWord;

  public String getAggregateWord() {
    return aggregateWord;
  }

  public void setAggregateWord(String aggregateWord) {
    this.aggregateWord = aggregateWord;
  }

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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}

