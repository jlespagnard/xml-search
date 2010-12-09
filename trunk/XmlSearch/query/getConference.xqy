let $yearParameter := request:get-parameter("annee","")
let $paysParameter := request:get-parameter("pays","")
let $titreParameter := request:get-parameter("titre","")

let $conferences :=
	for $conf in collection('/db/Raweb/Data')/conferences/conf/Quantile[contains(Annee,$yearParameter) and contains(ancestor::conf/TitreConference,$titreParameter) and contains(Lieu/@code, $paysParameter)]
	return <conference>{$conf/ancestor::conf/TitreConference}{$conf/Lieu}{$conf/Annee}</conference>

return <conferences>{$conferences}</conferences>