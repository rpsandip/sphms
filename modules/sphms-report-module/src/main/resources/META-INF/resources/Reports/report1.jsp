

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
        jQuery.noConflict();
        (function($) {
            $(function() {  
            	 AUI().use('aui-base','liferay-portlet-url', function(A) {
            		 landLoadDataTable =  $('#landLoadData').DataTable({
            		 "processing": true,
            	     "serverSide": true,
            	     "searching": false,
            	     "pageLength": 50,
            	     "ajax": '${getLandLoadReportURL}',
            		 "order": [],
            		 "columns": [
            	                    { "data": "landLoadfirstName", "name" : "landLoadfirstName", "title" : "landLoadfirstName"  },
            	                    { "data": "landLoadlastName", "name" : "landLoadlastName" , "title" : "landLoadlastName"},
            	                    { "data": "landLoadlocation", "name" : "landLoadlocation" , "title" : "landLoadlocation"},
            	                    { "data": "landLoadcity", "name" : "landLoadcity" , "title" : "landLoadcity"},
            	                    { "data": "landLoadphoneNo", "name" : "landLoadphoneNo" , "title" : "landLoadphoneNo"},
            	                    { "data": "landLoadamount", "name" : "landLoadamount" , "title" : "landLoadamount"},
            	                    { "data": "landLoadchequeNo", "name" : "landLoadchequeNo" , "title" : "landLoadchequeNo"},
            	                    { "data": "landLoadbankName", "name" : "landLoadbankName" , "title" : "landLoadbankName"},
            	                    { "data": "hordingtitle", "name" : "hordingtitle" , "title" : "hordingtitle"},
            	                    { "data": "hordinglocation", "name" : "hordinglocation" , "title" : "hordinglocation"},
            	                    { "data": "hordingcity", "name" : "hordingcity" , "title" : "hordingcity"}
            	                ]
            	 });
            });
          });
          
          $('#startDate').datepicker({
        		format: 'dd/mm/yyyy',  
        	    autoclose: true
          }); 
          
          $('#endDate').datepicker({
      		format: 'dd/mm/yyyy',  
      	    autoclose: true
        }); 
          Date currentDate=new Date();
        $('#endDate').datepicker('setDate', currentDate);
        
        $("#filterSearch").on('click',function(){
            	var LandLoadId = $("#landLoad").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	var getDocumentURL = '${getLandLoadReportURL}&<portlet:namespace />landLoadId='+LandLoadId+'&<portlet:namespace />startDate='+startDate+'&<portlet:namespace />endDate='+endDate;
            	landLoadDataTable.ajax.url(getDocumentURL).load();
			});  
        })(jQuery);
    </script> 