package pers.opappo.playlist.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by minghli on 2018/12/16.
 */
@Entity
@Data
@DynamicUpdate
public class PlaylistDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playlistDetailId;

    private Integer playlistId;

    // 封面
    private String playlistCover;

    // 详情id
    private String playlistContent;

    // 添加时间
    private Date addTime;
}
