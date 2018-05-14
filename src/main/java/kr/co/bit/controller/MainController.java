package kr.co.bit.controller;

import kr.co.bit.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class MainController {
    @Autowired
    BlogService blogService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String main(Model model) {
        System.out.println("메인 들어옴");
        model.addAttribute("check","check");
        return "main/index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchKWD(@RequestParam String keyword, @RequestParam String which, Model model) {
        Map<String, Object> map = blogService.searchKWD(keyword, which);
        model.addAttribute("map", map);
        return "main/index";
    }
}
