package io.github.matthewjones2435;

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

import android.media.MediaDataSource;
import java.io.IOException;


public class MyDataSourceCallback extends MediaDataSource {

  private byte[] byteData;

  public MyDataSourceCallback(byte[] data) {
    byteData = data;

  }

  @Override
  public int readAt(long position, byte[] buffer, int offset, int size) throws IOException {
    int length = byteData.length;

    if(position >= length) {
      return -1;
    }
    if (size == 0) {
      return 0;
    }
    if(position + size > length) {
      size = (int) (length - position);
    }
    System.arraycopy(byteData, (int) position, buffer, offset, size);

    return size;
  }

  @Override
  public long getSize() throws IOException {
    return byteData.length;
  }

  @Override
  public void close() throws IOException {

  }
}
