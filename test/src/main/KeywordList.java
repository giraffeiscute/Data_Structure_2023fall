package main;
import java.util.ArrayList;

public class KeywordList
{
	private ArrayList<Keyword> lst;

	public KeywordList()
	{
		this.lst = new ArrayList<Keyword>();
	}

	public void add(Keyword keyword)
	{
		lst.add(keyword);
	}

	public void find(String s)
	{
		int maxValue = -1;
		Keyword LCS = null;

		for (Keyword k : lst)
		{
			int lcs = findLCS(k.name, s);

			if (lcs > maxValue)
			{
				maxValue = lcs;
				LCS = k;
			}
		}
		System.out.println(s + ": " + LCS.toString());
	}

	// YOUR TURN
	// 1. Implement the LCS algorithm
	// Return the length of lcs
	public int findLCS(String x, String y)
	{
		int n = x.length();
		int m = y.length();
		int[][] L = new int[n+1][m+1];
		for(int i=0;i<n+1;i++) {
			L[i][0]=0;
		}
		for(int j=0;j<m+1;j++) {
			L[0][j]=0;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				//System.out.println(x.charAt(i)+" and "+y.charAt(j));
				if(x.charAt(i)==y.charAt(j)) {
					//System.out.println(x.charAt(i)+" and "+y.charAt(j));
				L[i+1][j+1]=L[i][j]+1;
				}
				else {
					L[i+1][j+1] = Math.max(L[i+1][j],L[i][j+1]);
				}
			}
		}
		//printMatrix(L);
		//System.out.println("next");
		return L[n][m];
	}

	private void printMatrix(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				System.out.print(matrix[i][j] + " ");
				if (j == matrix[0].length - 1)
					System.out.print("\n");
			}
		}
	}
}
