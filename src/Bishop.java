public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(isTruePosition(line, column) && isTruePosition(toLine, toColumn) && (line != toLine) &&
                (Math.abs(line - toLine) == Math.abs(column - toColumn)))) return false;
        if (chessBoard.board[toLine][toColumn] != null && getColor().equals(chessBoard.board[toLine][toColumn].getColor()))
            return false;
        int lineStep = toLine > line ? 1 : -1;
        int columnStep = toColumn > column ? 1 : -1;
        line += lineStep;
        column += columnStep;
        while (line != toLine) {
            if (chessBoard.board[line][column] != null) return false;
            line += lineStep;
            column += columnStep;
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

}
