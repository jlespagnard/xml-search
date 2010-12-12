
		var dataGeoMap;
        function initData() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Country');
        data.addColumn('number', 'Nb conférence');
        data.addRows(2);
        data.setValue(0, 0, 'FR');
        data.setValue(0, 1, 2);
        data.setValue(1, 0, 'US');
        data.setValue(1, 1, 1);
		return data;	
		
		}
        function initDataConf(conferences)
        {
        	
        	 data = new google.visualization.DataTable();
        	 data.addColumn('string', 'Country');
             data.addColumn('string', 'Nb conférence');
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
             alert(conferences.length);
             for(j=0;j<conferences.length;j++)
         	{
            	 lieu = conferences[j].lieu.split(",")[0];
         		 data.setValue(j,0,lieu);
         		 data.setValue(j,1,nbConfParVille(conferences,lieu));
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
		function initPie(themes)
		{
			dataPie = new google.visualization.DataTable();
			dataPie.addColumn('string','Theme');
			dataPie.addColumn('number','Nb theme');
			dataPie.addRows(themes.length);
		}
		function pieChartgeo()
		{
			$("#resultconf").show();
			data = initData();
			$(".piegeo_div").each(function(){
				var chart = new google.visualization.PieChart(this);
				chart.draw(data,{width: 450, height: 300,title: 'Le suicide, des sensations pures'});	
				google.visualization.events.addListener(chart, 'select', selectHandler);
			});
		
			function selectHandler(e) 
			{
				geoMap();
			}
		}
		
		function pieChart()
		{
			data = initData();
			$(".pie_div").each(function(){
				var chart = new google.visualization.PieChart(this);
				chart.draw(data,{width: 450, height: 300,title: 'Le suicide, des sensations pures'});	
				google.visualization.events.addListener(chart, 'select', selectHandler);
			});
			
			function selectHandler(e) 
			{
				geoMappie();
			}
		}
		
		function barChart()
		{
			data = initData();
			$(".bar_div").each(function(){
				var bar = new google.visualization.BarChart(this).draw(data,
	            {title:"Yearly Coffee Consumption by Country",
	            width:600, height:400,
	            vAxis: {title: "Year"},
	            hAxis: {title: "Cups"}}
				);
				google.visualization.events.addListener(bar, 'select', selectHandler);
			});
		
			function selectHandler(e) 
			{
				function selectHandler(e) 
				{
					var selection = geomap.getSelection();
					geoZoom(data.getValue(selection[0].row,0));
					geoMap;
				}
			}
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
			dataGeoMap = initDataConf(conf);

			var geomap = new google.visualization.GeoMap(document.getElementById('geo_div'));
			geomap.draw(dataGeoMap, null);

//			message='';
//			for(i=0;i<data.getNumberOfRows();i++)
//			{
//				message+='<b style="text-decoration:none" onclick="geoZoom(&quot;'+data.getValue(i,0)+'&quot;);pieChart()">'+data.getValue(i,0)+'</b><br>';
//			}	
//			message+='<b style="text-decoration:none" onclick="geoMap();cleanDiv(&quot;pie_div&quot;)">Retour carte</b> ';
			//document.getElementById('geozoom_div').innerHTML=
			//'<b style="text-decoration:none" onclick="geoZoom(&quot;'+argZoom+'&quot;);pieChart()">'+data.getValue(1,0)+'</b><br><b style="text-decoration:none" onclick="geoMap();cleanDiv(&quot;pie_div&quot;)">Retour carte</b> ';
			//message;

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
			data = initDataConfZoom(conferences);
			alert(data.getValue(0,0));
			var options = {};
			options['region'] = country;
			options['colors'] = [0xFF8747, 0xFFB581, 0xc06000]; //orange colors
			options['dataMode'] = 'markers';
			
			
			var geozoom = new google.visualization.GeoMap(document.getElementById('geo_div'));
			geozoom.draw(data, options);
			
		}
		
		function cleanDiv(name)
		{
			document.getElementById(name).innerHTML='';
		}
		