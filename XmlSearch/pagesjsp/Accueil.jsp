<br/>
<div id="b_description" class="accueil">
	<p><h2 class="titre">Description du projet</h2></p>
	<p>
	L'INRIA publie chaque ann&eacute;e le rapport d'activit&eacute; (RA-web) de ses &eacute;quipes de recherche. Les donn&eacute;es recueillies 
	sont stock&eacute;es dans une BD native XML dans un format assez mal structur&eacute; qui &eacute;volue d'ann&eacute;e en ann&eacute;e, et dont 
	l'exploitation est (tr&egrave;s) mal ais&eacute;e. Dans ce projet, en tenant compte de cette contrainte sur la structuration des donn&eacute;es, 
	vous devrez extraire des donn&eacute;es pertinentes qui mettent en perspectives certaines activit&eacute;s de l'INRIA en utilisant les technos
	de g&eacute;olocalisation (GoogleMap ou OpenLayer) comme par exemple la r&eacute;partition sur une carte des chercheurs ayant 
	particip&eacute; &agrave;  une conf&eacute;rence, le nombre de publications r&eacute;alis&eacute;es dans le cadre d'une conf&eacute;rence, 
	etc.</p><br/><br/>
	<p>Objectifs du projet :
	<ul>
	    <li> Installation d'un serveur de donn&eacute;es (BD native XML "eXist") qui h&eacute;bergera les donn&eacute;es et les requetes XQuery 
	    requises</li>
	    <li> Installation d'un serveur Web "Tomcat" qui analysera les requetes client, et les propagera au serveur de donn&eacute;es, 
	    qui &agrave;  son tour les propagera en XML au client Web</li>
	    <li> D&eacute;veloppement d'un client Web pour l'affichage des donn&eacute;es re&ccedil; us dans une carte ou dans un graphique</li>
	</ul>
	</p>
	
	<img src="pagesjsp/img/logo_INRIA.jpg" alt="Logo Inria" class="logo"/>
</div>

<div id="b_conferences" class="accueil" style="display: none">
	<p><h2 class="titre">Conf&eacute;rences</h2></p>
	<p>
	L'onglet "Conf&eacute;rences" contient une carte du monde repr&eacute;sentant le nombre de conf&eacute;rences pour chaque pays. 
	En passant la souris sur un pays, une info bulle contenant le code du pays et le nombre de conf&eacute;rences s'affiche.
	En cliquant sur un pays s'affiche en dessous la liste (titre, lieu et année) de toutes les conf&eacute;rences.
	</p><br/><br/>
</div>

<div id="b_themes" class="accueil" style="display: none">
	<p><h2 class="titre">Th&egrave;mes</h2></p>
	<p>
	L'onglet "Th&egrave;mes" contient, pour chaque ann&eacute;e, un histographique de la r&eacute;partition des projets par th&egrave;me.
	En passant la souris sur un histogramme, une info bulle contenant le libell&eacute; du th&egrave;me et le nombre de projets s'affiche.
	</p><br/><br/>
</div>

<div id="b_cdr" class="accueil" style="display: none">
	<p><h2 class="titre">Centres de recherche</h2></p>
	<p>
	L'onglet "Centres de recherche" contient une carte du monde affichant chaque centre de recherche selon leur adresse sous forme de pin.
	En passant la souris sur un centre de recherche, une info bulle contenant le nom du centre de recherche s'affiche.
	Il est &eacute;galement possible d'afficher le street view en dessous de cette carte.
	</p><br/><br/>
</div>

<div id="b_projets" class="accueil" style="display: none">
	<p><h2 class="titre">Projets</h2></p>
	<p>
	L'onglet "Projets" permet de rechercher un projet par titre, acronyme, th&egrave;me et ann&eacute;e.
	Le r&eacute;sultat de la recherche affiche tous les projets correspondant.
	En cliquant sur un projet, toutes les informations le concernant sont affich&eacute;es.
	Il est &eacute;galement possible d'afficher la liste d&eacute;taill&eacute;e de tous les participants de ce projet, une courbe
	d'&eacute;volution du nombre de participants au cours du temps et un diagramme circulaire repr&eacute;sentant la r&eacute;partition
	des cat&eacute;gories professionnelles des participants.
	</p><br/><br/>
</div>