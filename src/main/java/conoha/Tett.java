package conoha;

import conoha.service.PixivImageService;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by caoshibin on 2017/10/28.
 */
@RestController
public class Tett {
    private List<Integer> idList = null;
    @Resource
    private PixivImageService pixivImageService;

    @RequestMapping("/hello")
    public String index() {
        System.out.println("index");
//        pixivImageService =new PixivImageServiceImpl();
        idList = pixivImageService.getAllId();
//        for(int a:idList){
//            System.out.println(a);
//        }
        JSONArray jsonObject = JSONArray.fromObject(idList);
        return jsonObject.toString();
    }
}
