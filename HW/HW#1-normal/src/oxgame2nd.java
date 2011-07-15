import java.io.*;
import java.util.*;

public class oxgame2nd {
    public static int[][] a = new int[3][3];
    public static int[][] tmpScore = new int[3][3];
    public static int[] gameScore = new int[8];
    public static int currentScore = 0;
    public static int finish = 0;
    public static int tmpPlayer = 0;
    public static int startWith = 1;
    public static String[] highScore = new String[5];
    public static String playerName = "";
    public static int[] gameBoard = new int[5];
    public static String[] player = new String[5];
    public static LinkedList<Integer> numbersList = new LinkedList<Integer>();
   
    public static void main(String args[]) throws IOException{
        String onPlay = "";
        String again = "";
        tmpPlayer = 0;
        startWith = 1;
        while(onPlay!="n"){
            a = new int[3][3];
            tmpPlayer = 0;
            again = "";
            onPlay = "";
            buildTable();
            randomVal();
            for(int l = 0;l <= 8; l++){
                getDirection();
                finish = chkResult();
                if(finish==1){
                    break;
                }
            }
            if(finish == 0){
                System.out.println("---> DRAW!!!");
            }else{
               
                recordPlayer(currentScore);
            }
            while(again!="y"){
                BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Do you want to play again (y/n)?");
                String keyInput = buf.readLine();
                if(keyInput.charAt(0) == 'y'){
                    again = "y";
                    int chk = 0;
                    while(chk==0){
                        System.out.println("Who's the first player (o/x)?");
                        String keyPlayer = buf.readLine();
                        if(keyPlayer.charAt(0)=='o'){
                            startWith = 1;
                            chk = 1;
                        }else if(keyPlayer.charAt(0)=='x'){
                            startWith = 10;
                            chk = 1;
                        }
                    }
                }
                if(keyInput.charAt(0) == 'n'){
                    again = "y";
                    onPlay = "n";
                }
              
            }
        }
        System.out.println("Bye");
    }
    public static String getPlayer()throws IOException{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your name:");
        playerName = buf.readLine();
       
        return playerName;
    }
    public static void recordPlayer(int score)throws IOException{
        int tmpScore = 0;
        String tmpName = "";
        String name = "";
        
        if(gameBoard.length < 5){
            name = getPlayer();
            gameBoard[gameBoard.length]= score;
            player[gameBoard.length] = name;
        }

        if(score>gameBoard[gameBoard.length-1]){
            name = getPlayer();
           
            tmpScore = gameBoard[gameBoard.length-1];
            gameBoard[gameBoard.length-1] = score;
           
            tmpName = player[player.length-1];
            player[player.length-1]=name;
        }
        for(int x=gameBoard.length-1;x>=0;x--){
            if(x >= 1){
                if(gameBoard[x] > gameBoard[x-1]){
                    tmpScore = gameBoard[x-1];
                    gameBoard[x-1] = gameBoard[x];
                    gameBoard[x] = tmpScore;
                   
                    tmpName = player[x-1];
                    player[x-1] = player[x];
                    player[x] = tmpName;
                }
            }
        }
        System.out.println("High score");
        for(int y = 0;y<gameBoard.length;y++){
            System.out.print("name:"+player[y]+" score:");
            System.out.println(Integer.toString(gameBoard[y]));
        }
    }
  
    public static void buildTable(){
        System.out.print("    B1    B2    B3  \n");
        System.out.print("A1  "+changeVal(a[0][0])+"  |  "+changeVal(a[0][1])+"  |  "+changeVal(a[0][2])+"   \n");
        System.out.print("   ----+-----+----- \n");
        System.out.print("A2  "+changeVal(a[1][0])+"  |  "+changeVal(a[1][1])+"  |  "+changeVal(a[1][2])+"   \n");
        System.out.print("   ----+-----+----- \n");
        System.out.print("A3  "+changeVal(a[2][0])+"  |  "+changeVal(a[2][1])+"  |  "+changeVal(a[2][2])+"   \n");
    }
 
    public static int chkPlayer(){
        int sum = 0;
        int curPlayer = 0;
        for(int x = 0; x<=2; x++){
            for(int y = 0; y<=2; y++){
                sum = a[x][y]+sum;
            }
        }
      
        if(startWith==1){
            if(sum%11==0){
                curPlayer = 1;
            }else{
                curPlayer = 10;
            }
        }else{
            if(sum%11==0){
                curPlayer = 10;
            }else{
                curPlayer = 1;
            }
        }
        return curPlayer;
     
    }
 
    public static void getDirection() throws IOException{
        int posx=0;
        int posy=0;
        if(chkPlayer()==1){
            int o = 0;
            while(o==0){
                posx = Integer.parseInt(directionKey("o(A):"));
                posy = Integer.parseInt(directionKey("o(B):"));
                if(a[posx][posy] == 0){
                    o = 1;
                }else{
                    System.out.println("Invalid move, please choose again!");
                }
            }
            a[posx][posy] = 1;
            buildTable();
         
        }else{
            int x = 0;
            while(x==0){
                posx = Integer.parseInt(directionKey("x(A):"));
                posy = Integer.parseInt(directionKey("x(B):"));
                if(a[posx][posy] == 0){
                    x = 1;
                }else{
                    System.out.println("Invalid move, please choose again!");
                }
            }
            a[posx][posy] = 10;
            buildTable();
        }
      
    }
 
    public static String directionKey(String txt) throws IOException{
        String strInput="";
        int e1 = 0;
        int thisNum = 0;
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(e1 == 0){
            e1 = 0;
            System.out.println(txt);
            strInput = br.readLine();
            try{
                thisNum = Integer.parseInt(strInput);
                if(((thisNum-1) <= 2)&&((thisNum-1) >= 0)){
                    e1 = 1;
                }else{
                    System.out.println("Invalid move, please choose again!");
                }
            }
            catch(Throwable t) {
                System.out.println("Invalid move, please choose again!");
            }

        }
        strInput = Integer.toString(thisNum-1);
        return strInput;
    }
 
    public static String changeVal(int num){
        String result = "";
        for(int i = 0; i<=2; i++){
            for(int j=0; j<=2; j++){
                if(num==1){
                    result = "o";
                }else if(num==10){
                    result = "x";
                }else{
                    result = " ";
                }
            }
        }
        return result;
    }

    public static void randomVal(){
        for(int i=1;i<=9;i++){
            numbersList.add(i);
        }
        Collections.shuffle(numbersList);
    }
 
    public static void dumpScore(){
        int pos = 0;
        for(int i = 0; i<=2; i++){
            for(int j=0; j<=2; j++){
                tmpScore[i][j] = numbersList.get(pos);
                pos++;
            }
        }
        gameScore[0] = tmpScore[0][0]+tmpScore[0][1]+tmpScore[0][2];
        gameScore[1] = tmpScore[1][0]+tmpScore[1][1]+tmpScore[1][2];
        gameScore[2] = tmpScore[2][0]+tmpScore[2][1]+tmpScore[2][2];
        gameScore[3] = tmpScore[0][0]+tmpScore[1][0]+tmpScore[2][0];
        gameScore[4] = tmpScore[0][1]+tmpScore[1][1]+tmpScore[2][1];
        gameScore[5] = tmpScore[0][2]+tmpScore[1][2]+tmpScore[2][2];
        gameScore[6] = tmpScore[0][0]+tmpScore[1][1]+tmpScore[2][2];
        gameScore[7] = tmpScore[2][0]+tmpScore[1][1]+tmpScore[0][2];
    }
 
    public static int chkResult(){
        int[] gameCase = new int[8];
        gameCase[0] = a[0][0]+a[0][1]+a[0][2];
        gameCase[1] = a[1][0]+a[1][1]+a[1][2];
        gameCase[2] = a[2][0]+a[2][1]+a[2][2];
        gameCase[3] = a[0][0]+a[1][0]+a[2][0];
        gameCase[4] = a[0][1]+a[1][1]+a[2][1];
        gameCase[5] = a[0][2]+a[1][2]+a[2][2];
        gameCase[6] = a[0][0]+a[1][1]+a[2][2];
        gameCase[7] = a[2][0]+a[1][1]+a[0][2];
     
        for(int k=0; k<=7; k++){
            if(gameCase[k] == 3){
                dumpScore();
                currentScore = gameScore[k];
                System.out.println("---> o won with "+currentScore+" points");
                return 1;
            }else if(gameCase[k] == 30){
                dumpScore();
                currentScore = gameScore[k];
                System.out.println("---> x won with "+currentScore+" points");
                return 1;
            }
        }
        return 0; 
    }
 
}