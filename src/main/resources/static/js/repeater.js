
var initRepeater=function(dataGroupSelector,dataGroupTemplateSelector, addButtonSelector){
	var addItem = function () {
	    var dataGroup = document.querySelector('['+dataGroupSelector+']');
	    var index = dataGroup.querySelectorAll('[data-group-element]').length;
	    var dataGroupTemplate = document.querySelector('['+dataGroupTemplateSelector+']');

	    var e = document.createElement('div');
	    e.innerHTML = dataGroupTemplate.innerHTML.split("$index").join(index);
	    e.setAttribute("data-group-element","");

	    dataGroup.appendChild(e);
	};


	var addButton = document.querySelector('['+addButtonSelector+']');

	addButton.addEventListener('click', function() {
	    addItem();
	}, false);
}

function remove(element) {
	var container_ = element.parentNode.parentNode.parentNode.parentNode;
	var delete_ = element.parentNode.parentNode.parentNode;
	container_.removeChild(delete_);
}


