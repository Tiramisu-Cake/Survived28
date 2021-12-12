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
}
