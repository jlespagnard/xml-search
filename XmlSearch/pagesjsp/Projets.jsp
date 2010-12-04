<br/>
<fieldset>
<legend>Formulaire de recherche</legend>
<table>
	<tr>
		<td width="150px"><label for="recherche">Projet recherché</label> : </td>
		<td width="200px"><input type="text" name="Projet recherché" id="recherche" /></td>
		<td width="200px"><select name="critere" id="critere">
			    <option value="Critere">Critères...</option>
			</select>
		</td>
		<td><input type="submit" value="Rechercher" onclick="recherche()"></td>
	</tr>
</table>
</fieldset>
<br/>
<fieldset id="result" style="display: none">
	<legend>Résultats de la recherche</legend>
</fieldset>