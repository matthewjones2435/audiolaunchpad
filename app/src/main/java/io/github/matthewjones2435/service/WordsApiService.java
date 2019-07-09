package io.github.matthewjones2435.service;

import io.github.matthewjones2435.BuildConfig;
import io.github.matthewjones2435.model.ApiWords;
import io.reactivex.Single;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface WordsApiService {

  @GET("words/?random=true")
  Single<List<ApiWords>> randomWords();

  static WordsApiService getInstance(){
    return InstanceHolder.INSTANCE;
  }

  class InstanceHolder {

    private static final WordsApiService INSTANCE;

    static {
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build();

      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(BuildConfig.BASE_URL)
          .client(client)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .build();
      INSTANCE = retrofit.create(WordsApiService.class);
    }
  }
}
