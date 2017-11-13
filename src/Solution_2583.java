import java.util.*;
public class Solution_2583 {
	// 2583�� ���� ���ϱ�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); // �� ����
		int n = sc.nextInt(); // �� ����
		int k = sc.nextInt(); // �簢�� ����
		
		int [][] map = new int[m][n];
		
		// �׸� �׸��� (-1�� ä���)
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
		//����
		int [][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		
		// ������ ���� ����
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
		
		// ó����ġ�� 1�� �������� ä���ش�.
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
			if(q.isEmpty()) { // ť�� ��������� �˻縦 �� �����ؾ� �� ��찡 �������� �ִ�.
				for(int i = 0; i < m; i++) {
					int []nextPos2 = new int[] {-1, -1};
					for(int j = 0; j < n; j++) {
						if(map[i][j] == 0) {
							areaCount++; // �ٸ����� ����
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
