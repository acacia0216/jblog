package kr.co.bit.dao;

import kr.co.bit.vo.PostVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PostDAO {
    @Autowired
    SqlSession sqlSession;

    public int postCount(int cateNo) {
        return sqlSession.selectOne("post.postCount",cateNo);
    }

    public void write(PostVO postVO) {
        int count = sqlSession.insert("post.write",postVO);
        System.out.println("포스트 입력하면 : "+count);
    }

    public List<PostVO> mainPage(Map map) {
        return sqlSession.selectList("post.mainPage",map);
    }

    public PostVO getPostOne(int postNo) {
        return sqlSession.selectOne("post.getPostOne",postNo);
    }
}
