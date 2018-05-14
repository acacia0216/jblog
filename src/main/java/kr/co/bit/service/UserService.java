package kr.co.bit.service;

import kr.co.bit.dao.UserDAO;
import kr.co.bit.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean idcheck(String id) {
        boolean flag = false;
        String idcheck = userDAO.idcheck(id);
        if(idcheck == null){
            flag = true;
        }
        return flag;
    }

    @Transactional
    public void join(UserVO userVO) {
        userDAO.join(userVO);
        String id = userVO.getId();
        String logofile = "/assets/images/spring-logo.jpg";
        String blogtitle = userVO.getUserName()+"님의 블로그입니다";
        Map map = new HashMap();
        map.put("id",id);
        map.put("logofile",logofile);
        map.put("blogtitle",blogtitle);
        userDAO.createblog(map);
        userDAO.createcategory(userVO);
    }

    public UserVO login(String id, String password) {
        Map map = new HashMap();
        map.put("id",id);
        map.put("password",password);
        return userDAO.login(map);
    }

}
