function DateConversion(date) {
  // 2023-02-11
  // 123456789
  var year = date.substring(0, 4);
  var month = date.substring(5, 7);
  var day = date.substring(8, 10);
  var monthString = "";
  switch (month) {
    case "01":
      monthString = "Jan";
      break;
    case "02":
      monthString = "Feb";
      break;
    case "03":
      monthString = "Mar";
      break;
    case "04":
      monthString = "Apr";
      break;
    case "05":
      monthString = "May";
      break;
    case "06":
      monthString = "Jun";
      break;
    case "07":
      monthString = "Jul";
      break;
    case "08":
      monthString = "Aug";
      break;
    case "09":
      monthString = "Sep";
      break;
    case "10":
      monthString = "Oct";
      break;
    case "11":
      monthString = "Nov";
      break;
    case "12":
      monthString = "Dec";
      break;
  }
  var res = day + "/" + monthString + "/" + year;
  console.log(`Result: ${res}`);
}

DateConversion("2023-02-11 11:06:18");
