import java.math.BigInteger;
import java.util.Scanner;


public class FairAndSquare {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; t++)
		{
			runMe(in, t);
		}
	}
	
	private static void runMe(Scanner in, int t)
	{
		BigInteger 	A = in.nextBigInteger(),
					B = in.nextBigInteger();
		
		BigInteger count = BigInteger.ZERO;
		
		
		
		System.out.println("Case #" + t + ": " + count);
	}

}
