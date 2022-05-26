<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>Digital Clock Design | With 12-hour/24-hour format Switcher - Html, Css & Javascript</title>
  <link rel="stylesheet" href="style.css">
</head>

<body onload="initClock()">
  <div class="datetime" >
    <div class="time">
      <span id="hour">00</span>:
      <span id="minutes">00</span>:
      <span id="seconds">00</span>
      <span id="period">AM</span>
    </div>
  </div>

  <script type="text/javascript">
    function updateClock() {
      var now = new Date();
      var 
        hr = now.getHours(),
        min = now.getMinutes(),
        sec = now.getSeconds(),
        pe = "AM";

      if (hr == 0) {
        hr = 12;
      }
      if (hr > 12) {
        hr = hr - 12;
        pe = "PM";
      }

      Number.prototype.pad = function (digits) {
        for (var n = this.toString(); n.length < digits; n = 0 + n);
        return n;
      }

      
      var ids = ["hour", "minutes", "seconds", "period"];
      var values = [hr.pad(2), min.pad(2), sec.pad(2), pe];
      for (var i = 0; i < ids.length; i++) 
      document.getElementById(ids[i]).firstChild.nodeValue = values[i];
    }

    function initClock() {
      updateClock();
      window.setInterval("updateClock()", 1);
    }
  </script>

</body>

</html>