#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool find(vector<int> v, int n){
    auto it = find(v.begin(), v.end(), n);
    return it != v.end();
}

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    vector<bool> hasCloth(n+1, false);
    int cnt = 0;

    sort(lost.begin(), lost.end());
    sort(reserve.begin(), reserve.end());
    
    for(int k=0; k<reserve.size(); k++) hasCloth[reserve[k]]=true;

    for(int i=0; i<reserve.size(); i++){
        
        if(find(lost, reserve[i])){
            hasCloth[reserve[i]]=true;
            cnt++;
            continue;
        }

        if(find(lost, reserve[i]-1) && !hasCloth[reserve[i]-1]){
            hasCloth[reserve[i]-1] = true;
            cnt++;
        }
        else if(find(lost, reserve[i]+1) && !hasCloth[reserve[i]+1]){
            hasCloth[reserve[i]+1] = true;
            cnt++;
        }
    }

    answer =  n - (lost.size() - cnt);
    return answer;
}