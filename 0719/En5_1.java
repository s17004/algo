import java.util.Scanner;
class En5_1 {
  public static void main(String[] args) {
    int n;
    Scanner stdIn = new Scanner(System.in);
    System.out.print("整数を入力せよ：");
    int x = stdIn.nextInt();
    if (x > 0){
      n = (x*(x-1));
    }else{
      n = 1;
    }
    System.out.println(x + "の階乗は" + n + "です。");
  }
}
