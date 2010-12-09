let $yearParameter := request:get-parameter("annee","")
let $collection := collection('/db/Raweb/Data')/conferences/conf

let $conferences :=
	for $conf in distinct-values($collection/Quantile[contains(Annee, $yearParameter)]/Lieu/@code)
	return <conferencesparpays><pays>{$conf}</pays><nbConferences>{(count($collection/Quantile[Lieu/@code = $conf]))}</nbConferences></conferencesparpays>

return <conferencesparpays_root>{$conferences}</conferencesparpays_root>