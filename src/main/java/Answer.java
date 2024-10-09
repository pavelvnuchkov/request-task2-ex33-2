import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.crypto.Data;

public class Answer {
    private String copyright;
    private String date;
    private String explanation;
    private String hdUrl;
    private String mediaType;
    private String service_version;
    private String title;
    private String url;

    public Answer(@JsonProperty("copyright") String copyright,
                  @JsonProperty("date") String date,
                  @JsonProperty("explanation") String explanation,
                  @JsonProperty("hdurl") String hdUrl,
                  @JsonProperty("media_type") String mediaType,
                  @JsonProperty("service_version") String service_version,
                  @JsonProperty("title") String title,
                  @JsonProperty("url") String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdUrl = hdUrl;
        this.mediaType = mediaType;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdUrl() {
        return hdUrl;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getService_version() {
        return service_version;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "copyright='" + copyright + '\'' + "\n" +
                ", date=" + date + "\n" +
                ", explanation='" + explanation + '\'' + "\n" +
                ", hdUrl='" + hdUrl + '\'' + "\n" +
                ", mediaType='" + mediaType + '\'' + "\n" +
                ", service_version='" + service_version + '\'' + "\n" +
                ", title='" + title + '\'' + "\n" +
                ", url='" + url + '\'' + "\n" +
                '}';
    }
}
