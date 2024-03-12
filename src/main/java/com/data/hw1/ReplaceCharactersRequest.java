package com.data.hw1;

public class ReplaceCharactersRequest {
    private String str1;
    private String str2;
    private String array1;
    private String array2;

    // Add getters and setters

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String getArray1() {
        return array1;
    }

    public void setArray1(String array1) {
        this.array1 = array1;
    }

    public String getArray2() {
        return array2;
    }

    public void setArray2(String array2) {
        this.array2 = array2;
    }

    // Method to replace characters based on array indices with bounds checking
    public String replaceCharacters() {
        // Convert string arrays to int arrays
        int[] intArray1 = convertStringToIntArray(array1);
        int[] intArray2 = convertStringToIntArray(array2);

        // Check if arrays are of equal length
        if (intArray1.length != intArray2.length) {
            throw new IllegalArgumentException("Arrays must be of equal length");
        }

        // Check for out of bounds indices
        int maxLength1 = str1.length();
        int maxLength2 = str2.length();
        for (int i = 0; i < intArray1.length; i++) {
            if (intArray1[i] < 0 || intArray1[i] >= maxLength1 || intArray2[i] < 0 || intArray2[i] >= maxLength2) {
                throw new IllegalArgumentException("Array indices out of bounds");
            }
        }

        // Modify the string based on the provided indices
        StringBuilder result = new StringBuilder(str1);
        for (int i = 0; i < intArray1.length; i++) {
            int index1 = intArray1[i];
            int index2 = intArray2[i];
            result.setCharAt(index1, str2.charAt(index2));
        }
        return result.toString();
    }

    // Method to convert comma-separated string to int array
    private int[] convertStringToIntArray(String strArray) {
        if (strArray == null || strArray.isEmpty()) {
            return new int[0]; // Return an empty array if string is null or empty
        }
        // Split the string by commas and convert each part to integer
        String[] parts = strArray.split(",");
        int[] intArray = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            intArray[i] = Integer.parseInt(parts[i].trim());
        }
        return intArray;
    }

    @Override
    public String toString(){
        return "User [str1=" + str1 + ", str2=" + str2 + ", array1=" + array1 + ",array2=" + array2 +"]";
    }
}
