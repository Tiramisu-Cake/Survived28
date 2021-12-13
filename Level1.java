package com.company;

public class Level1 {
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

    public static int odometer(int [] oksana) {
        int S = oksana[0]*oksana[1];
        for(int i = 2; i<oksana.length; i += 2) {
            S += oksana[i] * (oksana[i+1] - oksana[i-1]);
        }
        return S;

    }

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
}
