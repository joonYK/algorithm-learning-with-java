package coursera.unionFind.source;

public class QuickFindUF extends UnionFind {

    public QuickFindUF(int N) {
        super(N);
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        if(!connected(p, q)) {
            int pid = id[p];
            int qid = id[q];

            for (int i = 0; i < id.length; i++)
                if (id[i] == pid) id[i] = qid;
        }
    }
}
