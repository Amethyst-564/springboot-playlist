package pers.opappo.playlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.opappo.playlist.VO.PlaylistDetailVO;
import pers.opappo.playlist.VO.PlaylistVO;
import pers.opappo.playlist.VO.ResultVO;
import pers.opappo.playlist.dataobject.PlaylistDetail;
import pers.opappo.playlist.dataobject.PlaylistInfo;
import pers.opappo.playlist.dataobject.UserInfo;
import pers.opappo.playlist.enums.ResultEnum;
import pers.opappo.playlist.service.PlaylistDetailService;
import pers.opappo.playlist.service.PlaylistInfoService;
import pers.opappo.playlist.service.UserInfoService;
import pers.opappo.playlist.utils.ResultVOUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by minghli on 2018/9/19.
 */
@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistInfoService playlistInfoService;

    @Autowired
    private PlaylistDetailService playlistDetailService;

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody Map<String, String> data) {

        try {
            Integer playlistId = null;
            // 查询该歌单是否已有
            PlaylistInfo playlistInfoFromDB = playlistInfoService.findByPid(data.get("pid"));

            if (playlistInfoFromDB == null) {
                // 若不存在则写入info表
                PlaylistInfo playlistInfo = new PlaylistInfo();
                playlistInfo.setUserId(Integer.valueOf(data.get("user_id")));
                playlistInfo.setPlaylistName(data.get("playlist_name"));
                playlistInfo.setPid(data.get("pid"));

                playlistInfoService.save(playlistInfo);

                // playlistId为新info生成
                playlistId = playlistInfo.getPlaylistId();
            } else {
                // 若已存在则跳过写入info表，playlistId为库中查出
                playlistId = playlistInfoFromDB.getPlaylistId();
            }

            PlaylistDetail playlistDetail = new PlaylistDetail();
            playlistDetail.setPlaylistId(playlistId);
            playlistDetail.setPlaylistCover(data.get("playlist_cover"));
            playlistDetail.setPlaylistContent(data.get("playlist_content"));

            playlistDetailService.save(playlistDetail);

            return ResultVOUtil.success("保存歌单", data);
        } catch (Exception e) {
            return ResultVOUtil.error(ResultEnum.PLAYLIST_SAVE_FAILED);
        }

    }

    @GetMapping("/list")
    private ResultVO list(@RequestParam("username") String username) {

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
        List<PlaylistInfo> playlistInfoList = playlistInfoService.findByUserId(userInfo.getUserId());

        List<PlaylistVO> playlistVOList = new ArrayList<>();
        for (PlaylistInfo playlistInfo : playlistInfoList) {
            PlaylistVO playlistVO = new PlaylistVO();
            playlistVO.setPlaylistName(playlistInfo.getPlaylistName());
            playlistVO.setPid(playlistInfo.getPid());

            // 拼装歌单详情list
            List<PlaylistDetail> playlistDetailList = playlistDetailService.findByPlaylistId(playlistInfo.getPlaylistId());

            List<PlaylistDetailVO> playlistDetailVOList = new ArrayList<>();
            for (PlaylistDetail playlistDetail : playlistDetailList) {
                PlaylistDetailVO playlistDetailVO = new PlaylistDetailVO();
                playlistDetailVO.setPlaylistCover(playlistDetail.getPlaylistCover());
                playlistDetailVO.setPlaylistContent(playlistDetail.getPlaylistContent());

                playlistDetailVOList.add(playlistDetailVO);
            }
            playlistVO.setPlaylistDetailVOList(playlistDetailVOList);

            playlistVOList.add(playlistVO);
        }


        return ResultVOUtil.success("查询用户歌单", playlistVOList);
    }
}
