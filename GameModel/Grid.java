package GameModel;

public class Grid
{
	private Cell [][] grid;
    private int rows;
    private int columns;
	private int generation = 0;
    private int liveCells = 0;
    private Cell[][] next;

    // initializes a new grid with given columns and rows.
    // creates a new cell in each position
    public Grid (int rows, int columns)
	{
        this.rows = rows;
        this.columns = columns;
		grid = new Cell [rows][columns];
		for (int i = 0; i < rows; i ++)
		{
			for (int j = 0; j < columns ; j++)
			{
				grid[i][j] = new Cell();
			}
		}
		
	}

	public void setInitial (int row, int column)
	{

        grid[row][column].setLive();
	}

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Cell getCell(int row, int column){
        return grid[row][column];
    }

	public void nextGeneration ()
	{
        next = new Cell[getRows()][getColumns()];
        for (int i = 0; i< this.rows; i++) {
            for (int j = 0; j< this.columns; j++){
                next[i][j] = getNextState(grid, i, j);
                liveCells =0;
            }
        }
        grid = next;
		generation++;
	}
	
	
	public void printGame ()
	{//top left corner is (0,0)
		System.out.println ("Generation: "+generation);
		for (int numRow =0; numRow < rows; numRow++)
		{
			for (int numColumn = 0; numColumn < columns; numColumn++)
			{
				grid[numRow][numColumn].printCell();
			}
			System.out.println ();
		}
		
	}
    public Cell getNextState(Cell[][] board, int row, int column)
    {
        countSurroundingCells(board, row, column);
        Cell nextCell = new Cell();
        //rules for figuring out state of cell
        if ((liveCells <2 || liveCells >3) && board[row][column].getCurrentState())
        {
            nextCell.setDead();
        }
        else if ((liveCells == 2 || liveCells == 3) && board [row][column].getCurrentState())
        {
            nextCell.setLive();
        }
        else if (liveCells ==3 && !board[row][column].getCurrentState())
        {
             nextCell.setLive();
        }

        return nextCell;

    }
    private int countSurroundingCells(Cell[][] board, int row, int column) {
        for (NeighborCell neighbor: NeighborCell.values()){
            if (NeighborCell.getNeighborCellState(neighbor, board, row, column)){
                liveCells++;
            }
        }
        return liveCells;
    }
}