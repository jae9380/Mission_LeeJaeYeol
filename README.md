# Mission_LeeJaeYeol


----
Step 1.  종료
 먼저 입력을 받기 위해 Scanner 객체를 생성 후, 
명령어를 받을 변수에 .nextLine() 메소드로 값을 받고
.equals() 메소드를 사용하여 명령어가 "종료"일 경우 return;으로 종료를 한다.

-----

Step 2. 등록
 앞으로 계속 추가될 명령어 때문에 if문이 계속 생기면 가독성이 떨어질거라 생각했기 때문에
switch 문으로 변경과 추가적인 메소드 작성을 위해 controller 클래스 생성.
controller에서 App의 스캐너를 받아오기 위해 생성자를 통해 받아왔다.

----

Step 4. 매 등록시 명언번호 노출 및 증가
 명언 등록시 순번을 주기위한 count선언과 등록 메소드 내부에 count 증감식을 추가하여
계속되는 등록에 각 각의 번호를 주었다. 

----

Step 5. 목록
 글의 순번과 명언,작가를 담을 HashMap을 선언한다. Upload메소드를 만들어 순번을 키 값으로
값으로는 Model객체로 구성했다. 

----

Step 6. 삭제
 입력되는 명령어에서 행동과 id를 구별하기위한 메소드 별도의 클래스에서 작성을 하였다.
스캐너를 통해 받은 데이터를 전달 값으로 받아서 ? 기준으로 문자열 배열로 나눠 따로 저장을 했다.
삭제 명령어는 ?뒤에 게시글 순번을 나타내는 숫자를 걸러내기 위해 idNum메소드에서 String클래스의 replaceAll("[^\\d]","")을 사용해서 정수가 아닌 부분은 제거를하고 반환 값으로 줄려고 생각을 했다.

Controller클래스로 돌아와 switch문에 입력값을 바로 전달하는 부분을 getAction으로 받는 것으로 수정했다.

삭제하기에 있어 만약 없는 부분을 삭제를 하면 문제가 생기는 부분 때문에 키에 해당하는 값이 있는지 먼저 찾아보기 위한 메소드를 만들어 ```java map.containsKey(key) ```을 사용하여 해당 값이 없으면 -1을 있으면 원래의 key값을 반환하였다.

----

Step 7. 존재하지 않는 명언삭제에 대한 예외처리
6단계 구현과 동시에 예외에 대한 생각을 하면서 구성을 하였다.

-----

Step 8. 명언수정
map.get(key)으로 값을 불러와 값을 수정하도록 했다.

----

Step 9. 파일을 통한 영속성
파일에 데이터 입력을 하기위해 BufferedWriter, Filewriter객체를 생성했다.
for each문을 이용하여 map의 데이터를 String 타입의 변수에 넣어서 파일에 입력을 하도록 구상하였다.
이번에는 파일에 저장된 데이터를 불러오기 위해 BufferedReader, FileReader객체를 생성하여 while문을 이용하여 .readLine()을 이용하여 다음에 읽을 줄이 없으면 반복을 종료하게 만들어서 각 줄마다 /을 기준으로 나눈 배열을 만들어 map에 데이터를 입력시켰다.

----

Step 10. data.json 빌드
JSONArray객체를 만들어 for-each문을 반복하여 map에서 받은 데이터를 JSONObject에 저장하고 해당 Object를 Array에 넣어서 반복문을 사용해서 파일에 저장했다.