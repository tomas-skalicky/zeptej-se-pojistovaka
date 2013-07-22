var REQUIRED = 'povinný údaj';
var AUTHOR_NAME_PLACEHOLDER = ' Tvé jméno... (nepovinný údaj)';
var QUESTION_THEMA_PLACEHOLDER = ' Téma...';
var QUESTION_TEXT_PLACEHOLDER = ' Položit otázku...';
var ANSWER_TEXT_PLACEHOLDER = ' Odpovědět...';
var NONAME = 'Anonym';
var ANSWER_AUTHOR_NAME = 'Marie Skalická';
var AUTHOR_CONTACT_LINK = '#contactModal';
var DELETE_QUESTION_CONFIRMATION_QUESTION_PREFIX = 'Opravdu chcete smazat tento dotaz na téma "';
var DELETE_QUESTION_CONFIRMATION_QUESTION_SUFFIX = '" spolu se všemi jeho odpověďmi?';
var DELETE_ANSWER_CONFIRMATION_QUESTION = 'Opravdu chcete smazat tuto odpověď?';

function handleNoname(authorName) {
	if (authorName) {
		return authorName;
	} else {
		return NONAME;
	}
}

// http://stackoverflow.com/questions/10896749/what-does-function-function-window-jquery-do
!function($) {
	$(function() {
		initControls();
	});
}(window.jQuery);

function initControls() {
	$('#askQuestionBar button').click(showNewQuestionForm);
	initQuestionControls();
	initAnswerControls();
}

/**
 * Initializes controls which belong to existing question graphics.
 */
function initQuestionControls(questionElement) {
	var affectedQuestionElements;
	if (questionElement) {
		affectedQuestionElements = questionElement;
	} else {
		affectedQuestionElements = $('#existingQuestions section.question');
	}

	affectedQuestionElements.find('button.answer').click(showNewAnswerForm);
	initEditAndDeleteQuestionControls(affectedQuestionElements);
}

function initEditAndDeleteQuestionControls(elements) {
	elements.find('.controls .edit').click(showEditQuestionForm);
	elements.find('.controls .delete').click(showDeleteQuestionModal);
}

function showNewQuestionForm() {
	var newQuestionElement = $('#askQuestion');
	newQuestionElement.html(getNewQuestionFormHtml);
	toggleNewQuestionComponentsVisibility();
	initNewQuestionFormControls();

	var newForm = newQuestionElement.find('.question.new');
	newForm.find('[name=authorName]').focus();
}

function getNewQuestionFormHtml() {
	return "<div  class='shadow-colored-container'>"
			+ "    <div class='row-fluid'>"
			+ "        <div class='span12'>"
			+ "            <article>"
			+ "                <section class='question new'>"
			+ "                    <img src='images/1233576218_panacek-png_67x100.png' class='figure' alt='' />"
			+ "                    <div class='popover-wrapper'>"
			+ "                        <div class='popover right'>"
			+ "                            <div class='arrow'></div>"
			+ "                            <h3 class='popover-title'>"
			+ "                                <input type='text' name='authorName' placeholder='"
			+ AUTHOR_NAME_PLACEHOLDER
			+ "' />"
			+ "                                <input type='text' name='questionThema' placeholder='"
			+ QUESTION_THEMA_PLACEHOLDER
			+ "' /></h3>"
			+ "                            <div class='popover-content'>"
			+ "                                <textarea rows='3' name='questionText' placeholder='"
			+ QUESTION_TEXT_PLACEHOLDER
			+ "'></textarea></div></div>"
			+ "                        <button class='btn btn-info submit' type='button'>"
			+ ASK_QUESTION + "</button></div>" + "<div class='clear'></div>"
			+ "</section></article></div></div></div>";
}

function toggleNewQuestionComponentsVisibility() {
	$('#askQuestionBar button').toggleClass('hide');
	$('#askQuestion').toggleClass('show');
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

function checkQuestionFormInputs(questionForm) {
	var everythingOk = true;
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

function checkQuestionThemaInput(themaElement) {
	return checkRequiredElement(themaElement, {
		'attrWhereToShowError' : PLACEHOLDER,
		'originalAttrValue' : QUESTION_THEMA_PLACEHOLDER
	});
}

function checkQuestionTextInput(textElement) {
	return checkRequiredElement(textElement, {
		'attrWhereToShowError' : PLACEHOLDER,
		'originalAttrValue' : QUESTION_TEXT_PLACEHOLDER
	});
}

function checkRequiredElement(element, params) {
	var value = element.val();
	if (!value) {
		element.attr(params['attrWhereToShowError'],
				params['originalAttrValue'].concat(' (' + REQUIRED + ')'));
		return false;
	}
	return true;
}

function normalizeQuestion(questionForm) {
	var questionText = questionForm.find('[name=questionText]').val();
	return {
		'questionText' : encodeTextToHtml(questionText)
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
	var allQuestionsBlock = $('#existingQuestions .span12');
	questionParams['questionThema'] = questionForm.find('[name=questionThema]')
			.val();
	questionParams['authorName'] = handleNoname(questionForm.find(
			'[name=authorName]').val());
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
			+ getHiddenInfoHtml('questionId', questionParams['questionId'])
			+ "        <img src='images/1233576218_panacek-png_67x100.png' class='figure' alt='' />"
			+ "        <div class='popover-wrapper'>"
			+ "            <div class='popover right'>"
			+ "                <div class='arrow'></div>"
			+ "                <h3 class='popover-title'>"
			+ "                    <span class='questionThema'>"
			+ questionParams['questionThema']
			+ "</span><span class='controls'><i class='icon-pencil icon-white edit' data-toggle='tooltip' title='"
			+ EDIT
			+ "'></i><a href='#deleteModal' role='button' data-toggle='modal' class='delete'><i class='icon-remove icon-white' data-toggle='tooltip' title='"
			+ DELETE
			+ "'></i></a></span></h3>"
			+ "                <div class='popover-content'>"
			+ "                    <div class='questionText'>"
			+ questionParams['questionText']
			+ "</div></div>"
			+ "                <div class='popover-footer grey'>"
			+ "                    <span class='authorName'>"
			+ questionParams['authorName']
			+ "</span> <span class='dot'>·</span> <button class='answer btn btn-link' type='button'>"
			+ ANSWER
			+ "</button> <span class='dot'>·</span> <input name='creationTimestamp' type='hidden' value='"
			+ questionParams['creationTimestamp']
			+ "' /><span class='time continuouslyUpdated'>"
			+ getTimeCaption(questionParams['creationTimestamp'])
			+ "</span></div></div></div>" + "<div class='clear'></div>"
			+ "</section></article>";
}

function showEditQuestionForm() {
	var editedQuestionElement = $(this).closest('section.question');
	var questionParams = {
		'sectionClass' : 'edit',
		'questionThema' : editedQuestionElement.find('.questionThema').html(),
		'questionText' : decodeTextFromHtml(editedQuestionElement.find(
				'.questionText').html()),
		'authorName' : editedQuestionElement.find('.authorName').html(),
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

	focusQuestionForm(newForm);
}

function getEditQuestionFormHtml(questionParams) {
	return "<section class='question "
			+ questionParams['sectionClass']
			+ "'>"
			+ "        <img src='images/1233576218_panacek-png_67x100.png' class='figure' alt='' />"
			+ "        <div class='popover-wrapper'>"
			+ "            <div class='popover right'>"
			+ "                <div class='arrow'></div>"
			+ "                <h3 class='popover-title'>"
			+ "                    <input type='text' name='authorName' placeholder='"
			+ AUTHOR_NAME_PLACEHOLDER
			+ "' value='"
			+ questionParams['authorName']
			+ "' />"
			+ "                    <input type='text' name='questionThema' placeholder='"
			+ QUESTION_THEMA_PLACEHOLDER
			+ "' value='"
			+ questionParams['questionThema']
			+ "' /></h3>"
			+ "                <div class='popover-content'>"
			+ "                    <textarea rows='3' name='questionText' placeholder='"
			+ QUESTION_TEXT_PLACEHOLDER + "'>" + questionParams['questionText']
			+ "</textarea></div></div>"
			+ "            <button class='btn btn-info submit' type='button'>"
			+ questionParams['buttonTitle'] + "</button>"
			+ questionParams['cancelButton'] + "</div>"
			+ "<div class='clear'></div>" + "</section>";
}

function focusQuestionForm(questionForm) {
	questionForm.find('[name=authorName]').focus();
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
	// var questionId = editedQuestionElement.find('[name=questionId]').val();
	return questionParams;
}

function showUpdatedQuestion(questionForm, questionParams) {
	var questionThema = questionForm.find('[name=questionThema]').val();
	var authorName = handleNoname(questionForm.find('[name=authorName]').val());

	var editedQuestionElement = questionForm.prev();
	editedQuestionElement.find('.questionThema').html(questionThema);
	editedQuestionElement.find('.questionText').html(
			questionParams['questionText']);
	editedQuestionElement.find('.authorName').html(authorName);

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
	var deleteModal = $('#deleteModal');
	deleteModal.find('.modal-footer .delete').click(handleDeleteQuestion);

	var questionElement = $(this).closest('section.question');
	var questionThema = questionElement.find('.questionThema').html();
	deleteModal.find('#deleteModalConfirmationQuestion').html(
			DELETE_QUESTION_CONFIRMATION_QUESTION_PREFIX + questionThema
					+ DELETE_QUESTION_CONFIRMATION_QUESTION_SUFFIX);

	var questionId = questionElement.find('[name=questionId]').val();
	deleteModal.find('[name=itemToBeDeletedId]').val(questionId);
}

function handleDeleteQuestion() {
	var deleteModal = $(this).closest('#deleteModal');
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
			'section.question [name=questionId][value=' + questionId + ']')
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
		affectedAnswerElements = $('#existingQuestions section.answer');
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

	focusAnswerForm(newForm);
}

function getAnswerFormHtml(answerParams) {
	return "<section class='answer "
			+ answerParams['sectionClass']
			+ "'>"
			+ "    <img src='images/panacek-uvod.jpg' class='figure' alt='' />"
			+ "    <div class='popover-wrapper'>"
			+ "        <div class='popover left'>"
			+ "            <div class='arrow'></div>"
			+ "            <div class='popover-content'>"
			+ "                <textarea rows='3' name='answerText' placeholder='"
			+ ANSWER_TEXT_PLACEHOLDER + "'>" + answerParams['answerText']
			+ "</textarea></div></div>"
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
	var answerForm = $(this).closest('section.answer.new');
	if (!checkAnswerFormInputs(answerForm)) {
		return;
	}
	var answerParams = normalizeAnswer(answerForm);
	persistNewAnswer(answerForm, answerParams);
	showNewAnswer(answerForm, answerParams);
}

function checkAnswerFormInputs(answerForm) {
	return checkAnswerTextInput(answerForm.find('[name=answerText]'));
}

function checkAnswerTextInput(textElement) {
	return checkRequiredElement(textElement, {
		'attrWhereToShowError' : PLACEHOLDER,
		'originalAttrValue' : ANSWER_TEXT_PLACEHOLDER
	});
}

function normalizeAnswer(answerForm) {
	var answerText = answerForm.find('[name=answerText]').val();
	return {
		'answerText' : encodeTextToHtml(answerText)
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
			+ getHiddenInfoHtml('answerId', answerParams['answerId'])
			+ "    <img src='images/panacek-uvod.jpg' class='figure' alt='' />"
			+ "    <div class='popover-wrapper'>"
			+ "        <div class='popover left'>"
			+ "            <div class='arrow'></div>"
			+ "            <div class='popover-content'>"
			+ "                <div class='answerText'>"
			+ answerParams['answerText']
			+ "</div>"
			+ "                <span class='controls'><i class='icon-pencil icon-white edit' data-toggle='tooltip' title='"
			+ EDIT
			+ "'></i><a href='#deleteModal' role='button' data-toggle='modal' class='delete'><i class='icon-remove icon-white' data-toggle='tooltip' title='"
			+ DELETE
			+ "'></i></a></span></div>"
			+ "            <div class='popover-footer grey'>"
			+ "                <span class='authorName'><a href='"
			+ answerParams['contactLink']
			+ "' role='button' data-toggle='modal' class='showContact'>"
			+ answerParams['authorName']
			+ "</a></span> <span class='dot'>·</span> <input name='creationTimestamp' type='hidden' value='"
			+ answerParams['creationTimestamp']
			+ "' /><span class='time continuouslyUpdated'>"
			+ getTimeCaption(answerParams['creationTimestamp'])
			+ "</span></div></div></div>" + "<div class='clear'></div>"
			+ "</section>";
}

function showEditAnswerForm() {
	var editedAnswerElement = $(this).closest('section.answer');
	var answerParams = {
		'sectionClass' : 'edit',
		'answerText' : decodeTextFromHtml(editedAnswerElement.find(
				'.answerText').html()),
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
	// var answerId = editedAnswerElement.find('[name=answerId]').val();
	return answerParams;
}

function showUpdatedAnswer(answerForm, answerParams) {
	var editedAnswerElement = answerForm.prev();
	editedAnswerElement.find('.answerText').html(answerParams['answerText']);

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
	var deleteModal = $('#deleteModal');
	deleteModal.find('.modal-footer .delete').click(handleDeleteAnswer);

	deleteModal.find('#deleteModalConfirmationQuestion').html(
			DELETE_ANSWER_CONFIRMATION_QUESTION);

	var answerId = $(this).closest('section.answer').find('[name=answerId]')
			.val();
	deleteModal.find('[name=itemToBeDeletedId]').val(answerId);
}

function handleDeleteAnswer() {
	var deleteModal = $(this).closest('#deleteModal');
	var answerId = deleteModal.find('[name=itemToBeDeletedId]').val();
	persistDeletedAnswer(answerId);
	hideDeletedAnswer(answerId);
	deleteModal.modal('hide');
}

function persistDeletedAnswer(answerId) {
	// TODO : AJAX
}

function hideDeletedAnswer(answerId) {
	var answerToBeDeleted = $(
			'section.answer [name=answerId][value=' + answerId + ']').closest(
			'section.answer');
	answerToBeDeleted.remove();
}
