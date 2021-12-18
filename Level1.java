package com.company;

import java.util.ArrayList;

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

    public static void swap(int [] Arr, int i1, int i2) {
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

        swap(Tele_copy, mid, i_max);
        swap(Tele_copy, 0, i_min);

        for (int i = 1; i < N; i++) {
            if (i < mid) {
                for (int j = i + 1; j < N; j++) {
                    if (Tele_copy[j] < Tele_copy[i]) {
                        swap(Tele_copy, i, j);
                    }
                }
            }
            if(i == mid) continue;
            if (i > mid) {
                for(int j = i + 1; j < N; j++) {
                    if(Tele_copy[j] > Tele_copy[i]) {
                        swap(Tele_copy, i, j);
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
                    swap(ids_c, i, j);
                }
                if(sal_c[j] < sal_c[i]) {
                    swap(sal_c, i, j);
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
}
