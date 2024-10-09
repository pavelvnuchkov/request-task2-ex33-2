import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.sound.midi.Patch;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public final static String KEY_NASA = "9ndAT926G7QlFPfIid73nBngWd747nYhTyADCYuF";

    public static void main(String[] args) {
        connect();

    }

    public static void connect() {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom().
                        setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=" + KEY_NASA);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            ObjectMapper mapper = new ObjectMapper();
            Answer answer = mapper.readValue(response.getEntity().getContent().readAllBytes(), new TypeReference<Answer>() {
            });

            String nameFile = answer.getUrl().substring(answer.getUrl().lastIndexOf('/') + 1, answer.getUrl().length());

            try (InputStream inputStream = new URL(answer.getUrl()).openStream()) {

                Files.copy(inputStream, Path.of(nameFile), StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
