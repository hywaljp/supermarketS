package javaBean;

import java.util.Date;

public class Clerk {
    private int ckno;
    private  String ckname;
    private  int ckage;
    private Date redate;

    public Clerk(int ckno, String ckname, int ckage, Date redate) {
        this.ckno = ckno;
        this.ckname = ckname;
        this.ckage = ckage;
        this.redate = redate;
    }

    public Clerk() {
    }

    public int getCkno() {
        return ckno;
    }

    public void setCkno(int ckno) {
        this.ckno = ckno;
    }

    public String getCkname() {
        return ckname;
    }

    public void setCkname(String ckname) {
        this.ckname = ckname;
    }

    public int getCkage() {
        return ckage;
    }

    public void setCkage(int ckage) {
        this.ckage = ckage;
    }

    public Date getRedate() {
        return redate;
    }

    public void setRedate(Date redate) {
        this.redate = redate;
    }
}
