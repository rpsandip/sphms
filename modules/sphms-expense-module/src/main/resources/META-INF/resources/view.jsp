<%@ include file="/init.jsp" %>

<liferay-ui:success key="expnese-add-suceess" message="expnese-add-suceess"/>
<liferay-ui:success key="expense-update-success" message="expense-update-success"/>

<portlet:renderURL var="addExpenseURL">
        <portlet:param name="mvcRenderCommandName" value="/add_expense" />
</portlet:renderURL>
<a href="${addExpenseURL}" class="btn btn-primary">Add Expense</a>

<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
            	<table id="expenseList" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
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
            		 resourceURL.setPortletId('com_sphms_expense_portlet_portlet_ExpenseModulePortlet');
            		 resourceURL.setResourceId('/getExpenseList');
            		 
            		 bookingDataTable =  $('#expenseList').DataTable({
            		 "processing": true,
            	     "serverSide": true,
            	     "searching": false,
            	     "pageLength": 50,
            	     "ajax": resourceURL.toString(),
            		 "order": [],
            		 "columns": [
            		           		{ "data": "type", "name" : "type" , "title" : "Type"},
            	                    { "data": "amount", "name" : "amount", "title" : "Amount"  },
            	                    { "data": "description", "name" : "description", "title" : "Description"  },
            	                    { "data": "expenseDate", "name" : "expenseDate" , "title" : "Expense Date"},
            	                    { "data": "action", "name" : "Action" , "title" : "Action",
            	                    	"render": function(data, type, row, meta){
            	                    		var displayData="";
            	                    			var editExpenseURL = Liferay.PortletURL.createRenderURL();
            	                    			editExpenseURL.setParameter("expenseId",row.expenseId);
            	                    			editExpenseURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			editExpenseURL.setParameter("mvcRenderCommandName","/add_expense");
            	                    			displayData = '<a href="'+editExpenseURL+'" class="btn btn-block btn-primary">Edit</a>';
            	                    			
            	                    			return displayData;
            	                    	 }
            	                    }
            	                ]
            	 });
            		 
                     $("#filterSearch").on('click',function(){
                     	var clientId = $("#client").val();
                     	var startDate = $("#startDate").val();
                     	var endDate = $("#endDate").val();
                     	var resourceURL= Liferay.PortletURL.createResourceURL();
               		 	resourceURL.setPortletId('com_sphms_portlet_portlet_BillingModulePortlet');
               		 	resourceURL.setResourceId('/getBillingList');
               		 resourceURL.setParameter('searchclient',clientId);
               		 resourceURL.setParameter('searchStartDate',startDate);
               		 resourceURL.setParameter('searchEndDate',endDate);
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