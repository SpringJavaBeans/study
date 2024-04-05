#include <string>
#include <vector>
#include <queue>
#define MAX 101
using namespace std;

vector<int> adjList[MAX];

int bfs(int v1, int v2) {
    int cnt = 1;
    queue<int> q;
    vector<bool> visited(MAX, false);
    visited[v1] = true;
    visited[v2] = true;
    q.push(v1);

    while (!q.empty()) {
        int n = q.front(); q.pop();

        for (int i = 0; i < adjList[n].size(); i++) {
            if (!visited[adjList[n][i]]) {
                visited[adjList[n][i]] = true;
                q.push(adjList[n][i]);
                cnt++;
            }
        }
    }

    return cnt;
}

int solution(int n, vector<vector<int> > wires) {
    int answer = MAX;

    for (int i = 0; i < wires.size(); i++) {
        vector<int> v = wires[i];
        adjList[v[0]].push_back(v[1]);
        adjList[v[1]].push_back(v[0]);
    }

    for (int i = 0; i < wires.size(); i++) {
        vector<int> v = wires[i];
        int cnt = bfs(v[0], v[1]);
        int value = cnt * 2 - n;
        if (value < 0) value = -value;
        if (value < answer)
            answer = value;
    }

    return answer;
}