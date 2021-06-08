import java.util.ArrayList;
import java.util.Scanner;


public class FullBinaryTree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int caseNo = 1; caseNo <= T; caseNo++)
		{
			int N = in.nextInt();
			Node[] nodes = new Node[N];
			for (int i = 0; i  < N; i++)
			{
				nodes[i] = new Node();
			}
			
			for (int i = 0; i < N-1; i++)
			{
				int X = in.nextInt()-1,
					Y = in.nextInt()-1;
				
				nodes[X].adj.add(nodes[Y]);
				nodes[Y].adj.add(nodes[X]);
			}
			
			int minToRemove = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++)
			{
				
			}
		}
	}
	
	private static class Node
	{
		ArrayList<Node> adj;
		
		public Node()
		{
			adj = new ArrayList<Node>();
		}
	}
}
