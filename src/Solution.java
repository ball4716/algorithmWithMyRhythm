/**
 *
 * @author HyunyoungKim
 */
import java.util.*;
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int map[][] = new int[n+1][m+1];
        int dist[][] = new int[n+1][m+1];
        Queue<int[]> q = new LinkedList<int[]>();
        int curPos[] = new int[2];
        int dir[][] = {{1,0},{0,1},{0,-1},{-1,0}};
        for(int i = 1; i<=n; i++){
        	String s = sc.next();
            for(int j = 1; j<=m; j++){
                map[i][j] = s.charAt(j-1) - '0';
                dist[i][j] = 0;
            }
        }
        curPos[0] = 1;
        curPos[1] = 1;
        q.offer(curPos);
        map[1][1] = 0; // 참고해서 추가함
        dist[1][1] = 1;
        while(!q.isEmpty()){
        	curPos = q.poll();
            for(int i = 0; i < 4; i++){
            	int nextPos[] = new int[]{curPos[0] + dir[i][0],curPos[1] + dir[i][1]};
                if(nextPos[0] < 1 
                	|| nextPos[0] > n
                	|| nextPos[1] < 1 
                	|| nextPos[1] > m 
                	|| map[nextPos[0]][nextPos[1]] == 0){
                    continue;
                }else{
                	dist[nextPos[0]][nextPos[1]] = dist[curPos[0]][curPos[1]] + 1;
                    q.offer(nextPos);
                    map[nextPos[0]][nextPos[1]] = 0;//참고해서 변경함 curPos --> nextPos
                }
            }
            //map[curPos[0]][curPos[1]] = 0;
        }
        System.out.println(dist[n][m]);
    }
    
}