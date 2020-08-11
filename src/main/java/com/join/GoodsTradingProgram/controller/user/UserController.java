package com.join.GoodsTradingProgram.controller.user;

import com.baidu.aip.ocr.AipOcr;
import com.join.GoodsTradingProgram.config.BaiduConfig;
import com.join.GoodsTradingProgram.entity.user.User;
import com.join.GoodsTradingProgram.service.userService.UserService;
import com.join.GoodsTradingProgram.utils.Idcard.IdcardUtils;
import com.join.GoodsTradingProgram.utils.img.ImgUploadUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Liulq
 * @Description:
 * @Date: 21:40 2020/5/9
 */
@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/list")
    public List<User> listUser()throws Exception{
        return userService.listUser();
    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public User login(User user)throws Exception{
        User user1 = userService.login(user);
//        int a=1;
//        if (user1 == null){
//            a=0;
//            return a;
//        }
//        else {
//            return a;
//        }
        return user1;
    }

    @ResponseBody
    @RequestMapping(value = "/register")
    public int register(User user)throws Exception{
        User user1 = userService.selectUserMessage(user);
        int b=0;
        if (user1 == null){
            Integer a = userService.register(user);
            if (a == 1){
                b=1;
            }
        }
        return b;
    }

    @ResponseBody
    @RequestMapping(value = "/delUser")
    public int delUser(int id)throws Exception{
        return userService.delUser(id);
    }

    @ResponseBody
    @RequestMapping(value = "/updateUser")
    public int updateUser(User user)throws Exception{
        return userService.updateUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadHead")
    public int uploadHead(int id,@RequestParam(value = "file") MultipartFile file)throws Exception{
        ImgUploadUtil imgUploadUtil=new ImgUploadUtil();
        if(file.isEmpty()){
            return 0;
        }
        String filename=null;
        String path="/yfn/user/"+id+"_";
        String picUrl="/img/user/"+id+"_";
//            String path="e:/yfn/good/"+id+"_";
//            String picUrl="/img/good/"+id+"_";
        filename=imgUploadUtil.imgUpload(file,path);
        return userService.uploadHead(id,picUrl+filename);
    }
    @ResponseBody
    @RequestMapping(value = "/recognize")
    public JSONObject recognize(User user)throws Exception{
        AipOcr client = new AipOcr(BaiduConfig.APP_ID, BaiduConfig.API_KEY, BaiduConfig.SECRET_KEY);
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("probability", "true");

        // 参数为本地图片路径
        String image = user.getFileurl();//身份证照片路径
        return client.basicAccurateGeneral(image, options);

        // 参数为本地图片二进制数组
//        byte[] file = IdcardUtils.readImageFile(image);
//        JASONObject res = client.basicAccurateGeneral(file, options);
//        System.out.println(res.toString(2));
    }

}
