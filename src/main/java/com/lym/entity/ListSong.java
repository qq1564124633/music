package com.lym.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author liyumin
 * @date 2022/08/15 15:03
 * <p>
 * 歌单里面包含歌曲
 */
public class ListSong implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 歌曲id
     */
    private Integer songId;
    /**
     * 歌单id
     */
    private Integer songListId;

    public ListSong() {
    }

    public ListSong(Integer songId, Integer songListId) {
        this.songId = songId;
        this.songListId = songListId;
    }

    public ListSong(Integer id, Integer songId, Integer songListId) {
        this.id = id;
        this.songId = songId;
        this.songListId = songListId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getSongListId() {
        return songListId;
    }

    public void setSongListId(Integer songListId) {
        this.songListId = songListId;
    }

    @Override
    public String toString() {
        return "ListSong{" +
                "id=" + id +
                ", songId=" + songId +
                ", songListId=" + songListId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListSong listSong = (ListSong) o;
        return Objects.equals(id, listSong.id) && Objects.equals(songId, listSong.songId) && Objects.equals(songListId, listSong.songListId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, songId, songListId);
    }
}
