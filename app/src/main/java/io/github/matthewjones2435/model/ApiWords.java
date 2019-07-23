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


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * POJO class to collect information from REST API Datamuse
 */

public class ApiWords {

  @SerializedName("word")
  @Expose
  private String word;
  @SerializedName("score")
  @Expose
  private Long score;
  @SerializedName("tags")
  @Expose
  private List<String> tags = null;

  /**
   * Get method for collection of words from response JSON object from Datamuse Rest API
   * @return word as string
   */
  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public Long getScore() {
    return score;
  }

  public void setScore(Long score) {
    this.score = score;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  /**
   * Overide to return the collected words as a string
   * @return String.format(word)
   */
  @Override
  public String toString() {
    return String.format(word);
  }
}
