public class ZigzagIterator {
    List<Integer> v1;
    List<Integer> v2;
    int len1, len2;
    int id1, id2;
    boolean first;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        len1 = v1.size();
        len2 = v2.size();
        id1 = 0;
        id2 = 0;
        first = id1 == len1 ? false : true;
    }

    public int next() {
        if(first && id1 < len1){
            if(id2 != len2) first = !first;
            return v1.get(id1 ++);
        }else if(!first && id2 < len2){
            if(id1 != len1) first = !first;
            return v2.get(id2 ++);
        }else{
            return -1;
        }
    }

    public boolean hasNext() {
        if(id1 == len1 && id2 == len2) return false;
        else return true;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */