<!-- 1 - BANNER: -->
        <%@include file="../formato-comun/banner-comun.jsp" %>
        
        <!-- 2 - BARRA LATERAL: -->
        <%@include file="../formato-comun/barra-lateral.jsp" %>
        
        
        <!-- 3 - CONTENIDO: -->
        <div class="contenido col-xs-12 "    ng-class="{'true':'contenido-achicado', 'false':'contenido-ampliado'}[barraLateralAbierta]"  ng-show="usuarioLogeado.id != -1" >