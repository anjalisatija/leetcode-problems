// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private List<Integer> arr = new ArrayList<>();
    private int currentIndex;
    private int size;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.currentIndex = 0;
        while (iterator.hasNext()) {
            this.arr.add(iterator.next());
        }
        this.size = this.arr.size();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasNext()) throw new IndexOutOfBoundsException("No more elements in the array.");
        return this.arr.get(currentIndex);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasNext()) throw new IndexOutOfBoundsException("No more elements in the array.");
       
        return this.arr.get(currentIndex++);
    }

    @Override
    public boolean hasNext() {
        return this.currentIndex < this.size;
    }
}