import java.util.Scanner;

class En6_13_02 {

  //--- 配列の要素a[idx1]とa[idx2]を交換 ---//
  static void swap(int[] a, int idx1, int idx2) {
    int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
  }

  //--- 配列を分割する ---//
  static void quickSort(int[] a, int left, int right) {
    int pl = left;               // 左カーソル
    int pr = right;            // 右カーソル
    int x = a[(pl + pr) / 2];   // 枢軸（中央の要素）

    System.out.printf("a[%d]～a[%d]：{", left, right);
    for (int i = left; i < right; i++)
      System.out.printf("%d , ", a[i]);
    System.out.printf("%d}\n", a[right]);

    do {
      while (a[pl] > x) pl++;
      while (a[pr] < x) pr--;
      if (pl <= pr)
        swap(a, pl++, pr--);
    } while (pl <= pr);

    if (pr - left < right - pl) {
      int temp;
      temp = left;  left  = pl; pl = temp;
      temp = right; right = pr; pr = temp;
    }
    if (left < pr)  quickSort(a, left, pr);
    if (pl < right) quickSort(a, pl, right);
  }

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    System.out.println("クイックソート");
    System.out.print("要素数：");
    int nx = stdIn.nextInt();
    int[] x = new int[nx];

    for (int i = 0; i < nx; i++) {
      System.out.print("x[" + i + "]：");
      x[i] = stdIn.nextInt();
    }

    quickSort(x, 0, nx - 1);         // 配列xをクイックソート

    System.out.println("昇順にソートしました。");
    for (int i = 0; i < nx; i++)
      System.out.println("x[" + i + "]＝" + x[i]);
  }
}
