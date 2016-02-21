package GameModel;

/* Demo of a simple Blinker (period 2) in the Game of Life
 */

public class Main
{
	public static void main (String[] args)
	{
        Grid life = new Grid (3, 9);

		life.setInitial (1,0);
		life.setInitial(1,1);
		life.setInitial (1,2);

        life.nextGeneration();
        life.printGame();
    }
}
