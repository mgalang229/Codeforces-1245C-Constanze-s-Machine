import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/*

w = uu
m = nn

there is no letter w or m

the string itself is counted (assuming there are no w or m)

ouuokarinn
owokarinn
ouuokarim
owokarim

uu = 2
nn = 2

answer = 4

------------------------

2 n's
nn
m

answer = 2

------------------------

3 n's
nnn
mn
nm

answer = 3

------------------------

4n's
nnnn

mnn
mm

nmn

nnm

answer = 5

y = 4-2 = 2

2+(2-1)
1
1

------------------------

5 n's
nnnnn

mnnn
mmn
mnm

nmnn  
nmm

nnmn

nnnm

answer = 8 

3
2
1
1

let y = uu - 2 or y = nn - 2

z = y*(y+1)/2-1
sum = z+3

how about combinations?
nCr

 */

public class AuthorSol {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		outer: for (int tc = 1; tc <= T; tc++) {
			char[] s = fs.next().toCharArray();
			for (char c : s) {
				if (c == 'w' || c == 'm') {
					out.println(0);
					continue outer;
				}
			}
			int n = s.length;
			long[] dp = new long[n+1];
			dp[0] = 1;
			dp[1] = 1;
			for (int i = 2; i <= n; i++) {
				dp[i] = dp[i-1];
				if (s[i-1] == s[i-2] && (s[i-1] == 'u' || s[i-1] == 'n')) {
					dp[i] = add(dp[i], dp[i-2]);
				}
			}
			out.println(dp[n]);
		}
		out.close();
	}
	
	static final long mod = 1_000_000_007;
	static long add(long a, long b) {
		return (a + b) % mod;
	}
	
	static final Random rnd = new Random();
	
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newIndex = rnd.nextInt(n);
			int temp = a[newIndex]; //change this
			a[newIndex] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
