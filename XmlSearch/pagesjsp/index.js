// JavaScript Document
function recherche(){
	var shortname = $("#shortname").val();
	var titre = $("#titre").val();
	if(titre.length > 0){
		titre = titre.replace(/ /g, "_");
	}
	var annee = $("#annee option:selected").val();
	var theme = $("#themepr").val();
	$.getJSON("rechercherProjet", { annee: annee, projectName: titre, shortname: shortname, theme: theme, fullinfos: "no"}, function(Projets){
		var liste = "";
		var j = 0;
		if(Projets == null){
			liste = "Il n'y a pas de resultat";
		}else{
			liste = "<table><tr>";
		    for(var i in Projets){
	    		if(j > 5){
	    			j = 0;
	    			liste = liste + "</tr><tr>";
	    		}
	    		j++;
	    		var pos1 = Projets[i].shortName.indexOf(">") + 1;
	    		var pos2 = Projets[i].shortName.substring(pos1, Projets[i].shortName.length);
	    		pos1 = pos2.lastIndexOf("<");
	    		pos2 = pos2.substring(0, pos1);
	    		liste = liste + " <td><a href='#' onclick=\"get('" + pos2 + "','" + Projets[i].annee + "')\"> " + Projets[i].nom + "</a></td>";
		    }
		    liste = liste + "</tr></table>";
		}
	    $("#afficheprojets").html(liste);
		$("#result").show();
	});
}

function get(shortname, annee){
	var affichage = "";
	$.getJSON("getProjet", {shortname: shortname, annee: annee}, function(Projet){
		affichage = "<table width='100%' id='tabproj'><tr><td width='33%'><a href=\"#\" onclick=\"participants('" + shortname + "', '" + annee + "')\"> Participants </a></td>";
		affichage = affichage + "<td width='33%'><a href=\"#\" onclick=\"evolution('" + shortname + "')\"> Evolution des participants </a></td>";
		affichage = affichage + "<td width='33%'><a href=\"#\" onclick=\"categories('" + shortname + "', '" + annee + "')\"> Cat&eacute;gories </a></td></tr></table>";
		affichage = affichage + "<br/><br/>" + Projet[0].presentation;
		affichage = affichage.replace(/<p>/g, "<p class='text'>");
		affichage = affichage.replace(/<simplelist>/g, "<ul>");
		affichage = affichage.replace(/<\/simplelist>/g, "</ul>");
		affichage = affichage.replace(/<bodytitle>.*<\/bodytitle>/i, "<p class='text'>");
		$("#afficheprojets").html(affichage);
	});
}

function participants(shortname, annee){
	$.getJSON("getParticipantsProjet", {shortname: shortname, annee: annee}, function(Participants){
		var affichage = "<a href=\"#\" onclick=\"get('"+shortname+"','"+annee+"')>  << Retour </a><br/><br/>";
		affichage =	affichage + "<table><thead><tr><td>Nom</td><td>Pr&eacute;nom</td><td>Affiliation</td><td>Centre de recherche</td></tr></thead>";
		for(var i in Participants){
			affichage = affichage + "<tr><td>" + Participants[i].lastname + "</td><td>" + Participants[i].firstname + "</td><td>" + Participants[i].affiliation + "</td><td>" + Participants[i].researchcentre + "</tr>";
		}
		affichage = affichage + "</table>";
		$("#afficheprojets").html(affichage);
	});
}

function evolution(shortname){
	var affichage = "";
	$.getJSON("getNbParticipantsParProjet", {shortname: shortname}, function(Participants){
		affichage = affichage + "<div class=\"draw_div\"></div>";
		$("#afficheprojets").html(affichage);
		drawVisualization(Participants);
	});
}

function categories(shortname, annee){
	var affichage = "";
	$.getJSON('getRepartitionCategories',{ annee: annee, shortname: shortname }, function(categories) {
		affichage = affichage + "<div class=\"pie_div\"></div>";
		$("#afficheprojets").html(affichage);
		pieChart(categories);
	});
}

function callGetThemeParAnnee(p_annee) {
	$.getJSON('getThemeParAnnee', {annee : p_annee}, function(themesParAnnee) {
		columnChart(themesParAnnee, 'Theme', p_annee, 'Répartition des projets par thème pour l\'année '+p_annee, 'Thèmes', 'Nombre de projets');
	});
}

function callGetConference(pays,annee) {
	$.getJSON('getConference',{ pays:pays, annee:annee }, function(conf) {
		geoZoom(selectedCountry,conf);
	});
}


function callServConf()
{
	$.getJSON('getNbConferencesParPays',{ annee:'2008' }, function(conf) {
			geoMap(conf);
		});
}

function getElement(id)
{
	alert(id);
	return $("div[id="+id+"]");
}

var mymap;
function initMap() {
	var divMap = $("#map_canvas");
	alert(divMap);
	
	var latlng = new google.maps.LatLng(43.61619, 7.06786);
	var myOptions = {
	  zoom: 6,
	  center: latlng,
	  mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	mymap = new google.maps.Map(divMap, myOptions);
	
	google.maps.event.addListenerOnce(mymap, 'tilesloaded', addPin);
}

function addPin()
{	
	var centre;
	for(var key in centresRecherche)
	{
		
		centre = centresRecherche[key];
		coor = new google.maps.LatLng(centre.latitude,centre.longitude);
		
		mark = new google.maps.Marker({
			position: coor,
			map: mymap,
			title:centre.libelle
		});
		
	}
}

$(document).ready(function() {
	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content
	$(".navigation ul.subMenu").hide();
	
	$(".navigation li.toggleSubMenu span").each( function () { 
        // On stocke le contenu du span : 
        var TexteSpan = $(this).text(); 
        $(this).replaceWith('<a href="" title="Afficher le sous-menu">' + TexteSpan + '<\/a>') ;
    }); 
	
	// On modifie l'évènement "click" sur les liens dans les items de liste 
    // qui portent la classe "toggleSubMenu" : 
    $(".navigation li.toggleSubMenu > a").click( function () { 
        // Si le sous-menu était déjà ouvert, on le referme : 
        if ($(this).next("ul.subMenu:visible").length != 0) { 
            $(this).next("ul.subMenu").slideUp("normal"); 
        } 
        // Si le sous-menu est caché, on ferme les autres et on l'affiche : 
        else { 
            $(".navigation ul.subMenu").slideUp("normal"); 
            $(this).next("ul.subMenu").slideDown("normal"); 
        }
        
        // On empêche le navigateur de suivre le lien : 
        return false; 
    });
    
    $(".navigation li.lien > a").click( function () { 
        var idli = $(this).attr("id");
        idli = "#b_" + idli;
        $(".accueil").hide();
        $(idli).show();
        
        // On empêche le navigateur de suivre le lien : 
        return false; 
    });

	//On Click Event
	$("ul.tabs li").click(function() {
		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		var centresRecherche;
        if($(this).attr("id").match("conf")){
        	$.getJSON('getNbConferencesParPays',{ annee:'2008' }, function(conf) {
				geoMap(conf);
			});
        }
        else if($(this).attr("id").match("theme")){
        	$.getJSON('getThemeParAnnee', {annee : "2009"}, function(themesParAnnee) {
				columnChart(themesParAnnee, 'Theme', "2009", 'Répartition des projets par thème pour l\'année 2009', 'Thèmes', 'Nombre de projets');
			});
        }
        else if($(this).attr("id").match("centrederecherche")){
        	initMap();
			$.getJSON('getCentresRecherche', function(centres) {
				centresRecherche = centres;
				initMap();
			});
        }
		return false;
	});

});