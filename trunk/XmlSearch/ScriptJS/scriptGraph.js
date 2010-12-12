
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
			i = 0;
			for(key in themes)
				{
					dataPie.setValue(i,0,key);
					dataPie.setValue(i,1,themes[key])
					i++;
				}
			return dataPie;
		}
		
		function pieChart(themes)
		{
			data = initPie(themes);
			var chart = new google.visualization.PieChart(document.getElementById('pie_div'));
			chart.draw(data,{width: 450, height: 300,title: 'Le suicide, des sensations pures'});	
			google.visualization.events.addListener(chart, 'select', selectHandler);
			function selectHandler(e) 
			{
				alert("tg");
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
			data = initDataConfZoom(conferences);
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
		