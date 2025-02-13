package D_13_02_25.HashMapAndHashFunctions;
import java.util.*;
class SubarraysWithZeroSum {
    public static void findZeroSum(int[] arr){
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        for(int i=0; i< arr.length; i++){
            sum+=arr[i];
            if(map.containsKey(sum)){
                for(int start : map.get(sum)){
                    result.add(Arrays.asList(start+1, i));
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        for(List<Integer> subarray : result){
            int start = subarray.get(0);
            int end = subarray.get(1);
            System.out.println();
            for(int j=start; j<=end; j++){
                System.out.print(arr[j]+" ");
            }
        }
    }
    public static void main(String[] args){
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        findZeroSum(arr);
    }
}
