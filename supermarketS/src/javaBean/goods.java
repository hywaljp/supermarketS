package javaBean;

import java.util.Objects;

public class goods {
    private  int gno;
    private  String gname;
    private int gNUM;
    private  int gQTY;
    private  int gQTYWARN;
    private boolean gifsell;
    public  int fno;
    public  int sno;

    public goods() {
    }

    public int getGno() {
        return gno;
    }

    public void setGno(int gno) {
        this.gno = gno;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getgNUM() {
        return gNUM;
    }

    public void setgNUM(int gNUM) {
        this.gNUM = gNUM;
    }

    public int getgQTY() {
        return gQTY;
    }

    public void setgQTY(int gQTY) {
        this.gQTY = gQTY;
    }

    public int getgQTYWARN() {
        return gQTYWARN;
    }

    public void setgQTYWARN(int gQTYWARN) {
        this.gQTYWARN = gQTYWARN;
    }

    public boolean isGifsell() {
        return gifsell;
    }

    public void setGifsell(boolean gifsell) {
        this.gifsell = gifsell;
    }


    public int getFno() {
        return fno;
    }

    public void setFno(int fno) {
        this.fno = fno;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }



    @Override
    public String toString() {
        return "goods{" +
                "gno=" + gno +
                ", gname='" + gname + '\'' +
                ", gNUM=" + gNUM +
                ", gQTY=" + gQTY +
                ", gQTYWARN=" + gQTYWARN +
                ", gifsell=" + gifsell +
                ", fno=" + fno +
                ", sno=" + sno +
                '}';
    }
}
