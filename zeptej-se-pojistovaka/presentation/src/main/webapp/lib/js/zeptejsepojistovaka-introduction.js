var SPACE = ' ';

// http://stackoverflow.com/questions/10896749/what-does-function-function-window-jquery-do
!function($) {
	$(function() {
		var wordCount = getWordCountInIntroduction();
		displayWordCountInIntroductionHeader(wordCount);
	});
}(window.jQuery);

function getWordCountInIntroduction() {
	var introductionText = $('#introduction-wrapper blockquote div').text();
	var normalized = normalizeText(introductionText);
	var words = normalized.split(SPACE);
	return words.length;
}

function normalizeText(text) {
	var trimmed = text.trim();
	return trimmed.replace(/( )+/g, SPACE);
}

function displayWordCountInIntroductionHeader(wordCount) {
	$('#introduction-wrapper h2 span').text(wordCount);
}