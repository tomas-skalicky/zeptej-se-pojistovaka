var ENTER_KEY_CODE = 13;
var DELETE_THEMA_CONFIRMATION_QUESTION_PREFIX = 'Opravdu chcete smazat téma "';
var DELETE_THEMA_CONFIRMATION_QUESTION_SUFFIX = '"? Existence dotazů a odpovědí není touto operací ovlivněna.';

// http://stackoverflow.com/questions/10896749/what-does-function-function-window-jquery-do
!function($) {
	$(function() {
		initFilterControls();
	});
}(window.jQuery);

function initFilterControls() {
	initActivationControls();
	initDeactivationControls();
	initAddFilterControls();
	initDeleteFilterControls();
}

/**
 * Adds controls for adding a new filter.
 */
function initAddFilterControls() {
	$('#addFilter > button').click(handleAddFilter);
	$('#addFilter [name=filterName]').keypress(function(e) {
		if (e.which == ENTER_KEY_CODE) {
			handleAddFilter();
		}
	});
}

/**
 * Adds the new filter behind the last one and clears an input element holding
 * name of the new filter.
 */
function handleAddFilter() {
	var newFilterNameElement = $('#addFilter [name=filterName]');
	var newFilterName = normalizeFilterName(newFilterNameElement.val());
	if (!newFilterName) {
		return;
	}

	var filterParams = {
		'buttonAdditionalClasses' : 'btn-link btn-mini'
	};
	persistNewFilter(newFilterName, filterParams);
	var newFilterHtml = getFilterHtml(newFilterName, filterParams);
	clearVal(newFilterNameElement);

	var previousSibling = $('#filters .filter').last();
	$(newFilterHtml).insertAfter(previousSibling);
	var newFilterElement = previousSibling.next();
	initDeleteFilterControls(newFilterElement);
	initFilterActivationControls(newFilterElement.find('.filter-label'));
	enableBootstrapTooltips(newFilterElement);
}

function normalizeFilterName(inputFilterName) {
	return inputFilterName.trim();
}

function persistNewFilter(filterName, filterParams) {
	// TODO : AJAX
	// This will be later replaced by value returned by a database.
	filterParams['filterId'] = Math.floor((Math.random() * 100000) + 100);
}

function getFilterHtml(filterName, filterParams) {
	return "<div class='btn-group filter'>"
			+ "<a class='btn "
			+ filterParams['buttonAdditionalClasses']
			+ " filter-label' type='button'><input name='filterId' type='hidden' value='"
			+ filterParams['filterId']
			+ "' />"
			+ getFilterIconHtml(filterParams['icon'])
			+ SPACE
			+ "<span class='filterName'>"
			+ filterName
			+ "</span></a>"
			+ "<a href='#deleteModal' role='button' data-toggle='modal' class='btn "
			+ filterParams['buttonAdditionalClasses']
			+ " delete'><span data-toggle='tooltip' title='" + DELETE
			+ "'><i class='icon-remove'></i></span></a></div>";
}

function getFilterIconHtml(iconName) {
	if (iconName) {
		return "<i class='" + iconName + "'></i> ";
	} else {
		return '';
	}
}

/**
 * Adds controls for removing an existing filter.
 */
function initDeleteFilterControls(filterElement) {
	var filterElements;
	if (filterElement) {
		filterElements = filterElement;
	} else {
		filterElements = $('#filters .filter');
	}

	filterElements.find('.delete').click(showDeleteFilterModal);
}

function showDeleteFilterModal() {
	var deleteModal = $('#deleteModal');
	deleteModal.find('.modal-footer .delete').click(handleDeleteFilter);

	var filterElement = $(this).closest('.filter');
	var filterName = filterElement.find('.filterName').html();
	deleteModal.find('#deleteModalConfirmationQuestion').html(
			DELETE_THEMA_CONFIRMATION_QUESTION_PREFIX + filterName
					+ DELETE_THEMA_CONFIRMATION_QUESTION_SUFFIX);

	var filterId = filterElement.find('[name=filterId]').val();
	deleteModal.find('[name=itemToBeDeletedId]').val(filterId);
}

function handleDeleteFilter() {
	var deleteModal = $('#deleteModal');
	var filterId = deleteModal.find('[name=itemToBeDeletedId]').val();
	persistDeletedFilter(filterId);
	hideDeletedFilter(filterId);
	deleteModal.modal('hide');
	hideDeactivateFilterButton();
	showCorrespondingQuestionsAndAnswers();
}

function persistDeletedFilter(filterId) {
	// TODO : AJAX
}

function hideDeletedFilter(filterId) {
	var filterToBeDeleted = $(
			'#filters .filter [name=filterId][value=' + filterId + ']')
			.closest('.filter');
	filterToBeDeleted.remove();
}

function initActivationControls() {
	initFilterActivationControls();
}

function initFilterActivationControls(filterElements) {
	var elements;
	if (filterElements) {
		elements = filterElements;
	} else {
		elements = $('#filters .filter .filter-label.btn-link');
	}
	elements.click(activateFilter);
}

function activateFilter() {
	showAllFiltersDeactivation();
	showFilterActivation($(this));
	showDeactivateFilterButton();
	showCorrespondingQuestionsAndAnswers();
}

function showFilterActivation(filterElementsToBeActivated) {
	showFilterActivationOrDeactivation(filterElementsToBeActivated, 'btn-link',
			'btn-success');
	initFilterDeactivationControls(filterElementsToBeActivated);
}

function showDeactivateFilterButton() {
	$('#filters .deactivate-filter').show();
}

function showCorrespondingQuestionsAndAnswers() {
	// TODO : AJAX
	// var activatedFilterElements = $('#filters .filter .btn-success');
}

function initDeactivationControls() {
	$('#filters .deactivate-filter .btn').click(deactivateAllFilters);
	initFilterDeactivationControls();
}

function initFilterDeactivationControls(filterElements) {
	var elements;
	if (filterElements) {
		elements = filterElements;
	} else {
		elements = $('#filters .filter .filter-label.btn-success');
	}
	elements.click(deactivateFilter);
}

function deactivateFilter() {
	showFilterDeactivation($(this));
	hideDeactivateFilterButton();
	showCorrespondingQuestionsAndAnswers();
}

function deactivateAllFilters() {
	showAllFiltersDeactivation();
	hideDeactivateFilterButton();
	showCorrespondingQuestionsAndAnswers();
}

function hideDeactivateFilterButton() {
	var activatedFilterCount = $('#filters .filter .filter-label.btn-success').length;
	if (activatedFilterCount === 0) {
		$('#filters .deactivate-filter').hide();
	}
}

function showAllFiltersDeactivation() {
	var allActivatedFilterElements = $('#filters .filter .filter-label.btn-success');
	showFilterDeactivation(allActivatedFilterElements);
}

function showFilterDeactivation(filterElementsToBeDeactivated) {
	showFilterActivationOrDeactivation(filterElementsToBeDeactivated,
			'btn-success', 'btn-link');
	initFilterActivationControls(filterElementsToBeDeactivated);
}

function showFilterActivationOrDeactivation(filterElements, classToBeRemoved,
		classToBeAdded) {
	filterElements.each(function() {
		var currentFilterLabel = $(this);
		var currentDeleteButton = currentFilterLabel.closest('.filter').find(
				'.delete');

		currentFilterLabel.removeClass(classToBeRemoved);
		currentDeleteButton.removeClass(classToBeRemoved);

		if (!currentFilterLabel.hasClass(classToBeAdded)) {
			currentFilterLabel.addClass(classToBeAdded);
			currentDeleteButton.addClass(classToBeAdded);
		}
	});
}
