package com.ryxen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Tesst {
	static void min(List<Integer> arr) {
		int size = arr.size();
		int max = arr.get(0), min = arr.get(0);
		long sumMax = 0, sumMin = 0;
		int locateMin[] = new int[5];
		int locateMax[] = new int[5];
		int countMin = 0;
		int countMax = 0;
		for (int i = 0; i < size; i++) {
			if (min > arr.get(i)) {
				min = arr.get(i);
			}
			if (max < arr.get(i)) {
				max = arr.get(i);
			}
		}
		for (int i = 0; i < size; i++) {
			if (arr.get(i) == min) {
				countMin++;
				locateMin[i] = i;
			}
			if (arr.get(i) == max) {
				countMax++;
				locateMax[i] = i;
			}
		}
		for (int i = 0; i < size; i++) {
			if (arr.get(i) != min) {
				sumMax += arr.get(i);
			}
			if (arr.get(i) != max) {
				sumMin += arr.get(i);
			}
		}
		if (countMin >= 2) {
			for (int i = 0; i < locateMin.length - 1; i++) {
				sumMax += arr.get(locateMin[i]);
			}
		}
		if (countMax >= 2) {
			for (int i = 0; i < locateMax.length - 1; i++) {
				sumMin += arr.get(locateMax[i]);
			}
		}

		System.out.print(sumMin + " " + sumMax);
	}

	public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
		// Write your code here
		List<Integer> indexs = new ArrayList<Integer>();
		List<Integer> indexQuery = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < queries.size(); i++) {
			boolean check = false;
			for (int j = 0; j < strings.size(); j++) {
				if (queries.get(i).equals(strings.get(j))) {
					check = true;
					indexs.add(i);
				}
			}
			if (check == false) {
				map.put(i, 0);
			}
		}

		for (Integer r : indexs) {
			if (map.containsKey(r)) {
				map.put(r, map.get(r) + 1);
			} // if
			else {
				map.put(r, 1);
			}
		}
		TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(map);
		for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
			indexQuery.add(entry.getValue());
		}
		return indexQuery;
	}

	public static List<Integer> matchingStrings1(List<String> strings, List<String> queries) {
		List<Integer> index=new ArrayList<Integer>();
		for (String s : queries) {
			index.add(countStr(s, strings));
		}
		return index;
	}

	public static int countStr(String s, List<String> strings) {
		int count=0;
		for (String string : strings) {
			if(s.equals(string)) {
				count++;
			}
		}
		return count;

	}
	public static List<Integer> matchingStrings2(List<String> strings, List<String> queries) {
		Map<String,Integer>map=new HashMap<String, Integer>();
		for (String string : strings) {
			int temp=map.getOrDefault(string, 0);
			map.put(string, temp++);
		}
		List<Integer>sol=new ArrayList<Integer>();
		for (String query : queries) {
			sol.add(map.getOrDefault(query, 0));
		}
		return sol;
	}
	public static List<Long> convert(long n){
        List<Long> list=new ArrayList<Long>();
        //1001
        while(n>0) {           
            list.add(n%2);
            n=n/2;
        }
        return list;
    } 
	 public static long flippingBits(long n) {
		    // Write your code here
		 List<Long> list=convert(n);
		Collections.reverse(list);
		int size=list.size();
		for(int i=0;i<32-size;i++) {
			list.add(0,(long) 0);
		}
		for(int i=0;i<list.size();i++) {
			if(list.get(i)==0) {
				list.set(i, (long) 1);
			}else {
				list.set(i, (long) 0);
			}
		}
		long sum=0;
		int size1=list.size();
		for(int i=size1-1,j=0;i>=0;i--,j++) {
			sum+=list.get(i)*(Math.pow(2,j ));
			
		}
		return sum;
	 }
	 public static int diagonalDifference(List<List<Integer>> arr) {
		    // Write your code here
		
		 // duong cheo chinh
		 int cheoChinh=0;
		 for(int i=0;i<arr.size();i++) {
			 for(int j=0;j<arr.get(i).size();j++) {
				 if(j==i) {
				 cheoChinh+=arr.get(i).get(j);
			 }
			 }
		 }
		 // duong chep phu
		 int cheoPhu=0;
		 
		 int index=arr.size()-1;
		 for(int i=0;i<arr.size();i++) {			 
			 cheoPhu+=arr.get(i).get(index);
			 index--;
		 }
		        return Math.abs(cheoChinh-cheoPhu);
		    }
	 public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
		    // Write your code here
		 Collections.sort(A,new Comparator<Integer>() {
			 @Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1<o2?1:-1;
			}
		});
		 // java8 lamba Collections.sort(A,(o1,o2)->o1>o2?1:-1);
		 Collections.sort(B,new Comparator<Integer>() {
			 @Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1>o2?1:-1;
			}
		});
	
		
		 for(int i=0;i<A.size();i++) {
			 if((A.get(i)+B.get(i))<k){
				 return "NO";
			 }
		 }
		
		        return "YES";
		
		 
		
	 }
	 public static int birthday(List<Integer> s, int d, int m) {
		    // Write your code here
		    
		    int count=0;
		    if(s.size()==1){
		        if(s.get(0)==d)
		            return 1;
		        else return 0;
		    }else {   
		        for(int i=0;i<=s.size()-m;i++){
		            int sum=0;
		            for(int j=i;j<m+i;j++){
		            	if(j<s.size()) {
				            sum+=s.get(j);
				            System.out.print(s.get(j)+" ");
		            }
		            }
		            System.out.println();
		            if(sum==d){
		                count++;
		            }
		        }
		    }
		        return count;
		    }
	 public static int caesarCipher(String s1, int k) {
		    // Write your code here
		        String s="abcdefghijklmnopqrstuvwxyz";
		        List<String>list=new ArrayList<String>();
		        List<String>listRoated=new ArrayList<String>();
		        List<String>listCaesar=new ArrayList<String>();
		        StringBuilder sb=new StringBuilder(s1);
		        
		        for(int i=0;i<s.length();i++){
		            list.add(s.substring(i, i+1));
		        }
		        for(int i=0;i<s1.length();i++){
		        	listCaesar.add(s1.substring(i, i+1));
		        }
		        if(k<26) {
		        for(int i=k;i<s.length();i++){
		        	
		        	if(i<=s.length())
		        		listRoated.add(s.substring(i, i+1));
		        	if(i==s.length()-1){		
		        		for(int j=0;j<k;j++) {
		        			listRoated.add(s.substring(j,j+1));
		        		}
		        	}
		        }
		        }else if(k>=26) {
		        	int k1=k%26;
		        	for(int i=k1;i<s.length();i++){
			        	
			        	if(i<=s.length())
			        		listRoated.add(s.substring(i, i+1));
			        	if(i==s.length()-1){		
			        		for(int j=0;j<k1;j++) {
			        			listRoated.add(s.substring(j,j+1));
			        		}
			        	}
			        }
		        }
		        for(int i=0;i<listCaesar.size();i++) {
		        	for(int j=0;j<list.size();j++) {
		        		if(listCaesar.get(i).equals(list.get(j)) || listCaesar.get(i).equals(list.get(j).toUpperCase())) {
		        			System.out.println(listRoated.get(j));
		        			sb.replace(i, i+1, listRoated.get(j));
		        			if( listCaesar.get(i).equals(list.get(j).toUpperCase())) {
		        				sb.replace(i, i+1, listRoated.get(j).toUpperCase());
		        			}
		        		}
		        	}
		        }
		       
		        
		        return list.size();
		    }
	 public static int maxMin(int k, List<Integer> arr) {
		    // Write your code here
		 List<Integer> min=new ArrayList<Integer>();
		 int min1=0;
		 int min2=0;
		
		
		 for(int i=0;i<=arr.size()-k;i++) {
			 List<Integer> checkMin=new ArrayList<Integer>();
			 for(int j=i;j<k+i;j++) {
				 
				 checkMin.add(arr.get(j));
			 }
			
				 min1=Collections.max(checkMin);
				 min2=Collections.min(checkMin);
				
				min.add(min1-min2);
		 } 
		        return Collections.min(min);
	 }
	
	public static void main(String[] args) {
		List<Integer> arr=new ArrayList<Integer>();
		for(int i=0;i<10;i++) {
			arr.add(i);
		}
//		7 6 8 4 2
//		5 2 6 3 1   4 5 4 2 4 5 2 3 2 1 1 5 4
		System.out.println(maxMin(4,  arr) );
		
	}
}
