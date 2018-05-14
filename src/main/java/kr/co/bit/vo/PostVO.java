package kr.co.bit.vo;

public class PostVO {
    private int postNo;
    private int cateNo;
    private String postTitle;
    private String postContent;
    private String regdate;

    public PostVO() {
    }

    public PostVO(int postNo, int cateNo, String postTitle, String postContent, String regdate) {
        this.postNo = postNo;
        this.cateNo = cateNo;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.regdate = regdate;
    }

    public int getPostNo() {
        return postNo;
    }

    public void setPostNo(int postNo) {
        this.postNo = postNo;
    }

    public int getCateNo() {
        return cateNo;
    }

    public void setCateNo(int cateNo) {
        this.cateNo = cateNo;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "PostVO{" +
                "postNo=" + postNo +
                ", cateNo=" + cateNo +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", regdate='" + regdate + '\'' +
                '}';
    }
}
