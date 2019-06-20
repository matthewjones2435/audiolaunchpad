package io.github.matthewjones2435.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity (primaryKeys = {"keyword" },
                        indices = {@Index("user_input_one"), @Index("user_index_two")},
                        foreignKeys = {
                        @ForeignKey(entity = Keyword.class,
                            parentColumns =  "keyword_one",
                              childColumns =  "keyword_id")
})


public class Output {


  @ColumnInfo(name = "output_id", index = true)
  private long outputId;
  @ColumnInfo (name = "time_stamp")
  private long timeStamp;
  @ColumnInfo(name="file_name", index = true)
  private String fileName;

  public long getOutputId() {
    return outputId;
  }

  public void setOutputId(long outputId) {
    this.outputId = outputId;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public long getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
  }
}
