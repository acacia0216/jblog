package kr.co.bit.dao;

import kr.co.bit.vo.CommentVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CommentDAO {
    @Autowired
    SqlSession sqlSession;

    public List<CommentVO> getCmt(int postNo) {
        System.out.println(postNo);
        List list = sqlSession.selectList("comment.getCmt",postNo);
        System.out.println(list.toString());
        return list;
    }

    public int addCmt(CommentVO commentVO) {
        System.out.println("코멘트다오 도착"+commentVO.toString());
        int count = sqlSession.insert("comment.addCmt",commentVO);
        System.out.println("코멘트다오 나간다"+commentVO.toString());
        return count;
    }

    public CommentVO oneCmt(int cmtNo) {
        return sqlSession.selectOne("comment.oneCmt",cmtNo);
    }

    public int delCmt(int cmtNo) {
        return sqlSession.delete("comment.delCmt",cmtNo);
    }
}
