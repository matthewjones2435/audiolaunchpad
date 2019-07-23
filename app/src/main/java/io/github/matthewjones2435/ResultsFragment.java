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

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;


/**
 * The results fragment class is in a skeletal state as of currently
 * it would be where after the collection of haiku string, {@link HaikuFragment}
 * and conversion processing the midi file would be played through {@link MediaPlayer}
 * as a byte array
 */
public class ResultsFragment extends Fragment {


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.fragment_results, container, false);
    return view;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);



    /* Credit to Thomas Showers via Stack Overflow for mapping out the byte array according to
    how it would be read according to midi specifications.
     */
    byte[] midiBytes = new byte[]{

        'M', 'T', 'h', 'd',         // Chunk type HEADER ({77, 84, 104, 100})
        0, 0, 0, 6,                 // Chunk data length
        0, 0,                       // File format 0
        0, 1,                       // Number of tracks 1
        0x01, (byte) 0xE0,          // Division 480 (0x01E0, { 1, -32 })

        // TRACK DATA
        'M', 'T', 'r', 'k',         // Chunk type TRACK ({77, 84, 114, 107})
        0, 0, 0, 12,                // Chunk data length

        // Events
        0,                          // Zero delta for note on start
        (byte)(0x90 | 0x00),        // Note On status / channel 0
        52,                         // Note number 52 (E3)
        80,                         // Velocity 80 (range 0-127)

        (byte) 0x8F, 0x0,           // 1920 tick delta (480 x 4) Variable Length Quantity
        // Skip byte for running status
        52,                         // Note number 52 (E3)
        0,                          // Velocity 0 (effective note off)

        0,                          // Zero delta (since note off)
        (byte) 0xFF, 0x2F, 0x0      // End track event
    };

    MediaPlayer mediaPlayer = new MediaPlayer();

    mediaPlayer.setDataSource(new MyDataSourceCallback(midiBytes));
    }
  }



