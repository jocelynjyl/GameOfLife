package GameModel;

public class Cell
{
	private boolean cell;
	
	public Cell ()
	{
		cell = false;
	}
	
	public void setLive ()
	{
		cell = true;
	}
	
	public void setDead ()
	{
		cell = false;
	}

    public void printCell ()
	{
		if (cell) {
            System.out.print("*");
        }
        else {
            System.out.print("-");
        }
	}
	
	public boolean getCurrentState()
	{
		return cell;
	}
	
	


}