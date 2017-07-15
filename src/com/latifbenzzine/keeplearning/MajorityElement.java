package com.latifbenzzine.keeplearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here
        /*List<Integer> intlist =  Arrays.stream(a).boxed().collect(Collectors.toList());
        int[] d = Arrays.stream(a).filter(i -> Collections.frequency(intlist, i) >a.length/2).toArray();
        if(d.length > 1){
        	return 1;
        }*/
        
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                    int count = map.get(a[i]) +1;
                    if (count > a.length /2) {
                        //System.out.println("Majority found :- " + a[i]);
                        return 1;
                    } else
                        map.put(a[i], count);
 
            }
            else
                map.put(a[i],1);
            }
            //System.out.println(" No Majority element");
		return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

