(function(window, document) {
	window.moduleA = window.moduleA || {};
	window.moduleA.print = function(){
		console.log("This is moduleA !");
		document.write("This is moduleA !");
	}
})(window, document)