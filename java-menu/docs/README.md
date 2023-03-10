## 기능목록

### 도메인

- [x] 메뉴판은 카테고리와 메뉴명으로 정의된다.
  - [x] 메뉴판에서 메뉴의 이름으로 메뉴를 가져온다.
- [x] 식사 동료 모음은 2~5명의 코치로 이루어진다.
  - [예외] 식사 동료 모음이 2보다 작거나 5명 이상일 경우는 예외가 발생한다.
  - [예외] 식사 동료들의 이름은 같을 수 없다.
- [x] 식사 추천은 코치 2~5명의 코치의 5개의 요일별 음식 추천으로 이루어진다.
  - [x] 요일별 음식 추천은 코치들과 각각에게 맞는 음식으로 이루어진다.
    - [x] 각 코치들의 메뉴는 못먹는 음식으로 이루어질 수 없다.
    - [예외] 요일별 추천에 코치가 못먹는 음식을 등록하면 예외가 발생한다.
  - [x] 코치들은 같은 카테고리의 음식 중 하나를 먹는다.
  - [x] 카테고리는 랜덤으로 결정한다.
    - [x] 한 주간의 카테고리 중복은 2회 허용한다.
  - [x] 한 코치에 대해서 동일한 요리는 허용하지 않는다.
- [x] 코치는 이름과 못먹는 음식으로 정의된다.
  - [x] 못먹는 음식은 없을 수 있다.
  - [x] 못 먹는 음식은 등록된 메뉴여야한다.
    - [예외] 만약 못 먹는 음식으로 메뉴에 등록되지 않은 음식을 입력시 예외 발생
- [x] 요일별 추천 데이터를 반환한다.
- [x] 두 코치가 같다는 것은 이름이 같다는 것이다.
- 

## 입출력

### 입력

-[x] 같이 식사할 동료들을 입력받는다.
  - [x] 입력 형식은 " , "로 나누어진 코치들의 이름이다.
  - [x] 식사할 동료들은 2~5명으로 이루어진 코치 집합이다.
  - [예외] 동료들의 이름은 고유해야한다.
- [x] 코치가 못먹는 음식을 입력받는다.
  - [예외] 등록되지 않은 음식을 입력하면 예외가 발생한다.


### 출력
- [x] 서비스 안내 시작 문구를 출력한다.
- [x] 메뉴 추천 결과를 출력한다.
- [x] 에러 메시지를 출력한다.


## Todo

1. Menu를 고유 값으로 만들기 - 같은 이름을 같은 Menu가 생성되지 않도록 싱글톤으로 설계
2. 메뉴 카테고리를 하나의 객체로 분리하기