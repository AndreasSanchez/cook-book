var receipeController = (function() {

	var data = {
			allItems: {
				ingredient: 0,
				step: 0
			}
	}

	return {
		addItem: function(itemId) {
			var splitId, item, sum;

			splitId = itemId.split('-');
			item = splitId[0];

			if (item === 'ingredient') {
				data.allItems.ingredient = data.allItems.ingredient + 1;
				sum = data.allItems.ingredient;
			} else if (item === 'step') {
				data.allItems.step = data.allItems.step + 1;
				sum = data.allItems.step;
			}
			console.log(data);
			return sum;


		},

		getData: function(){
			return data;
		},

		testing: function() {
			console.log(data);
		}
	}



})();

var uiController = (function() {

	var DOMStrings = {

	}

	return {

		addItem: function(id, counter) {
			var html, newHtml;

			if (id.split('-')[0] === 'ingredient') {
				html = '<div class="removeable-input"><input id="ingredient-%counter%" type="text" th:field="*{ingredients}"/><button type="button" class="item__delete--btn">&times;</button></div>';
			} else if (id.split('-')[0]  === 'step') {
				html = '<div class="removeable-input"><input id="step-%counter%" type="text" th:field="*{steps}"/><button type="button" class="item__delete--btn">&times;</button></div>';;
			}

			newHtml = html.replace('%counter%', counter)


			document.getElementById(id).parentNode.insertAdjacentHTML('afterend', newHtml);
		},
		
		deleteItem: function(id) {
			var nodeToDelete = document.getElementById(id).parentNode;
			nodeToDelete.parentNode.removeChild(nodeToDelete);
			
			
		},

		getDOMStrings: function() {
			return DOMStrings;
		}

	}



})();


var controller = (function(receipeCtrl, uiCtrl) {

	var setEventListeners = function() {
		document.querySelector('.active-container').addEventListener('keypress', function(event) {
			var el, id;

			el = event.target;
			if (el.nodeName === 'INPUT'){


				id = el.getAttribute('id');
				parent = el.parentNode;

				if (parent.nextElementSibling === null) {
					crtlAddItem(id);
				}
			}
		});
		
		document.querySelector('.active-container').addEventListener('click', ctrlDeleteItem);
		
	}

	var crtlAddItem = function(id) {
		var counter;
		counter = receipeCtrl.addItem(id);

		uiCtrl.addItem(id, counter);

	}
	
	var ctrlDeleteItem = function(event) {
		var el, id;
		
		el = event.target;

		if (el.getAttribute('class') === 'item__delete--btn') {
			id = el.previousElementSibling.getAttribute('id');
			
			uiCtrl.deleteItem(id);
		}
	}

	return {
		init: function() {
			setEventListeners();
		}
	}
})(receipeController, uiController);
controller.init();