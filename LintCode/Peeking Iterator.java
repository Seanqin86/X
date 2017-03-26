// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    
    private Iterator<Integer> ite;
    private Integer nextNum;
    private boolean peekFlag = false;
    
    
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        ite = iterator;
    }
    
    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!peekFlag) {
            nextNum = ite.next();
            peekFlag = true;
        }
        return nextNum;
    }
    
    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!peekFlag) {
            return ite.next();
        }
        peekFlag = false;
        Integer result = nextNum;
        nextNum = null;
        return result;
    }
    
    @Override
    public boolean hasNext() {
        return peekFlag || ite.hasNext();
    }
}