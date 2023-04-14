function Grades(grades_name, grades_grade, grades_sex) {
  this.name = grades_name
  this.grade = grades_grade
  this.sex = grades_sex
}
const grade1 = new Grades("John", 8, "M");
const grade2 = new Grades("Sarah", 12, "F");
const grade3 = new Grades("Bob", 16, "M");
const grade4 = new Grades("Johnny", 2, "M");
const grade5 = new Grades("Ethan", 4, "M");
const grade6 = new Grades("Paula", 18, "F");
const grade7 = new Grades("Donald", 5, "M");
const grade8 = new Grades("Jennifer", 13, "F");
const grade9 = new Grades("Courtney", 15, "F");
const grade10 = new Grades("Jane", 9, "F");
let grades = [
  grade1,
  grade2,
  grade3,
  grade4,
  grade5,
  grade6,
  grade7,
  grade8,
  grade9,
  grade10,
];
function print_grade_list(grade_arr) {
  for (x of grade_arr)
    console.log(
        `     ${x.name} - ${x.grade} - ${x.sex}`);
}

//1. viet function tính thứ hạng trung bình của cả lớp
function avg_grade(grade_list){
    let sum = grade_list.reduce((total, element) => total +element.grade , 0);
    return sum / grade_list.length
}
console.log(`1. Average grade in the class: ${avg_grade(grades)}`)

//2. viet function tinh thu hang trung binh cua cac ban nam trong lop
function avg_grade_gender(grade_list, gender){
    let gender_grades = grade_list.filter((grade) => grade.sex.toLowerCase() === gender.toLowerCase());
    let sum = gender_grades.reduce((total, element) => total + element.grade , 0);
    return sum / gender_grades.length;
}
console.log(`2. Average grade of Male in the class: ${avg_grade_gender(grades,"m")}`);

//3. viet function tinh thu hang trung binh cua cac ban nu trong lop
console.log(`3. Average grade of FeMale in the class:  ${avg_grade_gender(grades,"f")}`);

//4. viet function tim ban nam co thu hang cao nhat lop
function max_grade_gender(grade_list,gender){
    return grade_list.filter((grade) => grade.sex.toLowerCase() === gender.toLowerCase())
                     .reduce((max_grade, grade) => (grade.grade > max_grade.grade) ? grade : max_grade).name;
  }
console.log(`4. Max grade of Male in the class: ${max_grade_gender(grades,"m")}`)

//5. viet function tim ban nu co thu hang cao nhat lop
console.log(`5. Max grade of FeMale in the class: ${max_grade_gender(grades,"f")}`)

//6. viet function tim ban nam co thu hang thap nhat lop
function min_grade_gender(grade_list,gender){
    return grade_list.filter((grade) => grade.sex.toLowerCase() === gender.toLowerCase())                  
                        .reduce((min_grade, grade) => (grade.grade < min_grade.grade) ? grade : min_grade).name;
}
console.log(`6. Min grade of Male in the class: ${min_grade_gender(grades,"m")}`)

//7. viet function tim ban nu co thu hang thap nhat lop
console.log(`7. Min grade of FeMale in the class: ${min_grade_gender(grades,"f")}`)

//8. Viết function thứ hạng cao nhất của cả lớp
function max_grade_class(grade_list){
  let grades = grade_list.map((grade) => grade.grade);
  return Math.max(...grades);

}
console.log(`8. Max grade in the class: ${max_grade_class(grades)}`)

//9. Viết function thứ hạng thấp nhất của cả lớp 
function min_grade_class(grade_list){
    let grades = grade_list.map((grade) => grade.grade);
    return Math.min(...grades);
  
  }
console.log(`9. Max grade in the class: ${min_grade_class(grades)}`)

//10. viết function lấy ra tất cả danh sách học viên nữ
function get_female(grade_list){
    return grade_list.filter((grade) => grade.sex === 'F');
}
console.log("10. Get list female")
print_grade_list(get_female(grades))

//11. viết function sắp xếp tên học viên theo chiều tăng dần của bảng chữ cái.
function sort_name_asc(grade_list){
    let sorted_list = grade_list.slice().sort((a, b) => {
    return a.name.localeCompare(b.name);
    });
    return sorted_list;  
}
console.log("11. Sorted list by name asc:");
print_grade_list(sort_name_asc(grades))

//12. Viết function sắp xếp thứ hạng học viên theo chiều giảm dần
function sort_by_grade_desc(product_list){
    return product_list.sort((a, b) => b.grade - a.grade);
}
console.log("12. Sorted list by grade desc:");
print_grade_list(sort_by_grade_desc(grades)) 

//13. viết ra function lấy ra học viên nữ có tên bắt đầu bằng J
function get_female_with_name_starting_with_J(grade_list) {
    return grade_list.filter((grade) => grade.sex === 'F' && grade.name.startsWith('J'));
}
console.log("13. female starting with J:");
print_grade_list(get_female_with_name_starting_with_J(grades)) 

//14. viết function lấy ra 5 học viên có thứ hạng cao nhất
function get_top_5_grade(grade_list) {
    let sorted_grades = grade_list.slice(0, 5).sort((a, b) => b.grade - a.grade);
    return sorted_grades.slice(0, 5);
}
console.log("14. get top 5 grade in the class:");
print_grade_list(get_top_5_grade(grades)) 