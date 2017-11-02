import java.util.*;
public class Solution_2667 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int map[][] = new int[n][n];
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			for(int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		int danjiMap[][] = new int[n][n];
		int danji = 0;
		List<Integer> listDanjiCount = new ArrayList<Integer>();
		
		int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(danjiMap[i][j] > 0 )
					continue;
				if(map[i][j] == 0)
					continue;
				int[] pos = {i,j};
				map[i][j] = 0;
				danjiMap[i][j] = danji;
				Queue <int[]> q = new LinkedList<int[]>();
				q.offer(pos);
				int count = 0;
				while(!q.isEmpty()) {
					count++;
					int curPos[] = q.poll();
					for(int k = 0; k < 4; k++) {
						int nextPos[] = {curPos[0]+dir[k][0], curPos[1]+dir[k][1]};
						if(nextPos[0]<0 || nextPos[0]>=n || nextPos[1]<0 || nextPos[1]>=n
								|| map[nextPos[0]][nextPos[1]]==0)
							continue;
						q.offer(nextPos);
						map[nextPos[0]][nextPos[1]] = 0;
						danjiMap[nextPos[0]][nextPos[1]] = danji;
					}
				}
				danji++;
				listDanjiCount.add(count);
			}
		}
		System.out.println(danji);
		listDanjiCount.sort(null);
		for(int i = 0; i < listDanjiCount.size(); i++) {
			System.out.println(listDanjiCount.get(i));
		}
	}

}
