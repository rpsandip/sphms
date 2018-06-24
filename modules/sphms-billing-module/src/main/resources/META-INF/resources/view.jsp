<%@ include file="/init.jsp" %>

<portlet:resourceURL id="/getBillingList" var="getBillingListURL">
</portlet:resourceURL>

<liferay-ui:success key="billing-updated-successfully" message="billing-updated-successfully"/>
<liferay-ui:success key="publish-bill-success" message="publish-bill-success"/>
<liferay-ui:error key="publish-bill-err" message="publish-bill-err"/>

<liferay-ui:error key="err-update-booking" message="err-update-booking"/>
<liferay-ui:success key="po-update-success" message="po-update-success"/>

<liferay-ui:error key="error-po-publish" message="error-po-publish"/>
<liferay-ui:success key="po-publish-success" message="po-publish-success"/>


<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
	            <form id="filterBilling">
	              	<div class="form-group col-md-2">
	                  <select name="customCompany" id="customCompany" class="form-control">
						<option value="0">Select Company</option>
							<c:forEach items="${companyList }" var="company">
								<option value="${company.companyId }">${company.name }</option>
							</c:forEach>	
						</select>
	                </div>
	              	<div class="form-group col-md-2">
	                  <select name="searchclient" id="client" class="form-control">
						<option value="0">Select Client</option>
							<c:forEach items="${clientList }" var="client">
								<option value="${client.clientId }">${client.clientName }</option>
							</c:forEach>	
						</select>
	                </div>
	                <div class="form-group col-md-2">
	                  <select name="status" id="status" class="form-control">
						<option value="">Select Status</option>
							<option value="0">Created</option>
							<option value="2">Published</option>
						</select>
	                </div>
	              	<div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchStartDate" id="startDate" placeholder="Start Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type="text" class="form-control" name="searchEndDate" id="endDate" placeholder="End Date"/>
	                </div>
	                <div class="form-group col-md-2">
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
            		 
            		 var resourceURL= Liferay.PortletURL.createResourceURL();
            		 resourceURL.setPortletId('com_sphms_portlet_portlet_BillingModulePortlet');
            		 resourceURL.setResourceId('/getBillingList');
            		 
            		 bookingDataTable =  $('#billings').DataTable({
            		 "processing": true,
            	     "serverSide": true,
            	     "searching": false,
            	     "pageLength": 50,
            	     "bSort": false,
            	     "ajax": resourceURL.toString(),
            		 "order": [],
            		 "columns": [
            		           		{ "data": "client", "name" : "client" , "title" : "Client"},
            		           		{ "data": "clientCity", "name" : "clientCity" , "title" : "Client City"},
            	                    { "data": "campaign", "name" : "campaign", "title" : "Campaign"  },
            	                    { "data": "financeYear", "name" : "financeYear", "title" : "Finance Year"  },
            	                    { "data": "bookingDate", "name" : "bookingDate" , "title" : "Booking Date"},
            	                    { "data": "billNo", "name" : "billNo" , "title" : "Bill No"},
            	                    { "data": "billDocument", "name" : "billDocument" , "title" : "Bill",
            	                    	"render": function(data, type, row, meta){
            	                    		var displayData = '';
            	                    			//'<a href="'+ row.billDocumentURL +'" class="">Download</a>';
            	                    		
            	                    		var downloadBillURL = Liferay.PortletURL.createResourceURL();
            	                    		downloadBillURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    		downloadBillURL.setResourceId('/download-bill');
            	                    		downloadBillURL.setParameter("billType",'ad-space-bill');
            	                    		downloadBillURL.setParameter("billingId",row.billingId);
            	                    		
            	                    		displayData = displayData +  '<a href="'+downloadBillURL.toString()+'" class="btn btn-block btn-primary">Download</a>';
            	                    		
            	                    		return displayData;
            	                    	 }
            	                    },
            	                    { "data": "status", "name" : "status" , "title" : "Status"},
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
            	                    			
            	                    			var poDetailURL = Liferay.PortletURL.createRenderURL();
            	                    			poDetailURL.setParameter("billingId",row.billingId);
            	                    			poDetailURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			poDetailURL.setParameter("mvcRenderCommandName","/po_detail");
            	                    			
            	                    			displayData = displayData +  '<a href="'+poDetailURL+'" class="btn btn-block btn-primary">Generated PO</a>';
            	                    			
            	                    			var poDetailURL = Liferay.PortletURL.createRenderURL();
            	                    			poDetailURL.setParameter("billingId",row.billingId);
            	                    			poDetailURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			poDetailURL.setParameter("mvcRenderCommandName","/upload_client_po");
            	                    			
            	                    			displayData = displayData +  '<a href="'+poDetailURL+'" class="btn btn-block btn-primary">Client PO</a>';
            	                    			
            	                    			if(row.status=="Created"){
	            	                    			var publishBillURL = Liferay.PortletURL.createActionURL();
	            	                    			publishBillURL.setParameter("billingId",row.billingId);
	            	                    			publishBillURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
	            	                    			publishBillURL.setName("/publish_bill");
	            	                    			
	            	                    			displayData = displayData +  '<a href="'+publishBillURL+'" class="btn btn-block btn-primary">PUBLISH</a>';
            	                    			}
            	                    			return displayData;
            	                    	 }
            	                    }
            	                ]
            	 });
            		 
                     $("#filterSearch").on('click',function(){
                     	var clientId = $("#client").val();
                     	var startDate = $("#startDate").val();
                    	var companyId = $("#customCompany").val();
                     	var endDate = $("#endDate").val();
                     	var status = $("#status").val();
                     	var resourceURL= Liferay.PortletURL.createResourceURL();
               		 	resourceURL.setPortletId('com_sphms_portlet_portlet_BillingModulePortlet');
               		 	resourceURL.setResourceId('/getBillingList');
               		    resourceURL.setParameter('searchclient',clientId);
               		    resourceURL.setParameter('searchStartDate',startDate);
               		    resourceURL.setParameter('searchEndDate',endDate);
               		    resourceURL.setParameter('customCompany',companyId);
               		 	resourceURL.setParameter('status',status);
                     	var getDocumentURL = resourceURL.toString();
                         bookingDataTable.ajax.url(getDocumentURL).load();
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
            
        })(jQuery);
</script>