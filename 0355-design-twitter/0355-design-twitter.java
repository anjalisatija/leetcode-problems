class Twitter {

    private static class Tweet {
        int time;
        int tweetId;

        Tweet(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    private Map<Integer, Set<Integer>> followingMap;
    private Map<Integer, List<Tweet>> tweetsMap;
    private int timeStamp;

    public Twitter() {
        followingMap = new HashMap<>();
        tweetsMap = new HashMap<>();
        timeStamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweetsMap.putIfAbsent(userId, new ArrayList<>());
        tweetsMap.get(userId).add(new Tweet(timeStamp++, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        Set<Integer> users = new HashSet<>();
        users.add(userId);
        if (followingMap.containsKey(userId)) {
            users.addAll(followingMap.get(userId));
        }

        for (int uid : users) {
            List<Tweet> tweets = tweetsMap.getOrDefault(uid, new ArrayList<>());
            for (Tweet tweet : tweets) {
                maxHeap.offer(tweet);
            }
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            result.add(maxHeap.poll().tweetId);
            count++;
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followingMap.putIfAbsent(followerId, new HashSet<>());
        followingMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (followingMap.containsKey(followerId)) {
            followingMap.get(followerId).remove(followeeId);
        }
    }
}