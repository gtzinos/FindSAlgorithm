/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findsalgorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author George Tzinos
 */
public class TrainData {
    ArrayList<String[]> trainingData;
    String[] S;
    int attributesLength;
    
    public TrainData(ArrayList<String[]> trainingData, int attributesLength) {
        this.trainingData = trainingData;
        this.attributesLength = attributesLength;
        this.S = new String[attributesLength];
        
        this.init();
    }
    
    public void init() {
        for(int i = 0; i < this.S.length; i++) {
            this.S[i] = "0";
        }
    }
    
    public void train() {
        for(int i = 0; i < this.trainingData.size(); i++) {
            String x[] = this.trainingData.get(i);
            
            if(this.isPositive(x)) {
                this.trainAsPositive(x);
            }
            //negative
            else {
                //Do nothing ?
            }
            
            this.printSGX(i);
        }
    }
    
    public void printSGX(int trainIndex) {
        System.out.print("X"  + (trainIndex+1) + ": ");
        System.out.println(Arrays.toString(this.trainingData.get(trainIndex)));
        
        System.out.print("S"  + (trainIndex+1) + ": ");
        System.out.println(Arrays.toString(this.S));
        
        System.out.println();
        System.out.println();
    }
    
    public boolean isPositive(String[] x) {
        if(String.valueOf(x[x.length - 1]).equals("Y") || String.valueOf(x[x.length - 1]).equals("1")) {
            return true;
        }
        
        return false;
    }
    
    public boolean isNegative(String[] x) {
        if(String.valueOf(x[x.length - 1]).equals("N") || String.valueOf(x[x.length - 1]).equals("0")) {
            return true;
        }
        
        return false;
    }
    
    public void trainAsPositive(String[] x) {
            
        for(int i = 0; i < x.length - 1; i++) {
            if(!this.S[i].equals("0") && !this.S[i].equals(x[i])) {
                this.S[i] = "?";
            }
            else {
                this.S[i] = x[i];
            }
        }
        
    }
}
