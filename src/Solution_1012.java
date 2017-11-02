import java.util.*;
public class Solution_1012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseNum = sc.nextInt();
		int result[] = new int[caseNum];
		for (int i = 0; i < caseNum; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int map[][] = new int[n][m];
			int bugNum = 0;
			int plantNum = sc.nextInt();
			int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
			int plantPos[][] = new int[plantNum][2];
			
			//식물 최초 위치 초기화
			for(int j =0; j < plantNum; j++) {
				plantPos[j][0] = sc.nextInt();
				plantPos[j][1] = sc.nextInt();
				map[plantPos[j][0]][plantPos[j][1]] = 1;
			}
			
			Queue <int[]> q = new LinkedList<int[]>();
			
			for(int j = 0; j < plantNum; j++) {
				if(map[plantPos[j][0]][plantPos[j][1]]==0)
					continue;
				bugNum++;
				map[plantPos[j][0]][plantPos[j][1]]=0;
				q.offer(plantPos[j]);
				while(!q.isEmpty()) {
					int curPos[] = q.poll();
					for(int k = 0; k < 4; k++) {
						int nextPos[] = {curPos[0]+dir[k][0], curPos[1]+dir[k][1]};
						if(nextPos[0] < 0 || nextPos[0]>=n || nextPos[1] <0 || nextPos[1]>=m
								|| map[nextPos[0]][nextPos[1]]==0)
							continue;
						map[nextPos[0]][nextPos[1]] = 0;
						q.offer(nextPos);
					}
				}
			}
			result[i] = bugNum;
		}
		for(int i=0;i<caseNum;i++) {
			System.out.println(result[i]);
		}
	}

}
