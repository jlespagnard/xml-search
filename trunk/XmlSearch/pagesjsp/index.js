// JavaScript Document
function recherche(){
	var shortname = $("#shortname").val();
	var titre = $("#titre").val();
	var annee = $("#annee option:selected").val();
	var theme = $("#theme").val();
	$.getJSON("rechercherProjet", { annee: annee, projectname: titre, shortname: shortname, theme: theme, fullinfos: "no"}, function(Projets){
		var liste = "<table><tr>";
		var j = 0;
	    for(var i in Projets){
	    	if(Projets[i].titre != null){
	    		alert("ok");
	    		if(j > 5){
	    			j = 0;
	    			liste = liste + "</tr><tr>";
	    		}
	    		j++;
	    		liste = liste + " <td><a onclick=\"get('" + Projets[i].titre + "','" + Projets[i].annee + "')\"> " + Projets[i].titre + "</a></td>";
//	    		liste = liste + " <br/>" + Projets[i].shortName;
	    	}
	    }
	    liste = liste + "</tr></table>";
	    $("#afficheprojets").html(liste);
		$("#result").show();
	});
}

//function get(shortname, annee){
//	var affichage = "";
//	alert(shortname);
//	alert(annee);
//	$.getJSON("getProjet", {shortname: shortname, annee: annee}, function(Projet){
//		affichage = "<a onclick=\"participants(" + annee + ", " + shortname + "\"> Participants </a>";
//		affichage = affichage + "<br/><a href=\"#\" onclick=\"evolution(" + shortname + "\"> Evolution des participants </a><br/>";
//		affichage = affichage + Projet.objectifs;
//		alert(affichage);
//		$("#afficheprojets").html(affichage);
//	});
//}
//
//function participants(annee, shortname){
//	document.getElementbyID("#afficheprojets").innerHTML = "";
//	var affichage = "";
//	$.getJSON("getParticipantsProjet", {shortname: shortname, annee: annee}, function(Participants){
//		for(var i in Participants){
//			affichage = affichage + "<br/>" + Participants[i].lastname + " " + Participants[i].firstname + " " + Participants[i].affiliation + " " + Participants[i].researchCentre;
//		}
//	});
//}

$(document).ready(function() {
	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs li").click(function() {
		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});

});