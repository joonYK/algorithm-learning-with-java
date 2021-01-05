package coursera.unionFind.source;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuickUnionPathCompressionUFTest {

    private UnionFind uf = new QuickUnionPathCompressionUF(10);

    @Test
    public void connectedTest() {
        assertFalse(uf.connected(0, 5));
    }

    @Test
    public void unionTest() {
        uf.union(0,1);
        uf.union(7,8);
        uf.union(8,9);

        assertTrue(uf.connected(0,1));
        assertTrue(uf.connected(7,8));
        assertTrue(uf.connected(7,9));
    }
}
