package basal.keyword.ThisOrSuperKeyWord;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/24
 * @Description:
 */


public class ThisKeyWord3 {
    public static void main(String args[]){
        BookObject bookObject1 = new BookObject();
        System.out.println("第1个对象"+bookObject1);
        System.out.println("第1个this对象"+bookObject1);

        BookObject bookObject2 = new BookObject();
        System.out.println("第2个对象"+bookObject2);
        System.out.println("第2个this对象"+bookObject2);
    }
}
