<br/>
<fieldset>
<legend>Formulaire de recherche</legend>
<table>
	<tr>
		<td width="150px"><label for="recherche">Projet recherch�</label> : </td>
		<td width="200px"><input type="text" name="Projet recherch�" id="recherche" /></td>
		<td width="200px"><select name="critere" id="critere">
			    <option value="Critere">Crit�res...</option>
			</select>
		</td>
		<td><input type="submit" value="Rechercher" onclick="recherche()"></td>
	</tr>
</table>
</fieldset>
<br/>
<fieldset id="result" style="display: none">
	<legend>R�sultats de la recherche</legend>
</fieldset>