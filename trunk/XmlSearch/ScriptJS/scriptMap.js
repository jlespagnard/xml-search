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
			var divMap = document.getElementById('map_canvas');
			alert(divMap);
			map = new google.maps.Map(divMap, myOptions);
//			var panoramaOptions = {
//				  //position: latlng,
//				  pov: {
//					heading: 34,
//					pitch: 10,
//					zoom: 1
//				  }
//				};
//						
//				var panorama = new  google.maps.StreetViewPanorama(document.getElementById("pano"),panoramaOptions);
//				map.setStreetView(panorama);
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