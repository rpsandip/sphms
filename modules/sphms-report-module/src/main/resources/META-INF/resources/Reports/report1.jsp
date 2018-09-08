

<portlet:resourceURL id="/getLandLoadReport" var="getLandLoadReportURL">

</portlet:resourceURL>
<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
	            <form id="filterProposal">
	              	<div class="form-group col-md-3">
	                  <select name="landLoad" id="landLoad" class="form-control">
							<c:forEach items="${landLoadList}" var="landLoad">
								<option value="${landLoad.landLordId }">${landLoad.firstName} ${landLoad.lastName }</option>
							</c:forEach>	
						</select>
	                </div>
	              	<div class="form-group col-md-3">
	                  <input type="text" class="form-control" name="startDate" id="startDate" placeholder="Start Date"/>
	                </div>
	                <div class="form-group col-md-3">
	                  <input type="text" class="form-control" name="endDate" id="endDate" placeholder="End Date"/>
	                </div>
	                <div class="form-group col-md-3">
	                  <input type=button class="btn btn-primary"  value="Search" id="filterSearch">
					 <input type=button class="btn btn-primary"  value="Export" id="export">
	                </div>
	              </form>
	              <br/>
	             <table id="landLoadData" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
            		<tbody></tbody>
            	</table>
            </div>
         </div>
      </div>
   </div>
</section>            	

 <script type="text/javascript">
        var landLoadDataTable="";
       
        $('#startDate').datepicker({
    		format: 'dd/mm/yyyy',  
    	    autoclose: true
      }); 
      
      $('#endDate').datepicker({
  		format: 'dd/mm/yyyy',  
  	    autoclose: true
      }); 
     
      $('#endDate').datepicker('setDate', 'today');
      
      var d = new Date();
      d.setFullYear(d.getFullYear() - 1);
      $('#startDate').datepicker('setDate', d);

        
        jQuery.noConflict();
        (function($) {
            $(function() {  
            	 AUI().use('aui-base','liferay-portlet-url', function(A) {
            		 var LandLoadId = $("#landLoad").val();
                 	 var startDate = $("#startDate").val();
                 	 var endDate = $("#endDate").val();
            		 var getDocumentURL = '${getLandLoadReportURL}&<portlet:namespace />landLoadId='+LandLoadId+'&<portlet:namespace />startDate='+startDate+'&<portlet:namespace />endDate='+endDate;
            		 landLoadDataTable =  $('#landLoadData').DataTable({
            		 "processing": true,
            	     "searching": false,
            	     "pageLength": 50,
            	     "ajax": getDocumentURL,
            		 "order": [],
            		 "columns": [
            	                    { "data": "landLoadfirstName", "name" : "landLoadfirstName", "title" : "First Name"  },
            	                    { "data": "landLoadlastName", "name" : "landLoadlastName" , "title" : "Last Name"},
            	                    { "data": "landLoadcity", "name" : "landLoadcity" , "title" : "City"},
            	                    { "data": "landLoadamount", "name" : "landLoadamount" , "title" : "Amount"},
            	                    { "data": "paymentDate", "name" : "paymentDate" , "title" : "Payment Date"},
            	                    { "data": "paymenttype", "name" : "paymenttype" , "title" : "Payment Type"},
            	                    { "data": "hordingtitle", "name" : "hordingtitle" , "title" : "Hoarding"}
            	                    
            	                ]
            	 });
            });
          });
          
                
        $("#filterSearch").on('click',function(){
            	var LandLoadId = $("#landLoad").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	var getDocumentURL = '${getLandLoadReportURL}&<portlet:namespace />landLoadId='+LandLoadId+'&<portlet:namespace />startDate='+startDate+'&<portlet:namespace />endDate='+endDate;
            	landLoadDataTable.ajax.url(getDocumentURL).load();
		 });
        
        $("#export").on('click',function(){
        	var LandLoadId = $("#landLoad").val();
        	var startDate = $("#startDate").val();
        	var endDate = $("#endDate").val();
        	var getDocumentURL = '${getLandLoadReportURL}&<portlet:namespace />landLoadId='+LandLoadId+'&<portlet:namespace />startDate='+startDate+'&<portlet:namespace />endDate='+endDate+'&<portlet:namespace />isExport='+true;
	 		window.location.href=getDocumentURL;
        });
        
        
        
        })(jQuery);
    </script> 