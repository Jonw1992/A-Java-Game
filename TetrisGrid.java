import java.util.Random;

public class TetrisGrid
{
	private int x = 0;
	private int y = 0;
	protected BlockType b = new BlockType();
	protected  BlockType b2 = new BlockType();
	protected int[][] grid = new int[18][30];
	protected int[][] gridCopy = new int[18][30];
	protected int[][] lockedGrid = new int[18][30];
	protected Random number = new Random();
	
	public TetrisGrid()
	{
		
		for(int i=0;i<18;i++)
		{
			for(int j=0;j<30;j++)
			{
				

				if(i > 3 && j >= 0 && i < 14 && j < 26)
				{
					grid[i][j]=0;
					lockedGrid[i][j] = 0;				
				}
				else 
				{
					grid[i][j] = 9;
					lockedGrid[i][j] = 1;
				}
			}
		}	
		
		newShape();		
	}
	
	public void newShape()
	{
		x = 7;
		y = 0;
		b = b2;
		
		b2 = new BlockType();
		b2.setType(number.nextInt(7)+1);
		b2.setState(number.nextInt(4)+1);
		
		for(int i =x;i<x+4;i++)
		{
			for(int j=y;j<y+4;j++)
			{
				grid[i][j] = b.blockState[i-x][j-y];
			}
		}	
		
	}
	
	public void changeState()
	{
		if(!cleft() && !cright() && !cdown())
		{
			if(b.state == 4)
			{
				b.setState(1);
			}
			else
			{
				b.setState(b.state + 1);
			}
			updateGrid();
		}
		else if(cleft())
		{
			x++;
			changeState();
		}
		else if(cright())
		{
			x--;
			changeState();
		}
		else if(cdown())
		{
			y--;
			changeState();
		}
	}
	
	public void left()
	{
		if(!cleft())
		{
			x--;
			updateGrid();
		}

	}
	
	public void right()
	{
		if(!cright())
		{
			x++;
			updateGrid();
		}

	}
	
	public void down()
	{
		if(!cdown())
		{
			y++;
			updateGrid();
		}
		else
		{
			Lock();
			checkRows();
			newShape();
		}	
	}
	
	public void checkRows()
	{
		int blocks = 0; 
		boolean found = true;
		while(found)
		{
			for(int i=4;i<26;i++)
			{
				blocks = 0; 
				for(int j=4;j<14;j++)
				{
					if(grid[j][i] !=0)
					{
						blocks++;
					}
				}
				if(blocks == 10)
				{
					deleteRow(i);
					found = true;
				}
				else
				{
					found = false;
				}
			}
		}			
	}
	
	public void deleteRow(int row)
	{
		for(int i=4;i<14;i++)
		{
			grid[i][row] = 0;
			lockedGrid[i][row]=0;
		}
		pushDown(row);
	}
	
	public void copyGrid()
	{
		for(int i=4;i<14;i++)
		{
			for(int j=4;j<26;j++)
			{
				gridCopy[i][j] = grid[i][j];
			}
		}
	}
	
	public void pushDown(int row)
	{
		copyGrid();
		for(int i=4;i<14;i++)
		{
			for(int j=4;j<row+1;j++)
			{
				grid[i][j] = gridCopy[i][j-1];
			}
		}
		Lock();
	}
	

	
	public boolean cdown()
	{
		boolean test = false; 
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(b.blockState[i][j] != 0) 
				{
					if(lockedGrid[i+x][j+y+1] != 0)
					{
						test = true;
					}
				}
			}
		}
		return test; 
	}
	
	public boolean cright()
	{
		boolean test = false; 
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(b.blockState[i][j] != 0) 
				{
					if(lockedGrid[i+x+1][j+y] != 0)
					{
						test = true;
					}
				}
			}
		}
		return test; 
	}
	
	public boolean cleft()
	{
		boolean test = false; 
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(b.blockState[i][j] != 0) 
				{
					if(lockedGrid[i+x-1][j+y] != 0)
					{
						test = true;
					}
				}
			}
		}
		return test; 
	}
	
	public void Lock()
	{
		for(int i=0;i<18;i++)
		{
			for(int j=4;j<30;j++)
			{
				if(grid[i][j] != 0)
				{
					lockedGrid[i][j] = 1;
				}
				if(grid[i][j] == 0)
				{
					lockedGrid[i][j] = 0;
				}	
			}
		}		
	}
	
	public void updateGrid()
	{
				
		for(int i=4;i<14;i++)
		{
			for(int j=4;j<26;j++)
			{
				if(lockedGrid[i][j] == 0)
				{
					grid[i][j] = 0;
				}
			}
		}
		for(int i=x;i<x+4;i++)
		{
			for(int j=y;j<y+4;j++)
			{
				if(lockedGrid[i][j] == 0) 
				{
					grid[i][j] = b.blockState[i-x][j-y];
				}
			}
		}
	}
	
/*	public void printGrid()
	{
		System.out.println("Loop has executed "+runCount+" ");
		for(int i=0;i<30;i++)
		{
			for(int j=0;j<18;j++)
			{
				System.out.print(grid[j][i]+"");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	public void printLockedGrid()
	{
		System.out.println("Loop has executed "+runCount+" ");
		for(int i=0;i<30;i++)
		{
			for(int j=0;j<18;j++)
			{
				System.out.print(lockedGrid[j][i]+"");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}*/
}