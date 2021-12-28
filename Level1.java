package com.company;

import java.util.*;

public class Level1 {
    // TASK 1
    public static int squirrel(int N) {
        if(N == 0) {
            return 1;
        }
        double log_Frac = 0.0;
        for(int i = 2; i <= N; i++) {
            log_Frac += Math.log10(i); // sum of logarithms of numbers 2..N
        }

        // Taking the fraction part of sum
        double int_part = (int) log_Frac;
        log_Frac = log_Frac - int_part;

        // finding the first digit of N!
        double z = Math.pow(10,log_Frac);
        int x = (int) z;
        while(x >= 10)
            x /= 10;
        return x;
    }

    // TASK 2
    public static int odometer(int [] oksana) {
        int S = oksana[0]*oksana[1];
        for(int i = 2; i<oksana.length; i += 2) {
            S += oksana[i] * (oksana[i+1] - oksana[i-1]);
        }
        return S;

    }

    //TASK 3
    public static int ConquestCampaign(int N, int M, int L, int [] battalion) {

        int[][] map = new int[N][M];
        for(int i = 0; i <2*L; i+=2) {
            map[battalion[i]-1][battalion[i+1]-1] = 1;
        }

        int n = L;
        int days = 1;

        while(n < N*M) {
            for(int i = 0; i <N; i++) {
                for(int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        if (i > 0) {
                            if(map[i - 1][j] == 0) {
                                map[i - 1][j] = 2;
                            }
                        }
                        if (j > 0) {
                            if(map[i][j - 1] == 0) {
                                map[i][j - 1] = 2;
                            }
                        }
                        if (i < N - 1) {
                            if (map[i + 1][j] == 0) {
                                map[i + 1][j] = 2;
                            }
                        }
                        if (j < M - 1) {
                            if (map[i][j + 1] == 0) {
                                map[i][j + 1] = 2;
                            }
                        }
                    }
                }
            }
            for(int i = 0; i <N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 2) {
                        map[i][j] = 1;
                        n++;
                    }
                }
            }
            days++;
        }
        return days;
    }

    // TASK 4

    public static void swapInt(int[] Arr, int i1, int i2) {
        int x = Arr[i1];
        Arr[i1] = Arr[i2];
        Arr[i2] = x;
    }
    public static int [] MadMax(int N, int [] Tele) {
        int mid = N / 2;
        int [] Tele_copy = new int[N];
        for(int i = 0; i < N; i++) {
            Tele_copy[i] = Tele[i];
        }
        int max = 0;
        int min = 255;
        int i_max = 0;
        int i_min = 0;

        for(int i = 0; i < N; i++){
            if (Tele_copy[i] > max) {
                max = Tele_copy[i];
                i_max = i;
            }
            if(Tele_copy[i] < min) {
                min = Tele_copy[i];
                i_min = i;
            }
        }

        swapInt(Tele_copy, mid, i_max);
        swapInt(Tele_copy, 0, i_min);

        for (int i = 1; i < N; i++) {
            if (i < mid) {
                for (int j = i + 1; j < N; j++) {
                    if (Tele_copy[j] < Tele_copy[i]) {
                        swapInt(Tele_copy, i, j);
                    }
                }
            }
            if(i == mid) continue;
            if (i > mid) {
                for(int j = i + 1; j < N; j++) {
                    if(Tele_copy[j] > Tele_copy[i]) {
                        swapInt(Tele_copy, i, j);
                    }
                }
            }
        }
        return Tele_copy;
    }

    // TASK 5

    public static int [] SynchronizingTables(int N, int [] ids, int [] salary) {
        int[] ids_c = new int[N];
        int[] sal_c = new int[N];

        for (int i = 0; i < N; i++) {
            ids_c[i] = ids[i];
            sal_c[i] = salary[i];
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1 ; j < N; j++) {
                if(ids_c[j] < ids_c[i]) {
                    swapInt(ids_c, i, j);
                }
                if(sal_c[j] < sal_c[i]) {
                    swapInt(sal_c, i, j);
                }
            }
        }

        int[] res = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(ids[i] == ids_c[j]) {
                    res[i] = sal_c[j];
                }
            }
        }

        return res;
    }

    // TASK 6

    public static String PatternUnlock(int N, int [] hits) {
        int[][] map = {{6,1,9},{5,2,8},{4,3,7}};
        double path = 0;
        for (int i = 0; i < N - 1; i++) {
            int x = hits[i];
            int y = hits[i+1];
            int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(x == map[j][k]) {
                        x1 = j;
                        x2 = k;
                    }
                    if(y == map[j][k]) {
                        y1 = j;
                        y2 = k;
                    }
                }
            }
            if(x1 != y1 && x2 !=y2) {
                path += Math.sqrt(2);
            } else {
                path += 1;
            }
        }

        String path_str = String.format("%.5f",path);
        String res = "";
        for (int i = 0; i < path_str.length(); i++) {
            if(path_str.charAt(i) != '0' && path_str.charAt(i) != ',') {
                res += path_str.charAt(i);
            }
        }

        return res;
    }

    // TASK 7

    static boolean sublineFinder(String line1, String line2) {

        int l2Len = line2.length();

        if(l2Len == 0) {
            return true;
        }

        int l1Len = line1.length();
        int sublinesNum = l1Len - l2Len + 1;

        int i = 0;
        int j = 0;
        while(i < sublinesNum) {
            if(line1.charAt(i+j) != line2.charAt(j)) {
                j = 0;
                i++;
            } else {
                if(j == l2Len - 1) {
                    if (i+j == l1Len - 1) {
                        return true;
                    }
                    if(l1Len > i+j + 1) {
                        if (line1.charAt(i + j + 1) == ' ') {
                            return true;
                        }
                    }
                    j = -1;
                    i++;
                }
                j++;
            }
        }

        return false;
    }

    public static int [] WordSearch(int len, String s, String subs) {

        int n = s.length();

        ArrayList<ArrayList<Character>> strArr = new ArrayList<ArrayList<Character>>();
        int j = 0;
        ArrayList<Character> C = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int nextWordLen = 0;
            if (s.charAt(i) != ' ') {
                C.add(s.charAt(i));
            } else {
                for (int k = i + 1; k < n; k++ ) {
                    if(s.charAt(k) == ' ') {
                        break;
                    } else {
                        nextWordLen++;
                    }
                }
                if(C.size() + nextWordLen + 1 > len) {
                    strArr.add(C);
                    j++;
                    C = new ArrayList<>();
                } else {
                    C.add(s.charAt(i));
                }
            }

            if (i == n - 1) {
                strArr.add(C);
                j++;
            }
            if (C.size() == len) {
                strArr.add(C);
                j++;
                C = new ArrayList<>();
                if (i < n-1 && s.charAt(i+1) == ' ') {
                    i++;
                }
            }
        }

        String[] strArr2 = new String[j];
        for (int i = 0; i < j; i++) {
            strArr2[i] = "";
            for (int k = 0; k < strArr.get(i).size(); k++) {
                strArr2[i] += strArr.get(i).get(k);
            }
        }

        int[] res = new int[j];
        for (int i = 0; i < j; i++) {
            if (sublineFinder(strArr2[i],subs) == true) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        return res;

    }

    // TASK 8

    public static int SumOfThe(int N, int [] data) {
        int res = 0;
        for (int i = 0; i < N; i++) {
            int checksum = 0;
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    checksum += data[j];
                }
            }
            if (checksum == data[i]) {
                res = data[i];
            }
        }
        return res;
    }

    // TASK 9

    public static String TheRabbitsFoot(String s, boolean encode) {

        int n = s.length();
        String str = "";
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ' ') {
                str += s.charAt(i);
            }
        }

        int len = str.length();
        double sqlen = Math.sqrt(len);
        int low = (int) sqlen;
        int up = low + 1;
        while (low * up < len) {
            low++;
        }

        String res = "";
        char[][] c = new char[low][up];

        if (encode == true) {
            int i = 0;
            int j = 0;
            for (int k = 0; k < len; k++) {
                c[i][j] = str.charAt(k);
                if (j == up - 1) {
                    i++;
                    j = 0;
                } else {
                    j++;
                }

            }

            for (i = 0; i < low; i++) {
                for (j = 0; j < up; j++) {
                    if (c[j][i] != '\u0000') {
                        res += c[j][i];
                    }
                    if (j == up - 1 && i != low - 1) {
                        res += ' ';
                    }
                }
            }

        } else {
            int k = 0;
            for (int i = 0; i < up; i++ ) {
                if (k == n) {
                    break;
                }
                for (int j = 0; j < low; j++) {
                    if (k == n) {
                        break;
                    }
                    if (s.charAt(k) != ' ') {
                        c[j][i] = s.charAt(k);
                    } else {
                        if (j == 0) {
                            j--;
                        }
                    }
                    k++;
                }
            }

            for (int i = 0; i < low; i++) {
                for (int j = 0; j < up; j++) {
                    if (c[i][j] != '\u0000') {
                        res += c[i][j];
                    }
                }
            }
        }

        return res;
    }

    // TASK 10

    public static int PrintingCosts(String Line) {

        String[] table = new String[33];
        table[0] = " ";
        table[3] = "`'";
        table[4] = ".";
        table[6] = "\"";
        table[7] = ",-^";
        table[8] = ":_";
        table[9] = "!~";
        table[10] = "<>/\\";
        table[11] = ";";
        table[12] = "()|";
        table[13] = "vrx+";
        table[14] = "Y=";
        table[15] = "?i";
        table[16] = "LlT7";
        table[17] = "tcu*";
        table[18] = "[]{}JXIfn";
        table[19] = "1Vzw";
        table[20] = "ojFC";
        table[21] = "Kksh4";
        table[22] = "20%Zm";
        table[23] = "83PUea";
        table[24] = "Ay&#";
        table[25] = "GSHNbdpq";
        table[26] = "96DEWO";
        table[27] = "5";
        table[28] = "RM";
        table[29] = "$B";
        table[30] = "g";
        table[31] = "Q";
        table[32] = "@";

        int ton = 0;
        int n = Line.length();
        for (int i = 0; i < n; i++) {
            int f = 0;
            for (int j = 0; j < table.length - 1; j++) {
                if (table[j] == null) {
                    continue;
                }
                for (int k = 0; k < table[j].length(); k++) {
                    if (Line.charAt(i) == table[j].charAt(k)) {
                        ton += j;
                        f = 1;
                    }
                }
            }
            if (f == 0) {
                ton += 23;
            }
        }

        return ton;
    }

    // TASK 11

    public static String BigMinus(String s1, String s2) {

        if (s1.equals(s2)) {
            return "0";
        }
        if (s1.equals("0")) {
            return s2;
        }
        if (s2.equals("0")) {
            return s1;
        }

        String ss1 = "";
        String ss2 = "";

        for (int i = s1.length() - 1; i >= 0; i--) {
            ss1 += s1.charAt(i);
        }
        for (int i = s2.length() - 1; i >= 0; i--) {
            ss2 += s2.charAt(i);
        }

        if (s1.length() < s2.length()) {
            String s = new String(ss1);
            ss1 = ss2;
            ss2 = s;
        }

        char[] c1 = ss1.toCharArray();
        char[] c2 = ss2.toCharArray();
        int n1 = c1.length;
        int n2 = c2.length;
        String str = "";
        int k = 0;
        for (int i = 0; i < n2; i++) {
            int x = c1[i] - '0';
            int y = c2[i] - '0';
            if (x >= y) {
                str += x-y;
                k++;
            } else {
                for (int j = i + 1; j < n1; j++) {
                    if (c1[j] == '0') {
                        c1[j] = '9';
                    } else {
                        int z = c1[j] - '0';
                        z--;
                        c1[j] = (char)(z + '0') ;
                        str += 10 + x - y;
                        k++;
                        j = n1;
                    }
                }
            }
        }

        for (int i = k; i < n1; i++) {
            str += c1[i];
        }

        String res = "";
        k = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != '0') {
                k = 1;
            }
            if (k != 0) {
                res += str.charAt(i);
            }
        }

        return res;
    }

    // TASK 12

    public static String MassVote(int N, int [] Votes) {
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += Votes[i];
        }

        double[] VotesPerc = new double[N];
        for (int i = 0; i < N; i++) {
            double a = (Votes[i] / (total * 1.0) ) * 100;
            String s = String.format("%.3f",a);
            VotesPerc[i] += Double.parseDouble(s.replace(",","."));
        }

        int k = 0;
        String res = "";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && VotesPerc[i] > VotesPerc[j]) {
                    k++;
                }
            }
            if (k == N - 1) {
                if (VotesPerc[i] > 50) {
                    res += "majority winner " + (i + 1);
                } else {
                    res += "minority winner " + (i + 1);
                }
            }
            if (!res.equals("")) {
                break;
            }
            k = 0;
        }
        if (res.equals("")) {
            return "no winner";
        }
        return res;
    }

    // TASK 13

    public static int [] UFO(int N, int [] data, boolean octal) {
        int[] res = new int[N];

        if (octal == true) {

            for (int i = 0; i < N; i++) {
                String S = "" + data[i];
                char[] c = S.toCharArray();
                int k = c.length;
                for (int j = 0; j < k; j++) {
                    res[i] += (c[j] - '0') * Math.pow(8, k - 1 - j);
                }
            }

        } else {

            for (int i = 0; i < N; i++) {
                String S = "" + data[i];
                char[] c = S.toCharArray();
                int k = c.length;
                for (int j = 0; j < k; j++) {
                    res[i] += (c[j] - '0') * Math.pow(16, k - 1 - j);
                }
            }

        }

        return res;
    }

    // TASK 14

    public static int Unmanned(int L, int N, int [][] track) {
       int[] wait_time = new int[N]; // how many seconds to spend on each traffic light

       for (int i = 0; i < N; i++) {
           int x;
           if (i == 0) {
               x = track[0][0];
           } else {
               x = wait_time[i - 1] + track[i][0];
           }
           int j = 1;
           while (x >= track[i][j]) {
               x -= track[i][j];
               j = 3 - j;
           }
           j = 3 - j;

           if (j == 1 && x >= track[i][3 - j]) {
               wait_time[i] = x;
           }
           if (j == 2) {
               wait_time[i] = track[i][3 - j] - x;
           }
       }

       int res = L;
       for (int i = 0; i < N; i++) {
           if (L >= track[i][0]) {
               res += wait_time[i];
           }
       }

       return res;
    }

    // TASK 15

    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
        if (W2 > W1 || H2 > H1) {
            return false;
        }

        char[][] arrS1 = new char[H1][W1];
        char[][] arrS2 = new char[H2][W2];

        int k = 0;
        for (int i = 0; i < H1; i++) {
            for (int j = 0; j < W1; j++) {
                arrS1[i][j] = S1.charAt(k);
                k++;
                if (j == W1 - 1) {
                    k++;
                }
            }
        }

        k = 0;
        for (int i = 0; i < H2; i++) {
            for (int j = 0; j < W2; j++) {
                arrS2[i][j] = S2.charAt(k);
                k++;
                if (j == W2 - 1) {
                    k++;
                }
            }
        }

        for (int i = 0; i < H1; i++) {
            for (int j = 0; j < W1; j++) {

                if (arrS1[i][j] == arrS2[0][0] && (H1 - i) >= H2 && (W1 - j) >= W2) {

                    char[][] C = new char[H2][W2];
                    for (int s = 0; s < H2; s++) {
                        for (int t = 0; t < W2; t++) {
                            C[s][t] = arrS1[i+s][j+t];
                        }
                    }

                    if (Arrays.deepEquals(C, arrS2)) {
                        return true;
                    }

                }
            }
        }

        return false;
    }

    // TASK 16

    public static int MaximumDiscount(int N, int [] price) {
        int[] p_copy = price;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (p_copy[i] > p_copy[j]) {
                    int x = p_copy[i];
                    p_copy[i] = p_copy[j];
                    p_copy[j] = x;
                }
            }
        }

        int free_num =  N / 3;
        int discount1 = 0;
        for (int i = 0; i < free_num; i++) {
            discount1 += p_copy[i];
        }

        int discount2 = 0;
        for (int i = N - 3; i >= 0; i = i - 3) {
            discount2 += p_copy[i];
        }

        if (discount1 > discount2) {
            return discount1;
        }
        return  discount2;

    }

    // TASK 17

    public static boolean LineAnalysis(String line) {
        int n = line.length();
        if (line.lastIndexOf('*') != n - 1 || line.indexOf('*') != 0) {
            return false;
        }

        int star = 0;
        for (int i = 0; i < n; i++) {
            if (line.charAt(i) == '*') {
                star++;
            }
        }
        if (star == n) {
            return true;
        }

        int dot_pattern = 0;
        for (int i = 1; i < n; i++) {
                if (line.charAt(i) == '.') {
                    dot_pattern++;
                } else {
                    break;
                }
        }

        if (dot_pattern == 0) {
            return false;
        }

        boolean res = true;
        for (int i = dot_pattern + 2; i < n; i += dot_pattern + 1) {
            for (int j = 0; j < dot_pattern; j++) {
                if (line.charAt(i + j) != '.') {
                    res = false;
                    break;
                }
            }
            if (res == false) {
                break;
            }
        }

        return res;
    }

    // TASK 18

    public static void leftRound(int[] A, int c) {
        int l = A[c-1];
        A[c-1] = A[c];
        A[c] = A[c+1];
        A[c+1] = l;
    }
    public static boolean MisterRobot(int N, int [] data) {
        int[] data_c = data;

        boolean res = true;
        for (int i = N - 1; i >= 0; i--) {
            int j = 0;
            if (data_c[i] != i + 1) {
                for (int k = i - 1; k >= 0; k--) {
                    if (data_c[k] == i + 1) {
                        j = k;
                        break;
                    }
                }
                while (j != i) {
                    if (j == 0 && i == 1) {
                        res = false;
                        break;
                    }
                    if (i - j > 1) {
                        leftRound(data_c, j + 1);
                        j += 2;
                    } else {
                        leftRound(data_c, j);
                        j--;
                    }
                }
                if (res == false) {
                    break;
                }
            }
        }
        return res;
    }

    // TASK 19
    public static String CutToLastSpace (String S) {
        int n = S.lastIndexOf(' ');
        String Line = "";
        for (int i = 0; i < n + 1; i++) {
            Line += S.charAt(i);
        }
        return Line;
    }
    public static String CutAfterLastSpace (String S) {
        int n = S.lastIndexOf(' ');
        String Line = "";
        for (int i = n+1; i < S.length(); i++) {
            Line += S.charAt(i);
        }
        return Line;
    }

    public static void swapString(String[] Arr, int i1, int i2) {
        String x = Arr[i1];
        Arr[i1] = Arr[i2];
        Arr[i2] = x;
    }
    public static String [] ShopOLAP(int N, String [] items) {

        ArrayList<String> items_c = new ArrayList<>(Arrays.asList(items));

        for (int i = 0; i< items_c.size(); i++) {

            String S1 = CutToLastSpace(items_c.get(i));
            String S1_p = CutAfterLastSpace(items_c.get(i));
            int p1 = Integer.parseInt(S1_p);

            for (int j = i + 1; j< items_c.size(); j++) {

                String S2 = CutToLastSpace(items_c.get(j));
                if (S1.equals(S2)) {
                    String S2_p = CutAfterLastSpace(items_c.get(j));
                    int p2 = Integer.parseInt(S2_p);
                    p1 += p2;
                    String S = S1 + p1;
                    items_c.add(i,S);
                    items_c.remove(i+1);
                    items_c.remove(j);
                    j--;
                }
            }
        }


        int n = items_c.size();
        for (int i = 0; i < n-1; i++) {

            String S1_p = CutAfterLastSpace(items_c.get(i));
            int p1 = Integer.parseInt(S1_p);

            for (int j = i + 1; j < n; j++) {

                String S2_p = CutAfterLastSpace(items_c.get(j));
                int p2 = Integer.parseInt(S2_p);
                if (p1 < p2) {
                    String S1 = items_c.get(j);
                    String S2 = items_c.get(i);
                    items_c.remove(i);
                    items_c.add(i, S1);
                    items_c.remove(j);
                    items_c.add(j, S2);
                }
            }
        }


        String[] res = items_c.toArray(new String[0]);
        for (int i = 0; i<res.length - 1; i++) {

            String S1 = CutAfterLastSpace(items_c.get(i));

            for (int j = i + 1; j< res.length; j++) {

                String S2 = CutAfterLastSpace(items_c.get(j));
                if (S1.equals(S2)) {
                    String S1_1 = CutToLastSpace(items_c.get(i));
                    String S2_1 = CutToLastSpace(items_c.get(j));
                    if (S1_1.compareTo(S2_1) > 0) {
                        swapString(res, i, j);
                    }
                }
            }
        }

        return res;
    }

    // TASK 20

    static String S = "";
    static ArrayList<String> Slog = new ArrayList<>();
    static int c = 0;
    static int u = 0;

    public static String BastShoe(String command) {

        if (Slog.isEmpty()) {
            Slog.add("");
        }
        String p = "" + command.charAt(0);
        try {
            Integer.parseInt(p);
        }
        catch (Exception e) {
            return S;
        }
        int x = Integer.parseInt(p);



        int n = command.length();
        if (n > 1 && command.charAt(1) != ' ') {
            x = -1;
        }

        if(x == 1 && n > 2) {


            if (u == 1) {
                u = 0;
                Slog.clear();
                Slog.add(S);
            }
            String S1 = "";
            for (int i = 2; i < n; i++) {
                S1 += command.charAt(i);
            }
            S += S1;


            Slog.add(S);
            c = Slog.size() - 1;

        }


        if (x == 2 && n > 2) {


            if (u == 1) {
                u = 0;
                Slog.clear();
                Slog.add(S);
            }
            String S1 = "";
            for (int i = 2; i < n; i++) {
                S1 += command.charAt(i);
            }
            try {
                Integer.parseInt(S1);
            } catch (Exception e) {
                return S;
            }
            int y = Integer.parseInt(S1);
            if (y >= S.length()) {
                S = "";
            } else {
                S1 = "";
                for (int i = 0; i < S.length() - y; i++) {
                    S1 += S.charAt(i);
                }
                S = S1;
            }

            Slog.add(S);
            c = Slog.size() - 1;

        }

        if (x == 3 && n > 2) {

            String S1 = "";
            for (int i = 2; i < n; i++) {
                S1 += command.charAt(i);
            }
            try {
                Integer.parseInt(S1);
            }
            catch (Exception e) {
                return S;
            }

            int y = Integer.parseInt(S1);

            if (y >= S.length() || y < 0) {
                return "";
            }

            return String.valueOf(S.charAt(y));

        }
        if (x == 4 && n == 1) {

            u = 1;
            int k = Slog.size();
            if (k > 0 && c > 0) {
                c--;
                S = Slog.get(c);
            }

        }
        if (x == 5 && n == 1) {

            int k = Slog.size();
            if (c < k - 1) {
                c++;
                S = Slog.get(c);
            }

        }

        return S;
    }

    // TASK 21

    public static String BiggerGreater(String input) {
        int n = input.length();
        String[] input_c = new String[n];

        for (int i = 0; i<n; i++) {
            input_c[i] = "" + input.charAt(i);
        }

        int r = 0;
        for (int i = 1; i<n; i++) {
            if (input_c[i].compareTo(input_c[i-1]) <= 0) {
                r++;
            }
        }

        if (r >= n - 1) {
            return "";
        }

        if (n == 2) {
            swapString(input_c,0,1);
            return String.join("", input_c);
        }

        String res = "";
        int p = 0;
        for (int i = n - 1; i > 0; i--) {
            String S = "" + input.charAt(i);
            for (int j = i - 1; j > 0; j--) {

                if (S.compareTo(input_c[j]) > 0) {
                    swapString(input_c, j, i);
                        for (int k = j + 1; k < n - 1; k++) {
                            for (int s = k + 1; s < n; s++) {
                                if (input_c[k].compareTo(input_c[s]) > 0) {
                                    swapString(input_c, k, s);
                                }
                            }
                        }
                    res = String.join("", input_c);
                    if (res.compareTo(input) > 0) {
                        p++;
                        break;
                    }
                }

            }
            if (p != 0) {
                break;
            }
        }

        if (p == 0) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (input_c[i].compareTo(input_c[j]) > 0) {
                        swapString(input_c, j, i);
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                if (input_c[j].compareTo("" + input.charAt(0)) > 0 ) {
                    swapString(input_c,j,0);
                    break;
                }
            }

            for (int i = 1; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (input_c[i].compareTo(input_c[j]) > 0) {
                        swapString(input_c, j, i);
                    }
                }
            }
            res = String.join("", input_c);
        }

        return res;
    }

    // TASK 22

    public static void swapChar(char[] Arr, int i1, int i2) {
        char x = Arr[i1];
        Arr[i1] = Arr[i2];
        Arr[i2] = x;
    }
    public static boolean SherlockValidString(String s) {
        int n = s.length();
        char[] pass = s.toCharArray();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pass[i] >= pass[j]) {
                    swapChar(pass, i, j);
                }
            }
        }

        ArrayList<Integer> Counts = new ArrayList<>();
        int k = 1;
        for (int i = 0; i < n - 1; i++) {
            if (pass[i] == pass[i+1]) {
                k++;
            } else {
                Counts.add(k);
                k = 1;
            }
        }
        Counts.add(k);

        boolean res = true;
        k = Counts.size();
        int j = 0;
        for (int i = 0; i < k; i++) {
            int z = Counts.get(i);
            for (int y : Counts) {
                int x = z - y;
                if (x != 0) {
                    if (Math.abs(x) > 1) {
                        res = false;
                        break;
                    }
                    if (x < 0) {
                        j++;
                    }
                }
            }
            if (j > 1 || res == false) {
                res = false;
                break;
            }
            j = 0;
        }

        return res;

    }

    // TASK 23
    public static String [] TreeOfLife(int H, int W, int N, String [] tree) {
        int[][] tree_c = new int[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (tree[i].charAt(j) == '.') {
                    tree_c[i][j] = 0;
                } else {
                    tree_c[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {

            for (int k = 0; k < H; k++) {
                for (int j = 0; j < W; j++) {
                    tree_c[k][j]++;
                }
            }

            if (i % 2 == 1) {
                for (int k = 0; k < H; k++) {
                    for (int j = 0; j < W; j++) {
                        if (tree_c[k][j] > 2) {
                            tree_c[k][j] = 0;
                            if (k > 0) {
                                tree_c[k - 1][j] = 0;
                            }
                            if (j > 0) {
                                tree_c[k][j - 1] = 0;
                            }
                            if (k < H - 1) {
                                if (tree_c[k+1][j] < 3) {
                                    tree_c[k + 1][j] = 0;
                                }
                            }
                            if (j < W - 1) {
                                if (tree_c[k][j+1] < 3) {
                                    tree_c[k][j + 1] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }

        String[] res = new String[H];
        for (int i = 0; i < H; i++) {
            res[i] = "";
            for (int j = 0; j < W; j++) {
                if (tree_c[i][j] > 0) {
                    res[i] += "+" ;
                } else {
                    res[i] += ".";
                }
            }
        }

        return res;
    }

    // TASK 24

    public static void MatrixTurn(String[] Matrix, int M, int N, int T) {

        int min = M;
        if (min > N) {
            min = N;
        }

        int[][] Mat = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Mat[i][j] = Integer.parseInt("" + Matrix[i].charAt(j));
            }
        }

        int[][] Mat_c = new int[M][N];

        for (int s = 0; s < T; s++) {

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    Mat_c[i][j] = Mat[i][j];
                }
            }

            //Angles
            for (int i = 0; i < min / 2; i++) {
                Mat[i][i] = Mat_c[i + 1][i];
                Mat[i][N - i - 1] = Mat_c[i][N - i - 2];
                Mat[M - i - 1][i] = Mat_c[M - i - 1][i + 1];
                Mat[M - i - 1][N - i - 1] = Mat_c[M - i - 2][N - i - 1];
            }

            //Rows
            for (int i = 0; i < min / 2; i++) {
                for (int j = i + 1; j < N - i - 1; j++) {
                    Mat[i][j] = Mat_c[i][j - 1];
                    Mat[M - i - 1][N - j - 1] = Mat_c[M - i - 1][N - j];
                }
            }

            //Columns
            for (int i = 0; i < min / 2; i++) {
                for (int j = i + 1; j < M - i - 1; j++) {
                    Mat[j][i] = Mat_c[j + 1][i];
                    Mat[M - j - 1][N - i - 1] = Mat_c[M - j - 2][N - i - 1];
                }
            }

        }

        for (int i = 0; i < M; i++) {
            Matrix[i] = "";
            for (int j = 0; j < N; j++) {
                Matrix[i] += Mat[i][j];
            }
        }

    }

    // TASK 25

    public static int[] Transform(int[] A, int N) {
        List<Integer> B = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                int k = i + j;
                int x = A[j];
                for (int s = j + 1; s <= k; s++) {
                    if (x < A[s]) {
                        x = A[s];
                    }
                }
                B.add(x);
            }
        }

        int[] C = B.stream().mapToInt(i -> i).toArray();

        return C;
    }
    public static boolean TransformTransform(int[] A, int N) {
        int[] B1 = Transform(A, N);
        int[] B2 = Transform(B1, B1.length);

        int res = 0;
        for (int x : B2) {
            res += x;
        }

        if (res % 2 == 0) {
            return true;
        }

        return false;
    }
}
