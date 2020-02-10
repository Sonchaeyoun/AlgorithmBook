package AlgoSpot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Picnic {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < c ; i++) {
			boolean[] taken = new boolean[10];
			boolean[][] areFriends = new boolean[10][10];
			
			String r = br.readLine();
			StringTokenizer st = new StringTokenizer(r, " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			String r2 = br.readLine();
			StringTokenizer st2 = new StringTokenizer(r2, " ");
			
			while(st2.hasMoreTokens()) {
				int one = Integer.parseInt(st2.nextToken());
				int two = Integer.parseInt(st2.nextToken());
				areFriends[one][two] = true;
			}
			
			System.out.println(checkPair(taken,n, areFriends));
			
		}
	}
	
	public static int checkPair(boolean[] t, int n, boolean[][] areFriends) {
		int first = -1;
		
		for(int i = 0; i < n; i++) {
			if(!t[i]) {
				first = i;
				break;
			}
		}
		
		if(first == -1) return 1;
		
		int ret = 0;
		
		for(int i = first+1; i < n; i++) {
			if(!t[i] && areFriends[first][i]) {
				t[first] = t[i] = true;
				ret += checkPair(t, n, areFriends);
				t[first] = t[i] = false;				
			}
		}
		return ret;
	}

}
