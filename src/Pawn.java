public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(isTruePosition(line, column) && isTruePosition(toLine, toColumn) && (column == toColumn) &&
                ("White".equals(getColor()) && ((line == 1) && ((toLine == 2) || (toLine == 3)) || (line >= 2) && (line <= 6) && (toLine - line == 1)) ||
                        "Black".equals(getColor()) && ((line == 6) && ((toLine == 5) || (toLine == 4)) || (line <= 5) && (line >= 1) && (line - toLine == 1))))) return false;
        if (chessBoard.board[toLine][toColumn] != null && getColor().equals(chessBoard.board[toLine][toColumn].getColor()))
            return false;
        if ((Math.abs(line - toLine) == 2) && (chessBoard.board[(line + toLine) / 2][column] != null)) return false;
        return true;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

}
