package pers.opappo.playlist.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by minghli on 2018/12/16.
 */
@Data
public class PlaylistDetailVO {

    @JsonProperty("cover")
    private String playlistCover;

    @JsonProperty("content")
    private String playlistContent;

    @JsonProperty("add_time")
    private Date addTime;
}
