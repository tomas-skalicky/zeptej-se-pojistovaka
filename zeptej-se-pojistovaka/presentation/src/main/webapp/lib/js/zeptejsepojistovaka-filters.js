var ENTER_KEY_CODE = 13;

var NEW_FILTER_NAME = 'Název nového filtru';
var NEW_FILTER_NAME_REQUIRED = 'Název nového filtru: povinný';
var NEW_FILTER_NAME_TOO_SHORT = 'Název nového filtru: příliš krátký';

var DELETE_THEMA_CONFIRMATION_QUESTION_PREFIX = 'Opravdu chcete smazat téma "';
var DELETE_THEMA_CONFIRMATION_QUESTION_SUFFIX = '"? Existence dotazů a odpovědí není touto operací ovlivněna.';

var MIN_FILTER_NAME_LENGTH = 2;

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
	$('#add-filter button').click(handleAddFilter);
	$('#add-filter [name=filterName]').keypress(function(e) {
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
	var newFilterNameElement = $('#add-filter [name=filterName]');
	if (!checkFilterNameInput(newFilterNameElement)) {
		return;
	}

	var newFilterName = normalizeFilterName(newFilterNameElement.val());
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

/**
 * @returns Boolean ... {@code true} if the given message form contains valid
 *          information; otherwise {@code false}.
 */
function checkFilterNameInput(filterNameElement) {
	var tooltipElements = getTooltipElements(filterNameElement);

	setUpTooltipElementsToDefault(NEW_FILTER_NAME, tooltipElements);

	var filterName = filterNameElement.val();
	if (!filterName) {
		setUpTooltipElementsToError(NEW_FILTER_NAME_REQUIRED, tooltipElements);
		return false;
	}
	if (filterName.trim().length < MIN_FILTER_NAME_LENGTH) {
		setUpTooltipElementsToError(NEW_FILTER_NAME_TOO_SHORT, tooltipElements);
		return false;
	}
	return true;
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
			+ " filter-label' type='button'>"
			+ getHiddenInputHtml('filterId', filterParams['filterId'])
			+ getFilterIconHtml(filterParams['icon'])
			+ SPACE
			+ "<span class='filter-name'>"
			+ filterName
			+ "</span></a>"
			+ "<a href='#delete-modal' role='button' data-toggle='modal' class='btn "
			+ filterParams['buttonAdditionalClasses']
			+ " delete'><span data-toggle='tooltip' title='"
			+ DELETE
			+ "' class='glyphicon glyphicon-remove' data-container='body'></span></a></div>";
}

function getFilterIconHtml(iconName) {
	if (iconName) {
		return "<span class='" + iconName + "'></span> ";
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
	var deleteModal = $('#delete-modal');
	deleteModal.find('.modal-footer .delete').click(handleDeleteFilter);

	var filterElement = $(this).closest('.filter');
	var filterName = filterElement.find('.filter-name').text();
	deleteModal.find('.confirmation-question').text(
			DELETE_THEMA_CONFIRMATION_QUESTION_PREFIX + filterName
					+ DELETE_THEMA_CONFIRMATION_QUESTION_SUFFIX);

	var filterId = filterElement.find('[name=filterId]').val();
	deleteModal.find('[name=itemToBeDeletedId]').val(filterId);
}

function handleDeleteFilter() {
	var deleteModal = $('#delete-modal');
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
		elements = $('#filters .filter .btn-link').filter('.filter-label');
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
	showFilterActivationOrDeactivation(filterElementsToBeActivated, new Array(
			'btn-link'), new Array('btn-success', 'selected-filter'));
	initFilterDeactivationControls(filterElementsToBeActivated);
}

function showDeactivateFilterButton() {
	$('#filters .deactivate-filter').show();
}

function showCorrespondingQuestionsAndAnswers() {
	// TODO : AJAX
	// var activatedFilterElements = $('#filters .filter
	// .filter-label.selected-filter');
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
		elements = $('#filters .filter .filter-label').filter(
				'.selected-filter');
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
	var activatedFilterCount = $('#filters .filter .filter-label').filter(
			'.selected-filter').length;
	if (activatedFilterCount === 0) {
		$('#filters .deactivate-filter').hide();
	}
}

function showAllFiltersDeactivation() {
	var allActivatedFilterElements = $('#filters .filter .filter-label')
			.filter('.selected-filter');
	showFilterDeactivation(allActivatedFilterElements);
}

function showFilterDeactivation(filterElementsToBeDeactivated) {
	showFilterActivationOrDeactivation(filterElementsToBeDeactivated,
			new Array('btn-success', 'selected-filter'), new Array('btn-link'));
	initFilterActivationControls(filterElementsToBeDeactivated);
}

function showFilterActivationOrDeactivation(filterElements, classesToBeRemoved,
		classesToBeAdded) {
	filterElements.each(function() {
		var currentFilterLabel = $(this);
		var currentDeleteButton = currentFilterLabel.closest('.filter').find(
				'.delete');

		for (classIndex in classesToBeRemoved) {
			var classToBeRemoved = classesToBeRemoved[classIndex];
			currentFilterLabel.removeClass(classToBeRemoved);
			currentDeleteButton.removeClass(classToBeRemoved);
		}

		for (classIndex in classesToBeAdded) {
			var classToBeAdded = classesToBeAdded[classIndex];
			if (!currentFilterLabel.hasClass(classToBeAdded)) {
				currentFilterLabel.addClass(classToBeAdded);
				// Do now color the delete button in green.
				if (classToBeAdded !== 'btn-success') {
					currentDeleteButton.addClass(classToBeAdded);
				}
			}
		}
	});
}
