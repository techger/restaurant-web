var ul;
var li_items; 
var li_number;
var image_number = 0;
var slider_width = 0;
var image_width;
var current = 0;

function hello(){
	alert("Hello world");
}

function createUl() {
  var ul = document.createElement('ul');
  ul.setAttribute('id', 'sub-items');

  var t, tt;
  subItems = ['element', 'element1', 'element2', 'element3'];
  subItems2 = ['element', 'element1', 'element2', 'element3'];

  document.getElementById('createSubItem').appendChild(ul);
  subItems.forEach(createSubItems);

  document.getElementById('createSubItem').appendChild(ul);
  subItems2.forEach(createSubItems);

  function createSubItems(element, index, arr) {
    var li = document.createElement('li');
    li.setAttribute('class', 'item');

    ul.appendChild(li);

    t = document.createTextNode(element);

    li.innerHTML = li.innerHTML + element;
  }
}
createUl();



function init(){	
	ul = document.getElementById('image_slider');
	li_items = ul.children;
	li_number = li_items.length;
	for (i = 0; i < li_number; i++){
		// nodeType == 1 means the node is an element.
		// in this way it's a cross-browser way.
		//if (li_items[i].nodeType == 1){
			//clietWidth and width???
			image_width = li_items[i].childNodes[0].clientWidth;
			slider_width += image_width;
			image_number++;
	}
	
	ul.style.width = parseInt(slider_width) + 'px';
	slider(ul);
}

function slider(){		
		animate({
			delay:17,
			duration: 3000,
			delta:function(p){return Math.max(0, -1 + 2 * p)},
			step:function(delta){
					ul.style.left = '-' + parseInt(current * image_width + delta * image_width) + 'px';
				},
			callback:function(){
				current++;
				if(current < li_number-1){
					slider();
				}
				else{
					var left = (li_number - 1) * image_width;					
					setTimeout(function(){goBack(left)},2000); 				
					setTimeout(slider, 4000);
				}
			}
		});
}
function goBack(left_limits){
	current = 0;	
	setInterval(function(){
		if(left_limits >= 0){
			ul.style.left = '-' + parseInt(left_limits) + 'px';
			left_limits -= image_width / 10;
		}	
	}, 17);
}
function animate(opts){
	var start = new Date;
	var id = setInterval(function(){
		var timePassed = new Date - start;
		var progress = timePassed / opts.duration
		if(progress > 1){
			progress = 1;
		}
		var delta = opts.delta(progress);
		opts.step(delta);
		if (progress == 1){
			clearInterval(id);
			opts.callback();
		}
	}, opts.dalay || 17);
}
window.onload = init;