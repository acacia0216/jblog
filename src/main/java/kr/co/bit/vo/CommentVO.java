package kr.co.bit.vo;

public class CommentVO {
    private int cmtNo;
    private int postNo;
    private int userNo;
    private String cmtContent;
    private String regdate;
    private String userName;

    public CommentVO() {
    }

    public CommentVO(int cmtNo, int postNo, int userNo, String cmtContent, String regdate, String userName) {
        this.cmtNo = cmtNo;
        this.postNo = postNo;
        this.userNo = userNo;
        this.cmtContent = cmtContent;
        this.regdate = regdate;
        this.userName = userName;
    }

    public int getCmtNo() {
        return cmtNo;
    }

    public void setCmtNo(int cmtNo) {
        this.cmtNo = cmtNo;
    }

    public int getPostNo() {
        return postNo;
    }

    public void setPostNo(int postNo) {
        this.postNo = postNo;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getCmtContent() {
        return cmtContent;
    }

    public void setCmtContent(String cmtContent) {
        this.cmtContent = cmtContent;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "CommentVO{" +
                "cmtNo=" + cmtNo +
                ", postNo=" + postNo +
                ", userNo=" + userNo +
                ", cmtContent='" + cmtContent + '\'' +
                ", regdate='" + regdate + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
