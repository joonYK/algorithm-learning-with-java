package coursera.unionFind.source;

public abstract class UnionFind {

    protected int[] id;

    public UnionFind(int N) {
        id = new int[N];

        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    //연결
    public abstract void union(int p, int q);

    //연결 확인
    public abstract boolean connected(int p, int q);
}
