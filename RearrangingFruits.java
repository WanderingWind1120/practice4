import java.util.TreeMap;

public class RearrangingFruits {
    public Long minCost (int[] basket1, int[] basket2){
        Long min = Long.MAX_VALUE;
        TreeMap<Integer, Integer> dif = new TreeMap<>();
        for (int i: basket1){
            dif.put(i, dif.getOrDefault(i, 0)+1);
            min = Math.min(min,i);
        }
        for (int i: basket2){
            dif.put(i, dif.getOrDefault(i, 0)-1);
            min = Math.min(min,i);
        }
        int replace = 0;
        for (Integer i: dif.keySet()){
            int v = dif.get(i);
            if (v % 2 > 0) return (long) -1;
            else replace += Math.max (0, dif.get(i) /2 );
        }
        int res = 0;
        for (Integer i: dif.keySet()){
            int cantake = Math.min(replace, Math.abs(dif.get(i)/2));
            res += cantake * Math.min(i, 2*min);
            replace -= cantake;
        }
        return (long) res;
    }
}
