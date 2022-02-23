$(document).ready(function(){
	
	$(".add_to_cart_button").on("click", function(e){
		addToCart();
	});
});

function addToCart(){
	quantity = $("#quantity"+productId).val();
	url = contextPath + "cart/add/" + productId + "/" + quantity;
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
