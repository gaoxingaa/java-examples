package org.example.binarydiff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryDiff {

    public static List<int[]> computeDiff(byte[] original, byte[] modified) {
        List<int[]> diff = new ArrayList<>();

        int length = Math.min(original.length, modified.length);

        for (int i = 0; i < length; i++) {
            if (original[i] != modified[i]) {
                diff.add(new int[]{i, modified[i] & 0xFF});
            }
        }

        // Handle extra bytes in the modified file
        if (modified.length > original.length) {
            for (int i = original.length; i < modified.length; i++) {
                diff.add(new int[]{i, modified[i] & 0xFF});
            }
        }

        return diff;
    }

    public static void main(String[] args) throws IOException {
        File originalFile = new File(BinaryDiff.class.getResource("/original.bin").getFile());
        File modifiedFile = new File(BinaryDiff.class.getResource("/modified.bin").getFile());


        byte[] original = readFileToByteArray(originalFile);
        byte[] modified = readFileToByteArray(modifiedFile);

        List<int[]> diff = computeDiff(original, modified);

        System.out.println("Differences:");
        for (int[] change : diff) {
            System.out.println("Offset: " + change[0] + ", New Value: " + change[1]);
        }
    }

    private static byte[] readFileToByteArray(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            return fis.readAllBytes();
        }
    }
}
