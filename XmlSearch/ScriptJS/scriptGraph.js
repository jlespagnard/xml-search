
        function initData() {
		    var data = new google.visualization.DataTable();
		    data.addColumn('string', 'Country');
		    data.addColumn('number', 'Nb conf�rence');
		    data.addRows(2);
		    data.setValue(0, 0, 'FR');
		    data.setValue(0, 1, 2);
		    data.setValue(1, 0, 'US');
		    data.setValue(1, 1, 1);
			return data;	
		}
        
        function initChart(p_data, p_titleHAxis, p_titleVAxis)
		{
			dataChart = new google.visualization.DataTable();
			dataChart.addColumn('string',p_titleHAxis);
			dataChart.addColumn('number',p_titleVAxis);
			dataChart.addRows(p_data.length);
			i = 0;
			for(key in p_data)
			{
				titre = p_data[key].split('=')[0];
				nombre = parseInt(p_data[key].split('=')[1]);
				dataChart.setValue(i,0,titre);
				dataChart.setValue(i,1,nombre);
				i++;
			}
			return dataChart;
		}
        
        function initDataConf(conferences)
        {
        	
        	 data = new google.visualization.DataTable();
        	 data.addColumn('string', 'Country');
             data.addColumn('string', 'Nb conf�rence');
             data.addRows(conferences.length);
             for(j=0;j<conferences.length;j++)
         	{
            	 conf = conferences[j].split('=');
         		 data.setValue(j,0,conf[0]);
         		 data.setValue(j,1,conf[1]);
         		
         	}
             return data;
        }
        function initDataConfZoom(conferences)
        {
        	 data = new google.visualization.DataTable();
        	 data.addColumn('string', 'City');
             data.addColumn('number', 'Conference');
             data.addRows(conferences.length);
             for(j=0;j<conferences.length;j++)
         	{
            	 lieu = conferences[j].lieu.split(",")[0];
         		 data.setValue(j,0,lieu);
         		 data.setValue(j,1,nbConfParVille(conferences,lieu));
         	}
             return data;
        }
        function initDataDraw(participants)
        {
        	
        	 data = new google.visualization.DataTable();
        	 data.addColumn('string', 'Ann�e');
             data.addColumn('number', 'Nb participants');
             data.addRows(participants.length);
             for(j=0;j<participants.length;j++)
         	{
            	 part = participants[j].split('=');
         		 data.setValue(j,0,part[0]);
         		 num = parseInt(part[1]);
         		 data.setValue(j,1,num);
         	}
             return data;
        }
        function nbConfParVille(conf,ville)
        {
        	nb =0;
        	for(i=0;i<conf.length;i++)
        		{
        			if(conf[i].lieu.split(",")[0] == ville)
        				{
        					nb++;
        				}
        		}
        	return nb;
        }
		function initPie(categories)
		{
			dataPie = new google.visualization.DataTable();
			dataPie.addColumn('string','Categorie');
			dataPie.addColumn('number','Nb');
			dataPie.addRows(categories.length);
			for(i=0;i<categories.length;i++)
			{
				cat = categories[i].split("=");
				laCat = cat[0];
				nbCat = parseInt(cat[1]);
				dataPie.setValue(i,0,laCat);
				dataPie.setValue(i,1,nbCat);
			}
			return dataPie;
		}
		
		function pieChart(categories)
		{
			data = initPie(categories);
			$(".pie_div").each(function(){
				var chart = new google.visualization.PieChart(this);
				chart.draw(data,{width: 450, height: 300,title: 'Categorie'});
			});
		}
		
		function columnChart(p_data, p_name, p_annee, p_title, p_titleHAxis, p_titleVAxis)
		{
			dataChart = initChart(p_data,p_titleHAxis,p_titleVAxis);
			var chart = new google.visualization.ColumnChart(document.getElementById(p_name.toLowerCase()+'_chart_div'));
			chart.draw(dataChart,{height: 480, title: p_title, haxis: {title: p_titleHAxis}, vaxis: {title: p_titleVAxis}});
		}
		
		function drawVisualization(participants)
		{
			data = initDataDraw(participants);
			$(".draw_div").each(function(){
				new google.visualization.LineChart(this).
			      draw(data, {curveType: "function",
			                  width: 500, height: 400,
			                  vAxis: {maxValue: 10}}
			          );
			});
		}
		function tableChart()
		{
			data = initData();
			$(".table_div").each(function(){
				visualization = new google.visualization.Table(this);
				visualization.draw(data, null);
				google.visualization.events.addListener(visualization, 'select', selectHandler); 
			});

			function selectHandler()
			  {
				var selection = visualization.getSelection();
				var message = '';
				for (var i = 0; i < selection.length; i++) {
				  var item = selection[i];
				  if (item.row != null && item.column != null) {
					var str = data.getFormattedValue(item.row, item.column);
					message += '{row:' + item.row + ',column:' + item.column + '} = ' + str + '\n';
				  } else if (item.row != null) {
					var str = data.getFormattedValue(item.row, 0);
					message += '{row:' + item.row + ', column:none}; value (col 0) = ' + str + '\n';
				  } else if (item.column != null) {
					var str = data.getFormattedValue(0, item.column);
					message += '{row:none, column:' + item.column + '}; value (row 0) = ' + str + '\n';
				  }
				}
				if (message == '') {
				  message = '<a onclick="cleanDiv(&quot;details_div&quot;)"></a>';
				}
				document.getElementById('details_div').innerHTML= 
				'<h3> Details </h3>'+message+'<br> ------ ';
			  }
		}
		function geoMap(conf)
		{
			var dataGeoMap = initDataConf(conf);
			var geomap = new google.visualization.GeoMap(document.getElementById('geo_div'));
			geomap.draw(dataGeoMap, null);
			google.visualization.events.addListener(geomap, 'select', selectHandler); 
			function selectHandler(e) 
			{
				rowData = geomap.getSelection()[0].row;
				selectedCountry = dataGeoMap.getValue(rowData,0);
				callGetConference(selectedCountry,'2008');
			}
		}
		function geoZoom(country,conferences)
		{
			content="";
			data = initDataConfZoom(conferences);
			for(i=0;i<data.getNumberOfRows();i++)
			{
				content+=detailsConference(conferences[i]);
				//content+=data.getValue(i,0)+'<a onclick="detailsConference(&quot;conference[i]&quot;)">'+conferences[i].titre+'</a><br>';
			}
			document.getElementById("infoZoom_div").innerHTML = content;
			var options = {};
			options['region'] = country;
			options['colors'] = [0xFF8747, 0xFFB581, 0xc06000]; //orange colors
			options['dataMode'] = 'markers';
			var geozoom = new google.visualization.GeoMap(document.getElementById('geo_div'));
			geozoom.draw(data, options);
			/*google.visualization.events.addListener(geozoom, 'select', selectH); 
			function selectH(e) 
			{
				rowData = geozoom.getSelection()[0].row;
				selectedCity = data.getValue(rowData,0);
				alert(selectedCity);
			}*/
		}
		function detailsConference(conference)
		{
			content = "<b>Titre: </b>"+conference.titre+"<b> Lieu: </b>"+conference.lieu+"<b> Annee: </b>"+conference.annee+"<br>";
			return content;
		}
		function cleanDiv(name)
		{
			document.getElementById(name).innerHTML='';
		}
		