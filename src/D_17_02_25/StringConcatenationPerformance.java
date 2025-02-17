package D_17_02_25;

import java.util.*;
public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        for (int size : datasetSizes) {
            System.out.println("Dataset Size: " + size);
            long startTime = System.nanoTime();
            String str = "";
            for (int i = 0; i < size; i++) {
                str += "a";
            }
            long endTime = System.nanoTime();
            long stringTime = endTime - startTime;
            startTime = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append("a");
            }
            endTime = System.nanoTime();
            long stringBuilderTime = endTime - startTime;
            startTime = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < size; i++) {
                sbf.append("a");
            }
            endTime = System.nanoTime();
            long stringBufferTime = endTime - startTime;
            System.out.println("String Concatenation Time: " + stringTime / 1e6 + " ms");
            System.out.println("StringBuilder Concatenation Time: " + stringBuilderTime / 1e6 + " ms");
            System.out.println("StringBuffer Concatenation Time: " + stringBufferTime / 1e6 + " ms");
        }
    }
}
