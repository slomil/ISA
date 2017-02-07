/**
 * 
 */
//PRIKAZUJE ODGOVARAJUCU FORMU U ZAVISNOSTI OD SELEKTOVANE VREDNOSTI
function changeFunc() {
	
    var selectBox = document.getElementById("idselekt");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    $("#forma").show();
    $("#poruka").hide();
    return selectedValue;
}

function preventFja(){
	
	
	
}