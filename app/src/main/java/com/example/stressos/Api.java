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

    @FormUrlEncoded
    @POST("userlogin")
    Call<UserNameResponse> userlogin(
            @Field("user_name") String user_name,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("insertparent")
    Call<ParentResponse> insertparent(
            @Field("user_name") String user_name,
            @Field("password") String password,
            @Field("first_name") String first_name,
            @Field("last_name") String last_name
    );

    @FormUrlEncoded
    @POST("getuserparents")
    Call<ParentResponse> getuserparents(
            @Field("user_name") String user_name
    );

    @FormUrlEncoded
    @POST("insertshift")
    Call<ParentResponse> insertshift(
            @Field("parent_id") int parent_id,
            @Field("start_time") String start_time,
            @Field("end_time") String end_time,
            @Field("date") String date
    );
}
