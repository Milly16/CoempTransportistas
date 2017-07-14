package com.coempperu.appmovil.coemptransp.io;

import com.coempperu.appmovil.coemptransp.io.responses.LoginResponse;
import com.coempperu.appmovil.coemptransp.io.responses.UnitsResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyApiService {

//    @GET("diseases")
//    Call<DiseasesResponse> getDiseases();

//    @FormUrlEncoded
//    @POST("upload/photo")
//    Call<SimpleResponse> postPhoto(
//            @Field("image") String base64,
//            @Field("extension") String extension,
//            @Field("user_id") String user_id
//    );

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> getLogin(
        @Field("email") String username,
        @Field("pwd") String password
    );

//    @FormUrlEncoded
//    @POST("product")
//    Call<SimpleResponse> postNewProduct(
//            @Field("code") String code,
//            @Field("name") String name,
//            @Field("description") String description
//    );

    @FormUrlEncoded
    @POST("PostUnits.php")
    Call<UnitsResponse> postNewUnits(
            @Field("tipo") String tipo,
            @Field("marca") String marca,
            @Field("modelo") String modelo,
            @Field("anio") String anio,
            @Field("placatracto") String placatracto,
            @Field("mtctracto") String mtctracto,
            @Field("placacarreta") String placacarreta,
            @Field("mtccarreta") String mtccarreta,
            @Field("color") String color,
            @Field("cilindro") String cilindro,
            @Field("eje") String eje,
            @Field("peso") String peso,
            @Field("carga") String carga,
            @Field("capacidad") String capacidad,
            @Field("soat") String soat,
            @Field("seguro") String seguro,
            @Field("fecha") String fecha,
            @Field("largo") String largo,
            @Field("ancho") String ancho,
            @Field("alto") String alto
    );

}