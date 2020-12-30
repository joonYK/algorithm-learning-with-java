package coursera.unionFind.source;

public abstract class UnionFind {

    protected int[] ids;

    public UnionFind(int N) {
        ids = new int[N];
    }

    //연결
    public abstract void union(int p, int q);

    //연결 확인
    public abstract boolean connected(int p, int q);
}
