public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!(isTruePosition(line, column) && isTruePosition(toLine, toColumn) &&
                ((Math.abs(line - toLine) == 1) && (Math.abs(column - toColumn) == 1) ||
                        (Math.abs(line - toLine) == 1) && (column == toColumn) ||
                        (line == toLine) && (Math.abs(column - toColumn) == 1)))) return false;
        if (chessBoard.board[toLine][toColumn] != null && getColor().equals(chessBoard.board[toLine][toColumn].getColor()))
            return false;
        return true;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (isTruePosition(line, column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(getColor()) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

}
