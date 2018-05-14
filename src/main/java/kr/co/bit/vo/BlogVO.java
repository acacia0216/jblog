package kr.co.bit.vo;

public class BlogVO {
    private String id;
    private String blogTitle;
    private String logoFile;
    private int cateNo;
    private String cateName;
    private int postNo;
    private String postTitle;
    private String postContent;
    private String regdate;

    public BlogVO() {
    }

    public BlogVO(String id, String blogTitle, String logoFile, int cateNo, String cateName, int postNo, String postTitle, String postContent, String regdate) {
        this.id = id;
        this.blogTitle = blogTitle;
        this.logoFile = logoFile;
        this.cateNo = cateNo;
        this.cateName = cateName;
        this.postNo = postNo;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.regdate = regdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getLogoFile() {
        return logoFile;
    }

    public void setLogoFile(String logoFile) {
        this.logoFile = logoFile;
    }

    public int getCateNo() {
        return cateNo;
    }

    public void setCateNo(int cateNo) {
        this.cateNo = cateNo;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getPostNo() {
        return postNo;
    }

    public void setPostNo(int postNo) {
        this.postNo = postNo;
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
        return "BlogVO{" +
                "id='" + id + '\'' +
                ", blogTitle='" + blogTitle + '\'' +
                ", logoFile='" + logoFile + '\'' +
                ", cateNo=" + cateNo +
                ", cateName='" + cateName + '\'' +
                ", postNo=" + postNo +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", regdate='" + regdate + '\'' +
                '}';
    }
}
