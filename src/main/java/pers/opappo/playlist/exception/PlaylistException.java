package pers.opappo.playlist.exception;

import lombok.Getter;
import pers.opappo.playlist.enums.ResultEnum;

/**
 * Created by minghli on 2018/12/16.
 */
@Getter
public class PlaylistException extends RuntimeException {

    private Integer code;

    public PlaylistException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public PlaylistException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
