<%@ include file="/init.jsp" %>

<portlet:resourceURL id="/getBillingList" var="getBillingListURL">
</portlet:resourceURL>

<liferay-ui:success key="billing-updated-successfully" message="billing-updated-successfully"/>

<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
	            <form id="filterBilling">
	              	<div class="form-group col-md-3">
	                  <select name="client" id="client" class="form-control">
						<option value="0">Select Client</option>
							<c:forEach items="${clientList }" var="client">
								<option value="${client.clientId }">${client.clientName }</option>
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
	             <table id="billings" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
            		<tbody></tbody>
            	</table>
            </div>
         </div>
      </div>
   </div>
</section>            	

<script type="text/javascript">
        var bookingDataTable="";
        jQuery.noConflict();
        (function($) {
            $(function() {  
            	 AUI().use('aui-base','liferay-portlet-url', function(A) {
            		 bookingDataTable =  $('#billings').DataTable({
            		 "processing": true,
            	     "serverSide": true,
            	     "searching": false,
            	     "pageLength": 50,
            	     "ajax": '${getBillingListURL}',
            		 "order": [],
            		 "columns": [
            		           		{ "data": "client", "name" : "client" , "title" : "Client"},
            	                    { "data": "campaign", "name" : "campaign", "title" : "Campaign"  },
            	                    { "data": "financeYear", "name" : "financeYear", "title" : "Finance Year"  },
            	                    { "data": "bookingDate", "name" : "bookingDate" , "title" : "Booking Date"},
            	                    { "data": "billDocument", "name" : "billDocument" , "title" : "Bill",
            	                    	"render": function(data, type, row, meta){
            	                    		var displayData = '<a href="'+ row.billDocumentURL +'" class="">Download</a>';
            	                    		return displayData;
            	                    	 }
            	                    },
            	                    { "data": "action", "name" : "Action" , "title" : "Action",
            	                    	"render": function(data, type, row, meta){
            	                    		var displayData="";
            	                    			var editBillingURL = Liferay.PortletURL.createRenderURL();
            	                    			editBillingURL.setParameter("billingId",row.billingId);
            	                    			editBillingURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			editBillingURL.setParameter("mvcRenderCommandName","/edit-billing");
            	                    			displayData = '<a href="'+editBillingURL+'" class="btn btn-block btn-primary">Edit</a>';
            	                    		
            	                    			var paymentURL = Liferay.PortletURL.createRenderURL();
            	                    			paymentURL.setParameter("billingId",row.billingId);
            	                    			paymentURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			paymentURL.setParameter("mvcRenderCommandName","/payment");
            	                    			
            	                    			displayData = displayData +  '<a href="'+paymentURL+'" class="btn btn-block btn-primary">Payment</a>';
            	                    			
            	                    			return displayData;
            	                    	 }
            	                    }
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
            
          $("#filterSearch").on('click',function(){
            	var clientId = $("#client").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	var getDocumentURL = '${getBillingListURL}&<portlet:namespace />clientId='+clientId+'&<portlet:namespace />startDate='+startDate+'&<portlet:namespace />endDate='+endDate;
                bookingDataTable.ajax.url(getDocumentURL).load();
			});  
        })(jQuery);
</script>