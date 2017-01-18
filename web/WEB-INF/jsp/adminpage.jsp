<%-- 
    Document   : adminlogin
    Created on : 22 Sep, 2014, 9:58:51 PM
    Author     : Welcome
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <meta name="description" content="">
            <meta name="author" content="Souvik Das">
            <title>Home</title>
            
               <link type="text/css" href="<c:url value="/resources/css/jquery-ui-1.10.4.css" />" rel="stylesheet">
            
             <link type="text/css" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />" rel="stylesheet">
          <script async type="text/javascript" src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js" />"></script>
            
            <link type="text/css" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css" />" rel="stylesheet">            
            
         
             <script  type="text/javascript" src="<c:url value="//ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"/>"></script>
          
            <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
            
            
            <script async type="text/javascript" src="<c:url value="//cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.3.0/bootbox.min.js" />"></script>
             <link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">    
             
           <link type="text/css" href="<c:url value="/resources/css/dashboard.css" />" rel="stylesheet"> 
           <script src="<c:url value="/resources/js/dashboard.js" />" type="text/javascript"></script>
     <link type="text/css" href="<c:url value="/resources/css/bar.css" />" rel="stylesheet"> 
            <%--
           
           <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
           <script type="text/javascript" src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.js"></script>
           <link type="text/css" rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.css">
            --%>
            
           
           
           <%--
            <script type="text/javascript" src="<c:url value="/resources/js/doc.js" />"></script> 
            <script type="text/javascript" src="<c:url value="/resources/js/respond.js" />"></script>
                 --%>
               
                 
            
    </head>
    <body>
        <%--<tiles:insertAttribute name="navigation"/>
        <br/>--%>
    

  
       <tiles:insertAttribute name="navigation"/>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Insights</h1>

          <div class="row placeholders">
            <div  style="background-color: rgba(240,255,255,0.2);border: #0077b3 1px;border-style:solid ;border-radius: 5px;margin: 5px 5px 5px 5px;padding-left: 10px;padding-right:10px" class="col-xs-5 col-sm-3 placeholder">
                <br/>
              <span style="font-size: 30px" class="glyphicon glyphicon-certificate"></span><c:if test="${relevance_stat gt relevance}">
                                                    <span style="color:green" class="glyphicon glyphicon-arrow-up"></span>

                                                </c:if>
                                                  <c:if test="${relevance_stat eq relevance}">
                                                    <span style="color:gray" class="glyphicon glyphicon-check"></span>

                                                </c:if>
                                                    <c:if test="${relevance_stat lt relevance}">
                                                    <span style="color:red" class="glyphicon glyphicon-arrow-down"></span>

                                                </c:if>
             <br/>
            <a  href="${pageContext.request.contextPath}/admin/past/7/relevance"> <h4> Relevance</h4>  </a>
             <span class="text-muted">${relevance}</span>
                      <br/>
                      <br/>
            </div>
             
             
             
            <div style="background-color: rgba(240,255,255,0.2);border: #0077b3 1px;border-style:solid ;border-radius: 5px;margin: 5px 5px 5px 5px;padding-left: 10px;padding-right:10px" class="col-xs-5 col-sm-3 placeholder">
               <br/>
              <span  style="font-size: 30px"  class="glyphicon glyphicon-list-alt"></span><c:if test="${materials_stat gt materials}">
                                                   <span style="color:green" class="glyphicon glyphicon-arrow-up"></span>

                                               </c:if>
                                                 <c:if test="${materials_stat eq materials}">
                                                   <span style="color:gray" class="glyphicon glyphicon-check"></span>

                                               </c:if>
                                                   <c:if test="${materials_stat lt materials}">
                                                   <span style="color:red" class="glyphicon glyphicon-arrow-down"></span>

                                               </c:if>
             <br/>
              <a  href="${pageContext.request.contextPath}/admin/past/7/materials"> <h4>Materials</h4>  </a>
              <span class="text-muted">${materials}</span>
                <br/><br/>                                
            </div>
            <div style="background-color: rgba(240,255,255,0.2);border: #0077b3 1px;border-style:solid ;border-radius: 5px;margin: 5px 5px 5px 5px;padding-left: 10px;padding-right:10px" class="col-xs-5 col-sm-3 placeholder">
               <br/>
             <span  style="font-size: 30px"  class="glyphicon glyphicon-picture"></span><c:if test="${instructions_stat gt instructions}">
                                                 <span style="color:green" class="glyphicon glyphicon-arrow-up"></span>

                                             </c:if>
                                               <c:if test="${instructions_stat eq instructions}">
                                                 <span style="color:gray" class="glyphicon glyphicon-check"></span>

                                             </c:if>
                                                 <c:if test="${instructions_stat lt instructions}">
                                                 <span style="color:red" class="glyphicon glyphicon-arrow-down"></span>

                                             </c:if>
             <br/>
             <a  href="${pageContext.request.contextPath}/admin/past/7/instructions"> <h4>Instructions</h4>  </a>
              <span class="text-muted">${instructions}</span>
                 <br/><br/>                               
            </div>
            <div style="background-color: rgba(240,255,255,0.2);border: #0077b3 1px;border-style:solid ;border-radius: 5px;margin: 5px 5px 5px 5px;padding-left: 10px;padding-right:10px" class="col-xs-5 col-sm-3 placeholder">
            <br/>
              <span  style="font-size: 30px"  class="glyphicon glyphicon-heart-empty"></span> <c:if test="${expectations_stat gt expectations}">
                                                   <span style="color:green" class="glyphicon glyphicon-arrow-up"></span>

                                               </c:if>
                                                 <c:if test="${expectations_stat eq expectations}">
                                                   <span style="color:gray" class="glyphicon glyphicon-check"></span>

                                               </c:if>
                                                   <c:if test="${expectations_stat lt expectations}">
                                                   <span style="color:red" class="glyphicon glyphicon-arrow-down"></span>

                                               </c:if>
             <br/>
                 <a  href="${pageContext.request.contextPath}/admin/past/7/expectations"> <h4>Expectations</h4>  </a>
              <span class="text-muted">${expectations}</span>
                    <br/><br/>                           
            </div>
            <div  style="background-color: rgba(240,255,255,0.2);border: #0077b3 1px;border-style:solid ;border-radius: 5px;margin: 5px 5px 5px 5px;padding-left: 10px;padding-right:10px" class="col-xs-5 col-sm-3 placeholder">
               <br/>
              <span  style="font-size: 30px"  class="glyphicon glyphicon-glass"></span> <c:if test="${length_stat gt length}">
                                              <span style="color:green" class="glyphicon glyphicon-arrow-up"></span>

                                          </c:if>
                                            <c:if test="${length_stat eq length}">
                                              <span style="color:gray" class="glyphicon glyphicon-check"></span>

                                          </c:if>
                                              <c:if test="${length_stat lt length}">
                                              <span style="color:red" class="glyphicon glyphicon-arrow-down"></span>

                                          </c:if>
             <br/>
              <a  href="${pageContext.request.contextPath}/admin/past/7/length"> <h4>Length</h4> </a>
              <span class="text-muted">${length}</span>
                   <br/><br/>                        
            </div>
            <div style="background-color: rgba(240,255,255,0.2);border: #0077b3 1px;border-style:solid ;border-radius: 5px;margin: 5px 5px 5px 5px;padding-left: 10px;padding-right:10px" class="col-xs-5 col-sm-3 placeholder">
             <br/>
               <span  style="font-size: 30px"  class="glyphicon glyphicon-eye-open"></span><c:if test="${presentation_stat gt presentation}">
                                                  <span style="color:green" class="glyphicon glyphicon-arrow-up"></span>

                                              </c:if>
                                                <c:if test="${presentation_stat eq presentation}">
                                                  <span style="color:gray" class="glyphicon glyphicon-check"></span>

                                              </c:if>
                                                  <c:if test="${presentation_stat lt presentation}">
                                                  <span style="color:red" class="glyphicon glyphicon-arrow-down"></span>

                                              </c:if>
             <br/>
                <a  href="${pageContext.request.contextPath}/admin/past/7/presentation"><h4>Presentation</h4> </a>
              <span class="text-muted">${presentation}</span>
                   <br/><br/>                             
            </div>
            <div style="background-color: rgba(240,255,255,0.2);border: #0077b3 1px;border-style:solid ;border-radius: 5px;margin: 5px 5px 5px 5px;padding-left: 10px;padding-right:10px" class="col-xs-5 col-sm-3 placeholder">
                
           <br/>
               <span  style="font-size: 30px"  class="glyphicon glyphicon-export"></span>   <c:if test="${content_stat gt content}">
                                                   <span style="color:green" class="glyphicon glyphicon-arrow-up"></span>

                                               </c:if>
                                                 <c:if test="${content_stat eq content}">
                                                   <span style="color:gray" class="glyphicon glyphicon-check"></span>

                                               </c:if>
                                                   <c:if test="${content_stat lt content}">
                                                   <span style="color:red" class="glyphicon glyphicon-arrow-down"></span>

                                               </c:if>
             <br/>
               <a  href="${pageContext.request.contextPath}/admin/past/7/content"><h4>Content</h4> </a>
              <span class="text-muted">${content}</span>
                 <br/><br/>                        
            </div>
             
                 
                  <div style="background-color: rgba(240,255,255,0.2);border: #0077b3 1px;border-style:solid ;border-radius: 5px;margin: 5px 5px 5px 5px;padding-left: 10px;padding-right:10px" class="col-xs-5 col-sm-3 placeholder">
                
           <br/>
               <span  style="font-size: 30px"  class="glyphicon glyphicon-cloud"></span>  
             <br/>
               <a  href="#"><h4>NPS</h4> </a>
              <span class="text-muted">${nps}</span>
                 <br/><br/>                        
            </div>
                  <div style="background-color: rgba(240,255,255,0.2);border: #0077b3 1px;border-style:solid ;border-radius: 5px;margin: 5px 5px 5px 5px;padding-left: 10px;padding-right:10px" class="col-xs-5 col-sm-3 placeholder">
                
           <br/>
               <span  style="font-size: 30px"  class="glyphicon glyphicon-book"></span>   
                                                  
             <br/>
               <a  href="#"><h4>Today's Count</h4> </a>
              <span class="text-muted">${total} user(s)</span>
                 <br/><br/>                        
            </div>
                 
                 <div style="background-color: rgba(240,255,255,0.2);border: #0077b3 1px;border-style:solid ;border-radius: 5px;margin: 5px 5px 5px 5px;padding-left: 10px;padding-right:10px" class="col-xs-5 col-sm-3 placeholder">
                
           <br/>
               <span  style="font-size: 30px"  class="glyphicon glyphicon-heart"></span>   
                                                  
             <br/>
               <a  href="#"><h4>Promoters</h4> </a>
              <span class="text-muted">${prom}</span>
                 <br/><br/>                        
            </div>
                 <div style="background-color: rgba(240,255,255,0.2);border: #0077b3 1px;border-style:solid ;border-radius: 5px;margin: 5px 5px 5px 5px;padding-left: 10px;padding-right:10px" class="col-xs-5 col-sm-3 placeholder">
                
           <br/>
               <span  style="font-size: 30px"  class="glyphicon glyphicon-edit"></span>   
                                                  
             <br/>
               <a  href="#"><h4>Passives</h4> </a>
              <span class="text-muted">${pass}</span>
                 <br/><br/>                        
            </div>
                 
          <div style="background-color: rgba(240,255,255,0.2);border: #0077b3 1px;border-style:solid ;border-radius: 5px;margin: 5px 5px 5px 5px;padding-left: 10px;padding-right:10px" class="col-xs-5 col-sm-3 placeholder">
                
           <br/>
               <span  style="font-size: 30px"  class="glyphicon glyphicon-exclamation-sign"></span>   
                                                  
             <br/>
               <a  href="#"><h4>Detractors</h4> </a>
              <span class="text-muted">${det}</span>
                 <br/><br/>                        
            </div>
                 
              
          </div>
  <br/>
  <hr/>
 



  
      <h2>Average Ratings</h2><br/>
  
      <div class='bar_group'>
	  
        	
        <div class='bar_group__bar thin elastic' label='Service' show_values='false' tooltip='true' value='${relevance}'></div>
        <div class='bar_group__bar thin elastic' label='Menu' show_values='false' tooltip='true' value='${materials}'></div>
        <div class='bar_group__bar thin elastic' label='Ambiance' show_values='false' tooltip='true' value='${instructions}'></div>
        <div class='bar_group__bar thin elastic' label='Food' show_values='false' tooltip='true' value='${expectations}'></div>
        <div class='bar_group__bar thin elastic' label='Beverage' show_values='false' tooltip='true' value='${length}'></div>
        <div class='bar_group__bar thin elastic' label='Refer' show_values='false' tooltip='true' value='${content}'></div>
        <div class='bar_group__bar thin elastic' label='Overall' show_values='false' tooltip='true' value='${presentation}'></div>
        <div style="display:none" class='bar_group__bar thin elastic' label='' show_values='true' tooltip='true' value='5'></div>
	
      </div>
 
    <div class='clear'></div>

<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

           <script src="<c:url value="/resources/js/bar.js" />" type="text/javascript"></script>
           
           
         
        </div>
           
            
  
  

    
     
           
           
      </div>
    </div>

  
    </body>
</html>
