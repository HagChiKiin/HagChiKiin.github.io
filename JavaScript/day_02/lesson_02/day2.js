let arr = [3, 5, 7, 10];
function sum_lab1(arr) {
  let sum = 0;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] % 2 !== 0 && arr[i] % 3 === 0) {
      sum += arr[i];
    }
  }
  return sum;
}
console.log(sum_lab1(arr));

// hàm kiểm tra số nguyên tố
function is_Prime(num) {
  if (num <= 1) return false;
  for (let i = 2; i <= Math.sqrt(num); i++) if (num % i === 0) return false;
  return true;
}
// lab 2
function sum_lab2(arr) {
  let sum = 0;
  for (let i = 0; i < arr.length; i++) 
    if (is_Prime(arr[i])) sum += arr[i];
  
  return sum;
}
console.log(sum_lab2(arr))

// 4. thêm phần tử vào mảng
function insertElement(arr,n,x,pos){
    var i = n;
    for (i ; i >= pos; i--) arr[i+1] = arr[i];
    arr[pos] = x;   
}
// lab 6
let arr1 = [1,2,4,5,8,9,11];
function is_Prime(num) {
    if (num <= 1) return false;
    for (let i = 2; i <= Math.sqrt(num); i++) if (num % i === 0) return false;
    return true;
  } 
function add_lab6(){
    let result = [];
    for (let i = 0; i < arr1.length; i++) {
        if(is_Prime(arr[i])) result.push(arr1[i]);    
    }
    return result;
}
// 5 thay đổi giá trị phần tử

// bai tap slide kien thuc
// 3.
// lab3
function lab3(arr){
  let result = arr.map(x => x % 2);
  return result;
}
let array = [4,2,5,6,2,7];
console.log(lab3(array));

// lab4 
function is_array(arr,value){
  return arr.includes(value);
}
let array1 = [1,2,3,4,5];
console.log(is_array(array1,6))

// 4
// lab 5
function divisible_15(){
  let result = [];
  for(let i = 0; i <100; i++)
    if( i % 15 === 0) result.push(i)
  return result;  
}
let array2 = divisible_15() 
console.log(array2);

// 8
// lab 9
function repeatString(arr){
  return new Array(10).fill(arr).join("")
}                                         
console.log(repeatString('a'))

// lab 10
function repeatString(arr){
  return new Array(10).fill(arr).join('-')
}                                         
console.log(repeatString('a'))

//  bài tập slide cuối
// bài 1
function checkElementExixst(arr,value){
  return arr.includes(value);
}
console.log(checkElementExixst([1,2,3,4,5],5));

// bài 2    
function getElementGreater(arr,value){
  return arr.filter(x => x > value);
}
console.log(getElementGreater([1,2,3,4,5],3));

// bài 3
let hex_char = [0,1,2,3,4,5,6,7,8,9,"A","B","C","D","E","F"]
function char(index) {
	return hex_char[index]
}
function hex_color() {
	let hexColor = "#"
	for (let index = 0; index < 6; index++){
		let randomPosition = Math.floor ( Math.random() * 16 ) 
    hexColor += char(randomPosition)
	}
	return hexColor
}
console.log(hex_color()) 


// bài tập luyện tạp 1
// lab 1
let arr = [1,2,3,4,5]  
// tổng
function sum(arr){
  let sum = 0;
  for( let x of arr)
    sum += x
  return sum; 
}
console.log(sum(arr));
// tích
function multiple(arr){
  let product = 1 ;
  for( let i = 0 ; i < arr.length; i++)
    product = product* arr[i]
  return product; 
}
console.log(multiple(arr));
// trung bình
function average(arr){
  let average = sum(arr);
  return average / arr.length;
}
console.log(average(arr))
// mảng lớn hơn key   -- filter : lọc theo điều kiện
function bigger_key(arr, key){
  return arr.filter(x => x > key);
}
console.log(bigger_key(arr,3))

// lab 2
// chèn vào vị trí cho trước -- splice thêm+xoa phần tử
function insert_element(arr, pos, element) {
  arr.splice(pos, 0, element);
  return arr;
}
console.log(insert_element([1,2,3,4,5],2,100));

// lab 3
// số chính phương
let abc =[1,3,4,9,12,16,21]
function filter_square_number(arr){
  return arr.filter(x => Math.sqrt(x) % 1 === 0);
}
console.log(filter_square_number(abc))

// lab 4
// số nguyên tố lớn nhất
function find_big_prime_num(arr){
  let max = arr.filter(num => {
    for(let i = 2; i <= Math.sqrt(num); i++) 
      if(num % i === 0) return false;
    return num >= 2;
  });
  if (max.length > 0) return Math.max(...max);
  else return null;
}
console.log(find_big_prime_num([1,2,3,4,8, 17,5,11,13]));

// lab 5
// thay thế số âm..  map duyệt qua các phần tử trong mảng
function replace(arr) {
  return arr.map(x => x < 0 ? 0 : x);
}
console.log(replace([1,-3,-5,-1,1,5]));

// lab 6
// xóa các số nguyên tố
function is_Prime(num) {
  if (num <= 1) return false;
  for (let i = 2; i <= Math.sqrt(num); i++) if (num % i === 0) return false;
  return true;
}
function delete_prime_num(arr){
  return arr.filter(x => !is_Prime(x));
}
console.log(delete_prime_num([1,2,3,4,56,7,8,9]));