let $yearParameter := request:get-parameter("annee","")
let $collection := collection('/db/Raweb/Data')/conferences/conf

let $conferences :=
	for $conf in distinct-values($collection/Quantile[contains(Annee, $yearParameter)]/Lieu/@code)
	let $count := collection('/db/Raweb/Data')/conferences/conf/Quantile[contains(Annee, $yearParameter)]/Lieu/@code[contains(.,$conf)]
	where($conf != "")
	return <conferencesparpays><pays>{$conf}</pays><nbConferences>{(count($count))}</nbConferences></conferencesparpays>

return <conferencesparpays_root>{$conferences}</conferencesparpays_root>