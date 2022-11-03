import java.util.*;

public class EuclideanDistance {
    static double distance(int x1, int y1, int x2, int y2) {
        // Calculating distance
        return Math.round(Math.sqrt(Math.pow(x2 - x1, 2)
                + Math.pow(y2 - y1, 2) * 1.0));
    }


    static List<Integer> topKFrequentElements(List<Integer> array, int k) {
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<Integer, Integer>();
        for (int n : array) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new List[array.size() + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        for (int key : frequencyMap.keySet()) {
            bucket[frequencyMap.get(key)].add(key);
        }

        List<Integer> result = new ArrayList();
        for (int i = bucket.length - 1; i >= 0; i--) {
            result.addAll(bucket[i]);
            if (result.size() >= k) {
                break;
            }
        }
        return result;
    }

    public static List<Integer> findEuclideanDistanceMode(List<List<Integer>> coordinates) {
        List<Integer> squaredDistances = new ArrayList<Integer>();
        for (int i = 0; i < coordinates.size() - 1; i++) {
            //converting double to int
            squaredDistances.add((int) distance(coordinates.get(i).get(0), coordinates.get(i).get(1), coordinates.get(i + 1).get(0), coordinates.get(i + 1).get(1)));
        }
        squaredDistances.forEach(num -> System.out.println(num));
        return topKFrequentElements(squaredDistances, 1);
    }


    public static void main(String[] args) {

        List<Integer> result = findEuclideanDistanceMode(Arrays.asList(Arrays.asList(-11, 3), Arrays.asList(8, 5), Arrays.asList(-3, 2), Arrays.asList(9, 17)));
        result.forEach(num -> System.out.println(num));
        //if squaredDistance turns out to be [19,11,19,19] answer is 19.
        //If squaredDistance turns out to be [19,11,11,19] answer is 19 11.

    }

}
