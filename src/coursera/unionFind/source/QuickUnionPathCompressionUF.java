package coursera.unionFind.source;

public class QuickUnionPathCompressionUF extends UnionFind {

    public QuickUnionPathCompressionUF(int N) {
        super(N);
    }

    private int root(int i) {
        while (i != id[i]) {
            //루트를 찾은 뒤에 부모노드를 루트노드로 저장해놓는다.
            id[i] = id[id[i]];
            i = id[i];
        }
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
