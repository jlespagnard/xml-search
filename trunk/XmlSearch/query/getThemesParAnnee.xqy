let $annee := request:get-parameter("annee",2009)
let $collection := concat('/db/Raweb/RA',$annee)

let $infos :=
	if($annee="2009")
	then for $projet in distinct-values(collection($collection)/raweb/identification/theme-de-recherche)
		return <themesparannee><theme>{$projet}</theme> <nbprojets>{(count(collection($collection)/raweb/identification/theme-de-recherche[contains (.,$projet)]))}</nbprojets></themesparannee>
	else for $projet in distinct-values(collection($collection)/raweb/identification/theme)
		return <themesparannee><theme>{$projet}</theme> <nbprojets>{(count(collection($collection)/raweb/identification/theme[contains (.,$projet)]))}</nbprojets></themesparannee>
		
return <themesparannee_root>{$infos}</themesparannee_root>