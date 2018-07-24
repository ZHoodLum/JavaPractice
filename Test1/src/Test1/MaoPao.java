package Test1;

public class MaoPao {
	public static void main(String[] args) {
		
		//ц╟ещ
		int[] a = {2,3,6,5,4,8,9};
		
		for(int j=0;j<a.length;j++){
			for(int i=0;i<a.length-1-j;i++){
				if(a[i]>a[i+1]){
					int temp = a[i+1];
					a[i+1] = a[i];
					a[i] = temp;
				}
			}
		}
		for(int n:a){
			System.out.println(n);
		}
	}

}
