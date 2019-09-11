function removeTableRow(indx){
	var oTable = $('#example').dataTable();   
  // Immediately remove the first row
  	oTable.fnDeleteRow( indx );
}
function removeAll(){
	var oSettings = $('#example').dataTable().fnSettings();
	var iTotalRecords = oSettings.fnRecordsTotal();
	for (i=0;i<=iTotalRecords;i++) {
		$('#example').dataTable().fnDeleteRow(0,null,true);
	}
}
function confirmDelete(){
	var r=confirm("Are you sure to Delete the Record.");
	if (r==true)   			
		return true;
 	else
		return false;
}