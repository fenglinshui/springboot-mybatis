package conoha.service;

import conoha.model.PixivImage;

import java.util.List;

/**
 * Created by caoshibin on 2017/1/23.
 */
public interface PixivImageService {
    public List<Integer> getAllId();

    public List<PixivImage> getPixivImagesByIds(List<Integer> list);

    public int updatePixivImage(PixivImage pixivImage);
}
