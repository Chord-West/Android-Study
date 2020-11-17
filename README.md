# Android-PersonalAssignment

- ### 20175161 소프트웨어학부 김현서

- ### Firbase 사용



#### MainPage ( 상품선택 페이지 )

---

<div style="display:flex; justify-content:space-around;">
	<img src="https://i.imgur.com/JeHo6qv.png" style="zoom:67%;" />
	<img src="https://i.imgur.com/TqovUWJ.png" style="zoom:67%;" />
</div>

- Main page는 Relative Layout으로 구성
- Checkbox widget을 사용해서 check한 품목들을 장바구니에 담거나
- 각각 아이템들은 Listview를 adapter에 적용시켜서 data들을 화면에 적용했습니다.. 
- 만약 체크를 안한 상태에서 BUY IT NOW 버튼을 누르면 제품을 선택하라고 TOAST 메세지가 출력됩니다.
- Check한 제품들을 BUY IT NOW 버튼을 누르면 Intent를 통해 Product Class에 Parcelable 을 상송받아서 ArrayList에 객체를 담아 값을 전달하고, 화면전환을 하고,  ADD TO CART 버튼 클릭시 Firebase에 저장하고, 장바구니 페이지로 이동합니다.
- 파이어베이스의 메소드를 통해서 Check한 제품들의 data를 Product Class를 만들어서 key값과 value들을 저장했습니다 .



#### CartPage ( 장바구니 페이지 )

---

<div style="display:flex; justify-content:space-around;">
	<img src="https://i.imgur.com/TnNimQe.png" style="zoom:67%;" />
	<img src="https://i.imgur.com/VSp0x48.png" style="zoom:67%; " />
</div>



- 장바구니 페이지는 Linear Layout으로 구성

- 파이어베이스의 메소드를 통해서 data 값들을 불러와서 Listview에 적용시켰습니다.

- Check한 제품들을 key값을 통해 제거하거나, 구매할 수 있습니다.

- BACK TO HOME 버튼 클릭 시 제품선택페이지로 화면전환을 하고, PAYMENT 버튼 클릭 시 Check한 제품들은 Product모델의 Parcelable을 상속받아 Intent의 ArrayList에 객체를 담아 전달하고, 구매페이지로 호만젼환  

- 삭제시 화면

- <div style="display:flex; justify-content:space-around;">
  	<img src="https://i.imgur.com/VnmB8Mp.png" style="zoom:50%;" />		<img src="https://i.imgur.com/ZxxbOvl.png" style="zoom:50%;" />
    	<img src="https://i.imgur.com/ml6FsbW.png" style="zoom:50%; "/>
  </div>





#### PaymentPage ( 구매 페이지 )

---

<div style="display:flex; justify-content:space-around;">
	<img src="https://i.imgur.com/n70IvWY.png" style="zoom:67%;" />
	<img src="https://i.imgur.com/sJvol6t.png" style="zoom:67%; " />
</div>

- 구매 페이지는 GridView를 사용했습니다.
- 장바구니 혹은 상품선택페이지에서 선택한 정보들을 Intent를 통해 불러와 정보를 띄워주고, 가격들의 총합을 계산해 결과 값을 결제총합에 출력하게 했습니다.
- 5x3으로 구성하였고 colspan이 필요한 부분은 적절하게 사용하였습니다.
- 전달받은 아이템들은 ListView로 화면에 출력
- EditText에 아무것도 입력하지 않았을 때에는 "정보를 입력해주세요"라는 Toast 메세지를 출력하게 했고, 정보를 모두 입력하고 Purchase를 누르면 상품선택페이지로 Intent를 이용해 화면전환을 했습니다.