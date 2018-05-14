package kr.co.bit.service;

import kr.co.bit.dao.BlogDAO;
import kr.co.bit.dao.CategoryDAO;
import kr.co.bit.dao.PostDAO;
import kr.co.bit.dao.UserDAO;
import kr.co.bit.vo.BlogVO;
import kr.co.bit.vo.CategoryVO;
import kr.co.bit.vo.PostVO;
import kr.co.bit.vo.SearchKWD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogService {
    @Autowired
    BlogDAO blogDAO;
    @Autowired
    PostDAO postDAO;
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    UserDAO userDAO;

    public Map<String, Object> getMain(String id, int crtPage) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("crtPage", crtPage);
        BlogVO blog = blogDAO.getBlog(map);
        List<BlogVO> category = categoryDAO.getCategory(id);
        System.out.println("카테고리 사이즈 : " + category.size());
        int cateNo = category.get(0).getCateNo();
        System.out.println("카티고리 번호 : " + cateNo);

        //페이징 변수 설정
        int listCnt = 3;//페이지당 게시글 갯수
        int pageBtnCount = 5;//페이징 버튼 세트 갯수
        int totalCount = postDAO.postCount(cateNo);//해당카테고리의 모든 포스트 수
        int startRnum = (crtPage - 1) * listCnt;//페이지에 표시할 시작번호(첫번째글)
        int endRnum = startRnum + listCnt;//페이지에 표시할 끝번호(세번째글)
        int endPageBtnNo = (int) (Math.ceil(crtPage / (double) pageBtnCount) * pageBtnCount);
        int startPageBtnNo = endPageBtnNo - (pageBtnCount - 1);
        int last = (int) (Math.ceil(totalCount / (double) listCnt));
        boolean prev = false;
        if (crtPage > pageBtnCount) {
            prev = true;
        }
        boolean next = false;
        if (endPageBtnNo * listCnt < totalCount) {
            next = true;
        } else {
            endPageBtnNo = (int) (Math.ceil(totalCount / (double) listCnt));
        }

        Map<String, Object> mapin = new HashMap<>();
        mapin.put("cateNo", cateNo);
        mapin.put("startRnum", startRnum);
        mapin.put("endRnum", endRnum);

        List<PostVO> post = postDAO.mainPage(mapin);
        PostVO getPostOne = null;
        if (post.size() == 0) {
            post = new ArrayList<>();
        } else {
            int postNo = post.get(0).getPostNo();
            getPostOne = postDAO.getPostOne(postNo);
        }
        int postCount = postDAO.postCount(cateNo);

        System.out.println("다가져왔다");

        Map<String, Object> mapout = new HashMap<>();
        mapout.put("blog", blog);
        mapout.put("category", category);
        mapout.put("post", post);
        mapout.put("postCount", postCount);
        mapout.put("getPostOne", getPostOne);
        mapout.put("cateNo", cateNo);
        //페이징에 필요한 변수 세팅해서 보내기
        mapout.put("pageBtnCount", pageBtnCount);
        mapout.put("crtPage", crtPage);
        mapout.put("startPageBtnNo", startPageBtnNo);
        mapout.put("endPageBtnNo", endPageBtnNo);
        mapout.put("last", last);
        mapout.put("prev", prev);
        mapout.put("next", next);
        return mapout;
    }

    public Map<String, Object> getManagementPage(String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        BlogVO blog = blogDAO.getBlog(map);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("blog", blog);
        return map1;
    }

    public void blogUpdate(String blogTitle, String id, MultipartFile multipartFile) {
        System.out.println("들어는 왔냐?");
        String test = multipartFile.getOriginalFilename();
        System.out.println("파일이름 : " + test);
        if (test.equals("") || test == null) {
            System.out.println("타이틀만 변경할래");
            Map<String, Object> map = new HashMap<>();
            map.put("blogTitle", blogTitle);
            map.put("id", id);
            blogDAO.blogUpdate(map);
        } else {
            System.out.println("타이틀이랑 사진 둘다 변경할래");
            String exName = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
            System.out.println(exName);
            String saveName = id + "_logoFile" + exName;
            System.out.println(saveName);
            String logoFile = "D:\\javaStudy\\upload\\" + saveName;
            System.out.println(logoFile);

            //파일 서버 복사
            try {
                System.out.println("서버에 파일복사 시작");
                byte[] fileData = multipartFile.getBytes();
                OutputStream outputStream = new FileOutputStream(logoFile);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

                bufferedOutputStream.write(fileData);

                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("서버에 파일 복사 끝");

            Map<String, Object> map = new HashMap<>();
            map.put("blogTitle", blogTitle);
            map.put("id", id);
            map.put("logoFile", saveName);
            blogDAO.blogUpdate(map);
        }

    }

    public Map<String, Object> mainPage(String id, int postNo, int cateNo, int crtPage) {
        BlogVO blog = blogDAO.mainPage(id);
        List<CategoryVO> category = categoryDAO.mainPage(id);

        Map<String, Object> mapin = new HashMap<>();
        mapin.put("cateNo", cateNo);
//페이징 변수 설정
        int listCnt = 3;//페이지당 게시글 갯수
        int pageBtnCount = 5;//페이징 버튼 세트 갯수
        int totalCount = postDAO.postCount(cateNo);//해당카테고리의 모든 포스트 수
        int startRnum = (crtPage - 1) * listCnt;//페이지에 표시할 시작번호(첫번째글)
        int endRnum = startRnum + listCnt;//페이지에 표시할 끝번호(세번째글)
        int endPageBtnNo = (int) (Math.ceil(crtPage / (double) pageBtnCount) * pageBtnCount);
        int startPageBtnNo = endPageBtnNo - (pageBtnCount - 1);
        int last = (int) (Math.ceil(totalCount / (double) listCnt));
        boolean prev = false;
        if (crtPage > pageBtnCount) {
            prev = true;
        }
        boolean next = false;
        if (endPageBtnNo * listCnt < totalCount) {
            next = true;
        } else {
            endPageBtnNo = (int) (Math.ceil(totalCount / (double) listCnt));
        }

        mapin.put("cateNo", cateNo);
        mapin.put("startRnum", startRnum);
        mapin.put("endRnum", endRnum);

        List<PostVO> post = postDAO.mainPage(mapin);
        if (postNo == 0) {
            if (post.size() != 0) {
                postNo = post.get(0).getPostNo();
            } else {
                post = new ArrayList<>();
            }
        }
        PostVO getPostOne = postDAO.getPostOne(postNo);
        int postCount = postDAO.postCount(cateNo);
        Map<String, Object> mapout = new HashMap<>();
        mapout.put("blog", blog);
        mapout.put("category", category);
        mapout.put("post", post);
        mapout.put("getPostOne", getPostOne);
        mapout.put("postCount", postCount);
        //페이징에 필요한 변수 세팅해서 보내기
        mapout.put("pageBtnCount", pageBtnCount);
        mapout.put("crtPage", crtPage);
        mapout.put("startPageBtnNo", startPageBtnNo);
        mapout.put("endPageBtnNo", endPageBtnNo);
        mapout.put("last", last);
        mapout.put("prev", prev);
        mapout.put("next", next);
        return mapout;
    }

    public Map<String,Object> searchKWD(String keyword, String which) {
        List<SearchKWD> blogList = null;
        List<SearchKWD> userList = null;
        Map<String,Object> map = new HashMap<>();
        if (which.equals("blog-title")) {
            blogList = blogDAO.searchKWD(keyword);
        System.out.println("블로그제목 : "+blogList.size());
        } else if (which.equals("blog-user")) {
            userList = userDAO.searchKWD(keyword);
        System.out.println("블로거 : "+userList.size());
        }
        map.put("blogList",blogList);
        map.put("userList",userList);
        map.put("keyword",keyword);
        return map;
    }
}
