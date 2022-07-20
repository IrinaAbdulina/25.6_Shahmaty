public abstract class ChessPiece {
    private String color;
    protected boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    protected boolean isTruePosition(int line, int column) {
        return (line >= 0) && (line <= 7) && (column >= 0) && (column <= 7);
    }

    public abstract String getSymbol();


}
