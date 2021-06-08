import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
enum Game
{
	UNFINISHED,
	XWON,
	OWON,
	DRAW
}

public class TicTacToeTomek {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		for (int i = 1; i <= n; i++)
		{
			Quad[]  rows = new Quad[4],
					cols = new Quad[4],
					diags = new Quad[2];
			for (int j = 0; j < 4; j++)
			{
				rows[j] = new Quad();
				cols[j] = new Quad();
				if (j < 2)
					diags[j] = new Quad(); 
			}
			
			String[] board = new String[4];
			for (int j = 0; j < 4; j++)
			{
				board[j] = in.next();
				for (int k = 0; k < 4; k++)
				{
					switch (board[j].charAt(k))
					{
					case 'X':
						rows[j].x++;
						cols[k].x++;
						if (j == k)
						{
							diags[0].x++;
						}
						if (j + k == 3)
						{
							diags[1].x++;
						}
						break;
					case 'O':
						rows[j].o++;
						cols[k].o++;
						if (j == k)
						{
							diags[0].o++;
						}
						if (j + k == 3)
						{
							diags[1].o++;
						}
						break;
					case 'T':
						rows[j].t++;
						cols[k].t++;
						if (j == k)
						{
							diags[0].t++;
						}
						if (j + k == 3)
						{
							diags[1].t++;
						}
						break;
					}
				}
			}
			
			Queue<Quad> q = new ArrayDeque<Quad>();
			q.addAll(Arrays.asList(rows));
			q.addAll(Arrays.asList(cols));
			q.addAll(Arrays.asList(diags));
			
			boolean winner = false;
			boolean unfinished = false;
			
			checkLoop: while (!q.isEmpty())
			{
				Quad next = q.poll();
				switch (next.status())
				{
				case UNFINISHED:
					unfinished = true;
					break;
				case XWON:
					System.out.println("Case #" + i + ": X won");
					winner = true;
					break checkLoop;
				case OWON:
					System.out.println("Case #" + i + ": O won");
					winner = true;
					break checkLoop;
				case DRAW:
					break;
				}
			}
			
			if (!winner)
			{
				if (unfinished)
				{
					System.out.println("Case #" + i + ": Game has not completed");
				}
				else
				{
					System.out.println("Case #" + i + ": Draw");
				}
			}
		}
	}

	
	private static class Quad
	{
		int n,
			t,
			x,
			o;
		
		public Quad()
		{
			n = 0;
			t = 0;
			x = 0;
			o = 0;
		}
		
		public Game status()
		{
			n = x+o+t;
			
			if (n < 4)
			{
				return Game.UNFINISHED;
			}
			else
			{
				if (t + x == 4)
				{
					return Game.XWON;
				}
				else if (t + o == 4)
				{
					return Game.OWON;
				}
				
				return Game.DRAW;
			}
		}
	}
}
