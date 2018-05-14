package kr.co.bit.vo;

public class SearchKWD {
    private String kwd;
    private String blogTitle;
    private String id;

    public SearchKWD() {
    }

    public SearchKWD(String kwd, String blogTitle, String id) {
        this.kwd = kwd;
        this.blogTitle = blogTitle;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SearchKWD{" +
                "kwd='" + kwd + '\'' +
                ", blogTitle='" + blogTitle + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
