var EDIT = 'Upravit';
var DELETE = 'Smazat';
var PLACEHOLDER = 'placeholder';
var ANSWER = 'Odpovědět';
var CANCEL = "Zrušit";
var ASK_QUESTION = 'Položit otázku';

var BR_HTML_ELEMENT = '<br />';
var NEW_LINE = '\n';

function clearVal(element) {
	element.val('');
}

/**
 * Enables Twitter Bootstrap tooltips for all elements in the tree of the given {@code rootElement} which have
 * {@code data-toggle="tooltip"}.
 */
function enableBootstrapTooltips(rootElement) {
	var commonSelector = '[data-toggle=tooltip]';
	var affectedElements;
	if (rootElement) {
		affectedElements = rootElement.find(commonSelector);
	} else {
		affectedElements = $(commonSelector);
	}
	affectedElements.tooltip();
}

function encodeTextToHtml(text) {
	return text.replace(/\n/g, BR_HTML_ELEMENT);
}

function decodeTextFromHtml(text) {
	return text.replace(/<br>/g, NEW_LINE);
}

function getHiddenInfoHtml(name, value) {
	return "<input name='" + name + "' type='hidden' value='" + value + "' />";
}