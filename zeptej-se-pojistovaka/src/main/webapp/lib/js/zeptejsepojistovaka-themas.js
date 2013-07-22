var ENTER_KEY_CODE = 13;
var DELETE_THEMA_CONFIRMATION_QUESTION_PREFIX = 'Opravdu chcete smazat téma "';
var DELETE_THEMA_CONFIRMATION_QUESTION_SUFFIX = '"? Existence dotazů a odpovědí není touto operací ovlivněna.';

// http://stackoverflow.com/questions/10896749/what-does-function-function-window-jquery-do
!function($) {
	$(function() {
		initThemaControls();
	});
}(window.jQuery);

function initThemaControls() {
	initAddThemaControls();
	initDeleteThemaControls();
}

/**
 * Adds controls for adding a new thema.
 */
function initAddThemaControls() {
	$('#addThema > button').click(handleAddThema);
	$('#addThema .themaName').keypress(function(e) {
		if (e.which == ENTER_KEY_CODE) {
			handleAddThema();
		}
	});
}

/**
 * Adds the new thema behind the last one and clears an input element holding name of the new thema.
 */
function handleAddThema() {
	var newThemaNameElement = $('#addThema [name=themaName]');
	var newThemaName = normalizeThemaName(newThemaNameElement.val());
	if (!newThemaName) {
		return;
	}

	var themaParams = {
		'buttonAdditionalClasses' : 'btn-link btn-mini'
	};
	persistNewThema(newThemaName, themaParams);
	var newThemaHtml = getThemaHtml(newThemaName, themaParams);
	clearVal(newThemaNameElement);

	var previousSibling = $('#themas .thema').last();
	$(newThemaHtml).insertAfter(previousSibling);
	var newThemaElement = previousSibling.next();
	initDeleteThemaControls(newThemaElement);
	enableBootstrapTooltips(newThemaElement);
}

function normalizeThemaName(inputThemaName) {
	return inputThemaName.trim();
}

function persistNewThema(themaName, themaParams) {
	// TODO : AJAX
	themaParams['themaId'] = 1000;
}

function getThemaHtml(themaName, themaParams) {
	return "<div class='btn-group thema'>"
			+ "<a class='btn "
			+ themaParams['buttonAdditionalClasses']
			+ "' type='button'><input name='themaId' type='hidden' value='"
			+ themaParams['themaId']
			+ "' />"
			+ getThemaIconHtml(themaParams['icon'])
			+ SPACE
			+ "<span class='themaName'>"
			+ themaName
			+ "</span></a>"
			+ "<a href='#deleteModal' role='button' data-toggle='modal' class='btn "
			+ themaParams['buttonAdditionalClasses']
			+ " delete'><span data-toggle='tooltip' title='" + DELETE
			+ "'><i class='icon-remove'></i></span></a></div>";
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
function initDeleteThemaControls(themaElement) {
	var themaElements;
	if (themaElement) {
		themaElements = themaElement;
	} else {
		themaElements = $('#themas .thema');
	}

	themaElements.find('.delete').click(showDeleteThemaModal);
}

function showDeleteThemaModal() {
	var deleteModal = $('#deleteModal');
	deleteModal.find('.modal-footer .delete').click(handleDeleteThema);

	var themaElement = $(this).closest('.thema');
	var themaName = themaElement.find('.themaName').html();
	deleteModal.find('#deleteModalConfirmationQuestion').html(
			DELETE_THEMA_CONFIRMATION_QUESTION_PREFIX + themaName
					+ DELETE_THEMA_CONFIRMATION_QUESTION_SUFFIX);

	var themaId = themaElement.find('[name=themaId]').val();
	deleteModal.find('[name=itemToBeDeletedId]').val(themaId);
}

function handleDeleteThema() {
	var deleteModal = $(this).closest('#deleteModal');
	var themaId = deleteModal.find('[name=itemToBeDeletedId]').val();
	persistDeletedThema(themaId);
	hideDeletedThema(themaId);
	deleteModal.modal('hide');
}

function persistDeletedThema(themaId) {
	// TODO : AJAX
}

function hideDeletedThema(themaId) {
	var themaToBeDeleted = $(
			'#themas .thema [name=themaId][value=' + themaId + ']').closest(
			'.thema');
	themaToBeDeleted.remove();
}
