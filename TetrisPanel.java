import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.Random;

public class TetrisPanel extends JPanel implements ActionListener,KeyListener, Runnable
{
	int runCount = 0;
	int left = 200;
	int right = 600;
	int top	= 20;
	int bottom = 800;
	int step = 30;
	int x = 0;
	int y = 0;
	Timer t = new Timer(5,this);
	Random number = new Random();
	BlockType b = new BlockType();
	BlockType b2 = new BlockType();
	int[][] grid = new int[18][30];
	int[][] gridCopy = new int[18][30];
	int[][] lockedGrid = new int[18][30];
	

	
	public TetrisPanel()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setBackground(Color.black);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
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
		t.start();
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void paintComponent(Graphics g)
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		super.paintComponent(g);
		g.setColor(new Color(171,171,171));
		g.fillRect(30,30,300,660);
		g.fillRect(360,30,180,180);
		paintBlocks(g);
		paintB2(g);
	}
	public void paintB2(Graphics g)
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(b2.blockState[i][j] == 0)
				{
					g.setColor(new Color(171,171,171));
					g.fillRect(step*(i)+390,step*(j)+60,step,step);
				}
				if(b2.blockState[i][j] == 1)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);		
					g.setColor(new Color(97,212,105));
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
				if(b2.blockState[i][j] == 2)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);
					g.setColor(Color.white);
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
				if(b2.blockState[i][j] == 3)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);		
					g.setColor(new Color(150,58,185));
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
				if(b2.blockState[i][j] == 4)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);	
					g.setColor(new Color(255,252,132));
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
				if(b2.blockState[i][j] == 5)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);	
					g.setColor(new Color(255,87,87));
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
				if(b2.blockState[i][j] == 6)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);	
					g.setColor(new Color(98,255,255));
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
				if(b2.blockState[i][j] == 7)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);
					g.setColor(new Color(52,101,235));
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
				if(b2.blockState[i][j] == 9)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);
					g.setColor(Color.white);
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
			}
		}
						
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
	
	public void paintBlocks(Graphics g)
	{
	
		for(int i=4;i<14;i++)
		{
			for(int j=4;j<26;j++)
			{
				if(grid[i][j] == 0)
				{
					g.setColor(new Color(171,171,171));
					g.fillRect(step*(i-3),step*(j-3),step,step);	
				}
				if(grid[i][j] == 1)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i-3),step*(j-3),step,step);		
					g.setColor(new Color(97,212,105));
					g.fillRect(step*(i-3)+2,step*(j-3)+2,step-4,step-4);
				}
				if(grid[i][j] == 2)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i-3),step*(j-3),step,step);		
					g.setColor(Color.white);
					g.fillRect(step*(i-3)+2,step*(j-3)+2,step-4,step-4);
				}
				if(grid[i][j] == 3)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i-3),step*(j-3),step,step);			
					g.setColor(new Color(150,58,185));
					g.fillRect(step*(i-3)+2,step*(j-3)+2,step-4,step-4);
				}
				if(grid[i][j] == 4)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i-3),step*(j-3),step,step);			
					g.setColor(new Color(255,252,132));
					g.fillRect(step*(i-3)+2,step*(j-3)+2,step-4,step-4);
				}
				if(grid[i][j] == 5)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i-3),step*(j-3),step,step);		
					g.setColor(new Color(255,87,87));
					g.fillRect(step*(i-3)+2,step*(j-3)+2,step-4,step-4);
				}
				if(grid[i][j] == 6)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i-3),step*(j-3),step,step);		
					g.setColor(new Color(98,255,255));
					g.fillRect(step*(i-3)+2,step*(j-3)+2,step-4,step-4);
				}
				if(grid[i][j] == 7)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i-3),step*(j-3),step,step);		
					g.setColor(new Color(52,101,235));
					g.fillRect(step*(i-3)+2,step*(j-3)+2,step-4,step-4);
				}
				if(grid[i][j] == 9)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i-3),step*(j-3),step,step);		
					g.setColor(Color.white);
					g.fillRect(step*(i-3)+2,step*(j-3)+2,step-4,step-4);
				}
			}
		}
	}
	
	public void run()
	{
		while(true)
		{
			//printGrid();
			//printLockedGrid();
			down();

			try
			{
				Thread.sleep(300);
			}
			catch(Exception e)
			{
				
			}
			
			runCount++;
		}
	}	

	public void printGrid()
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
	}
	
	public void actionPerformed(ActionEvent e)
	{	
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		
		repaint();
	}
		
	public void keyPressed(KeyEvent e)
	{
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_LEFT)
		{
	
			left();
			
		}
		if(code == KeyEvent.VK_RIGHT)
		{	

			right();

		}
		if(code == KeyEvent.VK_DOWN)
		{
			down();
		}
		if(code == KeyEvent.VK_SPACE)
		{
			changeState();
		}
		
	}
	
	public void keyTyped(KeyEvent e)
	{
	
	}
	
	public void keyReleased(KeyEvent e)
	{

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
}