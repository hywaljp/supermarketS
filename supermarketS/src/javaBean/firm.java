package javaBean;

public class firm {
    private int fno;
    private String fname;
    private String faddress;
    private  String fTN;

    public firm(int fno, String fname, String faddress, String fTN) {
        this.fno = fno;
        this.fname = fname;
        this.faddress = faddress;
        this.fTN = fTN;
    }

    public firm() {
    }

    public int getFno() {
        return fno;
    }

    public void setFno(int fno) {
        this.fno = fno;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFaddress() {
        return faddress;
    }

    public void setFaddress(String faddress) {
        this.faddress = faddress;
    }

    public String getfTN() {
        return fTN;
    }

    public void setfTN(String fTN) {
        this.fTN = fTN;
    }
}
