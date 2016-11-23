package com.example.lee.retrofittotask;

import android.util.Log;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by lee on 2016/11/21.
 */

public class UpLoad {
    private static final String ENDPOINT = "http://192.168.0.19:8000/";
    public interface UploadService {
        /**
         * 上傳一組資料
         *
         * @param description
         * @param imgs
         * @return
         */
        @Multipart
        @POST("task/")
        Call<ResponseBody> upload(@Part("task_name") RequestBody name,
                                  @Part("task_desc") RequestBody desc,
                                  @Part MultipartBody.Part image);
    }
    // Retrofit實例化，注意這裡是private static final
    private static final Retrofit sRetrofit = new Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    // 生成代理物件 apiManager
    private static final UploadService apiManager = sRetrofit.create(UploadService.class);

    // 使用ResponseBody的泛型方法upload
    public static void uploadData(String task_name, String task_desc) throws IOException {
        MediaType textType = MediaType.parse("text/plain");
        RequestBody name = RequestBody.create(textType, task_name);
        RequestBody desc = RequestBody.create(textType, task_desc);
        RequestBody img = RequestBody.create(MediaType.parse("application/octet-stream"),
                new File("/storage/sdcard0/DCIM/100MEDIA/IMAG0002.jpg"));
        MultipartBody.Part image = MultipartBody.Part.createFormData("file", "IMAG0002.jpg", img);
        Call<ResponseBody> call = apiManager.upload(name, desc, image);

//        call.execute();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("Response body: ",response.body().toString());
                MainActivity.textView.setText(response.message());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }



        });

    }
}
