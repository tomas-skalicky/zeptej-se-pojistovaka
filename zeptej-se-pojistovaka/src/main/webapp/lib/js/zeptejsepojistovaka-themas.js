var ENTER_KEY_CODE = 13;

// http://stackoverflow.com/questions/10896749/what-does-function-function-window-jquery-do
!function($) {
	$(function() {
		enableBootstrapTooltips();
		initAddThemaControls();
		initRemoveThemaControls();
	});
}(window.jQuery);

/**
 * Adds controls for adding a new thema.
 */
function initAddThemaControls() {
	$('#addThema > button').click(handleAddThema);
	$('#addThema > input').keypress(function(e) {
		if (e.which == ENTER_KEY_CODE) {
			handleAddThema();
		}
	});
}

/**
 * Adds the new thema behind the last one and clears an input element holding name of the new thema.
 */
function handleAddThema() {
	var html = getThemaHtml($('#addThema > input').val(), {
		'buttonAdditionalClasses' : 'btn-link btn-mini'
	});
	$('#themas .span12 > div:last-child').prev().after(html);
	clearVal($('#addThema > input'));
	initRemoveThemaControls();
}

function getThemaHtml(themaName, params) {
	return "<div class='btn-group'><button class='btn " + params['buttonAdditionalClasses'] + "' type='button'>"
			+ getThemaIconHtml(params['icon']) + themaName + "</button><button class='btn "
			+ params['buttonAdditionalClasses'] + "' type='button'><i class='icon-remove'></i></button></div>";
}

function getThemaIconHtml(iconName) {
	if (iconName) {
		return "<i class='" + iconName + "'></i> ";
	} else {
		return '';
	}
}

/**
 * Adds controls for removing an existing thema.
 */
function initRemoveThemaControls() {
	$('#themas button').has('i[class="icon-remove"]').click(handleRemoveThema);
}

function handleRemoveThema() {
	$(this).parent().remove();
}
