import java.util.*;
public class Solution_2747 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int fi[] = new int[n+1];
		fi[0] = 0;
		fi[1] = 1;
		for(int i = 2; i <= n; i++) {
			fi[i] = fi[i-1] + fi[i-2];
		}
		System.out.println(fi[n]);
		sc.close();
	}

}
