package cn.liaohongdong.controller.api;

import cn.liaohongdong.common.JsonData;
import cn.liaohongdong.dao.SysMagicMapper;
import cn.liaohongdong.model.SysMagic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/magic")
public class ApiMagicController {

    @Autowired
    private SysMagicMapper sysMagicMapper;

    @CrossOrigin
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonData setMagic(@RequestBody String data) {
        System.out.println(data);
        SysMagic sysMagic = new SysMagic();
        sysMagic.setData(data);
        sysMagic.setId(1);
        int insert = sysMagicMapper.updateByPrimaryKeySelective(sysMagic);
        System.out.println(insert);
        if(insert > 0){
            return JsonData.success("保存成功", 20000);
        }
        return JsonData.fail("保存失败");
    }

    @CrossOrigin
    @RequestMapping(value = "/getMagicIndex")
    @ResponseBody
    public JsonData getMagic(){
        SysMagic sysMagic = sysMagicMapper.selectByPrimaryKey(1);
        return JsonData.success(sysMagic,"",20000);
    }
}
