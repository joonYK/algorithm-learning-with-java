package coursera.unionFind.source;

public class QuickUnionUF extends UnionFind {

    public QuickUnionUF(int N) {
        super(N);
        for (int i = 0; i < N; i++)
            ids[i] = i;
    }

    private int root(int i) {
        while (i != ids[i])
            i = ids[i];
        return i;
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        ids[i] = j;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
