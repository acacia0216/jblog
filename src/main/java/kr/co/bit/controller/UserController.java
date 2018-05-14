package kr.co.bit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.bit.service.UserService;
import kr.co.bit.vo.UserVO;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/joinform", method = RequestMethod.GET)
    public String joinform() {
        System.out.println("회원가입폼으로 간다");
        return "user/joinForm";
    }

    @ResponseBody
    @RequestMapping(value = "/idcheck", method = RequestMethod.POST)
    public boolean idcheck(@RequestParam String id) {
        System.out.println("아이디체크하러 옴");
        boolean flag = userService.idcheck(id);
        System.out.println("아이디 체크하고 나옴");
        return flag;
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(@ModelAttribute UserVO userVO) {
        System.out.println("회원가입시키러 들어옴");
        System.out.println(userVO);
        userService.join(userVO);
        System.out.println("회원가입후 메인으로 이동");
        return "user/joinSuccess";
    }

    @RequestMapping(value = "/loginform", method = RequestMethod.GET)
    public String loginform() {
        System.out.println("로그인폼으로 간다");
        return "user/loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String id, @RequestParam String password, HttpSession httpSession, Model model) {
        UserVO userVO = userService.login(id, password);
        httpSession.setAttribute("authUser", userVO);
        boolean flag = false;
        if (userVO != null) {
            System.out.println(userVO.toString());
            return "redirect:/";
        } else if (userVO == null) {
            model.addAttribute("flag", flag);
            return "user/loginForm";
        }
		return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("authUser");
        return "redirect:/";
    }
}
