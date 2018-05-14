package kr.co.bit.controller;

import kr.co.bit.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
@RequestMapping(value = "/{id}")
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String blogMain(@PathVariable String id, @RequestParam(value = "crtPage", required = false, defaultValue = "1") int crtPage, Model model) {
        System.out.println("블로그 메인으로 ㄱㄱ");
        Map map = blogService.getMain(id, crtPage);
        model.addAttribute("map", map);
        System.out.println("블로그에 필요한거 다 가지고 나왔냐");
        System.out.println(map.get("post").toString());
        return "blog/blog-main";
    }

    @RequestMapping(value = "/mainPage", method = RequestMethod.GET)
    public String mainPage(@PathVariable String id, @RequestParam(value = "postNo", required = false, defaultValue = "1") int postNo, @RequestParam(value = "cateNo", required = false, defaultValue = "1") int cateNo, @RequestParam(value = "crtPage", required = false, defaultValue = "1") int crtPage, Model model) {
        Map<String, Object> map = blogService.mainPage(id, postNo, cateNo, crtPage);
        map.put("cateNo",cateNo);
        model.addAttribute("map", map);
        return "blog/blog-main";
    }

    @RequestMapping(value = "/admin/basic", method = RequestMethod.GET)
    public String managementPage(@PathVariable String id ,Model model) {
        Map<String, Object> map = blogService.getManagementPage(id);
        model.addAttribute("map", map);
        return "blog/admin/blog-admin-basic";
    }

    @RequestMapping(value = "/blogupdate", method = RequestMethod.POST)
    public String blogUpdate(@RequestParam String blogTitle, @PathVariable String id, @RequestParam("file") MultipartFile multipartFile) {
        blogService.blogUpdate(blogTitle, id, multipartFile);
        return "redirect:/" + id;
    }

}
