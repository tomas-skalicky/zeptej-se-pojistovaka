// http://stackoverflow.com/questions/10896749/what-does-function-function-window-jquery-do
!function($) {
	$(function() {
		initRequestVars();
		initLocalizedMessages();
		enableBootstrapTooltips();
	});
}(window.jQuery);

var REQUEST_CONTEXT_PATH = '';

function initRequestVars() {
	REQUEST_CONTEXT_PATH = $('#requestContextPath').val();
}

var EDIT = '';
var DELETE = '';
var ANSWER = '';
var CANCEL = '';
var ASK_QUESTION = '';
var IN_BAD_FORMAT = '';

function initLocalizedMessages() {
	EDIT = $('#locale-edit').val();
	DELETE = $('#locale-delete').val();
	ANSWER = $('#locale-answer').val();
	CANCEL = $('#locale-cancel').val();
	ASK_QUESTION = $('#locale-askQuestion').val();
	IN_BAD_FORMAT = $('#locale-inBadFormat').val();
}
