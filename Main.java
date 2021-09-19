package tictactoe;

import java.util.Scanner;

public class Main {
    static Scanner cs = new Scanner(System.in);
    static char[] input;
    static int p,m;
    static String check;

    public static void won(String s) {


        switch (s) {
            case "Draw":
                System.out.println("Draw");
                break;
            case "Impossible":
                System.out.println("Impossible");
                break;
            case "X wins":
                System.out.println("X wins");
                break;
            case "O wins":
                System.out.println("O wins");
                break;
        }
    }

    static String boardCondition() {
        int xs = 0;
        int os = 0;
        String cond = "Game not finished";
        for (char c : input) {
            if (c == 'X') {
                xs++;
            }
            if (c == 'O') {
                os++;
            }
        }

        if (input[0] + input[1] + input[2] == 264
                && input[3] + input[4] + input[5] == 237
                || input[0] + input[1] + input[2] == 264
                && input[6] + input[7] + input[8] == 237
                || input[0] + input[1] + input[2] == 237
                && input[3] + input[4] + input[5] == 264
                || input[0] + input[1] + input[2] == 237
                && input[6] + input[7] + input[8] == 264
                || input[3] + input[4] + input[5] == 237
                && input[6] + input[7] + input[8] == 264
                || input[3] + input[4] + input[5] == 264
                && input[6] + input[7] + input[8] == 237
                || input[0] + input[3] + input[6] == 264
                && input[1] + input[4] + input[7] == 237
                || input[0] + input[3] + input[6] == 264
                && input[2] + input[5] + input[8] == 237
                || input[0] + input[3] + input[6] == 237
                && input[1] + input[4] + input[7] == 264
                || input[0] + input[3] + input[6] == 237
                && input[2] + input[5] + input[8] == 264
                || input[1] + input[4] + input[7] == 264
                && input[2] + input[5] + input[8] == 237
                || input[1] + input[4] + input[7] == 237
                && input[2] + input[5] + input[8] == 264) {
            cond = "Impossible";
        } else if ((Math.abs(xs - os) > 1) || (Math.abs(os - xs) > 1)) {
            cond = "Impossible";
        } else if (input[0] + input[1] + input[2] == 264
                || input[0] + input[3] + input[6] == 264
                || input[0] + input[4] + input[8] == 264
                || input[2] + input[5] + input[8] == 264
                || input[6] + input[7] + input[8] == 264
                || input[2] + input[4] + input[6] == 264
                || input[3] + input[4] + input[5] == 264
                || input[1] + input[4] + input[7] == 264) {
            cond = "X wins";
        } else if (input[0] + input[1] + input[2] == 237
                || input[0] + input[3] + input[6] == 237
                || input[0] + input[4] + input[8] == 237
                || input[2] + input[5] + input[8] == 237
                || input[6] + input[7] + input[8] == 237
                || input[2] + input[4] + input[6] == 237
                || input[3] + input[4] + input[5] == 237
                || input[1] + input[4] + input[7] == 237) {
            cond = "O wins";
        } else if (xs + os == 9) {
            cond = "Draw";
        } else return cond;

        return cond;
    }

    static void checkBoard() {

        String result = "---------" + "\n" + "| ";
        String input2;
        int l = input.length;
        int k = 0, row, col;
        row = (int) Math.sqrt(l);
        col = (int) Math.sqrt(l);

        if (row * col < l) {
            row = col;
        }
        char[][] boardGrid = new char[row][col];


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (k < input.length)
                    boardGrid[i][j] = input[k];
                k++;
                result += boardGrid[i][j] + " ";
            }
            if (k < 8) {
                result = result + "|" + "\n" + "| ";
            } else result = result + "|" + "\n" + "---------";

        }
        //System.out.println("Enter coordinates: ");
            while (true) {
                System.out.println("Enter coordinates: ");
                input2 = cs.nextLine();

                int i = (input2.charAt(0) - '0') - 1;
                int j = (input2.charAt(2) - '0') - 1;

                if (i > 2 || j > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.println("Enter coordinates: ");
                } else if (Character.isDigit(i) && Character.isDigit(j)) {
                    System.out.println("You should enter numbers!");
                    System.out.println("Enter coordinates: ");
                } else if (boardGrid[i][j] == 88 || boardGrid[i][j] == 79) {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.println("Enter coordinates: ");
                } else if (boardGrid[p][m] == 'X') {
                    boardGrid[i][j] = 'O';

                    System.out.println("---------");
                    System.out.println("| " + boardGrid[0][0] + " " + boardGrid[0][1] + " " + boardGrid[0][2] + " " + "|");
                    System.out.println("| " + boardGrid[1][0] + " " + boardGrid[1][1] + " " + boardGrid[1][2] + " " + "|");
                    System.out.println("| " + boardGrid[2][0] + " " + boardGrid[2][1] + " " + boardGrid[2][2] + " " + "|");
                    System.out.println("---------");
                    if (i == 0 && j == 0) {
                        input[0] = boardGrid[i][j];
                    }
                    if (i == 0 && j == 1) {
                        input[1] = boardGrid[i][j];
                    }
                    if (i == 0 && j == 2) {
                        input[2] = boardGrid[i][j];
                    }
                    if (i == 1 && j == 0) {
                        input[3] = boardGrid[i][j];
                    }
                    if (i == 1 && j == 1) {
                        input[4] = boardGrid[i][j];
                    }
                    if (i == 1 && j == 2) {
                        input[5] = boardGrid[i][j];
                    }
                    if (i == 2 && j == 0) {
                        input[6] = boardGrid[i][j];
                    }
                    if (i == 2 && j == 1) {
                        input[7] = boardGrid[i][j];
                    }
                    if (i == 2 && j == 2) {
                        input[8] = boardGrid[i][j];
                    }
                    p = i;
                    m = j;
                    won(boardCondition());
                    if (boardCondition().equals("X wins") || boardCondition().equals("O wins") || boardCondition().equals("Draw")) {
                        break;
                }
            }

                    else if (boardGrid[p][m] != 'X') {
                        boardGrid[i][j] = 'X';
                        System.out.println("---------");
                        System.out.println("| " + boardGrid[0][0] + " " + boardGrid[0][1] + " " + boardGrid[0][2] + " " + "|");
                        System.out.println("| " + boardGrid[1][0] + " " + boardGrid[1][1] + " " + boardGrid[1][2] + " " + "|");
                        System.out.println("| " + boardGrid[2][0] + " " + boardGrid[2][1] + " " + boardGrid[2][2] + " " + "|");
                        System.out.println("---------");
                        if (i == 0 && j == 0) {
                            input[0] = boardGrid[i][j];
                        }
                        if (i == 0 && j == 1) {
                            input[1] = boardGrid[i][j];
                        }
                        if (i == 0 && j == 2) {
                            input[2] = boardGrid[i][j];
                        }
                        if (i == 1 && j == 0) {
                            input[3] = boardGrid[i][j];
                        }
                        if (i == 1 && j == 1) {
                            input[4] = boardGrid[i][j];
                        }
                        if (i == 1 && j == 2) {
                            input[5] = boardGrid[i][j];
                        }
                        if (i == 2 && j == 0) {
                            input[6] = boardGrid[i][j];
                        }
                        if (i == 2 && j == 1) {
                            input[7] = boardGrid[i][j];
                        }
                        if (i == 2 && j == 2) {
                            input[8] = boardGrid[i][j];
                        }
                        p = i;
                        m = j;
                        won(boardCondition());
                    if (boardCondition().equals("X wins") || boardCondition().equals("O wins") || boardCondition().equals("Draw")) {
                        break;
                    }
                    }
                }
            }
    public static void main(String[] args) {

        input = new char[] {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

        System.out.println("---------");
        System.out.println("| " + input[0] + " " + input[1] + " " + input[2] + " " + "|");
        System.out.println("| " + input[4] + " " + input[4] + " " + input[5] + " " + "|");
        System.out.println("| " + input[6] + " " + input[7] + " " + input[8] + " " + "|");
        System.out.println("---------");

        checkBoard();

       //

    }

}
