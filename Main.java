import java.util.Scanner;
////////////////////////////////////////
// bazi ba computer


public class Main {
    public int count = 0;
    public static void main (String[] args) {
        TicTacToe tic1 = new TicTacToe();
        System.out.println("pley with your friend 1");
        System.out.println("pley with computer 2");
        Scanner scanner = new Scanner(System.in);
        int vorood = scanner.nextInt();
        int count = 0;
        if (vorood == 1) {
            while (true) {
                tic1.print();
                count++;
                int a = 0;
                if (count % 2 == 1)
                    a = tic1.player1();
                if (count % 2 == 0)
                    a = tic1.player2();
                if (a == 1) {
                    System.out.println("player 1 wins!");
                    break;
                }
                if (a == 2) {
                    System.out.println("player 2 wins!");
                    break;
                }
                if (count == 9) {
                    System.out.println("tie!");
                    break;
                }
            }
        }
        if (vorood == 2) {
            System.out.println("will you start or computer?"
            + "me 1   and for computer 2");
            int javab = scanner.nextInt();
            if (javab == 1) {
                while (true) {
                    tic1.print();
                    count++;
                    int a = 0;
                    if (count % 2 == 1)
                        a = tic1.player1();
                    if (count % 2 == 0)
                        a = tic1.playComp();
                    if (a == 1) {
                        System.out.println("player 1 wins!");
                        break;
                    }
                    if (a == 2) {
                        System.out.println("computer wins!");
                        break;
                    }
                    if (count == 9) {
                        System.out.println("tie!");
                        break;
                    }
                }
            }
            if (javab == 2) {
                while (true) {
                    tic1.print();
                    count++;
                    int a = 0;
                    if (count % 2 == 1)
                        a = tic1.playComp();
                    if (count % 2 == 0)
                        a = tic1.player1();
                    if (a == 1) {
                        System.out.println("player 1 wins!");
                        break;
                    }
                    if (a == 2) {
                        System.out.println("computer wins!");
                        break;
                    }
                    if (count == 9) {
                        System.out.println("tie!");
                        break;
                    }
                }
            }
        }
    }
}

class TicTacToe {
    enum move {
        X,O,empty;
    };
    private move x = move.X;
    private move o = move.O;
    private move Empty = move.empty;
    private move map[][] = new move[3][3];

    public TicTacToe() {
        int i,j;
        for ( i = 0 ; i <= 2 ; i++) {
            for (j = 0 ; j <= 2 ; j++) {
                map[i][j] = Empty;
            }
        }
    }
    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int win() {
        if (winRow() == 1 || winCol() == 1 || winDia() == 1 )
            return 1;

        if (winRow() == 2 || winCol() == 2 || winDia() == 2 )
            return 2;
        return 0;
    }

    public int winDia() {
        int alamatX = 0;
        int alamatO = 0;
        for (int i = 0; i < 3; i++) {
            if (map[i][i] == move.X)
                alamatX++;
            if (map[i][i] == move.O)
                alamatO++;
            if (alamatX == 3)
                return 1;
            if (alamatO == 3)
                return 2;
        }

        alamatX = 0;
        alamatO = 0;
        for (int i = 0; i < 3; i++) {
            if (map[i][2 - i] == move.X)
                alamatX++;
            if (map[i][2 - i] == move.O)
                alamatO++;
            if (alamatX == 3)
                return 1;
            if (alamatO == 3)
                return 2;
        }
        return 0;
    }

    public int winRow() {
        for (int i = 0; i < 3; i++) {
            int alamatX = 0;
            int alamatO = 0;
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == move.X)
                    alamatX++;
                if (map[i][j] == move.O)
                    alamatO++;
            }
            if (alamatX == 3)
                return 1;
            if (alamatO == 3)
                return 2;
        }
        return 0;
    }

    public int winCol() {
        for (int i = 0; i < 3; i++) {
            int alamatX = 0;
            int alamatO = 0;
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == move.X)
                    alamatX++;
                if (map[j][i] == move.O)
                    alamatO++;
            }
            if (alamatX == 3)
                return 1;
            if (alamatO == 3)
                return 2;
        }
        return 0;
    }

    public int player1() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (map[row][col] != Empty) {
                System.out.println("makan tekrari");
                continue;
            }
            map[row][col] = move.X;
            if (win() == 1)
                return 1;
            return 0;
        }
//        return 0;
    }
    public int player2() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (map[row][col] != move.empty) {
                System.out.println("makan tekrari");
                continue;
            }
            map[row][col] = move.O;
            if (win() == 2)
                return 2;
            return 0;
        }
    }
    public int playComp() {
        while (true) {
            int sw = 1;
            for (int i = 0; i < 3 && sw == 1; i++) {
                for (int j = 0; j < 3 && sw == 1; j++) {
                    if (map[i][j] == move.empty) {
                        map[i][j] = move.O;
                        sw = 0;
                    }
                }
            }
            // if sw == 0 break;
            if (win() == 2)
                return 2;
            return 0;
        }
    }

}