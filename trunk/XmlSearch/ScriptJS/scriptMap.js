		var map; // object google map 
		function initMap() 
		{
			var latlng = new google.maps.LatLng(43.61619, 7.06786);
			var myOptions = {
			  zoom: 6,
			  center: latlng,
			  mapTypeId: google.maps.MapTypeId.ROADMAP,
			  streetViewControl: true
			};

			map = new google.maps.Map(document.getElementById("map_canvas"),
			myOptions);
			
	
				// set marker + set infoMarker
					
			/*	var contentString = '<div id="content">'+
				'<div id="siteNotice">'+
				'</div>'+
				'<h1 id="firstHeading" class="firstHeading">Site de bowdeaux</h1>'+
				'<div id="bodyContent">'+
				'<p><b>Bulbizare</b>,blablablablablabla <b>Vomito</b> !' +
				'<a href="http://www.google.fr">Lien pour diagramme circulaire</a>'+
				'</div>'+
				'</div>';
	
				var infowindow = new google.maps.InfoWindow({
					content: contentString
				});
	
				var myLatlng = new google.maps.LatLng(44.807946,-0.596811);
				var marker = new google.maps.Marker({
					position: myLatlng,
					map: map,
					title:"CRI Bordeaux"
				});
	
				google.maps.event.addListener(marker, 'click', function() {
				  infowindow.open(map,marker);
				});
						
	
				var panoramaOptions = {
				  position: myLatlng,
				  pov: {
					heading: 34,
					pitch: 10,
					zoom: 3
				  }
				};
						
				var panorama = new  google.maps.StreetViewPanorama(document.getElementById("pano"),panoramaOptions);
				map.setStreetView(panorama);
			});


			var myLatlng = new google.maps.LatLng(44.807946,-0.596811);
			var marker = new google.maps.Marker({
				position: myLatlng,
				map: map,
				title:"CRI Bordeaux"
			});

			google.maps.event.addListener(marker, 'click', function() {
			  infowindow.open(map,marker);
			});*/
					

			/*var panoramaOptions = {
			  position: myLatlng,
			  pov: {
				heading: 34,
				pitch: 10,
				zoom: 3
			  }
			};
					
			var panorama = new  google.maps.StreetViewPanorama(document.getElementById("pano"),panoramaOptions);
			map.setStreetView(panorama);*/


		  
		}
		function addPin(lstCentre)
		{	
			
			var centre;
			for(var key in lstCentre)
			{
				
				centre = lstCentre[key];
				coor = new google.maps.LatLng(centre.latitude,centre.longitude);
				
				mark = new google.maps.Marker({
					position: coor,
					map: map,
					title:centre.libelle
				});
				
			}
			/*coor = new google.maps.LatLng(45.807946,-0.596811);
			mark = new google.maps.Marker({
				position: coor,
				map: map,
				title:"TG"
			});*/
		}