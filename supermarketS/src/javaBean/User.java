package javaBean;

public class User {
    private  int uno;
    private String uname;
    private String Utype;

    public User(int uno, String uname, String utype) {
        this.uno = uno;
        this.uname = uname;
        Utype = utype;
    }

    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUtype() {
        return Utype;
    }

    public void setUtype(String utype) {
        Utype = utype;
    }
}
