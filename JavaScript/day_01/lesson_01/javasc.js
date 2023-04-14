function ktra_solonhon(a, b) {
  if (a > b) {
    return a;
  } else {
    return b;
  }
}
function ktra_chanle(a) {
  if (a % 2 === 0) {
    return a + " la so chan";
  } else {
    return a + " la so le";
  }
}
function ktra_chiahetcho3va5(a) {
  if (a % 15 === 0) {
    return a + " chia het cho ca 3 va 5";
  } else {
    return a + "khong chia het cho 3 va 5";
  }
}
function ktra_tongavab(a, b, c) {
  if (c === a + b) {
    return c + " = " + a + " + " + b;
  } else {
    return c + " khong = " + a + " + " + b;
  }
}
function ktra_giatri(mark) {
  if (mark >= 85) {
    return "A";
  } else if (mark >= 70) {
    return "B";
  } else if (mark >= 40) {
    return "C";
  } else {
    return "D";
  }
}
function switch_case_day() {
  let day = 6;
  switch (day) {
    case 1: {
      console.log("thu 2");
      break;
    }
    case 2: {
      console.log("thu 3");
      break;
    }
    case 3: {
      console.log("thu 4");
      break;
    }
    case 4: {
      console.log("thu 5");
      break;
    }
    case 5: {
      console.log("thu 6");
      break;
    }
    case 6: {
      console.log("thu 7");
      break;
    }
    case 0: {
      console.log("chu nhat");
      break;
    }
    default: {
      console.log("lua chon khong hop le");
      break;
    }
  }
}
function switch_case_month() {
  let month = 5;
  switch (month) {
    case 1:
    case 2:
    case 3: {
      console.log("mua xuan");
      break;
    }
    case 4:
    case 5:
    case 6: {
      console.log("mua ha");
      break;
    }
    case 7:
    case 8:
    case 9: {
      console.log("mua thu");
      break;
    }
    case 10:
    case 11:
    case 12: {
      console.log("mua dong");
      break;
    }
    default: {
      console.log("lua chon khong hop le");
    }
  }
}
function for_lab1(a) {
  let text = "";
  for (let i = 1; i <= 10; i++) {
    if (i < 10) {
      text += a + "-";
    } else {
      text += a;
    }
  }
  return text;
}
function while_lab1(a) {
  let text = "";
  let i = 1;
  while(i<=10){
    if(i<10){
      text += a + "-";
    } else {
      text += a;
    }
    i++;
  }
  return text;
}

