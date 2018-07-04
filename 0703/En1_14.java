import java.util.Scanner;
class En1_14 {
  public static void main(String[]args){
    System.out.println("正方形を表示します。");
    Scanner setID = new Scanner(System.in);
    int dansu;
    do{
    System.out.print("段数は：");
    dansu = setID.nextInt();
    }while(dansu <= 0);
    for(int i = 1;i<=dansu;i++){
      for(int j = 1;j<=dansu;j++)
        System.out.print('*');
      System.out.println();
    }
  }
}
