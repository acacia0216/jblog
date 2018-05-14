package kr.co.bit.service;

import kr.co.bit.dao.CommentDAO;
import kr.co.bit.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    @Autowired
    CommentDAO commentDAO;

    public List<CommentVO> getCmt(int postNo) {
        return commentDAO.getCmt(postNo);
    }

    public CommentVO addCmt(CommentVO commentVO) {
        System.out.println(commentVO.toString());
        int count = commentDAO.addCmt(commentVO);
        System.out.println(commentVO.toString());
        if (count == 0) {
            CommentVO commentVO1 = new CommentVO();
            return commentVO1;
        }
        int cmtNo = commentVO.getCmtNo();
        return commentDAO.oneCmt(cmtNo);
    }

    public int delCmt(int cmtNo) {
        int count = commentDAO.delCmt(cmtNo);
        if(count > 0){
            count = cmtNo;
        }
        return count;
    }
}
