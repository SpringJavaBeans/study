#include <string>
#include <vector>
#include <algorithm>

using namespace std;

//2:58 //3:15
//구명보트
int solution(vector<int> people, int limit) {
    int answer = 0, i = 0;
    sort(people.begin(), people.end());
    while (people.size() >= i) {
        int n = people.back();
        people.pop_back();

        if (people[i] + n <= limit) {
            answer++;
            i++;
        }
        else
            answer++;
    }
    return answer;
}