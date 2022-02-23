var previousQuantity;
csrfValue = $("meta[name='_csrf']").attr("content");
csrfHeaderName = $("meta[name='_csrf_header']").attr("content");
$(document).ready(function(){
	
	updateTotal();
	$(".minusButton").on("click", function(event){
		event.preventDefault();
		productId = $(this).data("pid");
		qtyInput = $("#quantity" + productId);
		globalThis.previousQuantity = qtyInput.val();
		newQty = parseInt(qtyInput.val()) - 1;
		if (newQty > 0){
			qtyInput.val(newQty);
			updateQuantity(productId, newQty);
		}
		
	});
	$(".plusButton").on("click", function(event){
		event.preventDefault();
		productId = $(this).data("pid");
		qtyInput = $("#quantity" + productId);
		globalThis.previousQuantity = qtyInput.val();
		newQty = parseInt(qtyInput.val()) + 1;
		if (newQty > 0){
			qtyInput.val(newQty);
			updateQuantity(productId, newQty);
		}
	});
	$(".remove").on("click", function(event){
		event.preventDefault();
		productId = $(this).data("pid");
		removeFromCart(productId);
	})
	
	$("#checkout_proceed").click(function(e){
		e.preventDefault();
		window.location = contextPath + "checkout"
	})
});

function removeFromCart(productId){
	url = contextPath + "cart/delete/" + productId;
	$.ajax({
		type: "POST",
		url: url,
		beforeSend: function(xhr){
			xhr.setRequestHeader(csrfHeaderName, csrfValue);
		}
	}).done(function(response){
		alert(response);
		if(response.includes("removed")){
			$("#tableRow-"+productId).remove();
			updateTotal();
		}
	}).fail(function(response){
		alert(response);
	});
}


function updateQuantity(productId, quantity){
	url = contextPath + "cart/update/" + productId + "/" + quantity;
	
	$.ajax({
		type: "POST",
		url: url,
		beforeSend: function(xhr){
			xhr.setRequestHeader(csrfHeaderName, csrfValue);
		}
	}).done(function(newSubtotalResponse){
		updateSubtotal(productId, newSubtotalResponse);
		updateTotal();
	}).fail(function(response){
		alert("Failed to change quantity");
	});
}

function updateSubtotal(productId, newSubtotal){
	newSubtotal = parseFloat(newSubtotal);
	$("#subtotal"+productId).text(newSubtotal.toFixed(2));
}
function updateTotal(){
	total = 0.0;
	$(".subTotal").each(function(index, element){
		total += parseFloat(element.innerHTML);
		console.log(total);
	});
	$("#totalAmount").text("$" + total);
}