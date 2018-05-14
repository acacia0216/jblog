package kr.co.bit.vo;

public class CategoryVO {
    private int cateNo;
    private String id;
    private String cateName;
    private String description;
    private String regdate;
    private int postCount;

    public CategoryVO() {
    }

    public CategoryVO(int cateNo, String id, String cateName, String description, String regdate, int postCount) {
        this.cateNo = cateNo;
        this.id = id;
        this.cateName = cateName;
        this.description = description;
        this.regdate = regdate;
        this.postCount = postCount;
    }

    public int getCateNo() {
        return cateNo;
    }

    public void setCateNo(int cateNo) {
        this.cateNo = cateNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    @Override
    public String toString() {
        return "CategoryVO{" +
                "cateNo=" + cateNo +
                ", id='" + id + '\'' +
                ", cateName='" + cateName + '\'' +
                ", description='" + description + '\'' +
                ", regdate='" + regdate + '\'' +
                ", postCount=" + postCount +
                '}';
    }
}
