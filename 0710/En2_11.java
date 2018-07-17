import java.util.Scanner;
class En2_11{
   int y;   // 西暦年
   int m;   // 月（1～12）
   int d;   // 日（1～31）
   static int[][] mdays = {
      {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},   // 平年
      {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},   // 閏年
   };
   static int isLeap(int year) {
      return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
   }
   En2_11(int y, int m, int d) {
      this.y = y;
      this.m = m;
      this.d = d;
   }
   En2_11 after(int n) {
      En2_11 temp = new En2_11(this.y, this.m, this.d);
      if (n < 0)
         return (before(-n));
     temp.d += n;
      while (temp.d > mdays[isLeap(temp.y)][temp.m - 1]) {
         temp.d -= mdays[isLeap(temp.y)][temp.m - 1];
         if (++temp.m > 12) {
            temp.y++;
            temp.m = 1;
         }
      }
    return temp;
   }
   En2_11 before(int n) {
      En2_11 temp = new En2_11(this.y, this.m, this.d);
      if (n < 0)
         return (after(-n));
      temp.d -= n;
      while (temp.d < 1) {
         if (--temp.m < 1) {
            temp.y--;
            temp.m = 12;
         }
         temp.d += mdays[isLeap(temp.y)][temp.m - 1];
      }
      return temp;
   }
   public static void main(String[] args) {
      Scanner stdIn = new Scanner(System.in);
      System.out.print("日付を入力してください。\n");
      System.out.print("年：");  int y = stdIn.nextInt();
      System.out.print("月：");  int m = stdIn.nextInt();
      System.out.print("日：");  int d = stdIn.nextInt();
      En2_11 date = new En2_11(y, m, d);
      System.out.print("何日前／後の日付を求めますか：");
      int n = stdIn.nextInt();
      En2_11 d1 = date.after(n);
      System.out.printf("%d日後の日付は%d年%d月%d日です。\n", n, d1.y, d1.m, d1.d);
      En2_11 d2 = date.before(n);
      System.out.printf("%d日前の日付は%d年%d月%d日です。\n", n, d2.y, d2.m, d2.d);
   }
}
