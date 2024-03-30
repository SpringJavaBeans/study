#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(int n) {
    int answer = 0;
    int p[60001];
    p[0] = 1;
    p[1] = 1;

    for(int i=2; i<=n; i++){
        p[i] = (p[i-1] + p[i-2]) % 1000000007;
    }

    return p[n];
}