package javaBean;

import java.util.Date;

public class VIPuser {

    private int vipnuo;
    private  int vipcardnuo;
    private  int VIPSUMMoney;
    private Date redate;

    public VIPuser(int vipnuo, int vipcardnuo, int VIPSUMMoney, Date redate) {
        this.vipnuo = vipnuo;
        this.vipcardnuo = vipcardnuo;
        this.VIPSUMMoney = VIPSUMMoney;
        this.redate = redate;
    }

    public int getVipnuo() {
        return vipnuo;
    }

    public void setVipnuo(int vipnuo) {
        this.vipnuo = vipnuo;
    }

    public int getVipcardnuo() {
        return vipcardnuo;
    }

    public void setVipcardnuo(int vipcardnuo) {
        this.vipcardnuo = vipcardnuo;
    }

    public int getVIPSUMMoney() {
        return VIPSUMMoney;
    }

    public void setVIPSUMMoney(int VIPSUMMoney) {
        this.VIPSUMMoney = VIPSUMMoney;
    }

    public Date getRedate() {
        return redate;
    }

    public void setRedate(Date redate) {
        this.redate = redate;
    }
}
