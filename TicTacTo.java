import java.util.Scanner;

public class TicTacTo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char arr[][] = { {'7','8','9'},{'4','5','6'},{'1','2','3'} };
        boolean is_selected[] = new boolean[9];
        System.out.println("Player 1 is has O and Player 2 has X");
        int x = 0;
        while(true){
            print_board(arr);
            if (is_ended(arr) == 'X'){
                System.out.println("**************");
                System.out.println("Player 2 Wins");
                System.out.println("**************");
                break;
            }else if (is_ended(arr) == 'O'){
                System.out.println("**************");
                System.out.println("Player 1 Wins");
                System.out.println("**************");
                break;
            }
            if (is_tied(arr)){
                System.out.println("Tied!!");
                break;
            }
            System.out.print("Enter The Box (Player #" + ( (x % 2 == 0) ? "1 (O)" : "2 (X)") + " ) : ");
            int choice = input.nextInt();
            if (is_selected[choice - 1]){
                System.out.println("Already Selected");
                continue;
            }
            is_selected[choice - 1] = true;
            arr = update_board(arr,choice, (x % 2 == 0));
            x++;
        }
        
    }
    static char[][] update_board(char[][] arr,int choice, boolean is_1){
        switch(choice){
            case 1: arr[2][0] = (is_1) ? 'O' : 'X'; break;
            case 2: arr[2][1] = (is_1) ? 'O' : 'X'; break;
            case 3: arr[2][2] = (is_1) ? 'O' : 'X'; break;
            case 4: arr[1][0] = (is_1) ? 'O' : 'X'; break;
            case 5: arr[1][1] = (is_1) ? 'O' : 'X'; break;
            case 6: arr[1][2] = (is_1) ? 'O' : 'X'; break;
            case 7: arr[0][0] = (is_1) ? 'O' : 'X'; break;
            case 8: arr[0][1] = (is_1) ? 'O' : 'X'; break;
            case 9: arr[0][2] = (is_1) ? 'O' : 'X'; break;
        }
        return arr;
    }
    static void print_board(char arr[][]){
        System.out.println("------");
        System.out.println(arr[0][0] + "|" + arr[0][1] + "|" + arr[0][2]);
        System.out.println(arr[1][0] + "|" + arr[1][1] + "|" + arr[1][2]);
        System.out.println(arr[2][0] + "|" + arr[2][1] + "|" + arr[2][2]);
        System.out.println("------");
    }
    // return 1 when not ended , -1 or 0 for winner
    static char is_ended(char [][] arr){
        if (compare(arr[0][0], arr[0][1], arr[0][2]))
            return arr[0][0];
        else if(compare(arr[1][0], arr[1][1], arr[1][2]))
            return arr[1][0];
        else if(compare(arr[2][0], arr[2][1], arr[2][2]))
            return arr[2][0];
        else if(compare(arr[0][0], arr[1][0], arr[2][0]))
            return arr[0][0];
        else if(compare(arr[0][1], arr[1][1], arr[2][1]))
            return arr[0][1];
        else if(compare(arr[0][2], arr[1][2], arr[2][2]))
            return arr[0][2];
        else if(compare(arr[0][0], arr[1][1], arr[2][2]))
            return arr[0][0];    
        else if(compare(arr[0][2], arr[1][1], arr[2][0]))
            return arr[0][2];
        else 
            return '1';
    }
    static boolean is_tied(char[][] arr){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3;j++){
                if (arr[i][j] != 'X' && arr[i][j] != 'O') return false;
            }
        }
        return true;
    }

    static boolean compare(int a, int b, int c){
        return (a == b && b == c); 
    }
}
