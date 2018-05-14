package kr.co.bit.vo;

public class UserVO {
    private int userno;
    private String id;
    private String userName;
    private String password;
    private String date;

    public UserVO() {
    }

    public UserVO(int userno, String id, String userName, String password, String date) {
        this.userno = userno;
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.date = date;
    }

    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userno=" + userno +
                ", id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
