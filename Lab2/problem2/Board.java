package problem2;

public class Board {
    private Piece[][] grid = new Piece[8][8];
    private Position whiteKingPos, blackKingPos;

    public Board() {
        setupPieces();
    }

    private void setupPieces() {
        grid[0][0] = new Rook(Piece.Color.WHITE, new Position(0,0));
        grid[0][1] = new Knight(Piece.Color.WHITE, new Position(0,1));
        grid[0][2] = new Bishop(Piece.Color.WHITE, new Position(0,2));
        grid[0][3] = new Queen(Piece.Color.WHITE, new Position(0,3));
        grid[0][4] = new King(Piece.Color.WHITE, new Position(0,4));
        whiteKingPos = new Position(0,4);
        grid[0][5] = new Bishop(Piece.Color.WHITE, new Position(0,5));
        grid[0][6] = new Knight(Piece.Color.WHITE, new Position(0,6));
        grid[0][7] = new Rook(Piece.Color.WHITE, new Position(0,7));
        for (int c = 0; c < 8; c++)
            grid[1][c] = new Pawn(Piece.Color.WHITE, new Position(1,c));

        grid[7][0] = new Rook(Piece.Color.BLACK, new Position(7,0));
        grid[7][1] = new Knight(Piece.Color.BLACK, new Position(7,1));
        grid[7][2] = new Bishop(Piece.Color.BLACK, new Position(7,2));
        grid[7][3] = new Queen(Piece.Color.BLACK, new Position(7,3));
        grid[7][4] = new King(Piece.Color.BLACK, new Position(7,4));
        blackKingPos = new Position(7,4);
        grid[7][5] = new Bishop(Piece.Color.BLACK, new Position(7,5));
        grid[7][6] = new Knight(Piece.Color.BLACK, new Position(7,6));
        grid[7][7] = new Rook(Piece.Color.BLACK, new Position(7,7));
        for (int c = 0; c < 8; c++)
            grid[6][c] = new Pawn(Piece.Color.BLACK, new Position(6,c));
    }

    public Position getWhiteKingPos() { return whiteKingPos; }
    public Position getBlackKingPos() { return blackKingPos; }

    public void printBoard() {
        System.out.println("  a b c d e f g h");
        for (int r = 7; r >= 0; r--) {
            System.out.print((r+1) + " ");
            for (int c = 0; c < 8; c++) {
                if (grid[r][c] == null)
                    System.out.print("· ");
                else
                    System.out.print(grid[r][c].getSymbol() + " ");
            }
            System.out.println(r+1);
        }
        System.out.println("  a b c d e f g h");
    }

    public Piece getPiece(Position p) {
        return grid[p.getRow()][p.getCol()];
    }

    public void movePiece(Position from, Position to) {
        Piece piece = getPiece(from);
        if (piece == null) return;
        grid[from.getRow()][from.getCol()] = null;
        grid[to.getRow()][to.getCol()] = piece;
        piece.setPos(to);
        if (piece instanceof King) {
            if (piece.getColor() == Piece.Color.WHITE)
                whiteKingPos = to;
            else
                blackKingPos = to;
        }
        if (piece instanceof Pawn) {
            int promotionRow = (piece.getColor() == Piece.Color.WHITE) ? 7 : 0;
            if (to.getRow() == promotionRow) {
                grid[to.getRow()][to.getCol()] = new Queen(piece.getColor(), to);
            }
        }
    }

    public boolean isMoveLegal(Position from, Position to, Piece.Color currentPlayer) {
        Piece piece = getPiece(from);
        if (piece == null || piece.getColor() != currentPlayer) return false; // if the piece has and the same color?
        if (from.equals(to)) return false;  //go to the same cell

        Piece target = getPiece(to);
        if (target != null && target.getColor() == currentPlayer) return false;//cъесть свобю фигуру

        if (!piece.isLegalMove(to)) return false;

        if (!(piece instanceof Knight) && !isPathClear(from, to)) return false; //is clear the path

        if (wouldLeaveKingInCheck(from, to, currentPlayer)) return false; //check shax

        return true;
    }

    private boolean isPathClear(Position from, Position to) {
        int dr = Integer.signum(to.getRow() - from.getRow());
        int dc = Integer.signum(to.getCol() - from.getCol());
        int r = from.getRow() + dr;
        int c = from.getCol() + dc;
        while (r != to.getRow() || c != to.getCol()) {
            if (grid[r][c] != null) return false; //not cle4ar-=>false
            r += dr;
            c += dc;
        }
        return true;
    }

    private boolean wouldLeaveKingInCheck(Position from, Position to, Piece.Color player) {
        Piece piece = getPiece(from);
        Piece captured = getPiece(to);
        grid[from.getRow()][from.getCol()] = null;
        grid[to.getRow()][to.getCol()] = piece;
        Position oldPos = piece.getPos();
        piece.setPos(to);

        Position kingPos = (player == Piece.Color.WHITE) ? whiteKingPos : blackKingPos;
        if (piece instanceof King) kingPos = to;

        boolean inCheck = isSquareAttacked(kingPos, player);

        grid[from.getRow()][from.getCol()] = piece;
        grid[to.getRow()][to.getCol()] = captured;
        piece.setPos(oldPos);
        if (piece instanceof King) {
            if (player == Piece.Color.WHITE)
                whiteKingPos = from;
            else
                blackKingPos = from;
        }

        return inCheck;
    }

    public boolean isSquareAttacked(Position square, Piece.Color defendingPlayer) {
        Piece.Color opponent = (defendingPlayer == Piece.Color.WHITE) ? Piece.Color.BLACK : Piece.Color.WHITE;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) { //check all cells of the board
                Piece p = grid[r][c]; //each piece
                if (p != null && p.getColor() == opponent) {
                    if (p.isLegalMove(square)) {
                        if (p instanceof Knight) return true;
                        if (isPathClear(p.getPos(), square)) return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasAnyLegalMove(Piece.Color player) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece p = grid[r][c];
                if (p != null && p.getColor() == player) {
                    Position from = new Position(r, c); //from
                    for (int r2 = 0; r2 < 8; r2++) {
                        for (int c2 = 0; c2 < 8; c2++) {
                            Position to = new Position(r2, c2); //to
                            if (isMoveLegal(from, to, player))
                                return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}