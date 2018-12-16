package pers.opappo.playlist.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by minghli on 2018/10/16.
 */
@Data
public class PlaylistVO {

    @JsonProperty("playlist_id")
    private Integer playlistId;

    @JsonProperty("name")
    private String playlistName;

    @JsonProperty("pid")
    private String pid;

    @JsonProperty("detail")
    private List<PlaylistDetailVO> playlistDetailVOList;

}
