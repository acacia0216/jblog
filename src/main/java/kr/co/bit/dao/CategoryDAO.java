package kr.co.bit.dao;

import kr.co.bit.vo.BlogVO;
import kr.co.bit.vo.CategoryVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CategoryDAO {
    @Autowired
    SqlSession sqlSession;

    public List<CategoryVO> getList(String id) {
        return sqlSession.selectList("category.getList",id);
    }

    public CategoryVO insert(CategoryVO categoryVO) {
        System.out.println("아작스다오 들어오고");
        System.out.println(categoryVO.toString());
        sqlSession.insert("category.insert",categoryVO);
        System.out.println(categoryVO.toString());
        System.out.println("아작스인서트끝");
        return categoryVO;
    }

    public CategoryVO addGet(CategoryVO categoryVO1) {
        return sqlSession.selectOne("category.addGet",categoryVO1);
    }

    public int delete(Map<String, Object> map) {
        System.out.println("아작스 삭제 여기까진 오니?");
        return sqlSession.delete("category.delete",map);
    }

    public List<CategoryVO> mainPage(String id) {
        return sqlSession.selectList("category.mainPage",id);
    }
    public List<BlogVO> getCategory(String id) {
        System.out.println("카테고리 가져와");
        return sqlSession.selectList("category.main",id);
    }
}
