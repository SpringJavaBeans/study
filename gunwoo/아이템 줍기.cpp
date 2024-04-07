#include <string>
#include <vector>
#include <cstring>
#include <queue>
#include <iostream>

using namespace std;

int map[50][50] = {0};

int bfs(int cx, int cy, int ix, int iy){
    queue<pair<int,int>> q;
    int dirx[] = {1,-1,0,0};
    int diry[] = {0,0,1,-1};
    q.emplace(cy,cx);
    int visited[50][50] = {0};
    visited[cy][cx]=1;

    while(!q.empty()){
        int x = q.front().second;
        int y = q.front().first;
        q.pop();

        for(int k=0; k<4; k++){
            int nx = x+dirx[k];
            int ny = y+diry[k];

            if(nx < 0 || nx >= 50 || ny < 0 || ny >= 50) continue;
            
            if(map[ny][nx]==1 && visited[ny][nx]==0){
                visited[ny][nx] = visited[y][x] + 1;
                q.emplace(ny,nx);
            }

            if(nx == ix && ny == iy){
                return visited[ny][nx];
            }
        }
    }

    return -1;
}

int solution(vector<vector<int>> rectangle, int characterX, int characterY, int itemX, int itemY) {
    int answer = 0;
    characterX *= 2; characterY*=2; itemX*=2; itemY*=2;
    //memset(map, sizeof(map), 0);
    //모든rectangle 2배
    for(int i=0; i<rectangle.size(); i++){
        for(int j=0; j<rectangle[0].size(); j++){
            rectangle[i][j] *= 2;
        }
    }

    for(int i=0; i<rectangle.size(); i++){
        int x1 = rectangle[i][0];
        int x2 = rectangle[i][2];
        int y1 = rectangle[i][1];
        int y2 = rectangle[i][3];

        for(int x=x1; x<=x2; x++){
            for(int y=y1; y<=y2; y++){
                map[y][x]=1;
            }
        }for(int x=x1 + 1; x<x2; x++){
            for(int y=y1 + 1; y<y2; y++){
                map[y][x]=0;
            }
        }
    }

     for(int i=0; i<rectangle.size(); i++){
        int x1 = rectangle[i][0];
        int x2 = rectangle[i][2];
        int y1 = rectangle[i][1];
        int y2 = rectangle[i][3];

        for(int x=x1 + 1; x<x2; x++){
            for(int y=y1 + 1; y<y2; y++){
                map[y][x]=0;
            }
        }
    }

    // for(int i=0; i<50; i++){
    //     for(int j=0; j<50; j++){
    //         if(map[j][i]==0) cout<<"ㅁ";
    //         else cout<<"😍";
    //     }

    //     cout<<endl;
    // }

    answer = bfs(characterX, characterY, itemX, itemY);
    
    return answer/2;
}

int main(){
    vector<vector<int>> rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
    int characterX = 1;
    int characterY = 3;
    int itemX = 7;
    int itemY = 8;

    cout << solution(rectangle, characterX, characterY, itemX, itemY);
}