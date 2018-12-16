package pers.opappo.playlist.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.opappo.playlist.dataobject.PlaylistInfo;
import pers.opappo.playlist.enums.ResultEnum;
import pers.opappo.playlist.exception.PlaylistException;
import pers.opappo.playlist.repository.PlaylistInfoRepository;
import pers.opappo.playlist.service.PlaylistInfoService;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by minghli on 2018/9/30.
 */
@Service
public class PlaylistInfoServiceImpl implements PlaylistInfoService {

    @Autowired
    PlaylistInfoRepository repository;

    @Override
    public PlaylistInfo findOne(Integer playlistId) {
        PlaylistInfo playlistInfo;
        try {
            playlistInfo = repository.findById(playlistId).get();
        } catch (NoSuchElementException e) {
            throw new PlaylistException(ResultEnum.PLAYLIST_INFO_NOT_EXIST);
        }

        return playlistInfo;
    }

    @Override
    public PlaylistInfo save(PlaylistInfo playlistInfo) {
        return repository.save(playlistInfo);
    }

    @Override
    public List<PlaylistInfo> findByUserId(Integer userId) {

        return repository.findByUserId(userId);
    }

    @Override
    public PlaylistInfo findByPid(String pid) {
        return repository.findByPid(pid);
    }
}
