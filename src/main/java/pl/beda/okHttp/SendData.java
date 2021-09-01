package pl.beda.okHttp;

import lombok.extern.java.Log;
import okhttp3.*;

import java.io.IOException;

@Log
public class SendData {

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        FormBody body = new FormBody.Builder()
                .add("id", "1")
                .add("title", "foo")
                .add("body", "bar")
                .add("userId", "1")
                .build();

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .headers(new Headers.Builder().add("Content-type", "application/json; charset=UTF-8").build())
                .method("PUT", body)
                .build();

        Response response = client.newCall(request).execute();
        log.info(response.body().string());
    }
}
