import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class TetrisFrame extends JFrame
{

	TetrisFrame()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setTitle("Tetris");
		setSize(570,740);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		add(new TetrisPanel());
		setVisible(true);

	}
}	

	
	
