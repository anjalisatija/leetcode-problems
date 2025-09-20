import java.util.*;

public class Router {
    private int memoryLimit;
    private Deque<Packet> queue;
    private Set<String> seen;
    private Map<Integer, List<Integer>> destMap;

    private static class Packet {
        int source, destination, timestamp;
        Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        String key() {
            return source + "," + destination + "," + timestamp;
        }
    }

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.seen = new HashSet<>();
        this.destMap = new HashMap<>();
    }

    private int findLeft(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int findRight(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private void insertSorted(List<Integer> list, int value) {
        int idx = findLeft(list, value);
        list.add(idx, value);
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);
        String key = packet.key();

        if (seen.contains(key)) return false;

        if (seen.size() == memoryLimit) {
            Packet removed = queue.pollFirst();
            seen.remove(removed.key());
            List<Integer> timestamps = destMap.get(removed.destination);
            int idx = findLeft(timestamps, removed.timestamp);
            timestamps.remove(idx);
            if (timestamps.isEmpty()) {
                destMap.remove(removed.destination);
            }
        }

        queue.offerLast(packet);
        seen.add(key);
        destMap.computeIfAbsent(destination, k -> new ArrayList<>());
        insertSorted(destMap.get(destination), timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];

        Packet packet = queue.pollFirst();
        seen.remove(packet.key());

        List<Integer> timestamps = destMap.get(packet.destination);
        int idx = findLeft(timestamps, packet.timestamp);
        timestamps.remove(idx);
        if (timestamps.isEmpty()) {
            destMap.remove(packet.destination);
        }

        return new int[]{packet.source, packet.destination, packet.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destMap.containsKey(destination)) return 0;

        List<Integer> timestamps = destMap.get(destination);
        int lo = findLeft(timestamps, startTime);
        int hi = findRight(timestamps, endTime);
        return hi - lo;
    }
}