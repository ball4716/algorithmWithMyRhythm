import java.util.*;
public class Solution_7576 {
	// 7576�� �丶��
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] map = new int[n][m];
		int[][] countDate = new int[n][m];
		List<int[]> tomPosList = new ArrayList<>();
		List<int[]> noTomPosList = new ArrayList<>();
		
		int totalTomatoNum = 0;
		int minDate = -1;
		int[][] dir = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
		
		//�ʱ�ȭ �� ������ �丶�� ��ġ, �丶�� ���� ��ġ ����
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					tomPosList.add(new int[]{i,j});
				}else if(map[i][j] == -1) {
					noTomPosList.add(new int[]{i,j});
				}else { // map[i][j] == 0
					totalTomatoNum++; // ���� ������ �丶�� ���� �߰�
				}
			}
		}
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0; i < tomPosList.size(); i++) {
			q.offer(tomPosList.get(i)); // ���� �;��ִ� �丶���� ��ġ ����
		}
		
		while(!q.isEmpty()) {
			int[] curPos = q.poll();
			for(int i = 0; i < dir.length; i++) {
				int[] nextPos = new int[]{curPos[0]+dir[i][0], curPos[1]+dir[i][1]};
				if(nextPos[0]<0 || nextPos[0]>= n || nextPos[1] < 0 || nextPos[1] >= m
						|| map[nextPos[0]][nextPos[1]] != 0) {
					continue;
				} // ���� ����ų� ���� �丶�䰡 ���ų� Ȥ�� �̹� ���� ��쿣 ���� ������� ���ư�
				
				q.offer(nextPos);
				map[nextPos[0]][nextPos[1]] = 1;
				if(countDate[nextPos[0]][nextPos[1]] == 0
						|| countDate[nextPos[0]][nextPos[1]] > countDate[curPos[0]][curPos[0]] + 1)
					countDate[nextPos[0]][nextPos[1]] = countDate[curPos[0]][curPos[1]] + 1;
				totalTomatoNum--; // ������ �丶�� ���� �ϳ� ����
				if(totalTomatoNum == 0) {
					q.clear();
					 //�丶�䰡 ��� �;��� ��쿡�� �ּ��� ��¥���� ����Ѵ�.
					for(int k = 0; k < countDate.length; k++) {
						for(int j = 0; j < countDate[k].length; j++) {
							if(countDate[k][j]>minDate)
								minDate = countDate[k][j];
						}
					}
				}
			}
		}
		
		System.out.println(minDate);
	}

}
