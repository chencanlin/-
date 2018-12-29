package com.ccl.yuedu.request.request;


import com.ccl.yuedu.request.constant.Urls;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by chencanlin on 2018/9/25 15:51
 */
public interface CommonServiceApi {

    /*// 接口请求测试
    @GET(Urls.test_interface)
    Call<ResponseBody> qqLoginGetUserInfo();

    @FormUrlEncoded
    @Headers("Cookie:ZHBSESSID=d71d355c19fef3098b54e5d3aed30de5")
    @POST(Urls.test_interface_two)
    Call<ResponseBody> requestTest(@FieldMap Map<String, String> car_model_no);
*/
    /*@FormUrlEncoded
    @POST(Urls.SEND_SMS_INFO)
    Call<ResponseBody> sendSmsInfo(@FieldMap Map<String, String> smsInfoMap);*/

    /*@Multipart
    @POST("upload")
    Call<ResponseBody> upload(@Part("description") RequestBody description,
                              @Part MultipartBody.Part file);

    RequestBody requestFile =
            RequestBody.create(MediaType.parse("multipart/form-data"), file);

    // MultipartBody.Part  和后端约定好Key，这里的partName是用image
    MultipartBody.Part body =
            MultipartBody.Part.createFormData("image", file.getName(), requestFile);

    // 添加描述
    String descriptionString = "hello, 这是文件描述";
    RequestBody description =
            RequestBody.create(
                    MediaType.parse("multipart/form-data"), descriptionString);

    // 执行请求
    Call<ResponseBody> call = service.upload(description, body);*/

    /*@POST()
    Call<ResponseBody> upLoad(
            @Url() String url,
            @Body RequestBody Body);

    //构建body
    RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
            .addFormDataPart("name", name)
            .addFormDataPart("name", psd)
            .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("image/*"), file))
            .build();

    Call<ResponseBody> call = service.upload(url, requestBody );*/

    //    @FormUrlEncoded
//    @Headers("Content-type:application/json;charset=utf-8")

    @GET(Urls.GET_QQ_USER_INFO)
    Call<ResponseBody> qqLoginGetUserInfo(@Query("oauth_consumer_key") String appId, @Query("access_token") String accessToken, @Query("openid") String openId, @Query("format") String format);

    @GET(Urls.GET_BOOK_ALL_CATEGORY)
    Call<ResponseBody> getBookAllCategory();

    @GET(Urls.GET_BOOK_LIST_BY_CATEGORY)
    Call<ResponseBody> getBookListByCategory(@QueryMap Map<String, String> paramsMap);

    @GET(Urls.GET_BOOK_DETAIL)
    Call<ResponseBody> getBookDetail(@Path(value = "bookId") String bookId);
}
