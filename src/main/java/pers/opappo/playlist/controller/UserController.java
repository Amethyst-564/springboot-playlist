package pers.opappo.playlist.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.opappo.playlist.VO.ResultVO;
import pers.opappo.playlist.VO.UserDetailVO;
import pers.opappo.playlist.dataobject.UserDetail;
import pers.opappo.playlist.dataobject.UserInfo;
import pers.opappo.playlist.enums.ResultEnum;
import pers.opappo.playlist.service.UserDetailService;
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

    @Autowired
    private UserDetailService userDetailService;

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public ResultVO login(@RequestBody Map<String, String> data) {

        UserInfo userInfo = userInfoService.findUserInfoByUsername(data.get("username"));
        try {
            if (userInfo.getPassword().equals(data.get("password"))) {
                try {
                    userInfoService.updateVisit(userInfo);
                } catch (Exception e) {
                    return ResultVOUtil.error(ResultEnum.UNEXPECTED_ERROR);
                }
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

        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(username);
            userInfo.setPassword(data.get("password"));
            userInfoService.save(userInfo);

            UserDetail userDetail = new UserDetail();
            userDetail.setUserId(userInfo.getUserId());
            userDetail.setUserAlias(username);
            userDetail.setUserIcon("http://oklij0lk2.bkt.clouddn.com/18-12-15/96151682.jpg");
            userDetail.setUserDescription("快来修改你的个性签名吧~");
            userDetailService.save(userDetail);
        } catch (Exception e) {
            return ResultVOUtil.error(ResultEnum.UNEXPECTED_ERROR);
        }

        return ResultVOUtil.success("注册");
    }

    @GetMapping("/detail")
    public ResultVO detail(@RequestParam("username") String username) {

        // 1 从库中查询用户信息
        UserInfo userInfo = userInfoService.findUserInfoByUsername(username);

        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.USER_NOT_EXIST);
        }
        // 2 判断用户状态
        if (userInfo.getUserStatus() != 0) {
            return ResultVOUtil.error(ResultEnum.USER_STATUS_ERROR);
        }

        // 3 查询用户所拥有歌单并拼装
        UserDetail userDetail = userDetailService.findByUserId(userInfo.getUserId());

        // 4. 拼装VO对象
        UserDetailVO userDetailVO = new UserDetailVO();
        userDetailVO.setAlias(userDetail.getUserAlias());
        userDetailVO.setIcon(userDetail.getUserIcon());
        userDetailVO.setDescription(userDetail.getUserDescription());



        return ResultVOUtil.success("查询用户详情", userDetailVO);
    }
}
