//Mostrar modal
document.querySelector("#show-login").addEventListener("click", function() {
	document.querySelector(".popup").classList.add("active");
});
//ocultar modal
document.querySelector(".popup .close-btn").addEventListener("click", function() {
	document.querySelector(".popup").classList.remove("active");
});

/*ocultar forms*/
let ocultar;
let ocultar2;

function Ocultar() {
	ocultar = true;
	ocultar2 = false;
	$('#showRegsitro').hide();
}
function login() {
	if (ocultar2 === true && ocultar === false) {
		$('#showLogin').show();
		$('#showRegsitro').hide();
		ocultar = true;
		ocultar2 = false;
	}

}
function registro() {
	if (ocultar === true && ocultar2 === false) {
		$('#showRegsitro').show();
		$('#showLogin').hide();
		ocultar2 = true;
		ocultar = false;
	}

}



