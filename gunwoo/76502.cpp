#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

//"([])"

//9:30
bool IsValid(string s){
    stack<char> st;

    for(int i=0; i<s.size(); i++){
        if(s[i]==']'){
            char c = st.top();
            if(c != '[') return false;
            st.pop();
        }
        else if(s[i]==')'){
            char c = st.top();
            if(c != '(') return false;
            st.pop();
        }
        else if(s[i]=='}'){
            char c = st.top();
            if(c != '{') return false;
            st.pop();
        }
        else
            st.push(s[i]);
    }

    return st.empty();
}

int solution(string s) {
    int answer = 0;

    answer += IsValid(s);
    for(int i=1; i<s.size(); i++){
        char c = s[0];
        s.erase(s.begin());
        s.push_back(c);
        answer += IsValid(s);
    }

    return answer;
}
