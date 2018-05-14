package kr.co.bit.service;

import kr.co.bit.dao.BlogDAO;
import kr.co.bit.dao.CategoryDAO;
import kr.co.bit.dao.PostDAO;
import kr.co.bit.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    BlogDAO blogDAO;
    @Autowired
    PostDAO postDAO;

    public List<CategoryVO> getList(String id) {
        List<CategoryVO> list = categoryDAO.getList(id);
        for (CategoryVO a : list) {
            int cateNo = a.getCateNo();
            System.out.println("카테고리 번호 : " + cateNo);
            int postCount = postDAO.postCount(cateNo);
            a.setPostCount(postCount);
        }
        for (CategoryVO b : list) {
            System.out.println(b.toString());
        }
        return list;
    }

    public CategoryVO insert(CategoryVO categoryVO) {
        CategoryVO categoryVO1 = categoryDAO.insert(categoryVO);
        return categoryDAO.addGet(categoryVO1);
    }

    public int delete(String id, int cateNo) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("cateNo",cateNo);
        System.out.println("데이터 가지고 오긴 했니? "+id+" "+cateNo);
        int count = categoryDAO.delete(map);
        if(count > 0){
            count = cateNo;
        }else if(count < 1){
            count = 0;
        }
        System.out.println("갔다 왔으니 카운트를 찍어주렴 : "+count);
        return count;
    }
}
