package pers.opappo.playlist.enums;

import lombok.Getter;

@Getter
public enum UserStatusEnum {

    NORMAL(0, "正常"),
    DISABLED(1, "禁止")
    ;

    private Integer code;

    private String message;

    UserStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
