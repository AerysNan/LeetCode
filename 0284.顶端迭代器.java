/*
 * @lc app=leetcode.cn id=284 lang=java
 *
 * [284] 顶端迭代器
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.Iterator;
import java.util.Optional;


class PeekingIterator implements Iterator<Integer> {
  Iterator<Integer> iterator;
  Optional<Integer> cache;

  public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    this.iterator = iterator;
    this.cache = Optional.empty();
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    if (!cache.isPresent())
      cache = Optional.of(iterator.next());
    return cache.get();
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    if (cache.isPresent()) {
      int value = cache.get();
      cache = Optional.empty();
      return value;
    }
    return iterator.next();
  }

  @Override
  public boolean hasNext() {
    return iterator.hasNext() || cache.isPresent();
  }
}
// @lc code=end

