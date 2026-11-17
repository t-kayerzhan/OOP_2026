package problem2;

public class TestChess {
    public static void main(String[] args) {
        
        Rook rook = new Rook(Piece.Color.WHITE, new Position(0, 0));
        
        boolean canMove = rook.isLegalMove(new Position(4, 0));
        System.out.println("Can the rook move to a5? " + canMove); 
        
        canMove = rook.isLegalMove(new Position(2, 2));
        System.out.println("Can the rook move to c3? " + canMove); 
    }
}