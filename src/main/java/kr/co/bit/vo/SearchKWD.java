package kr.co.bit.vo;

public class SearchKWD {
    private String kwd;
    private String blogTitle;
    private String userName;

    public SearchKWD() {
    }

    public SearchKWD(String kwd, String blogTitle, String userName) {
        this.kwd = kwd;
        this.blogTitle = blogTitle;
        this.userName = userName;
    }

    public String getKwd() {
        return kwd;
    }

    public void setKwd(String kwd) {
        this.kwd = kwd;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "SearchKWD{" +
                "kwd='" + kwd + '\'' +
                ", blogTitle='" + blogTitle + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
