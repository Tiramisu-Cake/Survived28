package com.company;

public class Level2 {
    public static int odometer(int [] oksana) {
        int S = oksana[0]*oksana[1];
        for(int i = 2; i<oksana.length; i = i + 2) {
            S += oksana[i] * (oksana[i+1] - oksana[i-1]);
        }
        return S;
    }
}
