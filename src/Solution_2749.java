import java.util.Scanner;
public class Solution_2749 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1000000;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int fi[] = new int[n+1];
		fi[0] = 0;
		fi[1] = 1;
		for(int i = 2; i <= n; i++) {
			fi[i] = (fi[i-1]%num + fi[i-2]%num)%num;
		}
		System.out.println(fi[n]);
		sc.close();
	}

}
