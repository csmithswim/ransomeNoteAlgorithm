package com.csmithswim;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
    /*Make hashmap of strings in magazine and compare inside a for
    in loop of the note array.
     */
    
    //Make HashMap containing strings from magazine
    HashMap<String, Integer> magazineMap = new HashMap<>();
    for (String magPage : magazine) {
//        System.out.println(magazineMap);
        if (magPage.equals(" ")) {
            continue;
        }
        if (magazineMap.containsKey(magPage)) {
            magazineMap.replace(magPage, magazineMap.get(magPage) + 1);
            continue;
        }
        magazineMap.put(magPage, 1);
//        System.out.println("End of map creation");
    }

        //Compare the magazineMap with elements of the note array
        Integer counter = 0;

        for (String notePage : note){
//            System.out.println(notePage);
//            System.out.println(magazineMap);
            if (!magazineMap.containsKey(notePage)){
                counter = 1;
//                System.out.println(counter);
                System.out.println("No");
                break;
            }
            if (magazineMap.get(notePage) == 0){
                counter = 1;
//                System.out.println(counter);
                System.out.println("No");
                break;
            }
            magazineMap.replace(notePage, magazineMap.get(notePage) - 1);
        }
        if (counter==0){
//            System.out.println(counter);
            System.out.println("Yes");
        }

    }



    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}

/* Sample Input 0
6 4
give me one grand today night
give one grand today
Sample Output 0
Yes

Sample Input 1
6 5
two times three is not four
two times two is four
Sample Output 1
No

Explanation 1
'two' only occurs once in the magazine.

Sample Input 2
7 4
ive got a lovely bunch of coconuts
ive got some coconuts
Sample Output 2
No
*/
