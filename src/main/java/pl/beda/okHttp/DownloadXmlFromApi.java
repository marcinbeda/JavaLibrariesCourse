package pl.beda.okHttp;

import lombok.extern.java.Log;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;

@Log
public class DownloadXmlFromApi {

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://www.w3schools.com/xml/note.xml")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                log.info(e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String xml = response.body().string();

                Serializer serializer = new Persister();
                try {
                    Note note = serializer.read(Note.class, xml);
                    log.info(note.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        log.info("Program działa dalej.");
    }
}
