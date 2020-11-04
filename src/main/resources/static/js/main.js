"use strict";
(function () {
    //Converted Time in Degrees
    //Rotate From
    const d = new Date();
    const convertedSeconds =
        ((d.getSeconds() + d.getMilliseconds() / 1000) / 60) * 360;
    const convertedMinutes = (d.getMinutes() / 60) * 360;
    const convertedHours = ((d.getHours() + d.getMinutes() / 60) / 12) * 360;

    //Rotate To
    const rotateSecondsTo = convertedSeconds + 360;
    const rotateMinutesTo = convertedMinutes + 360;
    const rotateHoursTo = convertedHours + 360;

    //Update Css
    const root = document.documentElement;
    root.style.setProperty("--s-rotate-from", convertedSeconds + "deg");
    root.style.setProperty("--m-rotate-from", convertedMinutes + "deg");
    root.style.setProperty("--h-rotate-from", convertedHours + "deg");
    root.style.setProperty("--s-rotate-to", rotateSecondsTo + "deg");
    root.style.setProperty("--m-rotate-to", rotateMinutesTo + "deg");
    root.style.setProperty("--h-rotate-to", rotateHoursTo + "deg");
})();