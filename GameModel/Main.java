package GameModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main (String[] args)
	{
        Grid life = new Grid (3, 9);
        JFrame frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane();
        frame.pack();
        frame.setVisible(true);

		life.setInitial (1,0);
		life.setInitial(1,1);
		life.setInitial (1,2);

    }
}
