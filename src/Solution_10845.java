import java.util.*;
public class Solution_10845 {
	public List<Integer> stack;
	public Solution_10845() {
		stack = new ArrayList<Integer>();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());
		Solution_10845 stack = new Solution_10845();
		for(int i = 0; i < testCase; i++) {
			String order = sc.next();
			int x = 0;
			if("push".equals(order)) {
				x = sc.nextInt();
				stack.push(x);
			}else if("pop".equals(order)) {
				System.out.println(stack.pop());
			}else if("size".equals(order)) {
				System.out.println(stack.size());
			}else if("empty".equals(order)) {
				System.out.println(stack.empty());
			}else if("front".equals(order)) {
				System.out.println(stack.front());
			}else if("back".equals(order)) {
				System.out.println(stack.back());
			}
			
			
		}
		sc.close();
	}
	

	public void push(int x) {
		stack.add(x);
	}
	
	public int pop() {
		if(stack.size()!=0) {
			int returnNum = stack.get(0);
			stack.remove(0);
			return returnNum;
		}
		return -1;
	}
	
	public int size() {
		return stack.size();
	}
	
	public int empty() {
		if(stack.size()!=0)
			return 0;
		return 1;
	}
	
	public int front() {
		if(stack.size()!=0) {
			return stack.get(0);
		}
		return -1;
	}
	
	public int back() {
		if(stack.size()!=0) {
			return stack.get(stack.size()-1);
		}
		return -1;
	}
}
