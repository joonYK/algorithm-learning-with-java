package coursera.unionFind.source;

public class WeightedQuickUnionUF extends UnionFind{

    //각각 트리의 가중치를 저장
    private int[] sz;

    public WeightedQuickUnionUF(int N) {
        super(N);

        sz = new int[N];

        //가중치를 각 1로 초기화.
        for (int i = 0; i < sz.length; i++)
            sz[i] = 1;
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
        if (i == j) return;

        //트리의 가중치 비교 (작은 트리의 루트가 큰 트리의 루트에 연결되도록)
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
