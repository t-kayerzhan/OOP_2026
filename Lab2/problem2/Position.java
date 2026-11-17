package problem2;

public class Position {
 private int row; // 0 to 7   	8x8
 private int col; // 0 (a) to 7 (h)

 public Position(int row, int col) {
     if (row < 0 || row > 7 || col < 0 || col > 7)
         throw new IllegalArgumentException("invalid position");
     this.row = row;
     this.col = col;
 }

 public Position(String algebraic) {
     if (algebraic.length() != 2)
         throw new IllegalArgumentException("invalid format");
     char file = algebraic.charAt(0);  //row
     char rank = algebraic.charAt(1); //col
     col = file - 'a';
     row = rank - '1';
     if (row < 0 || row > 7 || col < 0 || col > 7)
         throw new IllegalArgumentException("out of board");
 }

 public int getRow() { return row; }
 public int getCol() { return col; }

 @Override
 public boolean equals(Object obj) {
     if (!(obj instanceof Position)) return false;
     Position p = (Position) obj;
     return row == p.row && col == p.col;
 }

 @Override
 public String toString() {
     return "" + (char)('a' + col) + (char)('1' + row);  //a1, e4 ...
 }
}