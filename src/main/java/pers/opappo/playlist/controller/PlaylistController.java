package pers.opappo.playlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.opappo.playlist.VO.ResultVO;
import pers.opappo.playlist.dataobject.PlaylistInfo;
import pers.opappo.playlist.enums.ResultEnum;
import pers.opappo.playlist.service.PlaylistService;
import pers.opappo.playlist.utils.ResultVOUtil;

import java.util.Map;

/**
 * Created by minghli on 2018/9/19.
 */
@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody Map<String, String> data) {

        PlaylistInfo playlistInfo = new PlaylistInfo();
        //TODO 将前端发来的json对象入库
        playlistInfo.setUserId(Integer.valueOf(data.get("user_id")));
        playlistInfo.setPlaylistName(data.get("playlist_name"));
        playlistInfo.setPid(data.get("pid"));
        playlistInfo.setPlaylistCover(data.get("playlist_cover"));
        playlistInfo.setPlaylistContent(data.get("playlist_content"));

        try {
            playlistService.save(playlistInfo);
            return ResultVOUtil.success("保存歌单", data);
        } catch (Exception e) {
            return ResultVOUtil.error(ResultEnum.PLAYLIST_SAVE_FAILED);
        }



    }
}
