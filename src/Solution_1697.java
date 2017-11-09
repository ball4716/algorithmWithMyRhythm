import java.util.*;
public class Solution_1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int [] dir = {-1, 1, 2}; // dir[2]는 곱하기 나머지는 더하기
		
		int [] map = new int [100001];
		int [] countMap = new int [100001];
		
		//결과 시간초
		int count = 0;
		
		map[n] = -1;
		map[k] = 1;
		countMap[n] = 0;
		
		//int curPos = n;
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		if(n == k) {
			countMap[k] = 0;
		}else if((n+1 == k) || (n-1 == k) || (n*2 == k)) {
			countMap[k] = 1;
		}else {
			while(!q.isEmpty()) {
				int curPos = q.poll();//현재 위치 받기
				for(int i = 0; i < dir.length; i++) {
					int nextPos = 0;
					if(i != 2) {
						nextPos = curPos + dir[i];
					}else {
						nextPos = curPos * dir[i];
					}
					if(nextPos < 0 || nextPos > 100000 || map[nextPos] == -1)
						continue;
					map[nextPos] = -1;
					if(countMap[nextPos] == 0 || countMap[nextPos] > countMap[curPos]+1)
						countMap[nextPos] = countMap[curPos]+1;
					q.offer(nextPos);
					if(nextPos == k) {
						q.clear();
						break;
					}
				}
			}
		}
		
		System.out.println(countMap[k]);
	}
}
