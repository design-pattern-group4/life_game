프로젝트 개요:  
Holub Life Game 프로젝트에 대해 설계패턴을 적용하여 기능을 확장하고 설계를 개선 

(링크: https://holub.com/software/life/index.html)

⚫ 수업 시간에 다룬 설계패턴 및 객체지향 설계 개념을 적극적으로 활용하며, 그 결과를 문서화해야 함  
⚫ 기존 Life Game 프로젝트가 지원하던 기능은 그대로 동작해야 함  
⚫ 기능 확장과 설계 개선 활동이 잘 되었다는 것을 JUnit을 이용해 테스트

⚫ Life Game 관련 참고 자료:

    https://bitstorm.org/gameoflife/standalone/.
    http://www.math.com/students/wonders/life/life.html
    http://golly.sourceforge.net/

게임 규칙
-

grid 칸들의 행동 규칙  
이웃은 기준 중심으로 8칸 (좌상,상,우상,우,우하,하,좌하,좌) 

이미 선택되어 있는 칸 (populated)

- 이웃 0~1개시 => 선택해제 (loneliness)
- 이웃 2~3개시 => 선택유지
- 이웃 4개 이상시 => 선택해제 (overpopulation)

선택되어있지 않은 칸 (empty or unpopulated)

- 이웃 3개시 => 선택