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
	Timer t = new Timer(5,this);

	TetrisGrid grid;
	
	public TetrisPanel()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setBackground(Color.black);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		grid = new TetrisGrid();
//--------------------------------
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
				if(grid.b2.blockState[i][j] == 0)
				{
					g.setColor(new Color(171,171,171));
					g.fillRect(step*(i)+390,step*(j)+60,step,step);
				}
				if(grid.b2.blockState[i][j] == 1)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);		
					g.setColor(new Color(97,212,105));
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
				if(grid.b2.blockState[i][j] == 2)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);
					g.setColor(Color.white);
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
				if(grid.b2.blockState[i][j] == 3)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);		
					g.setColor(new Color(150,58,185));
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
				if(grid.b2.blockState[i][j] == 4)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);	
					g.setColor(new Color(255,252,132));
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
				if(grid.b2.blockState[i][j] == 5)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);	
					g.setColor(new Color(255,87,87));
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
				if(grid.b2.blockState[i][j] == 6)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);	
					g.setColor(new Color(98,255,255));
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
				if(grid.b2.blockState[i][j] == 7)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);
					g.setColor(new Color(52,101,235));
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
				if(grid.b2.blockState[i][j] == 9)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i)+390,step*(j)+60,step,step);
					g.setColor(Color.white);
					g.fillRect(step*(i)+2+390,step*(j)+2+60,step-4,step-4);	
				}
			}
		}
						
	}
	
	public void paintBlocks(Graphics g)
	{
	
		for(int i=4;i<14;i++)
		{
			for(int j=4;j<26;j++)
			{
				if(grid.grid[i][j] == 0)
				{
					g.setColor(new Color(171,171,171));
					g.fillRect(step*(i-3),step*(j-3),step,step);	
				}
				if(grid.grid[i][j] == 1)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i-3),step*(j-3),step,step);		
					g.setColor(new Color(97,212,105));
					g.fillRect(step*(i-3)+2,step*(j-3)+2,step-4,step-4);
				}
				if(grid.grid[i][j] == 2)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i-3),step*(j-3),step,step);		
					g.setColor(Color.white);
					g.fillRect(step*(i-3)+2,step*(j-3)+2,step-4,step-4);
				}
				if(grid.grid[i][j] == 3)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i-3),step*(j-3),step,step);			
					g.setColor(new Color(150,58,185));
					g.fillRect(step*(i-3)+2,step*(j-3)+2,step-4,step-4);
				}
				if(grid.grid[i][j] == 4)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i-3),step*(j-3),step,step);			
					g.setColor(new Color(255,252,132));
					g.fillRect(step*(i-3)+2,step*(j-3)+2,step-4,step-4);
				}
				if(grid.grid[i][j] == 5)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i-3),step*(j-3),step,step);		
					g.setColor(new Color(255,87,87));
					g.fillRect(step*(i-3)+2,step*(j-3)+2,step-4,step-4);
				}
				if(grid.grid[i][j] == 6)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i-3),step*(j-3),step,step);		
					g.setColor(new Color(98,255,255));
					g.fillRect(step*(i-3)+2,step*(j-3)+2,step-4,step-4);
				}
				if(grid.grid[i][j] == 7)
				{
					g.setColor(Color.black);
					g.fillRect(step*(i-3),step*(j-3),step,step);		
					g.setColor(new Color(52,101,235));
					g.fillRect(step*(i-3)+2,step*(j-3)+2,step-4,step-4);
				}
				if(grid.grid[i][j] == 9)
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
			//grid.printGrid();
			//grid.printLockedGrid();
			grid.down();

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
	
			grid.left();
			
		}
		if(code == KeyEvent.VK_RIGHT)
		{	

			grid.right();

		}
		if(code == KeyEvent.VK_DOWN)
		{
			grid.down();
		}
		if(code == KeyEvent.VK_SPACE)
		{
			grid.changeState();
		}
		
	}
	
	public void keyTyped(KeyEvent e)
	{
	
	}
	
	public void keyReleased(KeyEvent e)
	{

	}
	

}