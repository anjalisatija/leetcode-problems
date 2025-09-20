public class RandomizedCollection {
    List<Integer> list;
    Map<Integer, List<Integer>> map;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        map.computeIfAbsent(val, k -> new ArrayList<>()).add(list.size());
        list.add(val);
        return map.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        List<Integer> indices = map.get(val);
        int idxToRemove = indices.remove(indices.size() - 1);
        if (indices.isEmpty()) map.remove(val);

        if (idxToRemove != list.size() - 1) {
            int lastElement = list.get(list.size() - 1);
            list.set(idxToRemove, lastElement);
            map.get(lastElement).remove(Integer.valueOf(list.size() - 1));
            map.get(lastElement).add(idxToRemove);
        }
        list.remove(list.size() - 1);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}