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
	initLoadMoreControls();
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
		affectedQuestionElements = $('#existing-questions .question');
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
	questionForm.find('.question.new [name=authorEmail]').focus();
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
			+ "' data-placement='right'><input type='text' name='authorEmail' placeholder='"
			+ NONREQUIRED_AUTHOR_EMAIL_PLACEHOLDER
			+ "' /></span>"
			+ "                                <span data-toggle='tooltip' title='"
			+ AUTHOR_NAME
			+ "' data-placement='right'><input type='text' name='authorName' placeholder='"
			+ AUTHOR_NAME_PLACEHOLDER
			+ "' /></span>"
			+ "                                <span data-toggle='tooltip' title='"
			+ QUESTION_THEMA
			+ "' data-placement='right'><input type='text' name='questionThema' placeholder='"
			+ QUESTION_THEMA_PLACEHOLDER
			+ "' /></span></h3>"
			+ "                            <div class='popover-content'>"
			+ "                                <span data-toggle='tooltip' title='"
			+ QUESTION_TEXT
			+ "' data-placement='right'><textarea rows='3' name='questionText' placeholder='"
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
	var questionForm = $(this).closest('.question.new');
	if (!checkQuestionFormInputs(questionForm)) {
		return;
	}
	var threadJson = composeThreadJson(questionForm);
	if (persistNewQuestion(questionForm, threadJson)) {
		modifyThreadJsonForView(threadJson);
		showNewQuestion(questionForm, threadJson);
	}
}

/**
 * @returns Boolean ... {@code true} if the given question form contains valid
 *          information; otherwise {@code false}.
 */
function checkQuestionFormInputs(questionForm) {
	var everythingOk = true;
	var authorEmailOk = checkQuestionAuthorEmailInput(questionForm
			.find('[name=authorEmail]'));
	if (!authorEmailOk) {
		everythingOk = false;
	}
	var authorNameOk = checkQuestionAuthorNameInput(questionForm
			.find('[name=authorName]'));
	if (!authorNameOk) {
		everythingOk = false;
	}
	var themaOk = checkQuestionThemaInput(questionForm
			.find('[name=questionThema]'));
	if (!themaOk) {
		everythingOk = false;
	}
	var textOk = checkQuestionTextInput(questionForm
			.find('[name=questionText]'));
	if (!textOk) {
		everythingOk = false;
	}
	return everythingOk;
}

/**
 * @returns Boolean ... {@code true} if the given email address of question
 *          author is valid; otherwise {@code false}.
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
 * @returns Boolean ... {@code true} if the given name of question author is
 *          valid; otherwise {@code false}.
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
 * @returns Boolean ... {@code true} if the given question thema is valid;
 *          otherwise {@code false}.
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
 * @returns Boolean ... {@code true} if the given question text is valid;
 *          otherwise {@code false}.
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

function composeThreadJson(questionForm) {
	return {
		'thema' : getNullIfEmpty(questionForm.find('[name=questionThema]')
				.val().trim()),
		'question' : {
			'text' : encodeTextToHtml(questionForm.find('[name=questionText]')
					.val()),
			'author' : {
				'@type' : 'UNVERIFIED_CONTRIBUTION_AUTHOR',
				'name' : getNullIfEmpty(questionForm.find('[name=authorName]')
						.val().trim()),
				'email' : getNullIfEmpty(questionForm
						.find('[name=authorEmail]').val().trim())
			}
		},
		'tags' : []
	};
}

function persistNewQuestion(questionForm, threadJson) {
	var isOk = false;
	$
			.ajax({
				url : REQUEST_CONTEXT_PATH + '/otazka/nova/ulozit/',
				type : POST_TYPE,
				dataType : JSON_TYPE,
				contentType : JSON_CONTENT_TYPE,
				data : JSON.stringify(threadJson),
				async : false
			})
			.done(
					function(saveQuestionResponse) {
						var thread = saveQuestionResponse['thread'];
						threadJson['id'] = thread['id'];
						threadJson['question'] = thread['question'];
						isOk = true;
					}).fail(function(saveQuestionResponse) {
				isOk = false;
			});
	return isOk;
}

function modifyThreadJsonForView(threadJson) {
	threadJson['question']['author']['name'] = handleNoname(threadJson['question']['author']['name']);
}

function showNewQuestion(questionForm, threadJson) {
	var allQuestionsBlock = $('#existing-questions .col-12');
	allQuestionsBlock.prepend(getThreadHtml(threadJson));

	toggleNewQuestionComponentsVisibility();

	// Binds the handler function just with the new question, the others are
	// already bound.
	var newQuestionElement = allQuestionsBlock.find('.question').first();
	initQuestionControls(newQuestionElement);

	enableBootstrapTooltips(newQuestionElement);
}

function getThreadHtml(threadJson) {
	var question = threadJson['question'];

	var threadHtml = "<article class='thread'>"
			+ getHiddenInputHtml('threadId', threadJson['id'])
			+ getHiddenInputHtml('threadTags', threadJson['tags'])
			+ getQuestionHtml(threadJson);

	var answers = question['answers'];
	for ( var answerNum = 0; answerNum < answers.length; answerNum++) {
		threadHtml += getAnswerHtml(answers[answerNum]);
	}

	threadHtml += '</article>';
	return threadHtml;
}

function getQuestionHtml(threadJson) {
	var questionJson = threadJson['question'];
	var creationTimestamp = questionJson['creationTimestamp'];
	return "<section class='question'>"
			+ getHiddenInputHtml('questionId', questionJson['id'])
			+ "        <img src='images/1233576218_panacek-png_67x100.png' class='figure-image' alt='' />"
			+ "        <div class='popover-wrapper'>"
			+ "            <div class='popover right'>"
			+ "                <div class='arrow'></div>"
			+ "                <h3 class='popover-title'>"
			+ "                    <span class='question-thema'>"
			+ threadJson['thema']
			+ "</span><span class='controls'><span class='glyphicon glyphicon-pencil edit' data-toggle='tooltip' title='"
			+ EDIT
			+ "'></span><a href='#delete-modal' role='button' data-toggle='modal' class='delete'><span class='glyphicon glyphicon-remove' data-toggle='tooltip' title='"
			+ DELETE
			+ "'></span></a></span></h3>"
			+ "                <div class='popover-content'>"
			+ "                    <div class='question-text'>"
			+ questionJson['text']
			+ "</div></div>"
			+ "                <div class='popover-footer grey'>"
			+ "                    <span class='author-name'>"
			+ questionJson['author']['name']
			+ "</span> <span class='dot'>·</span> <button class='answer btn btn-link' type='button'>"
			+ ANSWER + "</button> <span class='dot'>·</span> "
			+ getHiddenInputHtml('creationTimestamp', creationTimestamp)
			+ "<span class='time continuously-updated'>"
			+ getTimeCaption(creationTimestamp) + "</span></div></div></div>"
			+ "<div class='clear'></div>" + "</section>";
}

function showEditQuestionForm() {
	var editedQuestionElement = $(this).closest('.question');
	$(getEditQuestionFormHtml(getEditQuestionFormParams(editedQuestionElement)))
			.insertAfter(editedQuestionElement);

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

function getEditQuestionFormParams(editedQuestionElement) {
	return {
		'sectionClass' : 'edit',
		'question' : {
			'author' : {
				'name' : getAuthorNameForEdit(editedQuestionElement.find(
						'.author-name').text()),
				'email' : ''
			},
			'thema' : editedQuestionElement.find('.question-thema').text(),
			'text' : decodeTextFromHtml(editedQuestionElement.find(
					'.question-text').html())
		},
		'buttonTitle' : EDIT,
		'cancelButton' : "<button class='btn cancel' type='button'>" + CANCEL
				+ "</button>"
	};
}

/**
 * Returns an empty string if the given {@code authorName} is undefined or it
 * equals "Anonym". Otherwise, returns the input.
 */
function getAuthorNameForEdit(authorName) {
	if (isNoname(authorName)) {
		return '';
	} else {
		return authorName;
	}
}

function getEditQuestionFormHtml(questionParams) {
	var question = questionParams['question'];
	var author = question['author'];
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
			+ "' data-placement='right'><input type='text' name='authorEmail' placeholder='"
			+ NONREQUIRED_AUTHOR_EMAIL_PLACEHOLDER
			+ "' value='"
			+ author['email']
			+ "' /></span>"
			+ "                    <span data-toggle='tooltip' title='"
			+ AUTHOR_NAME
			+ "' data-placement='right'><input type='text' name='authorName' placeholder='"
			+ AUTHOR_NAME_PLACEHOLDER
			+ "' value='"
			+ author['name']
			+ "' /></span>"
			+ "                    <span data-toggle='tooltip' title='"
			+ QUESTION_THEMA
			+ "' data-placement='right'><input type='text' name='questionThema' placeholder='"
			+ QUESTION_THEMA_PLACEHOLDER
			+ "' value='"
			+ question['thema']
			+ "' /></span></h3>"
			+ "                <div class='popover-content'>"
			+ "                    <span data-toggle='tooltip' title='"
			+ QUESTION_TEXT
			+ "' data-placement='right'><textarea rows='3' name='questionText' placeholder='"
			+ QUESTION_TEXT_PLACEHOLDER + "'>" + question['text']
			+ "</textarea></span></div></div>"
			+ "            <button class='btn btn-info submit' type='button'>"
			+ questionParams['buttonTitle'] + "</button>"
			+ questionParams['cancelButton'] + "</div>"
			+ "<div class='clear'></div>" + "</section>";
}

function focusQuestionForm(questionForm) {
	questionForm.find('[name=authorEmail]').focus();
}

function initEditQuestionFormControls(questionForm) {
	questionForm.find('.submit').click(handleEditQuestion);
	questionForm.find('.cancel').click(handleEditQuestionCancel);
}

function handleEditQuestion() {
	var questionForm = $(this).closest('.question.edit');
	if (!checkQuestionFormInputs(questionForm)) {
		return;
	}
	var threadJson = composeThreadJson(questionForm);
	if (persistUpdatedQuestion(questionForm, threadJson)) {
		modifyThreadJsonForView(threadJson);
		showUpdatedQuestion(questionForm, threadJson);
	}
}

function persistUpdatedQuestion(questionForm, threadJson) {
	// TODO : AJAX
	// var editedQuestionElement = questionForm.prev();
	// var questionId = editedQuestionElement.find('[name=questionId]').val();
	return threadJson;
}

function showUpdatedQuestion(questionForm, threadJson) {
	var question = threadJson['question'];
	var author = question['author'];

	var editedQuestionElement = questionForm.prev();
	editedQuestionElement.find('.author-email').text(author['email']);
	editedQuestionElement.find('.author-name').text(author['name']);
	editedQuestionElement.find('.question-thema').text(question['thema']);
	editedQuestionElement.find('.question-text').html(question['text']);

	questionForm.remove();
	editedQuestionElement.toggle();
}

function handleEditQuestionCancel() {
	var questionForm = $(this).closest('.question.edit');
	var editedQuestionElement = questionForm.prev();
	questionForm.remove();
	editedQuestionElement.toggle();
}

function showDeleteQuestionModal() {
	var deleteModal = $('#delete-modal');
	deleteModal.find('.modal-footer .delete').click(handleDeleteQuestion);

	var questionElement = $(this).closest('.question');
	var questionThema = questionElement.find('.question-thema').text();
	deleteModal.find('.confirmation-question').text(
			DELETE_QUESTION_CONFIRMATION_QUESTION_PREFIX + questionThema
					+ DELETE_QUESTION_CONFIRMATION_QUESTION_SUFFIX);

	var questionId = questionElement.find('[name=questionId]').val();
	deleteModal.find('[name=itemToBeDeletedId]').val(questionId);
}

function handleDeleteQuestion() {
	var deleteModal = $('#delete-modal');
	var questionId = deleteModal.find('[name=itemToBeDeletedId]').val();
	persistDeletedQuestion(questionId);
	hideDeletedQuestion(questionId);
	deleteModal.modal('hide');
}

function persistDeletedQuestion(questionId) {
	// TODO : AJAX
}

function hideDeletedQuestion(questionId) {
	var wholeQuestionAnswersBlockToBeDeleted = $(
			'.question [name=questionId][value=' + questionId + ']').closest(
			'.thread');
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
		affectedAnswerElements = $('#existing-questions .answer');
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

	focusedQuestionAnswersBlock
			.append(getAnswerFormHtml(getNewAnswerFormParams()));

	// Binds the handler function just with the new form, the others are already
	// bound.
	var newForm = focusedQuestionAnswersBlock.find('.answer').last();
	initNewAnswerFormControls(newForm);

	enableBootstrapTooltips(newForm);
	focusAnswerForm(newForm);
}

function getNewAnswerFormParams() {
	return {
		'sectionClass' : 'new',
		'answer' : {
			'text' : ''
		},
		'buttonTitle' : ANSWER,
		'cancelButton' : ''
	};
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
			+ "' data-placement='right'><textarea rows='3' name='answerText' placeholder='"
			+ ANSWER_TEXT_PLACEHOLDER + "'>" + answerParams['answer']['text']
			+ "</textarea></span></div></div>"
			+ "        <button class='btn btn-info submit' type='button'>"
			+ answerParams['buttonTitle'] + "</button>"
			+ answerParams['cancelButton'] + "</div>"
			+ "<div class='clear'></div>" + "</section>";
}

function focusAnswerForm(answerForm) {
	answerForm.find('[name=answerText]').focus();
}

function initNewAnswerFormControls(answerForm) {
	var submitElement = answerForm.find('.submit');
	submitElement.click(handleAddAnswer);
}

function handleAddAnswer() {
	var answerForm = $(this).closest('.answer.new');
	if (!checkAnswerFormInputs(answerForm)) {
		return;
	}
	var answerJson = composeAnswerJson(answerForm);
	if (persistNewAnswer(answerForm, answerJson)) {
		showNewAnswer(answerForm, answerJson);
	}
}

/**
 * @returns Boolean ... {@code true} if the given answer form contains valid
 *          information; otherwise {@code false}.
 */
function checkAnswerFormInputs(answerForm) {
	return checkAnswerTextInput(answerForm.find('[name=answerText]'));
}

/**
 * @returns Boolean ... {@code true} if the given answer text is valid;
 *          otherwise {@code false}.
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

function composeAnswerJson(answerForm) {
	var questionAnswersBlock = $(answerForm).closest('.thread');
	return {
		'author' : {
			'@type' : 'UNVERIFIED_CONTRIBUTION_AUTHOR'
		},
		'text' : encodeTextToHtml(answerForm.find('[name=answerText]').val()),
		'thread' : {
			'id' : parseInt(questionAnswersBlock.find('[name=threadId]').val())
		},
		'question' : {
			'id' : parseInt(questionAnswersBlock.find('[name=questionId]')
					.val())
		}
	};
}

/**
 * @returns {@code true} if the answer has been successfully persisted;
 *          {@code false} otherwise.
 */
function persistNewAnswer(answerForm, answerParams) {
	var isOk = false;
	$.ajax({
		url : REQUEST_CONTEXT_PATH + '/odpoved/nova/ulozit/',
		type : POST_TYPE,
		dataType : JSON_TYPE,
		contentType : JSON_CONTENT_TYPE,
		data : JSON.stringify(answerParams),
		async : false
	}).done(function(saveNewAnswerResponse) {
		console.log(saveNewAnswerResponse);
		alert('success');
		var answer = saveNewAnswerResponse['answer'];
		answerParams['id'] = answer['id'];
		answerParams['creationTimestamp'] = answer['creationTimestamp'];
		isOk = true;
	}).fail(function(saveNewAnswerResponse) {
		console.log(saveNewAnswerResponse);
		alert('error');
		isOk = false;
	});
	return isOk;
}

function showNewAnswer(answerForm, answerParams) {
	var focusedQuestionAnswersBlock = $(answerForm).closest('article');
	answerParams['contactLink'] = AUTHOR_CONTACT_LINK;
	answerParams['author']['name'] = ANSWER_AUTHOR_NAME;
	focusedQuestionAnswersBlock.append(getAnswerHtml(answerParams));

	answerForm.remove();

	// Binds the handler function just with the new answer, the others are
	// already bound.
	var newAnswerElement = focusedQuestionAnswersBlock.find('.answer').last();
	initAnswerControls(newAnswerElement);

	enableBootstrapTooltips(newAnswerElement);
}

function getAnswerHtml(answerParams) {
	var creationTimestamp = answerParams['creationTimestamp'];
	return "<section class='answer'>"
			+ getHiddenInputHtml('answerId', answerParams['id'])
			+ "    <img src='images/panacek-uvod.jpg' class='figure-image' alt='' />"
			+ "    <div class='popover-wrapper'>"
			+ "        <div class='popover left'>"
			+ "            <div class='arrow'></div>"
			+ "            <div class='popover-content'>"
			+ "                <div class='answer-text'>"
			+ answerParams['text']
			+ "</div>"
			+ "                <span class='controls'><span class='glyphicon glyphicon-pencil edit' data-toggle='tooltip' title='"
			+ EDIT
			+ "'></span><a href='#delete-modal' role='button' data-toggle='modal' class='delete'><span class='glyphicon glyphicon-remove' data-toggle='tooltip' title='"
			+ DELETE + "'></span></a></span></div>"
			+ "            <div class='popover-footer grey'>"
			+ "                <span class='author-name'><a href='"
			+ answerParams['contactLink']
			+ "' role='button' data-toggle='modal' class='show-contact'>"
			+ answerParams['author']['name']
			+ "</a></span> <span class='dot'>·</span> "
			+ getHiddenInputHtml('creationTimestamp', creationTimestamp)
			+ "<span class='time continuously-updated'>"
			+ getTimeCaption(creationTimestamp) + "</span></div></div></div>"
			+ "<div class='clear'></div>" + "</section>";
}

function showEditAnswerForm() {
	var editedAnswerElement = $(this).closest('.answer');
	$(getAnswerFormHtml(getEditAnswerFormParams(editedAnswerElement)))
			.insertAfter(editedAnswerElement);

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

function getEditAnswerFormParams(editedAnswerElement) {
	return {
		'sectionClass' : 'edit',
		'answer' : {
			'text' : decodeTextFromHtml(editedAnswerElement
					.find('.answer-text').html())
		},
		'buttonTitle' : EDIT,
		'cancelButton' : "<button class='btn cancel' type='button'>" + CANCEL
				+ "</button>"
	};
}

function initEditAnswerFormControls(answerForm) {
	answerForm.find('.submit').click(handleEditAnswer);
	answerForm.find('.cancel').click(handleEditAnswerCancel);
}

function handleEditAnswer() {
	var answerForm = $(this).closest('.answer.edit');
	if (!checkAnswerFormInputs(answerForm)) {
		return;
	}
	var answerJson = composeAnswerJson(answerForm);
	if (persistUpdatedAnswer(answerForm, answerJson)) {
		showUpdatedAnswer(answerForm, answerJson);
	}
}

function persistUpdatedAnswer(answerForm, answerParams) {
	// TODO : AJAX
	// var editedAnswerElement = answerForm.prev();
	// var answerId = editedAnswerElement.find('[name=answerId]').val();
	return true;
}

function showUpdatedAnswer(answerForm, answerParams) {
	var editedAnswerElement = answerForm.prev();
	editedAnswerElement.find('.answer-text').html(answerParams['text']);

	answerForm.remove();
	editedAnswerElement.toggle();
}

function handleEditAnswerCancel() {
	var answerForm = $(this).closest('.answer.edit');
	var editedAnswerElement = answerForm.prev();
	answerForm.remove();
	editedAnswerElement.toggle();
}

function showDeleteAnswerModal() {
	var deleteModal = $('#delete-modal');
	deleteModal.find('.modal-footer .delete').click(handleDeleteAnswer);

	deleteModal.find('.confirmation-question').text(
			DELETE_ANSWER_CONFIRMATION_QUESTION);

	var answerId = $(this).closest('.answer').find('[name=answerId]').val();
	deleteModal.find('[name=itemToBeDeletedId]').val(answerId);
}

function handleDeleteAnswer() {
	var deleteModal = $('#delete-modal');
	var answerId = deleteModal.find('[name=itemToBeDeletedId]').val();
	persistDeletedAnswer(answerId);
	hideDeletedAnswer(answerId);
	deleteModal.modal('hide');
}

function persistDeletedAnswer(answerId) {
	// TODO : AJAX
}

function hideDeletedAnswer(answerId) {
	var answerToBeDeleted = $('.answer [name=answerId][value=' + answerId + ']')
			.closest('.answer');
	answerToBeDeleted.remove();
}

var canLoadMore;

function initLoadMoreControls() {
	$('#questions-and-answers .load-more-wrapper .loading-button').click(
			loadMoreThreads);

	canLoadMore = true;
	$(window).scroll(loadMoreThreadsIfBottom);
}

// TODO : DUMMY data
function loadThreads() {
	return [ {
		'id' : 44,
		'tags' : [],
		'question' : {
			'id' : 55555,
			'author' : {
				'id' : 1111,
				'name' : 'Tom Skalicky',
				'email' : 'tomsky@seznam.cz'
			},
			'thema' : 'Havarijní pojištění',
			'text' : 'The text of question',
			'creationTimestamp' : 1374235854000,
			'lastUpdateTimestamp' : 1374235854001,
			'answers' : [ {
				'id' : 55555,
				'author' : {
					'id' : 3,
					'name' : 'Marie',
				},
				'text' : 'Answer!!!',
				'creationTimestamp' : 1374235854002,
				'lastUpdateTimestamp' : 1374235854003
			}, {
				'id' : 55556,
				'author' : {
					'id' : 3,
					'name' : 'Marie',
				},
				'text' : 'Answer 2!!!',
				'creationTimestamp' : 1374235854003,
				'lastUpdateTimestamp' : ''
			} ]
		}
	}, {
		'id' : 43,
		'tags' : [],
		'question' : {
			'id' : 55556,
			'author' : {
				'id' : 112,
				'name' : 'Tomaaas Skalicky',
				'email' : 'tomsky@seznam.cz'
			},
			'thema' : 'Úrazové pojištění',
			'text' : 'The text of question 2',
			'creationTimestamp' : 1374235000000,
			'lastUpdateTimestamp' : 1374235000001,
			'answers' : [ {
				'id' : 55556,
				'author' : {
					'id' : 3,
					'name' : 'Marie',
				},
				'text' : 'Answer 1!!!',
				'creationTimestamp' : 1374235854003,
				'lastUpdateTimestamp' : ''
			} ]
		}
	} ];
}

function loadMoreThreadsIfBottom() {
	var LOAD_MORE_X_PIXELS_BEFORE_BOTTOM = 5;
	if ($(window).height() >= $(document).height() - $(window).scrollTop()
			- LOAD_MORE_X_PIXELS_BEFORE_BOTTOM
			&& canLoadMore) {
		canLoadMore = false;
		loadMoreThreads();
		canLoadMore = true;
	}
}

function loadMoreThreads() {
	toggleLoadingMoreComponentsVisibility();

	var LOADED_THREAD_COUNT = 10;
	var lastLoadedQuestionElement = $('#questions-and-answers .thread:last-child');
	var lastLoadedQuestionCreationTimestamp = lastLoadedQuestionElement.find(
			'.question [name=creationTimestamp]').val();

	// TODO : AJAX
	var loadedThreads = loadThreads(LOADED_THREAD_COUNT,
			lastLoadedQuestionCreationTimestamp);

	$(getThreadsHtml(loadedThreads)).insertAfter(lastLoadedQuestionElement);
	enableControlsOfFollowingSiblingThreads(lastLoadedQuestionElement);

	toggleLoadingMoreComponentsVisibility();
}

function toggleLoadingMoreComponentsVisibility() {
	var wrapperElement = $('#questions-and-answers .load-more-wrapper');
	wrapperElement.find('.loading-button').toggleClass('hide');
	wrapperElement.find('.loading-image').toggleClass('hide');
}

function getThreadsHtml(threads) {
	var html = "";
	for ( var threadNum = 0; threadNum < threads.length; threadNum++) {
		html += getThreadHtml(threads[threadNum]);
	}
	return html;
}

function enableControlsOfFollowingSiblingThreads(excludedSiblingElement) {
	var sibling = excludedSiblingElement.next();
	while (isSibling(sibling)) {
		initQuestionControls(sibling.find('.question'));
		sibling.find('.answer').each(function() {
			initAnswerControls($(this));
		});
		enableBootstrapTooltips(sibling);

		sibling = sibling.next();
	}
}

/**
 * @see http://stackoverflow.com/questions/5685685/how-to-judge-an-elements-previous-or-next-element-exist-with-jquery
 */
function isSibling(jQueryObject) {
	return (jQueryObject.length > 0);
}
