from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
dx = [-1, 1, 0, 0] #### 상,하,좌,우
dy = [0, 0, -1, 1]


arr = []
for i in range(n):
    arr.append(list(map(int, input().strip()))) 



def bfs():
    queue = deque()
    queue.append((0, 0)) #### 큐에 시작점 삽입
    visited = [[-1] * n for _ in range(n)] #### n*n의 2차원 배열을 만들어 -1로 채워 넣는다.
    visited[0][0] = 0 #### visited는 검은 방을 흰 방으로 바꾼 횟수이다. 시작점의 초기값이 0인 이유는 흰 방을 바꾸지 않으면 답이 0이기 때문이다. 
    while queue:
        x, y = queue.popleft() #### 현재 위치의 큐를 삭제함과 동시에 x,y의 값을 할당한다.(아래에서 appendleft를 사용하기에 원소들은 후입선출된다.)
        if x == n-1 and y == n-1: #### x,y는 끝방에(n-1,n-1) 도착할 경우 visited를 리턴한다.  
            return visited[x][y]
        for i in range(4): #### 현재 (x,y)노드를 기준으로 상하좌우의 값을 찾는다. 
            nx = x + dx[i]
            ny = y + dy[i]
            #### 만약 현재 노드(nx,ny)가 0보다 크거나 같으며 배열의 크기보다 작으며 방문하지 않았다면(-1) 아래의 코드를 실행시킨다. 
            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == -1: 
                if arr[nx][ny] == 1: #### 주어진 배열에서 현재 노드가 흰 방이라면 
                    queue.appendleft((nx, ny)) #### 현재 노드를 큐 왼쪽에 삽입한다. (appendleft를 실행하기 때문에 bfs 함수가 실행되면 이후에 들어온 값이 먼저 나간다. )
                    visited[nx][ny] = visited[x][y] #### 동일한 흰 방의 묶음이기 때문에 이전의 값과 동일하게 값을 할당한다. 
                else: #### 주어진 배열에서 현재 노드가 검은 방이라면
                    queue.append((nx, ny)) #### 현재 노드를 큐 오른쪽에 삽입한다. (검은방은 큐의 오른쪽에 삽입, 가장 나중에 나가게 됨)
                    visited[nx][ny] = visited[x][y] + 1 #### 검은 방을 흰 방처럼 사용했음으로 + 1 해준다. 


print(bfs())






