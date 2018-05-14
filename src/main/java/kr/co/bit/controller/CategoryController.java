package kr.co.bit.controller;

import kr.co.bit.service.BlogService;
import kr.co.bit.service.CategoryService;
import kr.co.bit.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/{id}/admin/category", method = RequestMethod.GET)
    public String categoryManagementPage(@PathVariable String id, Model model,@RequestParam (value = "crtPage",required=false,defaultValue = "1")int crtPage) {
        Map map = blogService.getMain(id,crtPage);
        model.addAttribute("map", map);
        return "blog/admin/blog-admin-cate";
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/admin/category/getList", method = RequestMethod.POST)
    public List<CategoryVO> getList(@PathVariable String id) {
        return categoryService.getList(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/admin/category/insert", method = RequestMethod.POST)
    public CategoryVO insert(@ModelAttribute CategoryVO categoryVO,@PathVariable String id) {
        System.out.println("아작스인서트 출발");
        return categoryService.insert(categoryVO);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/admin/category/delete",method = RequestMethod.POST)
    public int delete(@PathVariable String id, @RequestParam int cateNo){
        System.out.println("아작스 삭제하러 출발");
        return categoryService.delete(id,cateNo);
    }
}
