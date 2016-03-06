public class BlockType
{
	public int type = 1;
	public int state = 1;
	public int[][] blockState =	{{0,0,0,0},
								 {0,0,0,0},
								 {0,0,0,0},
								 {0,0,0,0}};

	public BlockType()
	{
		type = 1;
		state = 1;
		fill();
	}
	
	public void setType(int t)
	{
		this.type = t;
		fill();
	}
	public void setState(int s)
	{
		this.state = s;
		fill();
	}
	
	public void fill()
	{
		if(type == 1)
		{	
			blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
			blockState[1][0] = 0;blockState[1][1] = 1;blockState[1][2] = 1;blockState[1][3] = 0;
			blockState[2][0] = 0;blockState[2][1] = 1;blockState[2][2] = 1;blockState[2][3] = 0;
			blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;
		}
		else if(type == 2)
		{
			if(state == 1)
			{
				blockState[0][0] = 0;blockState[0][1] = 2;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 2;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 2;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 2;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 2)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 0;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 2;blockState[2][1] = 2;blockState[2][2] = 2;blockState[2][3] = 2;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 3)
			{
				blockState[0][0] = 0;blockState[0][1] = 2;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 2;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 2;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 2;blockState[3][2] = 0;blockState[3][3] = 0;			
			
			}
			else if(state == 4)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 0;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 2;blockState[2][1] = 2;blockState[2][2] = 2;blockState[2][3] = 2;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}

		}
		else if(type == 3)
		{
			if(state == 1)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 3;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 0;blockState[1][2] = 3;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 3;blockState[2][2] = 3;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 2)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 3;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 3;blockState[2][2] = 3;blockState[2][3] = 3;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 3)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 3;blockState[1][2] = 3;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 3;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 3;blockState[3][2] = 0;blockState[3][3] = 0;			
			
			}
			else if(state == 4)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 3;blockState[1][2] = 3;blockState[1][3] = 3;
				blockState[2][0] = 0;blockState[2][1] = 0;blockState[2][2] = 0;blockState[2][3] = 3;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;
			}		
		}
		else if(type == 4)
		{
			if(state == 1)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 4;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 4;blockState[2][1] = 4;blockState[2][2] = 4;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 2)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 4;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 4;blockState[2][2] = 4;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 4;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 3)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 0;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 4;blockState[2][1] = 4;blockState[2][2] = 4;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 4;blockState[3][2] = 0;blockState[3][3] = 0;			
			
			}
			else if(state == 4)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 4;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 4;blockState[2][1] = 4;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 4;blockState[3][2] = 0;blockState[3][3] = 0;			
			}		
		}
		else if(type == 5)
		{
			if(state == 1)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 5;blockState[1][2] = 5;blockState[1][3] = 0;
				blockState[2][0] = 5;blockState[2][1] = 5;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 2)
			{
				blockState[0][0] = 5;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 5;blockState[1][1] = 5;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 5;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 3)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 5;blockState[1][2] = 5;blockState[1][3] = 0;
				blockState[2][0] = 5;blockState[2][1] = 5;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 4)
			{
				blockState[0][0] = 5;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 5;blockState[1][1] = 5;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 5;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}		
		}
		else if(type == 6)
		{
			if(state == 1)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 0;blockState[1][2] = 6;blockState[1][3] = 0;
				blockState[2][0] = 6;blockState[2][1] = 6;blockState[2][2] = 6;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 2)
			{
				blockState[0][0] = 6;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 6;blockState[1][1] = 0;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 6;blockState[2][1] = 6;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 3)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 6;blockState[1][1] = 6;blockState[1][2] = 6;blockState[1][3] = 0;
				blockState[2][0] = 6;blockState[2][1] = 0;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			
			}
			else if(state == 4)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 6;blockState[1][1] = 6;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 6;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 6;blockState[3][2] = 0;blockState[3][3] = 0;			
			}		
		}
		else if(type == 7)
		{
			if(state == 1)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 7;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 7;blockState[1][2] = 7;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 7;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 2)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 7;blockState[1][2] = 7;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 0;blockState[2][2] = 7;blockState[2][3] = 7;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 3)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 7;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 7;blockState[1][2] = 7;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 7;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 4)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 7;blockState[1][2] = 7;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 0;blockState[2][2] = 7;blockState[2][3] = 7;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
		}
		else
		{
			type = 1;
			state = 1; 
			fill();
			if(state == 1)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 0;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 0;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 2)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 0;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 0;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}
			else if(state == 3)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 0;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 0;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			
			}
			else if(state == 4)
			{
				blockState[0][0] = 0;blockState[0][1] = 0;blockState[0][2] = 0;blockState[0][3] = 0;
				blockState[1][0] = 0;blockState[1][1] = 0;blockState[1][2] = 0;blockState[1][3] = 0;
				blockState[2][0] = 0;blockState[2][1] = 0;blockState[2][2] = 0;blockState[2][3] = 0;
				blockState[3][0] = 0;blockState[3][1] = 0;blockState[3][2] = 0;blockState[3][3] = 0;			
			}		
		}
	}
	
	

}