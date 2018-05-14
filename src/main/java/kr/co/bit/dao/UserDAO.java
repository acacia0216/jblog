package kr.co.bit.dao;

import kr.co.bit.vo.SearchKWD;
import kr.co.bit.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDAO {
    @Autowired
    SqlSession sqlSession;

    public String idcheck(String id) {
        System.out.println("아이디체크 다오 : "+id);
        String result = sqlSession.selectOne("users.idcheck",id);
        return result;
    }

    public void join(UserVO userVO) {
        sqlSession.insert("users.join",userVO);
    }

    public void createblog(Map map) {
        sqlSession.insert("users.createblog",map);
    }

    public void createcategory(UserVO userVO) {
        sqlSession.insert("users.createcategory",userVO);
    }

    public UserVO login(Map map) {
        return sqlSession.selectOne("users.login",map);
    }

    public List<SearchKWD> searchKWD(String keyword) {
        return sqlSession.selectList("users.searchKWD",keyword);
    }
}
