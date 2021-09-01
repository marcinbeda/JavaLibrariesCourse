package pl.beda.okHttp;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import lombok.extern.java.Log;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Log
public class DownloadJsonFromApi {

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                log.info(e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String json = response.body().string();
                Type type = new TypeToken<List<Post>>() {
                }.getType();
                List<Post> posts = new Gson().fromJson(json, type);
                log.info(posts.get(0).toString());
            }
        });
        log.info("Program działa dalej.");
    }
}
