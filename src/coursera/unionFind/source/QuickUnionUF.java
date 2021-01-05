package coursera.unionFind.source;

public class QuickUnionUF extends UnionFind {

    public QuickUnionUF(int N) {
        super(N);
    }

    private int root(int i) {
        while (i != id[i])
            i = id[i];
        return i;
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
