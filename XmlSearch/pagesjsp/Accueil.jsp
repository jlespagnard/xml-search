<br/><p><h2 class="titre">Description du projet</h2></p>
<p class="texte">
L'INRIA publie chaque année le rapport d'activité (RA-web) de ses équipes de recherche. Les données recueillies sont stockées dans une BD native XML dans un format assez mal structuré qui évolue d'année en année, et dont l'exploitation est (très) mal aisée. Dans ce projet, en tenant compte de cette contrainte sur la structuration des données, vous devrez extraire des données pertinentes qui mettent en perspectives certaines activités de l'INRIA en utilisant les technos de géolocalisation (GoogleMap ou OpenLayer) comme par exemple la répartition sur une carte des chercheurs ayant participé à une conférence, le nombre de publications réalisées dans le cadre d'une conférence, etc.</p><br/><br/>
<p>Objectifs du projet :
<ul>
    <li> Installation d'un serveur de données (BD native XML "eXist") qui hébergera les données et les requetes XQuery requises</li>
    <li> Installation d'un serveur Web "Tomcat" qui analysera les requetes client, et les propagera au serveur de données, qui à son tour les propagera en XML au client Web</li>
    <li> Développement d'un client Web pour l'affichage des données reçus dans une carte ou dans un graphique</li>
</ul
</p>

<img src="pagesjsp/img/logo_INRIA.jpg" alt="Logo Inria" class="logo"/>