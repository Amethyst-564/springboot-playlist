package pers.opappo.playlist.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by minghli on 2018/12/15.
 */
@Data
public class UserDetailVO {

    @JsonProperty("user_alias")
    private String alias;

    @JsonProperty("user_icon")
    private String icon;

    @JsonProperty("user_description")
    private String description;

}
