import java.util.*;

public class Solution_10828 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> stack = new ArrayList<Integer>();
		int orderCount = sc.nextInt();
		
		for(int i = 0; i < orderCount; i++) {
			String order = sc.next();
			int num = 0;
			if("push".equals(order)) {
				num = sc.nextInt();
			}
			stackMotion(stack, order, num);
		}
	}

	
	public static void stackMotion(List<Integer> stack, String order, int num) {
		if("push".equals(order)) {
			stack.add(num);
		}else if("pop".equals(order)){
			if(stack.size() == 0) {
				System.out.println(-1);
			}else {
				System.out.println(stack.get(stack.size()-1));
				stack.remove(stack.size()-1);
			}
		}else if("size".equals(order)){
			System.out.println(stack.size());
		}else if("empty".equals(order)){
			if(stack.size() == 0) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}else if("top".equals(order)){
			if(stack.size() == 0) {
				System.out.println(-1);
			}else {
				System.out.println(stack.get(stack.size()-1));
			}
		}
	}
}
