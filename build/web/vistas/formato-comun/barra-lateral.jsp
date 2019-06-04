<div class="barra-lateral" ng-class="{'true':'barra-lateral-abierta','false':'barra-lateral-cerrada'}[barraLateralAbierta]">
    
    <!-- LOADING DENTRO BARRA LATERAL: -->
    <div class="">
        <div class="col-xs-12 " ng-show="cargandoBarraLateral" style="margin-top: 25px;">
            <img src="../res/img/loader.gif" class="img img-responsive center-block">
        </div>
    </div>
    
    <!-- ITEMS BARRA LATERAL:-->
    <div class="item-barra-lateral col-xs-12 sin-padding"  ng-repeat="item in itemsBarraLateral" 
         ng-class="{'false':'item-barra-lateral','true':'item-barra-lateral-seleccionado' }[idDeLaVentanaActual == item.id]" 
         data-toggle="tooltip" title="{{item.nombre}}" data-placement="bottom" ng-click="redireccionamiento(item.enlace)">
        <img ng-src="{{item.icono}}" class="img-item-barra-lateral img img-responsive center-block">
        
        
        <!-- NOMBRE ITEM BARRA LATERAL: -->
        <h3 class="h-item-barra-lateral ">{{item.nombre}}</h3>
    </div>
    
</div>

<!-- SNACKBAR:-->
<div id="snackbar">Some text some message..</div>

<!-- CUADRO DE LOGIN: -->
<%@include file="../comun/cuadro-login.jsp" %>

<style>
    .barra-lateral
    {
        //border: solid 1px red;
        position: fixed;
        top: 50px;
        bottom: 0px;
        background-color: var(--principal2);
        color: white;
        
        padding-left: 6px;
        padding-right: 6px;
    }
    .barra-lateral-abierta
    {
        width: 100px;
        transition: 1s;
    }
    .barra-lateral-cerrada
    {
        width: 0px;
        transition: 1s;
    }
    .item-barra-lateral
    {
        height: 60px;
        margin-top:20px;
        border-radius: 6px;
        overflow: hidden;
        cursor: pointer;
        //border: solid 1px white;
        //background-color: red;
    }
    .item-barra-lateral:hover
    {
        background-color: rgba(0,0,0,0.25);
    }
    .item-barra-lateral-seleccionado
    {
        background-color: rgba(0,0,0,0.25);
    }
    .img-item-barra-lateral
    {
        height: 30px;
        margin-top: 5px;
    }
    .h-item-barra-lateral
    {
        color: white;
        margin: 0px;
        margin-top: 4px;
        font-size: 12px;
        text-align: center;
    }
</style>
