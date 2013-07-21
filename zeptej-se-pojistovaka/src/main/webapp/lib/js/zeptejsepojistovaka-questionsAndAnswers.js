var REQUIRED = 'povinný údaj';
var AUTHOR_NAME_PLACEHOLDER = ' Tvé jméno... (nepovinné)';
var QUESTION_THEMA_PLACEHOLDER = ' Téma...';
var QUESTION_TEXT_PLACEHOLDER = ' Položit otázku...';
var SUBMIT_NEW_QUESTION_TITLE = 'Položit otázku';
var ANSWER_TEXT_PLACEHOLDER = ' Odpovědět...';
var SUBMIT_NEW_ANSWER_TITLE = 'Odpovědět';
var CANCEL_TITLE = "Zrušit";
var NONAME = 'Anonym';
var ANSWER_AUTHOR_NAME = 'Marie Skalická';
var EDIT_TOOLTIP = 'Upravit';
var SUBMIT_EDIT_TITLE = EDIT_TOOLTIP;
var DELETE_TOOLTIP = 'Smazat';
var PLACEHOLDER = 'placeholder';

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

	affectedQuestionElements.find('button.answer').click(function(e) {
		showNewAnswerForm(e);
	});
	initEditAndDeleteQuestionControls(affectedQuestionElements);
}

function initEditAndDeleteQuestionControls(elements) {
	elements.find('.controls .edit').click(function(e) {
		showEditQuestionForm(e);
	});
	elements.find('.controls .delete').click(function(e) {
		handleDeleteQuestion(e);
	});
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
			+ SUBMIT_NEW_QUESTION_TITLE + "</button></div>"
			+ "<div class='clear'></div>"
			+ "</section></article></div></div></div>";
}

function toggleNewQuestionComponentsVisibility() {
	$('#askQuestionBar button').toggleClass('hide');
	$('#askQuestion').toggleClass('show');
}

function initNewQuestionFormControls() {
	$('.question.new .submit').click(function(e) {
		handleAddQuestion(e);
	});
}

function handleAddQuestion(e) {
	var questionForm = $(e.currentTarget).closest('section.question.new');
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
			+ EDIT_TOOLTIP
			+ "'></i><i class='icon-remove icon-white delete' data-toggle='tooltip' title='"
			+ DELETE_TOOLTIP
			+ "'></i></span></h3>"
			+ "                <div class='popover-content'>"
			+ "                    <div class='questionText'>"
			+ questionParams['questionText']
			+ "</div></div>"
			+ "                <div class='popover-footer grey'>"
			+ "                    <span class='authorName'>"
			+ questionParams['authorName']
			+ "</span> <span class='dot'>·</span> <button class='answer btn btn-link' type='button'>"
			+ SUBMIT_NEW_ANSWER_TITLE
			+ "</button> <span class='dot'>·</span> <input name='creationTimestamp' type='hidden' value='"
			+ questionParams['creationTimestamp']
			+ "' /><span class='time continuouslyUpdated'>"
			+ getTimeCaption(questionParams['creationTimestamp'])
			+ "</span></div></div></div>" + "<div class='clear'></div>"
			+ "</section></article>";
}

function showEditQuestionForm(e) {
	var editedQuestionElement = $(e.currentTarget).closest('section.question');
	var questionParams = {
		'sectionClass' : 'edit',
		'questionThema' : editedQuestionElement.find('.questionThema').html(),
		'questionText' : decodeTextFromHtml(editedQuestionElement.find(
				'.questionText').html()),
		'authorName' : editedQuestionElement.find('.authorName').html(),
		'buttonTitle' : SUBMIT_EDIT_TITLE,
		'cancelButton' : "<button class='btn btn-info cancel' type='button'>"
				+ CANCEL_TITLE + "</button>"
	};
	$(getEditQuestionFormHtml(questionParams)).insertAfter(
			editedQuestionElement);

	// If the user rolls his modifications back, we just shows this element again.
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
	var submitElement = questionForm.find('.submit');
	submitElement.click(function(e) {
		handleEditQuestion(e);
	});
	var cancelElement = questionForm.find('.cancel');
	cancelElement.click(function(e) {
		handleEditQuestionCancel(e);
	});
}

function handleEditQuestion(e) {
	var questionForm = $(e.currentTarget).closest('section.question.edit');
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

function handleEditQuestionCancel(e) {
	var questionForm = $(e.currentTarget).closest('section.question.edit');
	var editedQuestionElement = questionForm.prev();
	questionForm.remove();
	editedQuestionElement.toggle();
}

function handleDeleteQuestion(e) {
	var questionForm = $(e.currentTarget).closest('section.question');
	alert(questionForm.find('.questionText').html());
	// TODO
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
}

function initEditAndDeleteAnswerControls(elements) {
	elements.find('.controls .edit').click(function(e) {
		showEditAnswerForm(e);
	});
	elements.find('.controls .delete').click(function(e) {
		showDeleteAnswerModal(e);
	});
}

function showNewAnswerForm(e) {
	var focusedQuestionAnswersBlock = $(e.currentTarget).closest('article');
	var lastChild = focusedQuestionAnswersBlock.children().last();
	if (lastChild.hasClass('new')) {
		// The new answer form is already visible.
		focusAnswerForm(lastChild);
		return;
	}

	var answerParams = {
		'sectionClass' : 'new',
		'answerText' : '',
		'buttonTitle' : SUBMIT_NEW_ANSWER_TITLE,
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
	submitElement.click(function(e) {
		handleAddAnswer(e);
	});
}

function handleAddAnswer(e) {
	var answerForm = $(e.currentTarget).closest('section.answer.new');
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
	answerParams['contactPageUrl'] = $('#contactPageUrl').val();
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
			+ EDIT_TOOLTIP
			+ "'></i><i class='icon-remove icon-white delete' data-toggle='tooltip' title='"
			+ DELETE_TOOLTIP
			+ "'></i></span></div>"
			+ "            <div class='popover-footer grey'>"
			+ "                <span class='authorName'><a href='"
			+ answerParams['contactPageUrl']
			+ "'>"
			+ answerParams['authorName']
			+ "</a></span> <span class='dot'>·</span> <input name='creationTimestamp' type='hidden' value='"
			+ answerParams['creationTimestamp']
			+ "' /><span class='time continuouslyUpdated'>"
			+ getTimeCaption(answerParams['creationTimestamp'])
			+ "</span></div></div></div>" + "<div class='clear'></div>"
			+ "</section>";
}

function showEditAnswerForm(e) {
	var editedAnswerElement = $(e.currentTarget).closest('section.answer');
	var answerParams = {
		'sectionClass' : 'edit',
		'answerText' : decodeTextFromHtml(editedAnswerElement.find(
				'.answerText').html()),
		'buttonTitle' : SUBMIT_EDIT_TITLE,
		'cancelButton' : "<button class='btn btn-info cancel' type='button'>"
				+ CANCEL_TITLE + "</button>"
	};
	$(getAnswerFormHtml(answerParams)).insertAfter(editedAnswerElement);

	// If the user rolls his modifications back, we just shows this element again.
	editedAnswerElement.toggle();

	// Binds the handler function just with the new form, the others are already
	// bound.
	var newForm = editedAnswerElement.next();
	initEditAnswerFormControls(newForm);

	focusAnswerForm(newForm);
}

function initEditAnswerFormControls(answerForm) {
	var submitElement = answerForm.find('.submit');
	submitElement.click(function(e) {
		handleEditAnswer(e);
	});
	var cancelElement = answerForm.find('.cancel');
	cancelElement.click(function(e) {
		handleEditAnswerCancel(e);
	});
}

function handleEditAnswer(e) {
	var answerForm = $(e.currentTarget).closest('section.answer.edit');
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

function handleEditAnswerCancel(e) {
	var answerForm = $(e.currentTarget).closest('section.answer.edit');
	var editedAnswerElement = answerForm.prev();
	answerForm.remove();
	editedAnswerElement.toggle();
}

function showDeleteAnswerModel(e) {
	var answerForm = $(e.currentTarget).closest('section.answer');
	alert(answerForm.find('.answerText').html());
	// TODO
}
