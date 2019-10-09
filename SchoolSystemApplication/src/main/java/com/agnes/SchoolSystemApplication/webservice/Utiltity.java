package com.agnes.SchoolSystemApplication.webservice;

import com.google.gson.Gson;
import com.squareup.okhttp.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Utiltity {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public String findStudent(String registrationNumber, String url) throws IOException {
        // code request code here
        Map<String,String> map=new HashMap<>();
        map.put("registrationNumber",registrationNumber);
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON,new Gson().toJson(map));
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();

    }

}
