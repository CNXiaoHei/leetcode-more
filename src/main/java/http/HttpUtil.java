package http;


import okhttp3.*;

import java.io.IOException;

/**
 * @Author: Xiaohei
 * @CreateTime: 2022/7/21 23:35
 */
public class HttpUtil {

    public static String post(String url, String bodyParams) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, bodyParams);
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "aliyungf_tc=4ccf83ae430ec779c3c1b7400850839e2fbd2320b93656c6d40bff05b392d2e2; csrftoken=tgdD0liIkKbRtm2Usd1E7X2IlehEK5ejldwDeDvqlqwQdF53Kw2uZ05m4LysXpmV")
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
