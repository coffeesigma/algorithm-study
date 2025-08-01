#include <iostream>
#include <algorithm>
#include <map>

using namespace std;

bool compare(const pair<string, int>& a, const pair<string, int>& b) {
    if (a.second != b.second) {
        return a.second > b.second;
    }
    else if (a.first.size() != b.first.size()) {
        return a.first.size() > b.first.size();
    }
    return a.first < b.first;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int word_count;
    int min_len;
    map<string, int> word_list;
    string now_word;

    cin >> word_count;
    cin >> min_len;
    for(int i = 0; i < word_count; i++) {
        cin >> now_word;
        if (now_word.size() < min_len)
            continue;
        auto it = word_list.find(now_word);
        if (it == word_list.end())
            word_list.insert(pair<string, int>(now_word, 1));
        else
            it->second++;
    }
    vector<pair<string, int> > vec(word_list.begin(), word_list.end());
    sort(vec.begin(), vec.end(), compare);
    for(auto word : vec) {
        cout << word.first << "\n";
    }

    return 0;
}