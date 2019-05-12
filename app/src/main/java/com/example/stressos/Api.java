package com.example.stressos;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("usersignup")
    Call<DefaultResponse> createUser(
            @Field("user_name") String user_name,
            @Field("password") String password,
            @Field("f_name") String f_name,
            @Field("l_name") String l_name
    );
}
