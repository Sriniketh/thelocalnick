package booboo.thelocalnick.networkutils

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class HttpClient {

    private var mRestService: Retrofit? = null

    fun getClient(url:String): Retrofit {
        if (mRestService == null) {
            val client = OkHttpClient().newBuilder().addInterceptor (HttpInterceptor()).build()
            // ***YOUR CUSTOM INTERCEPTOR GOES HERE***
            //client.interceptors().add(HttpInterceptor())

            val retrofit = Retrofit.Builder()
                    // Using custom GSON Converter to parse JSON
                    // Add dependencies
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(url)
                    // Endpoint
                    .client(client)
                    .build()
            mRestService = retrofit
        }
        return mRestService!!
    }


}