// Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
// To flip an image horizontally means that each row of the image is reversed.
  // For example, flipping [1,1,0] horizontally results in [0,1,1].
// To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
  // For example, inverting [0,1,1] results in [1,0,0].
// LEETCODE -> 832. Flipping an Image

// Example 1:
  // Input: image = [[1,1,0],[1,0,1],[0,0,0]]
  // Output: [[1,0,0],[0,1,0],[1,1,1]]
  // Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
  // Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
  
// Example 2:
  // Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
  // Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
  // Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
  // Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

package com.rishi;

import java.util.Arrays;

public class FlipAndInvertImage {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        System.out.println(Arrays.deepToString(flipAndInvertImage(image)));
    }

    static int[][] flipAndInvertImage(int[][] image) {
        int[][] flippedImage = invertImage(image);
        return flippedImage;
    }

    static int[][] reverseImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int start = 0;
            int end = image[i].length - 1;

            while (start < end) {
                int temp = image[i][end];
                image[i][end] = image[i][start];
                image[i][start] = temp;

                start++;
                end--;
            }
        }
        return image;
    }

    static int[][] invertImage(int[][] image) {
        int[][] reversedImage = reverseImage(image);
        for (int i = 0; i < reversedImage.length; i++) {
            for (int j = 0; j < reversedImage[i].length; j++) {
                reversedImage[i][j] = reversedImage[i][j] == 0 ? 1 : 0;
            }
        }

        return reversedImage;
    }

}
