package GameModel;


public enum NeighborCell {
    TOPLEFT, TOPCENTER, TOPRIGHT, RIGHT, LEFT, BOTTOMLEFT, BOTTOMCENTER, BOTTOMRIGHT;


    public static boolean getNeighborCellState(NeighborCell neighbor, Cell [][] board, int rows, int columns) {
        boolean state = false;
        switch (neighbor) {
            case TOPLEFT:
                if (!(rows == 0 || columns == 0)) {
                    state = board [rows-1][columns-1].getCurrentState();
                }

                break;
            case TOPCENTER:
                if (rows != 0) {
                    state = board [rows-1][columns].getCurrentState();
                }
                break;
            case TOPRIGHT:
                if (!(rows == 0 || columns == board[0].length-1)) {
                    state = board [rows-1][columns+1].getCurrentState();
                }
                break;
            case LEFT:
                if (columns != 0) {
                    state = board [rows][columns-1].getCurrentState();
                }
                break;
            case RIGHT:
                if (columns != board[0].length-1) {
                    state = board [rows][columns+1].getCurrentState();
                }
                break;
            case BOTTOMLEFT:
                if (!(rows == board.length-1 || columns == 0)) {
                    state = board [rows+1][columns-1].getCurrentState();;
                }
                break;
            case BOTTOMCENTER:
                if (rows != board.length-1) {
                    state = board [rows+1][columns].getCurrentState();;
                }
                break;
            case BOTTOMRIGHT:
                if (!(rows == board.length-1 || columns == board[0].length-1)) {
                    state = board [rows+1][columns+1].getCurrentState();
                }
                break;
        }
        return state;
    }


}
