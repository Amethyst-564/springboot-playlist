package pers.opappo.playlist.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),
    PASSWORD_INCORRECT(1001, "密码不正确"),
    USER_NOT_EXIST(1002, "用户不存在"),
    USER_IS_EXISTED(1003, "用户名已存在"),
    UPLOAD_FAILED(1004, "上传失败"),
    PLAYLIST_SAVE_FAILED(1005, "歌单保存失败"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
