package cn.edu.sdu.erp.system.commons.models;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author sdcsyyg
 *
 */

public class MpsRecord implements Serializable {

    private static final long serialVersionUID = -8200962077583924901L;

    public static void main(String args[]) {
        MpsRecord m = new MpsRecord();
        String s = JSON.toJSONString(m);
        System.out.println(s);
        MpsRecord tm = JSON.parseObject("{eight:80,eleven:80,five:80,four:80,nine:80,one:0,seven:80,six:80,ten:80,three:80,twelve:80,two:0}", MpsRecord.class);
        System.out.println(tm.ten);
    }

    private int one;
    private int two;
    private int three;
    private int four;
    private int five;
    private int six;
    private int seven;
    private int eight;
    private int nine;
    private int ten;
    private int eleven;
    private int twelve;
    public int getOne() {
        return one;
    }
    public void setOne(int one) {
        this.one = one;
    }
    public int getTwo() {
        return two;
    }
    public void setTwo(int two) {
        this.two = two;
    }
    public int getThree() {
        return three;
    }
    public void setThree(int three) {
        this.three = three;
    }
    public int getFour() {
        return four;
    }
    public void setFour(int four) {
        this.four = four;
    }
    public int getFive() {
        return five;
    }
    public void setFive(int five) {
        this.five = five;
    }
    public int getSix() {
        return six;
    }
    public void setSix(int six) {
        this.six = six;
    }
    public int getSeven() {
        return seven;
    }
    public void setSeven(int seven) {
        this.seven = seven;
    }
    public int getEight() {
        return eight;
    }
    public void setEight(int eight) {
        this.eight = eight;
    }
    public int getNine() {
        return nine;
    }
    public void setNine(int nine) {
        this.nine = nine;
    }
    public int getTen() {
        return ten;
    }
    public void setTen(int ten) {
        this.ten = ten;
    }
    public int getEleven() {
        return eleven;
    }
    public void setEleven(int eleven) {
        this.eleven = eleven;
    }
    public int getTwelve() {
        return twelve;
    }
    public void setTwelve(int twelve) {
        this.twelve = twelve;
    }

}
