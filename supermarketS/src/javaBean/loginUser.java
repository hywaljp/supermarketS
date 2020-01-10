package javaBean;

public class loginUser {
    private String uname;
    private  String pwd;
    private  boolean isguanliyuan;

    public loginUser(String uname, String pwd, boolean isguanliyuan) {
        this.uname = uname;
        this.pwd = pwd;
        this.isguanliyuan = isguanliyuan;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean isIsguanliyuan() {
        return isguanliyuan;
    }

    public void setIsguanliyuan(boolean isguanliyuan) {
        this.isguanliyuan = isguanliyuan;
    }
}
