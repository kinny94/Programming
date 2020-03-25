public static List<Integer> get(int v, int e, int [][]eg) {
    List<Integer> ans = new LinkedList<>();
    int[]id = new int[v];
    Arrays.fill(id, -1);
    int[]low = new int[v];
    int[]ar = new int[v];
    List<Integer>[] graph = new List[v];
    for (int i = 0; i < v; i++) graph[i] = new ArrayList<>();
    for (int edg[] : eg) {
        int x = edg[0];
        int y = edg[1];
        graph[x].add(y);
        graph[y].add(x);
    }
    for (int i = 0; i < v; i++) {
        if (id[i] == -1) {
            count = 0;
            dfs(i, i, -1, id, low, graph, ar);
            if (count > 1) ar[i] = 1;
            else ar[i] = 0;
        }
        if (ar[i] == 1) ans.add(i);
    }
    return ans;
}
static int ii = 0;
static int count;
public static void dfs(int root, int at, int parent, int[] id, int[] low, List<Integer>[]graph, int[] ans) {
    if (root == parent) count++;
    id[at] = ii;
    low[at] = ii;
    ii++;
    for (int to : graph[at]) {
        if (to == parent) continue;
        if (id[to] == -1) {
            dfs(root, to, at, id, low, graph, ans);
            low[at] = Math.min(low[at], low[to]);
            if (id[at] <= low[to]) {
                ans[at] = 1;
            }
        }
        else {
            low[at] = Math.min(low[at], id[to]);
        }
    }
}

public static void main(String[] args) {
    int[][]eg = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}, {6, 7}, {7, 8}};
    List<Integer> ans = get(9, 9, eg);
}