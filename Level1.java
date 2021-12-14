package com.company;

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
}
