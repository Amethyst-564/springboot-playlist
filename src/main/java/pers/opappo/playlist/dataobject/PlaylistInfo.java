package pers.opappo.playlist.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by minghli on 2018/9/30.
 */
@Entity
@Data
@DynamicUpdate
public class PlaylistInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playlistId;

    // 用户id
    private Integer userId;

    // 歌单名
    private String playlistName;

    // 网易歌单id
    private String pid;

    // 封面
    private String playlistCover;

    // 详情id
    private String playlistContent;

    private Date createTime;

    private Date updateTime;
}
