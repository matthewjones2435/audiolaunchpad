package io.github.matthewjones2435.viewmodel;

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

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import io.github.matthewjones2435.model.ApiWords;
import io.github.matthewjones2435.service.WordsApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedList;
import java.util.List;

/**
 * View Model Class, currently inoperable and prevents app from building, It is meant to serve as
 * a the holder of the live data received from the RESTful API Datamuse so that after processing
 * it would display a nonsensical haiku in the Haiku Fragemnt {@link io.github.matthewjones2435.HaikuFragment}
 */

//public class HaikuViewModel extends AndroidViewModel  implements LifecycleObserver {
//
//  private MutableLiveData<List<ApiWords>> randomWords;
//  private CompositeDisposable pending = new CompositeDisposable();
//
//  public HaikuViewModel(@NonNull Application application) {
//    super(application);
//  }
//
//  public LiveData<List<ApiWords>> getRandomWords(String query) {
//    if (randomWords == null) {
//      randomWords = new MutableLiveData<>();
//    }
////    if (query != null) {
////      pending.add(
////          WordsApiService.getInstance().randomWords(query)
////              .subscribeOn(Schedulers.io())
////              .observeOn(AndroidSchedulers.mainThread())
////             .subscribe((words) -> randomWords.setValue(words))
////      );
////    } else {
////      randomWords.setValue(new LinkedList<>());
////    }
////
////  }
////  @OnLifecycleEvent(Event.ON_STOP)
////  public void disposePending () {
////    pending.clear();
////  }
//    return randomWords;
//    ]
//}
