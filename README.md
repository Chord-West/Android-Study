# Android-PersonalAssignment

- ###### Firbase 사용



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
- Check한 제품들을 BUY IT NOW를 통해 구매하거나, ADD TO CART를 통해 Firebase에 저장하고, 장바구니 페이지로 이동합니다.
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

- BACK TO HOME 버튼 클릭 시 제품선택페이지, PAYMENT 버튼 클릭 시 Check한 제품들 구매페이지로 이동  

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
- 