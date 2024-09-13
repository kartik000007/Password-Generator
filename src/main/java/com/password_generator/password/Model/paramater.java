package com.password_generator.password.Model;


import lombok.*;


public class paramater {
    private int length;
    private int numberCount;
    private int specialCharCount;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNumberCount() {
        return numberCount;
    }

    public void setNumberCount(int numberCount) {
        this.numberCount = numberCount;
    }

    public int getSpecialCharCount() {
        return specialCharCount;
    }

    public void setSpecialCharCount(int specialCharCount) {
        this.specialCharCount = specialCharCount;
    }

    public paramater(int length, int numberCount, int specialCharCount) {
        this.length = length;
        this.numberCount = numberCount;
        this.specialCharCount = specialCharCount;
    }

    public paramater() {
    }
}
