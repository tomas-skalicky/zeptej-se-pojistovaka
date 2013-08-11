var ENTER_KEY_CODE = 13;

var NEW_TAG_NAME = 'Název nového filtru';
var NEW_TAG_NAME_REQUIRED = 'Název nového filtru: povinný';
var NEW_TAG_NAME_TOO_SHORT = 'Název nového filtru: příliš krátký';

var DELETE_THEMA_CONFIRMATION_QUESTION_PREFIX = 'Opravdu chcete smazat téma "';
var DELETE_THEMA_CONFIRMATION_QUESTION_SUFFIX = '"? Existence dotazů a odpovědí není touto operací ovlivněna.';

var MIN_TAG_NAME_LENGTH = 2;

// http://stackoverflow.com/questions/10896749/what-does-function-function-window-jquery-do
!function($) {
	$(function() {
		initTagControls();
	});
}(window.jQuery);

function initTagControls() {
	initActivationControls();
	initDeactivationControls();
	initAddTagControls();
	initDeleteTagControls();
}

/**
 * Adds controls for adding a new tag.
 */
function initAddTagControls() {
	$('#add-tag button').click(handleAddTag);
	$('#add-tag [name=tagName]').keypress(function(e) {
		if (e.which == ENTER_KEY_CODE) {
			handleAddTag();
		}
	});
}

/**
 * Adds the new tag behind the last one and clears an input element holding
 * name of the new tag.
 */
function handleAddTag() {
	var newTagNameElement = $('#add-tag [name=tagName]');
	if (!checkTagNameInput(newTagNameElement)) {
		return;
	}

	var newTagName = normalizeTagName(newTagNameElement.val());
	var tagParams = {
		'buttonAdditionalClasses' : 'btn-link btn-mini'
	};
	persistNewTag(newTagName, tagParams);
	var newTagHtml = getTagHtml(newTagName, tagParams);
	clearVal(newTagNameElement);

	var previousSibling = $('#tags .tag').last();
	$(newTagHtml).insertAfter(previousSibling);
	var newTagElement = previousSibling.next();
	initDeleteTagControls(newTagElement);
	initTagActivationControls(newTagElement.find('.tag-label'));
	enableBootstrapTooltips(newTagElement);
}

/**
 * @returns Boolean ... {@code true} if the given message form contains valid
 *          information; otherwise {@code false}.
 */
function checkTagNameInput(tagNameElement) {
	var tooltipElements = getTooltipElements(tagNameElement);

	setUpTooltipElementsToDefault(NEW_TAG_NAME, tooltipElements);

	var tagName = tagNameElement.val();
	if (!tagName) {
		setUpTooltipElementsToError(NEW_TAG_NAME_REQUIRED, tooltipElements);
		return false;
	}
	if (tagName.trim().length < MIN_TAG_NAME_LENGTH) {
		setUpTooltipElementsToError(NEW_TAG_NAME_TOO_SHORT, tooltipElements);
		return false;
	}
	return true;
}

function normalizeTagName(inputTagName) {
	return inputTagName.trim();
}

function persistNewTag(tagName, tagParams) {
	// TODO : AJAX
	// This will be later replaced by value returned by a database.
	tagParams['tagId'] = Math.floor((Math.random() * 100000) + 100);
}

function getTagHtml(tagName, tagParams) {
	return "<div class='btn-group tag'>"
			+ "<a class='btn "
			+ tagParams['buttonAdditionalClasses']
			+ " tag-label' type='button'>"
			+ getHiddenInputHtml('tagId', tagParams['tagId'])
			+ getTagIconHtml(tagParams['icon'])
			+ SPACE
			+ "<span class='tag-name'>"
			+ tagName
			+ "</span></a>"
			+ "<a href='#delete-modal' role='button' data-toggle='modal' class='btn "
			+ tagParams['buttonAdditionalClasses']
			+ " delete'><span data-toggle='tooltip' title='"
			+ DELETE
			+ "' class='glyphicon glyphicon-remove' data-container='body'></span></a></div>";
}

function getTagIconHtml(iconName) {
	if (iconName) {
		return "<span class='" + iconName + "'></span> ";
	} else {
		return '';
	}
}

/**
 * Adds controls for removing an existing tag.
 */
function initDeleteTagControls(tagElement) {
	var tagElements;
	if (tagElement) {
		tagElements = tagElement;
	} else {
		tagElements = $('#tags .tag');
	}

	tagElements.find('.delete').click(showDeleteTagModal);
}

function showDeleteTagModal() {
	var deleteModal = $('#delete-modal');
	deleteModal.find('.modal-footer .delete').click(handleDeleteTag);

	var tagElement = $(this).closest('.tag');
	var tagName = tagElement.find('.tag-name').text();
	deleteModal.find('.confirmation-question').text(
			DELETE_THEMA_CONFIRMATION_QUESTION_PREFIX + tagName
					+ DELETE_THEMA_CONFIRMATION_QUESTION_SUFFIX);

	var tagId = tagElement.find('[name=tagId]').val();
	deleteModal.find('[name=itemToBeDeletedId]').val(tagId);
}

function handleDeleteTag() {
	var deleteModal = $('#delete-modal');
	var tagId = deleteModal.find('[name=itemToBeDeletedId]').val();
	persistDeletedTag(tagId);
	hideDeletedTag(tagId);
	deleteModal.modal('hide');
	hideDeactivateTagButton();
	showCorrespondingQuestionsAndAnswers();
}

function persistDeletedTag(tagId) {
	// TODO : AJAX
}

function hideDeletedTag(tagId) {
	var tagToBeDeleted = $(
			'#tags .tag [name=tagId][value=' + tagId + ']')
			.closest('.tag');
	tagToBeDeleted.remove();
}

function initActivationControls() {
	initTagActivationControls();
}

function initTagActivationControls(tagElements) {
	var elements;
	if (tagElements) {
		elements = tagElements;
	} else {
		elements = $('#tags .tag .btn-link').tag('.tag-label');
	}
	elements.click(activateTag);
}

function activateTag() {
	showAllTagsDeactivation();
	showTagActivation($(this));
	showDeactivateTagButton();
	showCorrespondingQuestionsAndAnswers();
}

function showTagActivation(tagElementsToBeActivated) {
	showTagActivationOrDeactivation(tagElementsToBeActivated, new Array(
			'btn-link'), new Array('btn-success', 'selected-tag'));
	initTagDeactivationControls(tagElementsToBeActivated);
}

function showDeactivateTagButton() {
	$('#tags .deactivate-tag').show();
}

function showCorrespondingQuestionsAndAnswers() {
	// TODO : AJAX
	// var activatedTagElements = $('#tags .tag
	// .tag-label.selected-tag');
}

function initDeactivationControls() {
	$('#tags .deactivate-tag .btn').click(deactivateAllTags);
	initTagDeactivationControls();
}

function initTagDeactivationControls(tagElements) {
	var elements;
	if (tagElements) {
		elements = tagElements;
	} else {
		elements = $('#tags .tag .tag-label').tag(
				'.selected-tag');
	}
	elements.click(deactivateTag);
}

function deactivateTag() {
	showTagDeactivation($(this));
	hideDeactivateTagButton();
	showCorrespondingQuestionsAndAnswers();
}

function deactivateAllTags() {
	showAllTagsDeactivation();
	hideDeactivateTagButton();
	showCorrespondingQuestionsAndAnswers();
}

function hideDeactivateTagButton() {
	var activatedTagCount = $('#tags .tag .tag-label').tag(
			'.selected-tag').length;
	if (activatedTagCount === 0) {
		$('#tags .deactivate-tag').hide();
	}
}

function showAllTagsDeactivation() {
	var allActivatedTagElements = $('#tags .tag .tag-label')
			.tag('.selected-tag');
	showTagDeactivation(allActivatedTagElements);
}

function showTagDeactivation(tagElementsToBeDeactivated) {
	showTagActivationOrDeactivation(tagElementsToBeDeactivated,
			new Array('btn-success', 'selected-tag'), new Array('btn-link'));
	initTagActivationControls(tagElementsToBeDeactivated);
}

function showTagActivationOrDeactivation(tagElements, classesToBeRemoved,
		classesToBeAdded) {
	tagElements.each(function() {
		var currentTagLabel = $(this);
		var currentDeleteButton = currentTagLabel.closest('.tag').find(
				'.delete');

		for (classIndex in classesToBeRemoved) {
			var classToBeRemoved = classesToBeRemoved[classIndex];
			currentTagLabel.removeClass(classToBeRemoved);
			currentDeleteButton.removeClass(classToBeRemoved);
		}

		for (classIndex in classesToBeAdded) {
			var classToBeAdded = classesToBeAdded[classIndex];
			if (!currentTagLabel.hasClass(classToBeAdded)) {
				currentTagLabel.addClass(classToBeAdded);
				// Do now color the delete button in green.
				if (classToBeAdded !== 'btn-success') {
					currentDeleteButton.addClass(classToBeAdded);
				}
			}
		}
	});
}
