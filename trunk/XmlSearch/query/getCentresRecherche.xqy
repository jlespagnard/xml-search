let $anneeDebut := request:get-parameter("anneeDebut",2006)
let $anneeFin := request:get-parameter("anneeFin",2009)

let $adresse1 := 
	for $centre in collection('/db/Raweb/Bastri')/AdresseGeographique_root/AdresseGeographique
	return <centre>{$centre/idCR} {$centre/libelle}{$centre/latitude}{$centre/longitude}</centre> 

let $adresse2 :=
	for $anneeCourrante in ($anneeDebut to $anneeFin)
		let $collection := concat('/db/Raweb/RA',$anneeCourrante,'/Add')
			for $centre2 in collection($collection)/adresseGeographiques/adresseGeographique
			return <centre> {$centre2/idCR} {$centre2/libelle}{$centre2/latitude}{$centre2/longitude}</centre>

return <centres>{$adresse1}{$adresse2}</centres>