package io.github.matthewjones2435.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity (foreignKeys = {
        @ForeignKey(entity = Keyword.class,
            parentColumns =  "keyword_id",
              childColumns =  "output_id")
})

public class Output {

  @PrimaryKey (autoGenerate = true)
  @ColumnInfo(name = "output_id", index = true)
  private long id;
  @ColumnInfo (name = "time_stamp")
  private long timeStamp;
  @ColumnInfo(name="file_name", index = true)
  private String fileName;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

}
