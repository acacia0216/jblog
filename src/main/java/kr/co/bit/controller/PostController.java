package kr.co.bit.controller;

import kr.co.bit.service.BlogService;
import kr.co.bit.service.PostService;
import kr.co.bit.vo.BlogVO;
import kr.co.bit.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/{id}/admin/writeform",method = RequestMethod.GET)
    public String writeform(@PathVariable String id, Model model,@RequestParam(value = "crtPage",required=false,defaultValue = "1")int crtPage){
        Map<String,Object> map = blogService.getMain(id,crtPage);
        model.addAttribute("map", map);
        return "blog/admin/blog-admin-write";
    }

    @RequestMapping(value = "/{id}/admin/write",method = RequestMethod.POST)
    public String write(@PathVariable String id,@ModelAttribute PostVO postVO,Model model,@RequestParam(value = "crtPage",required=false,defaultValue = "1") int crtPage){
        System.out.println("포스트 인서트 출발");
        System.out.println(postVO.toString());
        Map<String,Object> map = postService.write(postVO,id,crtPage);
        System.out.println("포스트 입력하고 도착");
        model.addAttribute("map",map);
        return "blog/admin/blog-admin-write";
    }
}
