public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(isTruePosition(line, column) && isTruePosition(toLine, toColumn) &&
                ((line != toLine) && (column == toColumn) || (line == toLine) && (column != toColumn)))) return false;
        if (chessBoard.board[toLine][toColumn] != null && getColor().equals(chessBoard.board[toLine][toColumn].getColor()))
            return false;
        int lineStep = Integer.compare(toLine, line);
        int columnStep = Integer.compare(toColumn, column);
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
        return "R";
    }

}
