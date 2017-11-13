import java.util.*;
public class Solution_2583 {
	// 2583번 영역 구하기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); // 행 갯수
		int n = sc.nextInt(); // 열 갯수
		int k = sc.nextInt(); // 사각형 갯수
		
		int [][] map = new int[m][n];
		
		// 네모 그리기 (-1로 채우기)
		for(int i = 0; i < k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for(int j = x1; j < x2; j++) {
				for(int l = y1; l< y2; l++) {
					map[l][j] = -1;
				}
			}
		}
		
		int areaCount = 1;
		//방향
		int [][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		
		// 영역에 대한 갯수
		List <Integer> list = new ArrayList<>();
		Queue <int[]> q = new LinkedList<>();
		
		int[] curPos = new int[] {-1,-1};
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0) {
					curPos = new int[] {i, j};
					break;
				}
			}
			if(curPos[0] != -1 || curPos[1] != -1)
				break;
		}
		
		// 처음위치는 1번 지역으로 채워준다.
		map[curPos[0]][curPos[1]] = areaCount;
		q.offer(curPos);
		
		while(!q.isEmpty()) {
			curPos = q.poll();
			for(int i = 0; i <dir.length; i++) {
				int row = curPos[0] + dir[i][0];
				int col = curPos[1] + dir[i][1];
				if(row < 0 || row >= m || col < 0 || col >= n
						|| map[row][col] != 0) {
					continue;
				}
				int []nextPos = new int[] {row, col};
				q.offer(nextPos);
				map[nextPos[0]][nextPos[1]] = areaCount;
			}
			if(q.isEmpty()) { // 큐가 비었음에도 검사를 더 수행해야 할 경우가 있을수도 있다.
				for(int i = 0; i < m; i++) {
					int []nextPos2 = new int[] {-1, -1};
					for(int j = 0; j < n; j++) {
						if(map[i][j] == 0) {
							areaCount++; // 다른지역 등장
							nextPos2 = new int[] {i, j};
							q.offer(nextPos2);
							map[nextPos2[0]][nextPos2[1]] = areaCount;
							break;
						}
					}
					if(nextPos2[0] != -1 || nextPos2[1] != -1)
						break;
				}
			}
		}
		
		System.out.println(areaCount);
		
		int i = 1;
		while(i<=areaCount) {
			int count = 0;
			for(int j = 0; j < m; j++) {
				for(int l = 0; l < n; l++) {
					if(map[j][l]==i) {
						count++;
					}
				}
			}
			list.add(count);
			i++;
		}
		
		list.sort(null);
		for(int e = 0; e < list.size(); e++) {
			System.out.print(list.get(e)+" ");
		}
	}

}
