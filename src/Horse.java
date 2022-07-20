public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(isTruePosition(line, column) && isTruePosition(toLine, toColumn) &&
                ((Math.abs(line - toLine) == 1) && (Math.abs(column - toColumn) == 2) ||
                        (Math.abs(line - toLine) == 2) && (Math.abs(column - toColumn) == 1)))) return false;
        if (chessBoard.board[toLine][toColumn] != null && getColor().equals(chessBoard.board[toLine][toColumn].getColor()))
            return false;
        return true;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

}
