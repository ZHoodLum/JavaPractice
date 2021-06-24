package basal.OOP.entity;

import java.io.Serializable;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/24
 * @Description:构造方法及关键字transient
 */
public class XuXianPerson implements Serializable {
	public static void main(String[] args) {
		System.out.println(String.format("%s/%s", "http://127.0.0.1:8070//openapi/v1", "apps/GATEWAY2/appnamespaces"));
		System.out.println("人鬼情未了篇....");
		new XuXianPerson("TOM", 426).tell();
	}

    private String name;
    private int age;
	/**
	 * 	java 的transient关键字为我们提供了便利，你只需要实现Serilizable接口，
	 * 	将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会序列化到指定的目的地中。
	 */
//	transient int age;

	/**
	 * 构造方法
	 */
    public XuXianPerson() {
    }

	/**
	 * 构造方法
	 * @param name
	 */
	public XuXianPerson(String name) {
        this.name = name;
    }

	/**
	 * 构造方法
	 * @param name
	 * @param age
	 */
	public XuXianPerson(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
		if (age > 0 && age < 140) {
			this.age = age;
		} else {
			this.name = "你觉得我还是人吗？ 这位公子......";
			this.age = age;
		}
    }

	/**
	 * 许仙Tell
	 */
	public void tell() {
		System.out.println("工资芳龄：" + this.getAge());
		System.out.println("佳人贵姓：" + this.getName());
	}

}

