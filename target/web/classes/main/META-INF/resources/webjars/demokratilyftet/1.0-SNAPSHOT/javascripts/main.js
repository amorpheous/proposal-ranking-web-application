if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
  
  jQuery(function() {
	console.log("Document loaded");
	$(".post-btn").click(function() {
	    var form = $(this).parents("form");
	    var data = {};
	    form.find("[data-field]").map(function(ix, domElem) {
	        var jqElem = $(domElem);
	        data[jqElem.data("field")] = jqElem.val();
	    });
	
	    console.log(form.data("date"));
	
	    $.ajax({
	        url: form.data("url"),
	        type: "POST",
	        contentType: "application/json",
	        data: JSON.stringify(data),
	        success: function(data) {
	            window.location = form.data("nexturl") + data.uuid;
	        },
	        error: function(jqXHR, textStatus, errorThrown) {
	            alert("Unable to complete operation!");
	        }
	    });
	    return false;
	});
  });

  jQuery(function() {
	  $(".update-form").click(function() {   
		  var uuid =  $(this).attr('data-uuid');
	      window.location = "/proposal/" + uuid + "/update";  
	  });       
  });
  
  jQuery(function() {
		console.log("Document loaded");
		$(".update-btn").click(function() {
		    var form = $(this).parents("form");
		    var data = {};
		    form.find("[data-field]").map(function(ix, domElem) {
		        var jqElem = $(domElem);
		        data[jqElem.data("field")] = jqElem.val();
		    });
		    
		    $.ajax({
		        url: form.data("url"),
		        type: "PUT",
		        contentType: "application/json",
		        data: JSON.stringify(data),
		        success: function(data) {
		            window.location = form.data("url");
		        },
		        error: function(jqXHR, textStatus, errorThrown) {
		            alert("Unable to complete operation!");
		        }
		    });
		    return false;
		});
	  });
  
  jQuery(function() {
	  $(".post-up").click(function() {   
		  var rank =  $(this).attr('data-rank');
		  var uuid =  $(this).attr('data-uuid');
		  
	  var incData=JSON.stringify({"uuid" : uuid, "rank" : Number(rank) + 1});
	  
	  $.ajax({
		url: "/proposal/" + uuid + "/incRank",
		type: "POST",
		contentType: "application/json",
		data: incData,
		success: function() {
			//window.location.reload(); 
			window.location = "/proposal/";
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("Unable to complete operation!");
		}
	  });
	  return false;
	  }); 
  	});
  
  jQuery(function() {
	  $(".post-down").click(function() {
		  var rank = $(this).attr('data-rank');
		  var uuid = $(this).attr('data-uuid');
		 
	  var decData = JSON.stringify({'uuid' : uuid, 'rank' : Number(rank) - 1});
		  
	  $.ajax({
		  url: "/proposal/" + uuid + "/decRank",
		  type: "POST",
		  contentType: "application/json",
		  data: decData,
		  success: function() {
			  window.location = "/proposal/";
		  },
		  error:function(jqXHR, textStatus, errorThrown) {
			 alert("Unable to complete operation!"); 
		  }
	  });
	  return false;
	  });
  });

  jQuery(function() {
	  $(".delete").click(function() {
		  var uuid = $(this).attr('data-uuid');
		  
	  $.ajax({
		  url: "/proposal/" + uuid,
		  type: "DELETE",
		  success: function() {
			  window.location = "/proposal/";
		  },
		  error:function(jqXHR, textStatus, errorThrown) {
			 alert("Unable to complete operation!"); 
		  }
	  });
	  return false;
	  });
  });

  jQuery(function() {
	  $(".new-post").click(function() {
		 window.location = "/proposal/new";
	  });
  });
  
  jQuery(function() {
	  $(".backToList").click(function() {
		 window.location = "/proposal/";
	  });
  });
  
  
}
