// JavaScript Document


function callaccrodian(){
	$('label.tree-toggler').click(function () {
		$(this).parent().children('ul.tree').toggle(300);
		
	});
	
	$('.oneLevel label').click(function () {
			$('label').toggleClass('active');
			$('.twoLevel label').removeClass('active');
			});
	$('.twoLevel label').click(function () {
			$('label').toggleClass('active');
			
	});
}

