<br/><p><h2 class="titre">Description du projet</h2></p>
<p class="texte">
L'INRIA publie chaque ann�e le rapport d'activit� (RA-web) de ses �quipes de recherche. Les donn�es recueillies sont stock�es dans une BD native XML dans un format assez mal structur� qui �volue d'ann�e en ann�e, et dont l'exploitation est (tr�s) mal ais�e. Dans ce projet, en tenant compte de cette contrainte sur la structuration des donn�es, vous devrez extraire des donn�es pertinentes qui mettent en perspectives certaines activit�s de l'INRIA en utilisant les technos de g�olocalisation (GoogleMap ou OpenLayer) comme par exemple la r�partition sur une carte des chercheurs ayant particip� � une conf�rence, le nombre de publications r�alis�es dans le cadre d'une conf�rence, etc.</p><br/><br/>
<p>Objectifs du projet :
<ul>
    <li> Installation d'un serveur de donn�es (BD native XML "eXist") qui h�bergera les donn�es et les requetes XQuery requises</li>
    <li> Installation d'un serveur Web "Tomcat" qui analysera les requetes client, et les propagera au serveur de donn�es, qui � son tour les propagera en XML au client Web</li>
    <li> D�veloppement d'un client Web pour l'affichage des donn�es re�us dans une carte ou dans un graphique</li>
</ul>
</p>

<img src="pagesjsp/img/logo_INRIA.jpg" alt="Logo Inria" class="logo"/>