package com.JasonWolfe.Week_01;

public class Main {

    public static void main(String[] args) {
        String cityName = "Columbus";
        int zipCode = 43215;
        float[] temperatures = {32, 25, 27, 40, 45};

        float averageTemperature = (temperatures[0] + temperatures[1] + temperatures[2] +
                temperatures[3] + temperatures[4]) / 5;

        System.out.println("City: " + cityName);
        System.out.println("Zip Code: " + zipCode);
        System.out.println("Average Temperature: " + averageTemperature);
    }
}