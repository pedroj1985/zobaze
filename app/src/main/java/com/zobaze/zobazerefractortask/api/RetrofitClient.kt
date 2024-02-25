import android.content.SharedPreferences
import com.zobaze.zobazerefractortask.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    companion object {
        const val BASE_URL = "https://dummy.restapiexample.com/api/v1/"
    }

    private val loggingInterceptor by lazy {
        HttpLoggingInterceptor()
    }

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .callTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)).build()
    }

    private val retrofit by lazy {
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
            .baseUrl(
                BASE_URL
            )
            .build()

    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }


}