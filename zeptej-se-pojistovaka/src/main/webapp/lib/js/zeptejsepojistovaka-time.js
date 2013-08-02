var BEFORE = 'Před';
var BEFORE_A_SECOND = 'Před sekundou';
var SECONDS_FOR_ELAPSED_TIME = 'sekundami';
var BEFORE_A_MINUTE = 'Před minutou';
var MINUTES_FOR_ELAPSED_TIME = 'minutami';
var BEFORE_AN_HOUR = 'Před hodinou';
var HOURS_FOR_ELAPSED_TIME = 'hodinami';
var AT = "v";
var YESTERDAY_AT = 'Včera ' + AT;
var ON_MONDAY_AT = 'V pondělí ' + AT;
var ON_TUESDAY_AT = 'V úterý ' + AT;
var ON_WEDNESDAY_AT = 'V středu ' + AT;
var ON_THURSDAY_AT = 'V čtvrtek ' + AT;
var ON_FRIDAY_AT = 'V pátek ' + AT;
var ON_SATURDAY_AT = 'V sobotu ' + AT;
var ON_SUNDAY_AT = 'V neděli ' + AT;
var ON_DAY_AT = {
	0 : ON_SUNDAY_AT,
	1 : ON_MONDAY_AT,
	2 : ON_TUESDAY_AT,
	3 : ON_WEDNESDAY_AT,
	4 : ON_THURSDAY_AT,
	5 : ON_FRIDAY_AT,
	6 : ON_SATURDAY_AT
};

var SECONDS_PER_MINUTE = 60;
var SECONDS_PER_HOUR = 60 * SECONDS_PER_MINUTE;
var SECONDS_PER_DAY = 24 * SECONDS_PER_HOUR;

var SHORT_DATE_FORMAT = "d.M.";
var LONG_DATE_FORMAT = SHORT_DATE_FORMAT + "yyyy";
var TIME_FORMAT = "h:mm";

/**
 * Returns timestamp of the current time (= now).
 */
function getNowInMillisec() {
	var now = new Date();
	return now.getTime();
}

// http://stackoverflow.com/questions/10896749/what-does-function-function-window-jquery-do
!function($) {
	$(function() {
		startTimeUpdater();
	});
}(window.jQuery);

function startTimeUpdater() {
	runTimeUpdater();

	// 10 seconds
	var TIME_UPDATE_INTERVAL = 10000;
	setInterval(runTimeUpdater, TIME_UPDATE_INTERVAL);
}

function runTimeUpdater() {
	var now = new Date();
	var nowInMillisec = now.getTime();

	$('.time.continuously-updated').each(
			function() {
				var currentElement = $(this);
				var creationTimestamp = currentElement.prev().val();
				var elapsedTimeInSec = Math
						.floor((nowInMillisec - creationTimestamp) / 1000);
				currentElement.text(getTimeCaption(creationTimestamp,
						elapsedTimeInSec, now));
			});
}

function getTimeCaption(creationTimestamp, elapsedTimeInSec, nowDate) {
	// Checks the provided arguments.
	if (!nowDate) {
		nowDate = new Date();
		if (!elapsedTimeInSec) {
			elapsedTimeInSec = Math
					.floor((nowDate.getTime() - creationTimestamp) / 1000);
		}
	}

	if (elapsedTimeInSec < SECONDS_PER_DAY) {
		return getRelativeTimeCaption(elapsedTimeInSec);
	} else if (elapsedTimeInSec < 6 * SECONDS_PER_DAY) {
		// Only 6 times to avoid a collision: now = Monday vs. relative creation day = Monday
		return getRelativeDateWithAbsoluteTimeCaption(creationTimestamp,
				nowDate);
	} else {
		return getAbsoluteTimeCaption(creationTimestamp, nowDate);
	}
}

function getRelativeTimeCaption(elapsedTimeInSec) {
	if (elapsedTimeInSec >= 2 * SECONDS_PER_HOUR) {
		var hourCount = Math.floor(elapsedTimeInSec / SECONDS_PER_HOUR);
		return BEFORE + ' ' + hourCount + ' ' + HOURS_FOR_ELAPSED_TIME;
	} else if (elapsedTimeInSec >= SECONDS_PER_HOUR) {
		return BEFORE_AN_HOUR;
	} else if (elapsedTimeInSec >= 2 * SECONDS_PER_MINUTE) {
		var minuteCount = Math.floor(elapsedTimeInSec / SECONDS_PER_MINUTE);
		return BEFORE + ' ' + minuteCount + ' ' + MINUTES_FOR_ELAPSED_TIME;
	} else if (elapsedTimeInSec >= SECONDS_PER_MINUTE) {
		return BEFORE_A_MINUTE;
	} else if (elapsedTimeInSec >= 2) {
		return BEFORE + ' ' + elapsedTimeInSec + ' ' + SECONDS_FOR_ELAPSED_TIME;
	} else {
		return BEFORE_A_SECOND;
	}
}

function getRelativeDateWithAbsoluteTimeCaption(creationTimestamp, nowDate) {
	var creationDate = new Date();
	creationDate.setTime(creationTimestamp);
	var before24Hours = new Date();
	before24Hours.setTime(nowDate.getTime() - SECONDS_PER_DAY * 1000);

	var onDayAt;
	if (isYesterday(creationDate, nowDate)) {
		onDayAt = YESTERDAY_AT;
	} else {
		onDayAt = ON_DAY_AT[creationDate.getDay()];
	}
	return onDayAt + SPACE + $.format.date(creationDate, TIME_FORMAT);
}

function isYesterday(testedDate, nowDate) {
	var before24Hours = new Date();
	before24Hours.setTime(nowDate.getTime() - SECONDS_PER_DAY * 1000);
	return testedDate.getDay() == before24Hours.getDay();
}

function getAbsoluteTimeCaption(creationTimestamp, nowDate) {
	var creationDate = new Date();
	creationDate.setTime(creationTimestamp);
	var formattedDate;
	if (creationDate.getFullYear() == nowDate.getFullYear()) {
		formattedDate = $.format.date(creationDate, SHORT_DATE_FORMAT);
	} else {
		formattedDate = $.format.date(creationDate, LONG_DATE_FORMAT);
	}
	return formattedDate + SPACE + AT + SPACE
			+ $.format.date(creationDate, TIME_FORMAT);
}
