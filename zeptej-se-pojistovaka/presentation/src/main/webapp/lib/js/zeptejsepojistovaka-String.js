/**
 * Adds a String#contains(String substring) function.
 */
if (!String.prototype.contains) {
	String.prototype.contains = function(substring) {
		var substringIndex = this.indexOf(substring);
		return !(substringIndex === -1);
	};
}