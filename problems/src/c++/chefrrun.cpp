#include<iostream>
using namespace std;

int main(){
long t;
cin>>t;
while(t-- > 0){
long answer = 0;
int  N ;
cin >> N;

long input[N];
bool visited[N];

for (int i = 0; i < N; i++) {
    cin>> input[i];
}

bool magic[N];
for (int i = 0; i < N; i++) {
    if(visited[i]){
        continue;
    }
    visited[i] = true;
    bool visitedNow[N];
    visitedNow[i] = true;
    while (true){
        int nextHope = (i + input[i] + 1) % N;
        if(visitedNow[nextHope]){
             while (true){
        if(magic[i]){
           break;
        }
        magic[i] = true;
        answer++;
        visited[i] = true;
        i = (i + input[i] + 1) % n;
    }
            break;
        }
        if(visited[nextHope]){
            return;
        }

        visited[nextHope] = true;
        visitedNow[nextHope] = true;
        i = nextHope;
    }
}

cout << answer;

}
return 0;
}
