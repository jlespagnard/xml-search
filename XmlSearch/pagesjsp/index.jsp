<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ page contentType="text/html;charset=ISO-8859-1" %>
	<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
	<meta name="Description" content="My RAweb - Team XML-Search" />  
	<title>My RAweb by XML-Search</title>
	<style type="text/css">
		html { height: 100% }
		body { height: 100%; margin: 0px; padding: 0px }
		#map_canvas { height: 40%;
				width: 100%;
			}
			
		#pano		{ 	height: 40%;
				width: 100%;
			}
			
		#pie_div {  margin-top:30px; }
		#geo_div	{  margin-top:30px; }
		#geozoom_div
		#bar_div {  margin-top:30px; }
		#table_div {  margin-top:30px; }
		#details_div
	</style>
	<link rel="stylesheet" media="screen" type="text/css" title="Design" href="pagesjsp/stylesheet.css" />
	<script type="text/javascript" src="pagesjsp/jquery.js"></script>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script type="text/javascript" src="ScriptJS/scriptMap.js"></script>
	<script type="text/javascript" src="ScriptJS/scriptGraph.js"></script>
	<script type="text/javascript">
		google.load("visualization", "1", {packages:["corechart"]});
		google.load("visualization", "1", {packages:["geomap"]});
		google.load("visualization", "1", {packages:["table"]});
		google.setOnLoadCallback(geoMap);
	</script>
	<script type="text/javascript" src="pagesjsp/index.js"></script>
</head>
<body onload='initMap();'>
	<div> 
		<p class="titreprincipal">XML Search</p>  
		<br/><br/>
		<ul class="tabs">
			<li><a href="#tab1">Accueil</a></li>
			<li><a href="#tab2">Conférences</a></li>
			<li><a href="#tab3">Thèmes</a></li>
			<li><a href="#tab4">Centres de recherche</a></li>
			<li><a href="#tab5">Projets</a></li>
		</ul>
		<hr id="sep">
	</div>
	<div id="tab_container">
		<div id="tab1" class="tab_content">
			<jsp:include page="Accueil.jsp"/>
		</div>
		<div id="tab2" class="tab_content">
			<jsp:include page="Conferences.jsp"/>
		</div>
		<div id="tab3" class="tab_content">
			<jsp:include page="Theme.jsp"/>
		</div>
		<div id="tab4" class="tab_content">
			<jsp:include page="CentreRech.jsp"/>
		</div>
		<div id="tab5" class="tab_content">
			<jsp:include page="Projets.jsp"/>
		</div>
	</div>
</body>
</html>