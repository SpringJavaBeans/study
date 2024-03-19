#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

//의상
//7:32  //7:45
int solution(vector<vector<string>> clothes) {
    int answer = 1;
    map<string, int> m;

    //옷의 종류를 개수만큼 카운팅
    //ex)
    //head : 2개
    //eyewear : 1개
    for (auto v : clothes) {
        m[v[1]]++;
    }

    for (auto tier : m) {
        //옷을 벗는 경우도 있으므로 +1
        //모든 조합의 수를 구한다
        answer *= tier.second + 1;
    }

    //모두 벗는 경우의 수는 제외해야하므로 - 1
    return answer - 1;
}