import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 * @lc app=leetcode.cn id=1146 lang=java
 *
 * [1146] 快照数组
 */
class SnapshotArray {

  class Value {
    int value;
    int version;

    public Value(int value, int version) {
      this.value = value;
      this.version = version;
    }
  }

  private ArrayList<ArrayList<Value>> content;
  int version = 0;

  public SnapshotArray(int length) {
    content = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      ArrayList<Value> snaps = new ArrayList<>();
      snaps.add(new Value(0, 0));
      content.add(snaps);
    }
  }

  public void set(int index, int val) {
    ArrayList<Value> snaps = content.get(index);
    if (!snaps.isEmpty() && snaps.get(snaps.size() - 1).version == version)
      snaps.get(snaps.size() - 1).value = val;
    else
      content.get(index).add(new Value(val, version));
  }

  public int snap() {
    return version++;
  }

  public int get(int index, int snap_id) {
    ArrayList<Value> snaps = content.get(index);
    int l = 0, h = snaps.size() - 1;
    while (l < h) {
      int m = (l + h + 1) >> 1;
      Value v = snaps.get(m);
      if (v.version == snap_id)
        return v.value;
      if (v.version > snap_id)
        h = m - 1;
      else
        l = m;
    }
    return snaps.get(l).value;
  }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length); obj.set(index,val); int
 * param_2 = obj.snap(); int param_3 = obj.get(index,snap_id);
 */
