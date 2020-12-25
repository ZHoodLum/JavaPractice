package basal.keyword.ThisOrSuperKeyWord;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/24
 * @Description:表示调用当前实例或者调用另一个构造函数
 */

public class ThisKeyWord1 {
    private String title = "Python";
    private double price = 66.3;
    //getter setter

    /**
     * 无参构造
     */
    public ThisKeyWord1(){
        System.out.println("新的Book类对象产生  无参构造");//把这句话想象成多行代码
    }

    /**
     * 有参构造方法
     * @param title
     */
    public ThisKeyWord1(String title){
        this.title = title;
        System.out.println("新的Book类对象产生  String title  有参构造方法");
    }

    /**
     * 有参构造方法
     * @param title
     */
    public ThisKeyWord1(String title, double price){
        System.out.println("新的Book类对象产生  String title,double price  有参构造方法");
        this.title = title;
        this.price = price;
    }

    /**
     * 主方法入口
     * @param args
     */
    public static void main(String args[]){
        ThisKeyWord1 book = new ThisKeyWord1("java开发",89);
        System.out.println(book.getInfo());
    }


    public String getInfo(){
        return "书名：" +this.title+",价格："+this.price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
