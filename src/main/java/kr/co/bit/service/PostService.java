package kr.co.bit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bit.dao.BlogDAO;
import kr.co.bit.dao.CategoryDAO;
import kr.co.bit.dao.PostDAO;
import kr.co.bit.vo.BlogVO;
import kr.co.bit.vo.PostVO;

@Service
public class PostService {
    @Autowired
    PostDAO postDAO;
    @Autowired
    BlogDAO blogDAO;
    @Autowired
    CategoryDAO categoryDAO;

    public Map<String,Object> write(PostVO postVO, String id,int crtPage) {
        postDAO.write(postVO);
        Map<String ,Object> map = new HashMap<String ,Object>();
        map.put("id",id);
        map.put("crtPage",crtPage);
        BlogVO blogVO = blogDAO.getBlog(map);
        List<BlogVO> category = categoryDAO.getCategory(id);
        Map<String ,Object> map1 = new HashMap<String ,Object>();
        map1.put("blog",blogVO);
        map1.put("category",category);
        return map1;
    }
}
