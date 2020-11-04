var date = new Date();
var day = date.getDate();
var year = date.getFullYear();

var monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
var dayNames = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

var monthLabel = document.getElementsByClassName('month-label')[0].innerHTML = monthNames[date.getMonth()];

var dayLabel = document.getElementsByClassName("day-label")[0].innerHTML = day;

var weekdayLabel = document.getElementsByClassName("weekday-label")[0].innerHTML = dayNames[date.getDay(0)];