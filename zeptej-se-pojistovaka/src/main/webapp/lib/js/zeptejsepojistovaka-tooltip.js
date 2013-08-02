/**
 * Enables Twitter Bootstrap tooltips for all elements in the tree of the given
 * {@code rootElement} which have {@code data-toggle="tooltip"}.
 */
function enableBootstrapTooltips(rootElement) {
	var commonSelector = '[data-toggle=tooltip]';
	var affectedElements;
	if (rootElement) {
		affectedElements = rootElement.find(commonSelector);
	} else {
		affectedElements = $(commonSelector);
	}
	affectedElements.tooltip();
}

function getTooltipElements(tooltippedElement) {
	return {
		'originalTitleTooltipElement' : tooltippedElement.parent()
	};
}

function setUpTooltipElementsToDefault(defaultTitle, params) {
	var originalTitleTooltipElement = params['originalTitleTooltipElement'];
	originalTitleTooltipElement.attr('data-original-title', defaultTitle);

	var tooltipElement = originalTitleTooltipElement.next();
	tooltipElement.find('.tooltip-inner').text(defaultTitle);
	tooltipElement.find('.tooltip-arrow').attr('style', '');
	tooltipElement.removeClass('error-tooltip');
}

function setUpTooltipElementsToError(errorTitle, params) {
	var originalTitleTooltipElement = params['originalTitleTooltipElement'];
	originalTitleTooltipElement.attr('data-original-title', errorTitle);
	originalTitleTooltipElement.tooltip('show');

	var tooltipElement = originalTitleTooltipElement.next();
	tooltipElement.find('.tooltip-inner').text(errorTitle);
	if (tooltipElement.hasClass('right') || tooltipElement.hasClass('left')) {
		tooltipElement.find('.tooltip-arrow').attr('style', 'top:50%');
	}
	if (!tooltipElement.hasClass('error-tooltip')) {
		tooltipElement.addClass('error-tooltip');
	}
}
