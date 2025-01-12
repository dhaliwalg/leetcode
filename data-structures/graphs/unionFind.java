// UNION FIND (DISJOINT SET)
// Used for: Finding connected components, cycle detection, minimum spanning tree
class UnionFind {
    private int[] parent;
    private int[] rank;   // Used for union by rank optimization
    
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        
        // Initialize each element as its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    // Find with path compression
    // Finds the root/representative of the set
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // Path compression
        }
        return parent[x];
    }
    
    // Union by rank
    // Merges two sets together
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            // Attach smaller rank tree under root of higher rank tree
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                // If ranks are same, make one as root and increment its rank
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
    
    // Check if two elements are in the same set
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
