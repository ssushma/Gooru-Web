// JavaScript Document

$(window).load(
		function() {
			"use strict";
			var preloaderDelay = 800;
			var preloaderFadeOutTime = 1000;
			function hidePreloader() {
				var loadingAnimation = $('#loading-animation');
				var preloader = $('.main');
				loadingAnimation.fadeOut();
				preloader.delay(preloaderDelay).fadeOut(preloaderFadeOutTime,
						function() {
						});
			}
			hidePreloader();

		});

$(window).load(function() {

	jQuery('.animate').waypoint(function() {
		var animation = jQuery(this).attr("data-animate");
		jQuery(this).addClass(animation);
		jQuery(this).addClass('animated');

	}, {
		offset : '80%'
	});
});
