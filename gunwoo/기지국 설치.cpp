#include <iostream>
#include <vector>
using namespace std;

int solution(int n, vector<int> stations, int w)
{
    int answer = 0;
    vector<int> emptyAreaList;
    int oldStation = stations[0];
    if (oldStation - w - 1 > 0)
        emptyAreaList.push_back(oldStation - w - 1);

    for (int i = 1; i < stations.size(); i++) {
        int station = stations[i];
        if ((station - w) - (oldStation + w) - 1 > 0) {
            emptyAreaList.push_back((station - w) - (oldStation + w) - 1);
        }

        oldStation = station;
    }

    if (oldStation + w < n)
        emptyAreaList.push_back(n - oldStation - w);

    int range = w * 2 + 1;
    for (int k = 0; k < emptyAreaList.size(); k++) {
        int emptyArea = emptyAreaList[k];
        int a = emptyArea / range;
        if (emptyArea % range != 0) a++;
        answer += a;
    }

    return answer;
}