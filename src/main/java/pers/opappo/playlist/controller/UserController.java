package pers.opappo.playlist.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.opappo.playlist.VO.ResultVO;
import pers.opappo.playlist.dataobject.UserInfo;
import pers.opappo.playlist.enums.ResultEnum;
import pers.opappo.playlist.service.UserInfoService;
import pers.opappo.playlist.utils.ResultVOUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by minghli on 2018/9/25.
 */

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public ResultVO login(@RequestBody Map<String, String> data) {

        UserInfo userInfo = userInfoService.findUserInfoByUsername(data.get("username"));
        try {
            if (userInfo.getPassword().equals(data.get("password"))) {
                Map<String, Integer> userObj = new HashMap<>();
                userObj.put("user_id", userInfo.getUserId());
                return ResultVOUtil.success("登陆", userObj);

            } else {
                return ResultVOUtil.error(ResultEnum.PASSWORD_INCORRECT);

            }

        } catch (NullPointerException e) {
            return ResultVOUtil.error(ResultEnum.USER_NOT_EXIST);
        }

    }

    @PostMapping(value = "/logon", produces = "application/json;charset=UTF-8")
    public ResultVO logon(@RequestBody Map<String, String> data) {

        String username = data.get("username");

        if (userInfoService.findUserInfoByUsername(username) != null) {
            return ResultVOUtil.error(ResultEnum.USER_IS_EXISTED);
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(data.get("password"));

        userInfoService.save(userInfo);

        return ResultVOUtil.success("注册");
    }
}
