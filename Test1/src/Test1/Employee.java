package Test1;

public class Employee {
	
	private String name;
	private double salary;
	
	
	public Employee(String n,double s){
		String name = n;
		double salary = s;
		
	}
	
	public static void main(String[] args) {
		Employee[] sta = new Employee[1];
		
		sta[0] = new Employee("Tom", 8000);
		for(Employee e:sta){
			System.out.println("name="+ e.getName()
			+",salary="+e.getSalary());
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
