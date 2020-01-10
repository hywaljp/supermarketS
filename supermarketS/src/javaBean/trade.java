package javaBean;

import java.util.ArrayList;
import java.util.Date;

public class trade {

    public String name;

    public static ArrayList<trade> list = new ArrayList();
    public static String date = "";
    public  static int ckno = 0;
    public static int sumprice = 0;
    public trade(String name, int price, int num) {
        this.name = name;
        this.price = price;
        this.num = num;
    }

    public trade() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int price;
    public int num;


}
