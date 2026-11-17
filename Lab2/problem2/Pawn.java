package problem2;

public class Pawn extends Piece {
 public Pawn(Color color, Position pos) {
     super(color, pos);
     symbol = (color == Color.WHITE) ? '♙' : '♟';
 }

 @Override
 public boolean isLegalMove(Position b) {
     int dr = b.getRow() - pos.getRow(); 
     int dc = Math.abs(b.getCol() - pos.getCol());
     int forward = (color == Color.WHITE) ? 1 : -1; // white moves up (row+1), black down (row-1)

     if (dc == 0 && dr == forward)
         return true;
     int startRow = (color == Color.WHITE) ? 1 : 6;
     if (pos.getRow() == startRow && dc == 0 && dr == 2 * forward)
         return true;
     if (dc == 1 && dr == forward) //diagonal
         return true;
     return false;
 }
}