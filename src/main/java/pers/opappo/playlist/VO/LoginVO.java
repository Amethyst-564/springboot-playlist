package pers.opappo.playlist.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by minghli on 2018/9/25.
 */
@Data
public class LoginVO {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
}
