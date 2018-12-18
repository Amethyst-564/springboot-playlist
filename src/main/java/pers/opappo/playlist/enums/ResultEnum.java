package pers.opappo.playlist.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),
    PASSWORD_INCORRECT(1001, "密码不正确"),
    USER_NOT_EXIST(1002, "用户不存在"),
    USER_IS_EXISTED(1003, "用户名已存在"),
    USER_STATUS_ERROR(1004, "用户状态异常"),
    PLAYLIST_SAVE_FAILED(2001, "歌单保存失败"),
    PLAYLIST_INFO_NOT_EXIST(2002, "该歌单信息不存在"),
    PLAYLIST_DETAIL_NOT_EXIST(2003, "该歌单详情不存在"),
    DELETE_PLAYLIST_INFO_FAILED(2004, "删除歌单信息失败"),
    DELETE_PLAYLIST_DETAIL_FAILED(2005, "删除歌单详情失败"),
    UPLOAD_FAILED(3001, "上传失败"),
    UNEXPECTED_ERROR(5000, "未知错误")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
