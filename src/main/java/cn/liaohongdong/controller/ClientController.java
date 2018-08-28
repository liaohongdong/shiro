package cn.liaohongdong.controller;

import cn.liaohongdong.dao.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientMapper clientMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("clientList", clientMapper.getAll());
        return "client/list";
    }
}
