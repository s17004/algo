import java.util.*;
public class EN0829 {
    static String[][] rank;
    static void printRank(String [][] r) {
        for (String[] a : r) {
            System.out.println(a[0] + " " + a[1] + " " + a[2]);
        }
    }
    static final Comparator<String []> RANK_ORDER = new RankOrderComparator();

    private static class RankOrderComparator implements Comparator<String []>{
        public int compare(String[] strd1, String[] strd2){
            int[] d1 = new int[3];
            int[] d2 = new int[3];
            try{
                for(int i = 0; i < 3;i++){
                    d1[i] = Integer.parseInt(strd1[i]);
                    d2[i] = Integer.parseInt(strd2[i]);
                }
            }catch(Exception e){System.out.println("Bad Data.");}

            int result;
            if(d1[0] > d2[0]) result = -1;
            else if(d1[0] < d2[0]) result = 1;
            else{
                if(d1[1] > d2[1]) result = -1;
                else if(d1[1] < d2[1]) result = 1;
                else result = 0;
            }
            return result;
        }
    }

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        rank = new String[N][];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            String[] array = s.split(",");
            rank[i] = array;
        }
        Arrays.sort(rank, new RankOrderComparator());

        System.out.println("降順ソート");
        printRank(rank);
    }
}
