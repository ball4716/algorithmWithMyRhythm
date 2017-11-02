import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Solution_1600_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int countHorseMove = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		int map[][] = new int[n][m];
		int dist[][] = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <m ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j <m ; j++) {
//				System.out.print(map[i][j] + " ");
//			}System.out.println();
//		}
		
		
		int dirMonkey[][] = {{1,0},{-1,0},{0,1},{0,-1}};
		int dirHorse[][] = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
		
		Queue<int[]> q = new LinkedList<int[]>();
		//처음 칸의 거리는 0으로 해야함!
		map[0][0] = -2;
		
		int[] tmp = new int[]{0,0,countHorseMove};
		
//		q.offer(new int[]{0,0,countHorseMove});
		q.offer(tmp);
//		System.out.println(tmp.length);
		
		while(!q.isEmpty()) {
			
			int curPos[] = q.poll();

//			System.out.println("===============");
//			for (int i = 0; i < curPos.length; i++) {
//				System.out.print(" " + curPos[i]);
//			}System.out.println();System.out.println("===============");
			
			for(int i=0; i< dirMonkey.length; i++) {
				int nextPos[] = {curPos[0]+dirMonkey[i][0], curPos[1]+dirMonkey[i][1], curPos[2]};
				if(nextPos[0]<0 || nextPos[0]>=n || nextPos[1]<0 || nextPos[1]>=m
						|| map[nextPos[0]][nextPos[1]]==-2
						|| map[nextPos[0]][nextPos[1]]==1)
					continue;
				map[nextPos[0]][nextPos[1]] = -2;
				if(dist[curPos[0]][curPos[1]] + 1 > 0 && // 더한 거리값이 0보다 크고
						(dist[nextPos[0]][nextPos[1]] == 0 || //다음위치 거리값이 0이거나 지금 더한값이 다음위치 거리값보다 작을떄
						dist[curPos[0]][curPos[1]] + 1 < dist[nextPos[0]][nextPos[1]]))
					dist[nextPos[0]][nextPos[1]] = dist[curPos[0]][curPos[1]] + 1;
				
//				System.out.println();
//				for (int j = 0; j < nextPos.length; j++) {
//					System.out.print(" " + nextPos[j]);
//				}System.out.println();
				
				q.offer(nextPos);
			}
			
			for(int i=0; i< dirHorse.length; i++) {
//				if(countHorseMove<1)
//					break;
				if(curPos[2] == 0) break; //이거
				
				
				
				int nextPos[] = {curPos[0]+dirHorse[i][0], curPos[1]+dirHorse[i][1], curPos[2]-1}; //이거
				if(nextPos[0]<0 || nextPos[0]>=n || nextPos[1]<0 || nextPos[1]>=m
						|| map[nextPos[0]][nextPos[1]]==-2
						|| map[nextPos[0]][nextPos[1]]==1)
					continue;
				map[nextPos[0]][nextPos[1]] = -2;
				if(dist[curPos[0]][curPos[1]] + 1 > 0 && // 더한 거리값이 0보다 크고
						(dist[nextPos[0]][nextPos[1]] == 0 ||  //다음위치 거리값이 0이거나 지금 더한값이 다음위치 거리값보다 작을떄
						dist[curPos[0]][curPos[1]] + 1 < dist[nextPos[0]][nextPos[1]]))
					dist[nextPos[0]][nextPos[1]] = dist[curPos[0]][curPos[1]] + 1;
				q.offer(nextPos);
//				countHorseMove--;
			}
			
			
		}
		if(dist[n-1][m-1] == 0)
			System.out.println("-1");
		else
			System.out.println(dist[n-1][m-1]);
	}
}
