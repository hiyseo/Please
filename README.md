# 🏄‍♂️SPLASH!
연락처와 갤러리, 날씨 기능이 있는 어플리케이션


### ***************************************************************열심히 부딪혀보다. SPLASH!***************************************************************

### 팀원

- **김윤서** 고려대학교 컴퓨터학과 20학번
- **이수민** KAIST 전산학부 21학번

### 개발 환경

- Android Studio
- Kotlin
- Android

## 전반적 기술 개요

- 저희는 구글의 공식적인 지원을 받으며 지속적인 성장과 개발을 보장하는 데 도움이 되는 안드로이드 개발용 언어인 Kotlin 기반의 안드로이드 앱 개발을 진행하였습니다. 'Navigation tab' 레이아웃을 이용하였고 각 탭은 각각의 'Fragment', 'ViewModel', 'Adapter'를 통해 원하는 내용을 구현합니다. 

### Tab1 | Contact

**프로필, 이름, 연락처를 한눈에 볼 수 있는 탭**

- RecyclerView 형태로 사진, 이름, 전화번호 및 즐겨찾기 아이콘 보임
- 연락처 상단에 연락처 개수를 알려주는 Textview 위치
- 연락처 클릭 시 사진, 이름, 전화번호를 볼 수 있는 상세정보 Fragment로 이동
- 상세정보 Fragment에는 연락처 삭제, 수정, 전화 버튼이 있고, 각 버튼을 클릭하여 각 기능 수행 가능
- 즐겨찾기 클릭 시 해당 아이템이 리스트 최상단으로 이동
- 즐겨찾기 해제 시 해당 아이템이 리스트 최하단으로 이동
- 연락처 하단의 + 버튼을 클릭하여 연락처 추가하는 Fragment로 이동
- 연락처 추가 Fragment에는 이름 및 전화번호를 받아 저장 버튼을 누르면 연락처에 추가됨

### Tab2 | Image

**캐릭터들의 사진과 이름이 담겨져 있는 탭**

- RecyclerView 형태로 CardView들로 정렬되어 있음
- 사진 클릭 시 이름과 사진 확대 화면이 보임
- 뒤로 이동하는 BACK 버튼이 있음

### Tab3 | Weather

**최신 날씨 정보를 불러오는 탭**

- Retrofit을 활용하여 공공데이터포털의 단기예보 API를 호출하여 날씨 정보를 가져와서 data class로 구현
- 데이터를 분석하여 기온, 하늘 상태, 강수 형태, 습도를 추출하여 각 시간대별로 배열에 저장
- 코드 형태의 정보를 문자열로 변환
- 고정된 위치(대전광역시 유성구 온천2등)의 날씨 정보를 표시
- RecylcerView를 이용하여 최신 6시간동안의 날씨 예보를 표시
- 하늘 상태에 따라 다른 View를 구현하여 날씨를 시각적으로도 쉽게 이해할 수 있도록 함
- 새로고침 버튼을 누르면 현재 시각의 데이터로 갱신하여 최신 날씨 정보를 제공
  
