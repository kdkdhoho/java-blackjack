# java-blackjack

블랙잭 미션 저장소

# 요구사항 분석
## 주요 객체의 속성, 역할
### PlayersFactory
- [x] 입력된 이름을 가지고 `Players`를 만들어 반환한다.
  - [x] 최소 2명에서 최대 8명의 `Players`를 생성한다.

### Participants
- [x] `Participant`들을 가진다.

### Participant
- [x] `Cards`를 가진다.
- [x] `Card`를 받는다.

### Player (extends Participant)
- [x] 이름을 가진다.
  - [x] 이름의 길이는 최소 1글자에서 최대 5글자이다.
- [x] `Cards`를 가진다.
- [x] `Card`를 받는다.

### Players
- [x] `Player`들을 가진다.

### Dealer (extends Participant)
- [x] `Cards`를 가진다.
- [x] `Card`를 받는다.

### BlackjackGame
- [ ] 시작하면서, `Participants`의 모두에게 2장의 카드를 나눠준다.
- [ ] `Participants` 순서대로 카드를 더 받을 지 물어본다.
  - [ ] 블랙잭인 참가자에게는 물어보지 않는다.
- [ ] 카드 세팅을 한다.
  - [ ] 21을 넘은 참가자에게는 카드를 더 이상 주지 않는다.
  - [ ] 'n'을 입력한 참가자에게는 더 이상 주지 않는다.
- [ ] 최종 승패를 결정한다.

### Card
- [x] `Number`와 `Pattern`을 가진다.

### Cards
- [x] `Card`들을 가진다.
- [x] 가지고 있는 `Card`로 총점을 계산한다.

### Number (Enum)
- [x] 숫자를 가진다. (A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K)
- [x] 숫자를 점수로 변환해준다.

### Pattern (Enum)
- [x] 문양을 가진다. (하트, 스페이드, 클로버, 다이아몬드)
  - [x] 문양에 맞는 이름을 가진다.

## 입출력 요구사항
### 입력 요구사항
- [ ] 참가자의 이름을 입력받는다. (','로 구분짓는다.)
  - [ ] 공백을 입력했는지 검증한다.
- [ ] 카드를 더 받을지 입력받는다.

### 출력 요구사항
- [ ] 딜러와 참가자들에게 나누어준 카드를 출력한다.
  - [ ] 딜러는 한 장의 카드만 출력한다.
- [ ] 더 이상 카드를 받지 않는다면, 현재 가진 카드들을 출력한다. (보류)
- [ ] 딜러의 점수가 16점 이하인 경우, 딜러가 한 장의 카드를 더 받았다고 출력한다.
- [ ] 참가자와 딜러가 가진 카드들을 모두 출력하고, 총점도 같이 출력한다.
- [ ] 최종 승패를 출력한다.


## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
