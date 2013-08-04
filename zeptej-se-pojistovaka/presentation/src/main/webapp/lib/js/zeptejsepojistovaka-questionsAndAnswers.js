var AUTHOR_EMAIL = 'Váš e-mail';
var REQUIRED_AUTHOR_EMAIL_PLACEHOLDER = AUTHOR_EMAIL + THREE_DOTS;
var NONREQUIRED_AUTHOR_EMAIL_PLACEHOLDER = 'Váš e-mail... (nepovinný, leč praktický)';
var AUTHOR_EMAIL_REQUIRED = 'Vaše jméno: povinný';
var AUTHOR_EMAIL_IN_BAD_FORMAT = AUTHOR_EMAIL + COLON + SPACE + IN_BAD_FORMAT;

var AUTHOR_NAME = 'Vaše jméno';
var AUTHOR_NAME_PLACEHOLDER = 'Vaše jméno... (nepovinné)';
var AUTHOR_NAME_TOO_SHORT = 'Vaše jméno: příliš krátké';

var QUESTION_THEMA = 'Téma';
var QUESTION_THEMA_PLACEHOLDER = QUESTION_THEMA + THREE_DOTS;
var QUESTION_THEMA_REQUIRED = 'Téma: povinné';
var QUESTION_THEMA_TOO_SHORT = 'Téma: příliš krátké';

var QUESTION_TEXT = 'Text dotazu';
var QUESTION_TEXT_PLACEHOLDER = QUESTION_TEXT + THREE_DOTS;
var QUESTION_TEXT_REQUIRED = 'Text dotazu: povinný';
var QUESTION_TEXT_TOO_SHORT = 'Text dotazu: příliš krátký';

var ANSWER_TEXT = 'Text odpovědi';
var ANSWER_TEXT_PLACEHOLDER = ANSWER_TEXT + THREE_DOTS;
var ANSWER_TEXT_REQUIRED = 'Text odpovědi: povinný';
var ANSWER_TEXT_TOO_SHORT = 'Text odpovědi: příliš krátký';

var NONAME = 'Anonym';
var ANSWER_AUTHOR_NAME = 'Marie Skalická';
var AUTHOR_CONTACT_LINK = '#contact-modal';
var DELETE_QUESTION_CONFIRMATION_QUESTION_PREFIX = 'Opravdu chcete smazat tento dotaz na téma "';
var DELETE_QUESTION_CONFIRMATION_QUESTION_SUFFIX = '" spolu se všemi jeho odpověďmi?';
var DELETE_ANSWER_CONFIRMATION_QUESTION = 'Opravdu chcete smazat tuto odpověď?';

var MIN_AUTHOR_NAME_LENGTH = 3;
var MIN_QUESTION_THEMA_LENGTH = 4;
var MIN_QUESTION_TEXT_LENGTH = 4;
var MIN_ANSWER_TEXT_LENGTH = MIN_QUESTION_TEXT_LENGTH;

function handleNoname(authorName) {
	if (authorName) {
		return authorName;
	} else {
		return NONAME;
	}
}

function isNoname(authorName) {
	return !authorName || (authorName === NONAME);
}

// http://stackoverflow.com/questions/10896749/what-does-function-function-window-jquery-do
!function($) {
	$(function() {
		initControls();
	});
}(window.jQuery);

function initControls() {
	initAskQuestionBarControls();
	initQuestionControls();
	initAnswerControls();
	initLoadNextControls();
}

function initAskQuestionBarControls() {
	$('#ask-question-bar button').click(showNewQuestionForm);
}

/**
 * Initializes controls which belong to existing question graphics.
 */
function initQuestionControls(questionElement) {
	var affectedQuestionElements;
	if (questionElement) {
		affectedQuestionElements = questionElement;
	} else {
		affectedQuestionElements = $('#existing-questions section.question');
	}

	affectedQuestionElements.find('button.answer').click(showNewAnswerForm);
	initEditAndDeleteQuestionControls(affectedQuestionElements);
}

function initEditAndDeleteQuestionControls(elements) {
	elements.find('.controls .edit').click(showEditQuestionForm);
	elements.find('.controls .delete').click(showDeleteQuestionModal);
}

function showNewQuestionForm() {
	var newQuestionElement = $('#ask-question');
	newQuestionElement.html(getNewQuestionFormHtml);
	toggleNewQuestionComponentsVisibility();
	initNewQuestionFormControls();

	enableBootstrapTooltips(newQuestionElement);
	focusNewQuestionForm(newQuestionElement);
}

function focusNewQuestionForm(questionForm) {
	questionForm.find('.question.new [name=author-email]').focus();
}

function getNewQuestionFormHtml() {
	return "<div class='shadow-colored-container'>"
			+ "    <div class='row'>"
			+ "        <div class='col-12'>"
			+ "            <article>"
			+ "                <section class='question new'>"
			+ "                    <img src='images/1233576218_panacek-png_67x100.png' class='figure-image' alt='' />"
			+ "                    <div class='popover-wrapper'>"
			+ "                        <div class='popover right'>"
			+ "                            <div class='arrow'></div>"
			+ "                            <h3 class='popover-title'>"
			+ "                                <span data-toggle='tooltip' title='"
			+ AUTHOR_EMAIL
			+ "' data-placement='right'><input type='text' name='author-email' placeholder='"
			+ NONREQUIRED_AUTHOR_EMAIL_PLACEHOLDER
			+ "' /></span>"
			+ "                                <span data-toggle='tooltip' title='"
			+ AUTHOR_NAME
			+ "' data-placement='right'><input type='text' name='author-name' placeholder='"
			+ AUTHOR_NAME_PLACEHOLDER
			+ "' /></span>"
			+ "                                <span data-toggle='tooltip' title='"
			+ QUESTION_THEMA
			+ "' data-placement='right'><input type='text' name='question-thema' placeholder='"
			+ QUESTION_THEMA_PLACEHOLDER
			+ "' /></span></h3>"
			+ "                            <div class='popover-content'>"
			+ "                                <span data-toggle='tooltip' title='"
			+ QUESTION_TEXT
			+ "' data-placement='right'><textarea rows='3' name='question-text' placeholder='"
			+ QUESTION_TEXT_PLACEHOLDER
			+ "'></textarea></span></div></div>"
			+ "                        <button class='btn btn-info submit' type='button'>"
			+ ASK_QUESTION
			+ "</button></div>"
			+ "<div class='clear'></div>"
			+ "</section></article></div></div></div>";
}

function toggleNewQuestionComponentsVisibility() {
	$('#ask-question-bar button').toggleClass('hide');
	$('#ask-question').toggleClass('show');
}

function initNewQuestionFormControls() {
	$('.question.new .submit').click(handleAddQuestion);
}

function handleAddQuestion() {
	var questionForm = $(this).closest('section.question.new');
	if (!checkQuestionFormInputs(questionForm)) {
		return;
	}
	var questionParams = normalizeQuestion(questionForm);
	questionParams = persistNewQuestion(questionForm, questionParams);
	showNewQuestion(questionForm, questionParams);
}

/**
 * @returns Boolean ... {@code true} if the given question form contains valid information; otherwise {@code false}.
 */
function checkQuestionFormInputs(questionForm) {
	var everythingOk = true;
	var authorEmailOk = checkQuestionAuthorEmailInput(questionForm
			.find('[name=author-email]'));
	if (!authorEmailOk) {
		everythingOk = false;
	}
	var authorNameOk = checkQuestionAuthorNameInput(questionForm
			.find('[name=author-name]'));
	if (!authorNameOk) {
		everythingOk = false;
	}
	var themaOk = checkQuestionThemaInput(questionForm
			.find('[name=question-thema]'));
	if (!themaOk) {
		everythingOk = false;
	}
	var textOk = checkQuestionTextInput(questionForm
			.find('[name=question-text]'));
	if (!textOk) {
		everythingOk = false;
	}
	return everythingOk;
}

/**
 * @returns Boolean ... {@code true} if the given email address of question author is valid; otherwise {@code false}.
 */
function checkQuestionAuthorEmailInput(authorEmailElement) {
	var tooltipElements = getTooltipElements(authorEmailElement);

	setUpTooltipElementsToDefault(AUTHOR_EMAIL, tooltipElements);

	var authorEmail = authorEmailElement.val();
	if (!authorEmail) {
		// Author's email address is optional.
		return true;
	}
	if (!isValidEmailAddress(authorEmail.trim())) {
		setUpTooltipElementsToError(AUTHOR_EMAIL_IN_BAD_FORMAT, tooltipElements);
		return false;
	}
	return true;
}

/**
 * @returns Boolean ... {@code true} if the given name of question author is valid; otherwise {@code false}.
 */
function checkQuestionAuthorNameInput(authorNameElement) {
	var tooltipElements = getTooltipElements(authorNameElement);

	setUpTooltipElementsToDefault(AUTHOR_NAME, tooltipElements);

	var authorName = authorNameElement.val();
	if (!authorName) {
		// Author's name is optional.
		return true;
	}
	if (authorName.trim().length < MIN_AUTHOR_NAME_LENGTH) {
		setUpTooltipElementsToError(AUTHOR_NAME_TOO_SHORT, tooltipElements);
		return false;
	}
	return true;
}

/**
 * @returns Boolean ... {@code true} if the given question thema is valid; otherwise {@code false}.
 */
function checkQuestionThemaInput(themaElement) {
	var tooltipElements = getTooltipElements(themaElement);

	setUpTooltipElementsToDefault(QUESTION_THEMA, tooltipElements);

	var thema = themaElement.val();
	if (!thema) {
		setUpTooltipElementsToError(QUESTION_THEMA_REQUIRED, tooltipElements);
		return false;
	}
	if (thema.trim().length < MIN_QUESTION_THEMA_LENGTH) {
		setUpTooltipElementsToError(QUESTION_THEMA_TOO_SHORT, tooltipElements);
		return false;
	}
	return true;
}

/**
 * @returns Boolean ... {@code true} if the given question text is valid; otherwise {@code false}.
 */
function checkQuestionTextInput(textElement) {
	var tooltipElements = getTooltipElements(textElement);

	setUpTooltipElementsToDefault(QUESTION_TEXT, tooltipElements);

	var text = textElement.val();
	if (!text) {
		setUpTooltipElementsToError(QUESTION_TEXT_REQUIRED, tooltipElements);
		return false;
	}
	if (text.trim().length < MIN_QUESTION_TEXT_LENGTH) {
		setUpTooltipElementsToError(QUESTION_TEXT_TOO_SHORT, tooltipElements);
		return false;
	}
	return true;
}

function normalizeQuestion(questionForm) {
	return {
		'authorEmail' : questionForm.find('[name=author-email]').val().trim(),
		'authorName' : handleNoname(questionForm.find('[name=author-name]')
				.val().trim()),
		'questionThema' : questionForm.find('[name=question-thema]').val()
				.trim(),
		'questionText' : encodeTextToHtml(questionForm.find(
				'[name=question-text]').val())
	};
}

function persistNewQuestion(questionForm, questionParams) {
	// TODO : AJAX
	// This will be later replaced by value returned by a database.
	questionParams['questionId'] = Math.floor((Math.random() * 100000) + 100);
	questionParams['creationTimestamp'] = getNowInMillisec();
	return questionParams;
}

function showNewQuestion(questionForm, questionParams) {
	var allQuestionsBlock = $('#existing-questions .col-12');
	allQuestionsBlock.prepend(getQuestionHtml(questionParams));

	toggleNewQuestionComponentsVisibility();

	// Binds the handler function just with the new question, the others are
	// already bound.
	var newQuestionElement = allQuestionsBlock.find('section.question').first();
	initQuestionControls(newQuestionElement);

	enableBootstrapTooltips(newQuestionElement);
}

function getQuestionHtml(questionParams) {
	return "<article>" + "    <section class='question'>"
			+ getHiddenInfoHtml('question-id', questionParams['questionId'])
			+ "        <img src='images/1233576218_panacek-png_67x100.png' class='figure-image' alt='' />"
			+ "        <div class='popover-wrapper'>"
			+ "            <div class='popover right'>"
			+ "                <div class='arrow'></div>"
			+ "                <h3 class='popover-title'>"
			+ "                    <span class='question-thema'>"
			+ questionParams['questionThema']
			+ "</span><span class='controls'><span class='glyphicon glyphicon-pencil edit' data-toggle='tooltip' title='"
			+ EDIT
			+ "'></span><a href='#delete-modal' role='button' data-toggle='modal' class='delete'><span class='glyphicon glyphicon-remove' data-toggle='tooltip' title='"
			+ DELETE
			+ "'></span></a></span></h3>"
			+ "                <div class='popover-content'>"
			+ "                    <div class='question-text'>"
			+ questionParams['questionText']
			+ "</div></div>"
			+ "                <div class='popover-footer grey'>"
			+ "                    <span class='author-name'>"
			+ questionParams['authorName']
			+ "</span> <span class='dot'>·</span> <button class='answer btn btn-link' type='button'>"
			+ ANSWER
			+ "</button> <span class='dot'>·</span> <input name='creation-timestamp' type='hidden' value='"
			+ questionParams['creationTimestamp']
			+ "' /><span class='time continuously-updated'>"
			+ getTimeCaption(questionParams['creationTimestamp'])
			+ "</span></div></div></div>" + "<div class='clear'></div>"
			+ "</section></article>";
}

function showEditQuestionForm() {
	var editedQuestionElement = $(this).closest('section.question');
	var authorName = editedQuestionElement.find('.author-name').text();
	var questionParams = {
		'sectionClass' : 'edit',
		'questionThema' : editedQuestionElement.find('.question-thema').text(),
		'questionText' : decodeTextFromHtml(editedQuestionElement.find(
				'.question-text').html()),
		'authorEmail' : '',
		'authorName' : getAuthorNameForEdit(authorName),
		'buttonTitle' : EDIT,
		'cancelButton' : "<button class='btn cancel' type='button'>" + CANCEL
				+ "</button>"
	};
	$(getEditQuestionFormHtml(questionParams)).insertAfter(
			editedQuestionElement);

	// If the user rolls his modifications back, we just shows this element
	// again.
	editedQuestionElement.toggle();

	// Binds the handler function just with the new form, the others are already
	// bound.
	var newForm = editedQuestionElement.next();
	initEditQuestionFormControls(newForm);

	enableBootstrapTooltips(newForm);
	focusQuestionForm(newForm);
}

/**
 * Returns an empty string if the given {@code authorName} is undefined or it equals "Anonym". Otherwise, returns the
 * input.
 */
function getAuthorNameForEdit(authorName) {
	if (isNoname(authorName)) {
		return '';
	} else {
		return authorName;
	}
}

function getEditQuestionFormHtml(questionParams) {
	return "<section class='question "
			+ questionParams['sectionClass']
			+ "'>"
			+ "        <img src='images/1233576218_panacek-png_67x100.png' class='figure-image' alt='' />"
			+ "        <div class='popover-wrapper'>"
			+ "            <div class='popover right'>"
			+ "                <div class='arrow'></div>"
			+ "                <h3 class='popover-title'>"
			+ "                    <span data-toggle='tooltip' title='"
			+ AUTHOR_EMAIL
			+ "' data-placement='right'><input type='text' name='author-email' placeholder='"
			+ NONREQUIRED_AUTHOR_EMAIL_PLACEHOLDER
			+ "' value='"
			+ questionParams['authorEmail']
			+ "' /></span>"
			+ "                    <span data-toggle='tooltip' title='"
			+ AUTHOR_NAME
			+ "' data-placement='right'><input type='text' name='author-name' placeholder='"
			+ AUTHOR_NAME_PLACEHOLDER
			+ "' value='"
			+ questionParams['authorName']
			+ "' /></span>"
			+ "                    <span data-toggle='tooltip' title='"
			+ QUESTION_THEMA
			+ "' data-placement='right'><input type='text' name='question-thema' placeholder='"
			+ QUESTION_THEMA_PLACEHOLDER
			+ "' value='"
			+ questionParams['questionThema']
			+ "' /></span></h3>"
			+ "                <div class='popover-content'>"
			+ "                    <span data-toggle='tooltip' title='"
			+ QUESTION_TEXT
			+ "' data-placement='right'><textarea rows='3' name='question-text' placeholder='"
			+ QUESTION_TEXT_PLACEHOLDER + "'>" + questionParams['questionText']
			+ "</textarea></span></div></div>"
			+ "            <button class='btn btn-info submit' type='button'>"
			+ questionParams['buttonTitle'] + "</button>"
			+ questionParams['cancelButton'] + "</div>"
			+ "<div class='clear'></div>" + "</section>";
}

function focusQuestionForm(questionForm) {
	questionForm.find('[name=author-email]').focus();
}

function initEditQuestionFormControls(questionForm) {
	questionForm.find('.submit').click(handleEditQuestion);
	questionForm.find('.cancel').click(handleEditQuestionCancel);
}

function handleEditQuestion() {
	var questionForm = $(this).closest('section.question.edit');
	if (!checkQuestionFormInputs(questionForm)) {
		return;
	}
	var questionParams = normalizeQuestion(questionForm);
	persistUpdatedQuestion(questionForm, questionParams);
	showUpdatedQuestion(questionForm, questionParams);
}

function persistUpdatedQuestion(questionForm, questionParams) {
	// TODO : AJAX
	// var editedQuestionElement = questionForm.prev();
	// var questionId = editedQuestionElement.find('[name=question-id]').val();
	return questionParams;
}

function showUpdatedQuestion(questionForm, questionParams) {
	var editedQuestionElement = questionForm.prev();
	editedQuestionElement.find('.author-email').text(
			questionParams['authorEmail']);
	editedQuestionElement.find('.author-name').text(
			questionParams['authorName']);
	editedQuestionElement.find('.question-thema').text(
			questionParams['questionThema']);
	editedQuestionElement.find('.question-text').html(
			questionParams['questionText']);

	questionForm.remove();
	editedQuestionElement.toggle();
}

function handleEditQuestionCancel() {
	var questionForm = $(this).closest('section.question.edit');
	var editedQuestionElement = questionForm.prev();
	questionForm.remove();
	editedQuestionElement.toggle();
}

function showDeleteQuestionModal() {
	var deleteModal = $('#delete-modal');
	deleteModal.find('.modal-footer .delete').click(handleDeleteQuestion);

	var questionElement = $(this).closest('section.question');
	var questionThema = questionElement.find('.question-thema').text();
	deleteModal.find('.confirmation-question').text(
			DELETE_QUESTION_CONFIRMATION_QUESTION_PREFIX + questionThema
					+ DELETE_QUESTION_CONFIRMATION_QUESTION_SUFFIX);

	var questionId = questionElement.find('[name=question-id]').val();
	deleteModal.find('[name=item-to-be-deleted-id]').val(questionId);
}

function handleDeleteQuestion() {
	var deleteModal = $('#delete-modal');
	var questionId = deleteModal.find('[name=item-to-be-deleted-id]').val();
	persistDeletedQuestion(questionId);
	hideDeletedQuestion(questionId);
	deleteModal.modal('hide');
}

function persistDeletedQuestion(questionId) {
	// TODO : AJAX
}

function hideDeletedQuestion(questionId) {
	var wholeQuestionAnswersBlockToBeDeleted = $(
			'section.question [name=question-id][value=' + questionId + ']')
			.closest('article');
	wholeQuestionAnswersBlockToBeDeleted.remove();
}

/**
 * Initializes controls which belong to existing answer graphics.
 */
function initAnswerControls(answerElement) {
	var affectedAnswerElements;
	if (answerElement) {
		affectedAnswerElements = answerElement;
	} else {
		affectedAnswerElements = $('#existing-questions section.answer');
	}

	initEditAndDeleteAnswerControls(affectedAnswerElements);
	initContactControls(affectedAnswerElements);
}

function initEditAndDeleteAnswerControls(elements) {
	elements.find('.controls .edit').click(showEditAnswerForm);
	elements.find('.controls .delete').click(showDeleteAnswerModal);
}

function showNewAnswerForm() {
	var focusedQuestionAnswersBlock = $(this).closest('article');
	var lastChild = focusedQuestionAnswersBlock.children().last();
	if (lastChild.hasClass('new')) {
		// The new answer form is already visible.
		focusAnswerForm(lastChild);
		return;
	}

	var answerParams = {
		'sectionClass' : 'new',
		'answerText' : '',
		'buttonTitle' : ANSWER,
		'cancelButton' : ''
	};
	focusedQuestionAnswersBlock.append(getAnswerFormHtml(answerParams));

	// Binds the handler function just with the new form, the others are already
	// bound.
	var newForm = focusedQuestionAnswersBlock.find('section.answer').last();
	initNewAnswerFormControls(newForm);

	enableBootstrapTooltips(newForm);
	focusAnswerForm(newForm);
}

function getAnswerFormHtml(answerParams) {
	return "<section class='answer "
			+ answerParams['sectionClass']
			+ "'>"
			+ "    <img src='images/panacek-uvod.jpg' class='figure-image' alt='' />"
			+ "    <div class='popover-wrapper'>"
			+ "        <div class='popover left'>"
			+ "            <div class='arrow'></div>"
			+ "            <div class='popover-content'>"
			+ "                <span data-toggle='tooltip' title='"
			+ ANSWER_TEXT
			+ "' data-placement='right'><textarea rows='3' name='answer-text' placeholder='"
			+ ANSWER_TEXT_PLACEHOLDER + "'>" + answerParams['answerText']
			+ "</textarea></span></div></div>"
			+ "        <button class='btn btn-info submit' type='button'>"
			+ answerParams['buttonTitle'] + "</button>"
			+ answerParams['cancelButton'] + "</div>"
			+ "<div class='clear'></div>" + "</section>";
}

function focusAnswerForm(answerForm) {
	answerForm.find('[name=answer-text]').focus();
}

function initNewAnswerFormControls(answerForm) {
	var submitElement = answerForm.find('.submit');
	submitElement.click(handleAddAnswer);
}

function handleAddAnswer() {
	var answerForm = $(this).closest('section.answer.new');
	if (!checkAnswerFormInputs(answerForm)) {
		return;
	}
	var answerParams = normalizeAnswer(answerForm);
	persistNewAnswer(answerForm, answerParams);
	showNewAnswer(answerForm, answerParams);
}

/**
 * @returns Boolean ... {@code true} if the given answer form contains valid information; otherwise {@code false}.
 */
function checkAnswerFormInputs(answerForm) {
	return checkAnswerTextInput(answerForm.find('[name=answer-text]'));
}

/**
 * @returns Boolean ... {@code true} if the given answer text is valid; otherwise {@code false}.
 */
function checkAnswerTextInput(textElement) {
	var tooltipElements = getTooltipElements(textElement);

	setUpTooltipElementsToDefault(ANSWER_TEXT, tooltipElements);

	var text = textElement.val();
	if (!text) {
		setUpTooltipElementsToError(ANSWER_TEXT_REQUIRED, tooltipElements);
		return false;
	}
	if (text.trim().length < MIN_ANSWER_TEXT_LENGTH) {
		setUpTooltipElementsToError(ANSWER_TEXT_TOO_SHORT, tooltipElements);
		return false;
	}
	return true;
}

function normalizeAnswer(answerForm) {
	return {
		'answerText' : encodeTextToHtml(answerForm.find('[name=answer-text]')
				.val())
	};
}

function persistNewAnswer(answerForm, answerParams) {
	// TODO : AJAX
	// This will be later replaced by value returned by a database.
	answerParams['answerId'] = Math.floor((Math.random() * 100000) + 100);
	answerParams['creationTimestamp'] = getNowInMillisec();
	return answerParams;
}

function showNewAnswer(answerForm, answerParams) {
	var focusedQuestionAnswersBlock = $(answerForm).closest('article');
	answerParams['contactLink'] = AUTHOR_CONTACT_LINK;
	answerParams['authorName'] = ANSWER_AUTHOR_NAME;
	focusedQuestionAnswersBlock.append(getAnswerHtml(answerParams));

	answerForm.remove();

	// Binds the handler function just with the new answer, the others are
	// already bound.
	var newAnswerElement = focusedQuestionAnswersBlock.find('section.answer')
			.last();
	initAnswerControls(newAnswerElement);

	enableBootstrapTooltips(newAnswerElement);
}

function getAnswerHtml(answerParams) {
	return "<section class='answer'>"
			+ getHiddenInfoHtml('answer-id', answerParams['answerId'])
			+ "    <img src='images/panacek-uvod.jpg' class='figure-image' alt='' />"
			+ "    <div class='popover-wrapper'>"
			+ "        <div class='popover left'>"
			+ "            <div class='arrow'></div>"
			+ "            <div class='popover-content'>"
			+ "                <div class='answer-text'>"
			+ answerParams['answerText']
			+ "</div>"
			+ "                <span class='controls'><span class='glyphicon glyphicon-pencil edit' data-toggle='tooltip' title='"
			+ EDIT
			+ "'></span><a href='#delete-modal' role='button' data-toggle='modal' class='delete'><span class='glyphicon glyphicon-remove' data-toggle='tooltip' title='"
			+ DELETE
			+ "'></span></a></span></div>"
			+ "            <div class='popover-footer grey'>"
			+ "                <span class='author-name'><a href='"
			+ answerParams['contactLink']
			+ "' role='button' data-toggle='modal' class='show-contact'>"
			+ answerParams['authorName']
			+ "</a></span> <span class='dot'>·</span> <input name='creation-timestamp' type='hidden' value='"
			+ answerParams['creationTimestamp']
			+ "' /><span class='time continuously-updated'>"
			+ getTimeCaption(answerParams['creationTimestamp'])
			+ "</span></div></div></div>" + "<div class='clear'></div>"
			+ "</section>";
}

function showEditAnswerForm() {
	var editedAnswerElement = $(this).closest('section.answer');
	var answerParams = {
		'sectionClass' : 'edit',
		'answerText' : decodeTextFromHtml(editedAnswerElement.find(
				'.answer-text').html()),
		'buttonTitle' : EDIT,
		'cancelButton' : "<button class='btn cancel' type='button'>" + CANCEL
				+ "</button>"
	};
	$(getAnswerFormHtml(answerParams)).insertAfter(editedAnswerElement);

	// If the user rolls his modifications back, we just shows this element
	// again.
	editedAnswerElement.toggle();

	// Binds the handler function just with the new form, the others are already
	// bound.
	var newForm = editedAnswerElement.next();
	initEditAnswerFormControls(newForm);

	enableBootstrapTooltips(newForm);
	focusAnswerForm(newForm);
}

function initEditAnswerFormControls(answerForm) {
	answerForm.find('.submit').click(handleEditAnswer);
	answerForm.find('.cancel').click(handleEditAnswerCancel);
}

function handleEditAnswer() {
	var answerForm = $(this).closest('section.answer.edit');
	if (!checkAnswerFormInputs(answerForm)) {
		return;
	}
	var answerParams = normalizeAnswer(answerForm);
	persistUpdatedAnswer(answerForm, answerParams);
	showUpdatedAnswer(answerForm, answerParams);
}

function persistUpdatedAnswer(answerForm, answerParams) {
	// TODO : AJAX
	// var editedAnswerElement = answerForm.prev();
	// var answerId = editedAnswerElement.find('[name=answer-id]').val();
	return answerParams;
}

function showUpdatedAnswer(answerForm, answerParams) {
	var editedAnswerElement = answerForm.prev();
	editedAnswerElement.find('.answer-text').html(answerParams['answerText']);

	answerForm.remove();
	editedAnswerElement.toggle();
}

function handleEditAnswerCancel() {
	var answerForm = $(this).closest('section.answer.edit');
	var editedAnswerElement = answerForm.prev();
	answerForm.remove();
	editedAnswerElement.toggle();
}

function showDeleteAnswerModal() {
	var deleteModal = $('#delete-modal');
	deleteModal.find('.modal-footer .delete').click(handleDeleteAnswer);

	deleteModal.find('.confirmation-question').text(
			DELETE_ANSWER_CONFIRMATION_QUESTION);

	var answerId = $(this).closest('section.answer').find('[name=answer-id]')
			.val();
	deleteModal.find('[name=item-to-be-deleted-id]').val(answerId);
}

function handleDeleteAnswer() {
	var deleteModal = $('#delete-modal');
	var answerId = deleteModal.find('[name=item-to-be-deleted-id]').val();
	persistDeletedAnswer(answerId);
	hideDeletedAnswer(answerId);
	deleteModal.modal('hide');
}

function persistDeletedAnswer(answerId) {
	// TODO : AJAX
}

function hideDeletedAnswer(answerId) {
	var answerToBeDeleted = $(
			'section.answer [name=answer-id][value=' + answerId + ']').closest(
			'section.answer');
	answerToBeDeleted.remove();
}

function initLoadNextControls() {
	$('#questions-and-answers .loadNextWrapper .btn').click(loadNext);
	// TODO :
}

function loadNext() {
	// TODO :
}
