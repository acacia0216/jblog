package kr.co.bit.controller;

import kr.co.bit.service.CommentService;
import kr.co.bit.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/getCmt",method = RequestMethod.POST)
    public List<CommentVO> getCmt(@RequestParam int postNo){
        System.out.println("코멘트 리스트 가질러 출발");
        List<CommentVO> list = commentService.getCmt(postNo);
        System.out.println("코멘트 리스트 가지고 도착");
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/addcmt",method = RequestMethod.POST)
    public CommentVO addCmt(@ModelAttribute CommentVO commentVO){
        System.out.println("입력 ㄱㄱ");
        CommentVO commentVO1 = commentService.addCmt(commentVO);
        System.out.println("입력 끝");
        System.out.println("코멘트 입력 다끝났으면? "+commentVO1.toString());
        return commentVO1;
    }

    @ResponseBody
    @RequestMapping(value = "/delcmt",method = RequestMethod.POST)
    public int delCmt(@RequestParam int cmtNo){
        return commentService.delCmt(cmtNo);
    }
}
