package com.ccl.yuedu.request.util;


import android.support.annotation.NonNull;

import com.ccl.yuedu.constans.Domain;
import com.ccl.yuedu.request.OnSendRequestListener;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by chencanlin on 2018/9/25 17:34
 */
public class HttpUtil {

    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Domain.DOMAIN)
//                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getRetrofit(String host) {
        return new Retrofit.Builder()
                .baseUrl(host)
//                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static <T> T createApi(Class<T> t) {
        return getRetrofit().create(t);
    }

    public static <T> T createApi(Class<T> t, String host) {
        return getRetrofit(host).create(t);
    }

    /*
     * 发送异步请求
     * */
    public static void sendRequest(Call<ResponseBody> call, final OnSendRequestListener onSendRequestListener) {
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                System.out.println(response.toString());
                try {
                    if (onSendRequestListener != null) {
                        if (!call.isCanceled()) {
                            if (response.isSuccessful()) {
                                ResponseBody body = response.body();
                                onSendRequestListener.onSucceed(body == null ? "" : body.string());
                            } else {
                                onSendRequestListener.onFailed(response.errorBody() == null ? "" : response.errorBody().string());
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                System.out.println(t.getMessage());
                if (onSendRequestListener != null) {
                    if (!call.isCanceled()) {
                        onSendRequestListener.onFailed(t.getMessage());
                    }
                }
            }
        });
    }

    /*
     * 发送同步请求
     * */
    public static void sendSyncRequest(final Call<ResponseBody> call, final OnSendRequestListener onSendRequestListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<ResponseBody> response = call.execute();
                    if (onSendRequestListener != null) {
                        if (!call.isCanceled()) {
                            if (response.isSuccessful()) {
                                ResponseBody body = response.body();
                                onSendRequestListener.onSucceed(body == null ? "" : body.string());
                            } else {
                                onSendRequestListener.onFailed(response.errorBody() == null ? "" : response.errorBody().string());
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
