package pers.opappo.playlist.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by minghli on 2018/10/16.
 */
@Data
public class PlaylistVO {

    @JsonProperty("name")
    private String playlistName;

    @JsonProperty("pid")
    private String pid;

    @JsonProperty("cover")
    private String playlistCover;

    @JsonProperty("content")
    private String playlistContent;

    @JsonProperty("time")
    private Date createTime;
}
