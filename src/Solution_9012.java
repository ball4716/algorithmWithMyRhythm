import java.util.*;
public class Solution_9012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int taskCase = Integer.parseInt(sc.nextLine());
		List<String> arrStr = new ArrayList<String>();
		for(int i = 0; i < taskCase; i++) {
			String strCase = sc.nextLine();
			Stack<Character> stack = new Stack<Character>();
			for(int j = 0; j < strCase.length(); j++) {
				stack.push(strCase.charAt(j));
			}
			int result = 0;
			int count = stack.size();
			for(int j = 0; j < count; j++) {
			//while(stack.size()!=0) {
				char ch = stack.pop();
				if(j == count-1 && ch == ')') {
					result=-1;
					break;
				}
				if(j == 0 && ch == '(') {
					result=-1;
					break;
				}
				else if(ch == '(') {
					result++;
				}else {
					result--;
				}
			}
			if(result == 0) {
				arrStr.add("YES");
			}else {
				arrStr.add("NO");
			}
		}
		for(int i = 0; i < arrStr.size(); i++) {
			System.out.println(arrStr.get(i));
		}
		sc.close();
	}

}
