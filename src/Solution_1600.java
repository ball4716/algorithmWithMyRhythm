import java.util.*;
public class Solution_1600 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int countHorseMove = sc.nextInt();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int map[][] = new int[n][m];
		int dist[][] = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <m ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int dirMonkey[][] = {{1,0},{-1,0},{0,1},{0,-1}};
		int dirHorse[][] = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
		
		Queue<int[]> q = new LinkedList<int[]>();
		//ó�� ĭ�� �Ÿ��� 0���� �ؾ���!
		map[0][0] = -2;
		q.offer(new int[]{0,0});
		while(!q.isEmpty()) {
			int curPos[] = q.poll();
			for(int i=0; i< dirMonkey.length; i++) {
				int nextPos[] = {curPos[0]+dirMonkey[i][0], curPos[1]+dirMonkey[i][1]};
				if(nextPos[0]<0 || nextPos[0]>=n || nextPos[1]<0 || nextPos[1]>=m
						|| map[nextPos[0]][nextPos[1]]==-2
						|| map[nextPos[0]][nextPos[1]]==1)
					continue;
				map[nextPos[0]][nextPos[1]] = -2;
				if(dist[curPos[0]][curPos[1]] + 1 > 0 && // ���� �Ÿ����� 0���� ũ��
						(dist[nextPos[0]][nextPos[1]] == 0 || //������ġ �Ÿ����� 0�̰ų� ���� ���Ѱ��� ������ġ �Ÿ������� ������
						dist[curPos[0]][curPos[1]] + 1 < dist[nextPos[0]][nextPos[1]]))
					dist[nextPos[0]][nextPos[1]] = dist[curPos[0]][curPos[1]] + 1;
				q.offer(nextPos);
			}
			for(int i=0; i< dirHorse.length; i++) {
				if(countHorseMove<1)
					break;
				int nextPos[] = {curPos[0]+dirHorse[i][0], curPos[1]+dirHorse[i][1]};
				if(nextPos[0]<0 || nextPos[0]>=n || nextPos[1]<0 || nextPos[1]>=m
						|| map[nextPos[0]][nextPos[1]]==-2
						|| map[nextPos[0]][nextPos[1]]==1)
					continue;
				map[nextPos[0]][nextPos[1]] = -2;
				if(dist[curPos[0]][curPos[1]] + 1 > 0 && // ���� �Ÿ����� 0���� ũ��
						(dist[nextPos[0]][nextPos[1]] == 0 ||  //������ġ �Ÿ����� 0�̰ų� ���� ���Ѱ��� ������ġ �Ÿ������� ������
						dist[curPos[0]][curPos[1]] + 1 < dist[nextPos[0]][nextPos[1]]))
					dist[nextPos[0]][nextPos[1]] = dist[curPos[0]][curPos[1]] + 1;
				q.offer(nextPos);
				countHorseMove--;
			}
			
		}
		if(dist[n-1][m-1] == 0)
			System.out.println("-1");
		else
			System.out.println(dist[n-1][m-1]);
	}
}
