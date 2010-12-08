
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
		
		function pieChart()
		{
			data = initData();
			var chart = new google.visualization.PieChart(document.getElementById('pie_div'));
			chart.draw(data,{width: 450, height: 300,title: 'Le suicide, des sensations pures'});	
			google.visualization.events.addListener(chart, 'select', selectHandler);
		
			function selectHandler(e) 
			{
				geoMap();
			}
		}
		function barChart()
		{
			data = initData();
			 var bar = new google.visualization.BarChart(document.getElementById('bar_div')).draw(data,
            {title:"Yearly Coffee Consumption by Country",
            width:600, height:400,
            vAxis: {title: "Year"},
            hAxis: {title: "Cups"}}
			);
			google.visualization.events.addListener(bar, 'select', selectHandler);
		
			function selectHandler(e) 
			{
				alert('tg');
			}
		}
		function tableChart()
		{
			data = initData();
			visualization = new google.visualization.Table(document.getElementById('table_div'));
			visualization.draw(data, null);
			google.visualization.events.addListener(visualization, 'select', selectHandler); 

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
		function geoMap()
		{
			data = initData();
			var geomap = new google.visualization.GeoMap(document.getElementById('geo_div'));
			geomap.draw(data, null);
			message='';
			for(i=0;i<data.getNumberOfRows();i++)
			{
				message+='<b style="text-decoration:none" onclick="geoZoom(&quot;'+data.getValue(i,0)+'&quot;);pieChart()">'+data.getValue(i,0)+'</b><br>';
			}	
			message+='<b style="text-decoration:none" onclick="geoMap();cleanDiv(&quot;pie_div&quot;)">Retour carte</b> ';
			document.getElementById('geozoom_div').innerHTML=
			//'<b style="text-decoration:none" onclick="geoZoom(&quot;'+argZoom+'&quot;);pieChart()">'+data.getValue(1,0)+'</b><br><b style="text-decoration:none" onclick="geoMap();cleanDiv(&quot;pie_div&quot;)">Retour carte</b> ';
			message;
			function selectHandler(e) 
			{
				alert('tg');
			}
		}
		
		function geoZoom(country)
		{
			data = new google.visualization.DataTable();
			data.addColumn('string', 'Ville');
			data.addColumn('number', 'Nb conférence');
			data.addRows(2);
			data.setValue(0, 0, 'Paris');
			data.setValue(0, 1, 2);
			data.setValue(1, 0, 'Nice');
			data.setValue(1, 1, 1);
				
			
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
		