package pers.opappo.playlist.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.opappo.playlist.dataobject.PlaylistDetail;
import pers.opappo.playlist.enums.ResultEnum;
import pers.opappo.playlist.exception.PlaylistException;
import pers.opappo.playlist.repository.PlaylistDetailRepository;
import pers.opappo.playlist.service.PlaylistDetailService;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by minghli on 2018/12/16.
 */
@Service
public class PlaylistDetailServiceImpl implements PlaylistDetailService {

    @Autowired
    private PlaylistDetailRepository repository;

    @Override
    public PlaylistDetail save(PlaylistDetail playlistDetail) {
        return repository.save(playlistDetail);
    }

    @Override
    public PlaylistDetail findOne(Integer playlistDetailId) {
        PlaylistDetail playlistDetail;
        try {
            playlistDetail = repository.findById(playlistDetailId).get();
        } catch (NoSuchElementException e) {
            throw new PlaylistException(ResultEnum.PLAYLIST_DETAIL_NOT_EXIST);
        }

        return playlistDetail;
    }

    @Override
    public List<PlaylistDetail> findByPlaylistId(Integer playlistId) {
        return repository.findListByPlaylistId(playlistId);
    }

    @Override
    public void deleteOne(Integer playlistDetailId) {
        PlaylistDetail playlistDetail;
        try {
            playlistDetail = repository.findById(playlistDetailId).get();
        } catch (NoSuchElementException e) {
            throw new PlaylistException(ResultEnum.PLAYLIST_DETAIL_NOT_EXIST);
        }
        repository.delete(playlistDetail);
    }

    @Override
    public void deleteList(Integer playlistId) {
        List<PlaylistDetail> playlistDetailList = repository.findListByPlaylistId(playlistId);
        if (playlistDetailList.size() != 0) {
            repository.deleteAll(playlistDetailList);
        }
    }
}
