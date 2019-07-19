package io.github.matthewjones2435.service;

import io.github.matthewjones2435.BuildConfig;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WordsApiService {

  @GET("words")
  Observable<List<String>> randomWords(@Query("?ml=") String userText) ;


  static WordsApiService getInstance() {
    return InstanceHolder.INSTANCE;
  }
  class InstanceHolder {

    private static final WordsApiService INSTANCE;

    static {
      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(BuildConfig.BASE_URL)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .build();
      INSTANCE = retrofit.create(WordsApiService.class);
    }
  }
}
