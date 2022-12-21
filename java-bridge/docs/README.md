# 기능목록

### 도메인

---
- [x] 입력한 만큼 랜덤 다리 방향 정보를 반환해준다
- [x] 다리를 생성한다.
  - [x] 다리의 길이는 3~20 사이이다.
    - [예외] 길이가 3~20 사이의 값이 아닐 경우 다리는 생성되지 않아야 한다.
  - [x] 다리는 방향인 U과 D로 이루어져 있다.
    - [예외] U나 D의 방향으로 해석될 수 없는 데이터는 다리에 포함될 수 없다.
  - [x] 다리의 n번째 칸이 U혹은 D가 맞는지 확인할 수 있다.
- [x] 방향은 U와 D 두개가 있다.
  - [x] 숫자 0은 D을 의미하고 1은 U을 의미한다.
    - [예외] 0또는 1이 아닌 값을 입력한다면 예외가 발생한다
  - [x] 스트링 U와 D는 방향 U,D를 각각 의미한다.
    - [예외] 스트링 U또는 D가 아닌 값으로 방향이 될 수 없다.
- [x] 다리 건너기 게임을 진행한다
  - [x] 플레이어에게 이동 방향을 알려준다. 
  - [x] 플레이어가 죽으면 한 턴이 끝난다.
  - [x] 플레이어가 다리 끝에 살아서 도달하면 성공이다.
  - [x] 게임이 이미 성공했거나 종료 호출을 하면 게임은 종료돼야한다.
  - [x] 플레이어가 다리의 어디까지 가있고 살아있는지 게임 현황을 알려준다.
  - [x] 게임 시도 횟수, 성공여부, 게임 진행 현황을 알려준다.
- [x] 플레이어가 이동한다
  - [예외] 플레이어가 죽었거나 다리의 끝인 상황에서 이동하면 예외가 발생한다.
  - [x] 플레이어는 다리 방향인 U또는 D로 움직일 수 있다.
  - [x] 플레이어가 잘못된 다리의 방향으로 전진하면 죽는다.
- [x] 플레이어가 죽어 실패하면 게임을 재시작하거나 종료한다.
  - [x] 게임을 재시작 한다.
    - [x] 플레이어를 다리의 처음으로 옮긴다.
    - [x] 죽은 유저를 살린다.
    - [x] 게임 시도 횟수를 1회 늘린다.
  - [x] 게임을 종료한다.
- [x] 게임 진행 커맨드를 설정한다
  - [x] 스트링 R은 재시작을 의미하는 커맨드로 해석된다.
  - [x] 스트링 Q는 종료를 의미하는 커맨드로 해석된다.
  - [예외] 스트링을 커맨드로 전환할 때 명시된 Q,R 이외의 값으로 바꾸려하면 예외가 발생한다.

### 입출력

----

#### 입력

- [x] 다리의 길이를 입력받는다
  - [예외] 숫자가 아니면 예외가 발생한다
  - [예외] 유효한 다리 길이가 아니면 예외가 발생한다.
- [x] 플레이어가 이동할 방향을 입력 받아 방향을 데이터를 반환한다.
  - [예외] 방향을 의미하는 입력이 아니라면 예외를 발생시킨다.
- [x] 게임 재시작/종료 커맨드를 입력받아 커맨드를 데이터를 반환한다.
  - [예외] 커맨드를 의미하는 입력이 아니라면 예외를 발생시킨다.

#### 출력
- [x] 게임 시작 문구를 출력한다.
- [x] 다리 게임의 진행 상황을 출력한다.
- [x] 최종 결과를 출력한다.
  - [x] 다리 게임의 최종 진행 상황을 출력한다.
  - [x] 다리 게임의 성공 여부를 출력한다.
  - [x] 시도한 횟수를 출력한다.
- [x] 에러 문자를 출력한다.
- [x] 일반 출력문을 출력한다.