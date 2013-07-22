// http://stackoverflow.com/questions/10896749/what-does-function-function-window-jquery-do
!function($) {
	$(function() {
		initContactControls();
	});
}(window.jQuery);

function initContactControls(rootElement) {
	var elements;
	if (rootElement) {
		elements = rootElement;
	} else {
		elements = $('.showContact');
	}
	elements.click(showContactModal);
}

function showContactModal() {
	// Due to security purposes. Against robots. User must show a human activity
	// (click on a button) to gain an access to an email address.
	$('#contactModal .email').attr('href', 'mailto:mskalickadoma@gmail.com');
}
