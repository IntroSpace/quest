package com.zodiac33.quest;

public class Result {
    private String name;
    private int k, a, r;

    Result (String name, int k, int a, int r) {
        this.name = name;
        this.k = k;
        this.a = a;
        this.r = r;
    }

    public void write () {}

    public static Result read (String name) {
        int pK = 0;
        int pA = 0;
        int pR = 0;
        Result result=new Result(name, pK, pA, pR);
        return result;
    }
}
