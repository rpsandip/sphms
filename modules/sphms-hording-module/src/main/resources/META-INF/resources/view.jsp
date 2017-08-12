<%@ include file="/init.jsp" %>

<liferay-ui:success key="hording-added-successfully" message="hording-added-successfully"/>
<liferay-ui:success key="hording-updated-successfully" message="hording-updated-successfully"/>

<portlet:renderURL var="addHordingURL">
        <portlet:param name="mvcRenderCommandName" value="/add_hording" />
</portlet:renderURL>


<a href="${addHordingURL}" class="btn btn-primary">Add Hoarding</a>

<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
            	<table id="hordings" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
					<thead>
			            <tr>
			                <th><h3>Hoardings</h3></th>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${hordingBeanList }" var="hordingBean">
            			<tr>
            				<td> 
            					<div class="row">
	        						<div class="col-md-4">
	        							<img src="${hordingBean.normalImageURL }" style="height:3.8cm;width: 6.0cm;">
	        						</div>
	        						<div class="col-md-8">
	        							<div>
	        								<span class="pull-left">
	        									<h4>${hordingBean.title }, ${ hordingBean.city}</h3>
	        								</span>
	        								<span class="pull-right">
	        									<h4>Rs. ${hordingBean.pricePerMonth }/PM</h4>
	        								</span>
	        							</div>
	        							<div style="clear: both;">
	        								<span><b>Type:</b> ${hordingBean.hordingType } </span>
	        							</div>
	        							<div style="clear: both;">
	        								<b>Size :</b> ${hordingBean.size }(Sq. Ft)
	        							</div>
	        							<div style="clear: both;">
	        								<b>Land Lord : </b> ${hordingBean.landLordName }
	        							</div>
	        							<div style="clear: both;">
	        								<div class="pull-right">
		        								<portlet:renderURL var="editHordingURL">
	       							 				<portlet:param name="mvcRenderCommandName" value="/add_hording" />
	       							 				<portlet:param name="hordingId" value="${ hordingBean.hordingId}" />
												</portlet:renderURL>
												<portlet:renderURL var="viewHordingURL">
	       							 				<portlet:param name="mvcRenderCommandName" value="/view_hording_detail" />
	       							 				<portlet:param name="hordingId" value="${ hordingBean.hordingId}" />
												</portlet:renderURL>
												<a href="${editHordingURL }" class="">Edit</a>&nbsp; &nbsp;
												<a href="${viewHordingURL }" class="">View Detail</a>
											</div>
	        							</div>
	        						</div>
	        					</div>	
	        			 	</td>
        			    </tr>
           			</c:forEach>
           			</tbody>
				</table>
            </div>
        </div>
     </div>
  </div>
</section>       
<script type="text/javascript">
        jQuery.noConflict();
        (function($) {
            $(function() {  
            	 $('#hordings').DataTable({
            		 "pageLength": 50,
            		 "order": []
            	 });
            });
        })(jQuery);
 </script>