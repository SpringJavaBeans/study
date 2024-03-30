#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    unordered_set<char> s;
    for(int a = 0; a<skill.size(); a++)
        s.insert(skill[a]);


    for(int i=0; i<skill_trees.size(); i++){
        int idx = 0;
        bool t = true;
        for(int j=0; j<skill_trees[i].size(); j++){
            if(s.find(skill_trees[i][j])==s.end())
                continue;

            if(skill_trees[i][j] == skill[idx]){
                idx++;
            }
            else{
                t = false;
                break;
            }
        }

        if(t) answer++;
    }

    return answer;
}