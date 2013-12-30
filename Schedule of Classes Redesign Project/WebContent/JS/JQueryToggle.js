/*Name: John Tan 
Date: 11/23/2013

*/

//ADVANCED FEATURE - slide toggle the "scheduleresults" page 

$(document).ready(function(){
		//hide the div first
		$('#hidden').hide();
		//load the html file into the div
		$('#hidden').load('coursedetails.html');
	
		//handle the clicks and perform the function
		$('ul#nav a').click(function(){
		//declare variable that handles the attribute that was clicked
		var page = $(this).attr('href');
		//load the page that was being clicked without having it refresh
		$('#hidden').load('hidden/' + page + '.html');
		//this is the slide toggle effect with the speed of 350
			$('#hidden').slideToggle(700);
		return false;
		});
	});
