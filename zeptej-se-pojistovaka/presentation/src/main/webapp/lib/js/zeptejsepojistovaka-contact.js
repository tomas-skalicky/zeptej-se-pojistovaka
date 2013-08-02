var MESSAGE_THEMA = 'Předmět vzkazu';
var MESSAGE_THEMA_PLACEHOLDER = MESSAGE_THEMA + THREE_DOTS;
var MESSAGE_THEMA_REQUIRED = 'Předmět vzkazu: povinný';

var MESSAGE_TEXT = 'Text vzkazu';
var MESSAGE_TEXT_PLACEHOLDER = MESSAGE_TEXT + THREE_DOTS;
var MESSAGE_TEXT_TOO_SHORT = 'Text vzkazu: příliš krátký';
var MESSAGE_TEXT_REQUIRED = 'Text vzkazu: povinný';

// http://stackoverflow.com/questions/10896749/what-does-function-function-window-jquery-do
!function($) {
	$(function() {
		initContactControls();
		initContactFormControls();
	});
}(window.jQuery);

function initContactControls(rootElement) {
	var elements;
	if (rootElement) {
		elements = rootElement;
	} else {
		elements = $('.show-contact');
	}
	elements.click(showContactModal);
}

function showContactModal() {
	// Due to security purposes. Against robots. User must show a human activity
	// (click on a button) to gain an access to an email address.
	$('#contact-modal .email').attr('href', 'mailto:mskalickadoma@gmail.com');
}

function initContactFormControls() {
	$('#contact-modal .message-form .submit').click(handleSendMessage);
}

function handleSendMessage() {
	var messageForm = $(this).closest('.message-form');
	if (!checkMessageFormInputs(messageForm)) {
		return;
	}
	var messageParams = normalizeMessage(messageForm);
	persistNewMessage(messageForm, messageParams);
	clearForm(messageForm);
}

/**
 * @returns Boolean ... {@code true} if the given message form contains valid
 *          information; otherwise {@code false}.
 */
function checkMessageFormInputs(messageForm) {
	var everythingOk = true;
	var authorEmailOk = checkMessageAuthorEmailInput(messageForm
			.find('[name=author-email]'));
	if (!authorEmailOk) {
		everythingOk = false;
	}
	var authorNameOk = checkMessageAuthorNameInput(messageForm
			.find('[name=author-name]'));
	if (!authorNameOk) {
		everythingOk = false;
	}
	var themaOk = checkMessageThemaInput(messageForm
			.find('[name=message-thema]'));
	if (!themaOk) {
		everythingOk = false;
	}
	var textOk = checkMessageTextInput(messageForm.find('[name=message-text]'));
	if (!textOk) {
		everythingOk = false;
	}
	return everythingOk;
}

/**
 * @returns Boolean ... {@code true} if the given email address of message
 *          author is valid; otherwise {@code false}.
 */
function checkMessageAuthorEmailInput(authorEmailElement) {
	var tooltipElements = getTooltipElements(authorEmailElement);

	setUpTooltipElementsToDefault(AUTHOR_EMAIL, tooltipElements);

	var authorEmail = authorEmailElement.val();
	if (!authorEmail) {
		setUpTooltipElementsToError(AUTHOR_EMAIL_REQUIRED, tooltipElements);
		return false;
	}
	if (!isValidEmailAddress(authorEmail.trim())) {
		setUpTooltipElementsToError(AUTHOR_EMAIL_IN_BAD_FORMAT, tooltipElements);
		return false;
	}
	return true;
}

/**
 * @returns Boolean ... {@code true} if the given name of message author is
 *          valid; otherwise {@code false}.
 */
function checkMessageAuthorNameInput(authorNameElement) {
	var tooltipElements = getTooltipElements(authorNameElement);

	setUpTooltipElementsToDefault(AUTHOR_NAME, tooltipElements);

	var authorName = authorNameElement.val();
	if (!authorName) {
		// Author's name is optional.
		return true;
	}
	if (authorName.trim().length < 3) {
		setUpTooltipElementsToError(AUTHOR_NAME_TOO_SHORT, tooltipElements);
		return false;
	}
	return true;
}

/**
 * @returns Boolean ... {@code true} if the given message thema is valid;
 *          otherwise {@code false}.
 */
function checkMessageThemaInput(themaElement) {
	var tooltipElements = getTooltipElements(themaElement);

	setUpTooltipElementsToDefault(MESSAGE_THEMA, tooltipElements);

	var thema = themaElement.val();
	if (!thema) {
		setUpTooltipElementsToError(MESSAGE_THEMA_REQUIRED, tooltipElements);
		return false;
	}
	return true;
}

/**
 * @returns Boolean ... {@code true} if the given message text is valid;
 *          otherwise {@code false}.
 */
function checkMessageTextInput(textElement) {
	var tooltipElements = getTooltipElements(textElement);

	setUpTooltipElementsToDefault(MESSAGE_TEXT, tooltipElements);

	var text = textElement.val();
	if (!text) {
		setUpTooltipElementsToError(MESSAGE_TEXT_REQUIRED, tooltipElements);
		return false;
	}
	if (text.trim().length < 10) {
		setUpTooltipElementsToError(MESSAGE_TEXT_TOO_SHORT, tooltipElements);
		return false;
	}
	return true;
}

function normalizeMessage(messageForm) {
	return {
		'authorEmail' : messageForm.find('[name=author-email]').val().trim(),
		'authorName' : handleNoname(messageForm.find('[name=author-name]')
				.val().trim()),
		'messageThema' : messageForm.find('[name=message-thema]').val().trim(),
		'messageText' : encodeTextToHtml(messageForm
				.find('[name=message-text]').val())
	};
}

function persistNewMessage(messageForm, messageParams) {
	// TODO : AJAX
	// This will be later replaced by value returned by a database.
	messageParams['messageId'] = Math.floor((Math.random() * 100000) + 100);
	messageParams['creationTimestamp'] = getNowInMillisec();
}
