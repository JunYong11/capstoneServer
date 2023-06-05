
public class test {

	public static void main(String[] args) {
		String [] arr = {"1","2","3","4","5"};
		String result = "";
		
		
		for(int i =0;i<arr.length;i++) {
			if(arr[i] == "1" || arr[i] == "3") {
				result += arr[i];
			}
		}
	
		
		System.out.print(result);

	}

}
