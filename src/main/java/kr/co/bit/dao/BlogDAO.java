package kr.co.bit.dao;

import kr.co.bit.vo.BlogVO;
import kr.co.bit.vo.SearchKWD;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BlogDAO {
    @Autowired
    SqlSession sqlSession;

    public BlogVO getBlog(Map<String,Object> map) {
        System.out.println("블로그 가져와");
        return sqlSession.selectOne("blog.main",map);
    }

    public void blogUpdate(Map<String,Object> map) {
        sqlSession.insert("blog.blogUpdate",map);
    }


    public BlogVO mainPage(String id) {
        return sqlSession.selectOne("blog.mainPage",id);
    }

    public List<SearchKWD> searchKWD(String keyword) {
        return sqlSession.selectList("blog.searchKWD",keyword);
    }
}
