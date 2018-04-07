import java.util.*;
public class Solution_10866 {
	List<Integer> deque;
	public Solution_10866() {
		// TODO Auto-generated constructor stub
		deque = new ArrayList<Integer>();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_10866 deque = new Solution_10866();
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < testCase; i++) {
			String order = sc.next();
			if("push_back".equals(order)) {
				int x = Integer.parseInt(sc.next());
				deque.push_backX(x);
			}else if("push_front".equals(order)) {
				int x = Integer.parseInt(sc.next());
				deque.push_frontX(x);
			}else if("pop_front".equals(order)) {
				System.out.println(deque.pop_front());
			}else if("pop_back".equals(order)) {
				System.out.println(deque.pop_back());
			}else if("size".equals(order)) {
				System.out.println(deque.size());
			}else if("empty".equals(order)) {
				System.out.println(deque.empty());
			}else if("front".equals(order)) {
				System.out.println(deque.front());
			}else if("back".equals(order)) {
				System.out.println(deque.back());
			}
		}
		sc.close();
	}

	public void push_frontX(int x) {
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(x);
		temp.addAll(deque);
		deque = temp;
	}
	
	public void push_backX(int x) {
		deque.add(x);
	}
	
	public int pop_front() {
		if(deque.size()!=0) {
			int frontNum = deque.get(0);
			deque.remove(0);
			return frontNum;
		}
		return -1;
	}
	
	public int pop_back() {
		if(deque.size()!=0) {
			int backNum = deque.get(deque.size()-1);
			deque.remove(deque.size()-1);
			return backNum;
		}
		return -1;
	}
	
	public int size() {
		return deque.size();
	}
	
	public int empty() {
		if(deque.size()==0) {
			return 1;
		}
		return 0;
	}
	
	public int front() {
		if(deque.size()!=0)
			return deque.get(0);
		return -1;
	}
	
	public int back() {
		if(deque.size()!=0)
			return deque.get(deque.size()-1);
		return -1;
	}
}
