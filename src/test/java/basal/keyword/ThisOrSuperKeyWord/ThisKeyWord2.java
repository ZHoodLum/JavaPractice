package basal.keyword.ThisOrSuperKeyWord;

import java.awt.print.Book;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/24
 * @Description:
 */


public class ThisKeyWord2 {
    private String title;
    private double price;
    //getter setter

//    public ThisKeyWord2(String t,double p){
//        title = t;
//        price = p;
//    }

//    public ThisKeyWord2(String title,double price){
//        title = title;
//        price = price;
//    }
    public ThisKeyWord2(String title,double price){
        this.title = title;
        this.price = price;
    }

    public String getInfo(){
        return "书名：" +this.title+",价格："+price;
    }

    public static void main(String args[]){
        ThisKeyWord2 thisKeyWord2 = new ThisKeyWord2("java开发",89);
        System.out.println(thisKeyWord2.getInfo());
    }


}
