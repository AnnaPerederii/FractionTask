package com.calculation.fraction;

public class Calculator {
    public int[] add(int arr[]){
        int lcm = lcm(arr[1], arr[3]);
        arr[0] = lcm/arr[1]*arr[0];
        arr[2] = lcm/arr[3]*arr[2];
        arr[0] = arr[0]+arr[2];
        arr[1] = lcm;
        arr = fractionsReduction(arr);
        return arr;
    }
    public int[] subtract(int arr[]){
        int lcm = lcm(arr[1], arr[3]);
        arr[0] = lcm/arr[1]*arr[0];
        arr[2] = lcm/arr[3]*arr[2];
        arr[0] = arr[0]-arr[2];
        arr[1] = lcm;
        arr = fractionsReduction(arr);
        return arr;
    }

    public int[] multiply(int arr[]){
        arr[0] = arr[0]*arr[2];
        arr[1] = arr[1]*arr[3];
        arr = fractionsReduction(arr);
        return arr;
    }
    public int[] divide(int arr[]){
        int change = arr[2];
        arr[2] = arr[3];
        arr[3] = change;
        arr = multiply(arr);
        arr = fractionsReduction(arr);
        return arr;
    }

    private int lcm(int a,int b){  //НОК
        return a / gcd(a,b) * b;
    }

    private int gcd(int a, int b) {  //НОД
        if (b == 0) return a;
        int x = a % b;
        return gcd(b, x);
    }

    private int[] fractionsReduction(int arr[]){
        int gcd = gcd(arr[0], arr[1]);
        arr[0] = arr[0]/gcd;
        arr[1] = arr[1]/gcd;
        return arr;
    }
}

