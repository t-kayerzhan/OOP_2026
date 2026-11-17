package problem2;

import java.util.Scanner;

public class ChessGame {
    private Board board;
    private Piece.Color currentPlayer;
    private Scanner scanner;

    public ChessGame() {
        board = new Board();
        currentPlayer = Piece.Color.WHITE;
        scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("===== CHESS =====");
        System.out.println("Enter moves as 'e2 e4'. 'Q' to exit.");
        board.printBoard();

        while (true) {
            System.out.print("\n" + currentPlayer + "'s move: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("Q")) break;

            String[] parts = input.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Invalid format. Use 'e2 e4'.");
                continue;
            }

            try {
                Position from = new Position(parts[0]);
                Position to = new Position(parts[1]);

                if (!board.isMoveLegal(from, to, currentPlayer)) {
                    System.out.println("Illegal move, try again.");
                    continue;
                }

                board.movePiece(from, to);
                board.printBoard();

                Piece.Color opponent = (currentPlayer == Piece.Color.WHITE) ? Piece.Color.BLACK : Piece.Color.WHITE;
                Position opponentKingPos = (opponent == Piece.Color.WHITE) ? board.getWhiteKingPos() : board.getBlackKingPos();
                boolean opponentInCheck = board.isSquareAttacked(opponentKingPos, opponent);

                if (opponentInCheck) {
                    if (!board.hasAnyLegalMove(opponent)) {
                        System.out.println("МАТ " + currentPlayer + " wins!");
                        break;
                    } else {
                        System.out.println("ШАХ");
                    }
                } else if (!board.hasAnyLegalMove(opponent)) {
                    System.out.println("ПАТ.");
                    break;
                }

                currentPlayer = opponent;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid position. Use (e.g., e2).");
            }
        }
        scanner.close();
        System.out.println("Game ended.");
    }

    public static void main(String[] args) {
        new ChessGame().play();
    }
}