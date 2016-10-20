package com.danielbrinker.android.aca.primefinder;

import android.widget.TextView;

/**
 * Created by danielbrinker on 9/2/16.
 */
public class PrimeFinder implements Runnable {


    public long target;
    public long prime;
    public boolean finished = false;
    private Thread runner;
    public TextView mPrimesToList;




    PrimeFinder(long inTarget, TextView primesToList) {
        target = inTarget;

        if (runner == null) {
            runner = new Thread(this);
            runner.start(); //here, public void run gets called
        }
    }

    @Override
    public void run() {
        long numPrimes = 0;
        long candidate = 2;

        while (numPrimes < target) {
            if (isPrime(candidate)) {
                numPrimes++;
                prime = candidate;
                System.out.println("Prime Candidate: " + candidate);// We want to print this while it's in the while loop

            }
            candidate++;


        }
        System.out.println("Number of Primes: " + numPrimes);
        finished = true; //This is used to stop the thread.

    }

    boolean isPrime(long checkNumber) {
        double root = Math.sqrt(checkNumber);

        for (int i = 2; i <= root; i++) {
            if (checkNumber % i == 0) {
                return false;

            }
        }
        return true;
    }
}

