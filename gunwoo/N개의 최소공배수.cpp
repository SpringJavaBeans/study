#include <string>
#include <vector>

using namespace std;

int gcd(int a, int b) {
    if (b == 0) return a;
    else return gcd(b, a % b);
}

int lcm(int a, int b, int gcd) {
    return (a * b) / gcd;
}

int solution(vector<int> arr) {
    int answer = 0;

    while (arr.size() > 1) {
        int a = arr.back(); arr.pop_back();
        int b = arr.back(); arr.pop_back();
        int lcm_value = lcm(a, b, gcd(a, b));
        arr.push_back(lcm_value);
    }
    
    answer = arr.front();

    return answer;
}