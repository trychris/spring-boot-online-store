$(document).ready(function(){
	
	$(".add_to_cart_button").on("click", function(e){
		productid = $(this).data("pid");
		addToCart(productid);
	});
});

function addToCart(productId){
	url = contextPath + "cart/add/" + productId + "/1";
	csrfValue = $("meta[name='_csrf']").attr("content");
	csrfHeaderName = $("meta[name='_csrf_header']").attr("content");
	$.ajax({
		type: "POST",
		url: url,
		beforeSend: function(xhr){
			xhr.setRequestHeader(csrfHeaderName, csrfValue);
		}
	}).done(function(response){
		alert(response);
	}).fail(function(response){
		alert(response);
	});
}