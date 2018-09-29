package pers.opappo.playlist.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * Created by minghli on 2018/9/27.
 */
@Data
public class ResultVO<T> {

    // 状态码
    private Integer code;

    //信息
    private String msg;

    private T data;

}
