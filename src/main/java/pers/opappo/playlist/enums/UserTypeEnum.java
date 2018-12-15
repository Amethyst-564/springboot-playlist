package pers.opappo.playlist.enums;

import lombok.Getter;

@Getter
public enum UserTypeEnum {

    NORMAL(0, "普通用户"),
    ADMIN(1, "管理员");

    private Integer code;

    private String message;

    UserTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}