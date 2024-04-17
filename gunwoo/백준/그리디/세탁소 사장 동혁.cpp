#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
	priority_queue<int, vector<int>, greater<>> card;

    int n;
    int ans = 0;

    cin >> n;

    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;

        card.push(a);
    }

    while (card.size() != 1) {
        int c1 = card.top();
        card.pop();
        int c2 = card.top();
        card.pop();

        ans += c1 + c2;
        card.push(c1 + c2);
    }

    cout << ans;


}
