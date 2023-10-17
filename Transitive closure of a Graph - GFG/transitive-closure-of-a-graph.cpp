//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// Back-end complete function Template for C++

class Solution{
public:
    void dfs(int s,int i, int N, vector<vector<int>>& graph, vector<bool>& vis, vector<vector<int>>& tcg){
        vis[i]=true;
        tcg[s][i]=1;
        for(int k=0; k<N; ++k){
            if(!vis[k] && graph[i][k]==1){
                dfs(s, k, N, graph, vis, tcg);
            }
        }
    }
    vector<vector<int>> transitiveClosure(int N, vector<vector<int>> graph)
    {
        // code here
        vector<bool> vis(N, false);
        vector<vector<int>> tcg=graph;
        for(int i=0; i<N; ++i){
            dfs(i,i,N, graph, vis, tcg);
            vis.assign(N, 0);
        }
        return tcg;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        vector<vector<int>> graph(N, vector<int>(N, -1));
        for(int i = 0;i < N;i++)
            for(int j=0;j<N;j++)
            cin>>graph[i][j];
        
        Solution ob;
        vector<vector<int>> ans = ob.transitiveClosure(N, graph);
        for(int i = 0;i < N;i++)
            {for(int j = 0;j < N;j++)
                cout<<ans[i][j]<<" ";
        cout<<"\n";}
    }
    return 0;
}
// } Driver Code Ends