import java.util.Scanner;

public class Solution_10844 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long[][] d = new long[n + 1][10];

		d[1][0] = 0;
		d[1][1] = 1;
		d[1][2] = 1;
		d[1][3] = 1;
		d[1][4] = 1;
		d[1][5] = 1;
		d[1][6] = 1;
		d[1][7] = 1;
		d[1][8] = 1;
		d[1][9] = 1;

		for (int i = 1; i < d.length - 1; i++) {
			for (int j = 0; j < d[i].length; j++) {
				if (j - 1 == -1) {
					d[i + 1][j] = d[i][j + 1]  % 1000000000;
					continue;
				}
				if (j + 1 == 10) {
					d[i + 1][j] = d[i][j - 1]  % 1000000000;
					continue;
				}
				d[i + 1][j] = (d[i][j - 1] + d[i][j + 1])  % 1000000000;
			}
		}
		long answer = 0;
		for (int i = 0; i < 10; i++) {
			answer += (d[n][i]);
		}
		System.out.println(answer % 1000000000);
	}

}
