
<!-- 1 - BANNER: -->
<div class="banner col-xs-12 sin-padding">
    
    <!-- 2 - WRAP HAMBURGER BARRA LATERAL: -->
    <div class="wrap-hamb-banner-adm row sin-padding">
        
        <!-- 3 - IMG HAMBURGER BARRA LATERAL: -->
        <img src="../res/img/iconos/menu.png" class="img-menu" ng-click="abrirBarraLateral()">
        
    </div>
    <!-- 4 - WRAP OTRAS PARTES SIN EL HAMBURGER BANNER-ADM: -->
    <div class="wrap-banner-adm-menos-hamb row col-xs-12  sin-padding">
        
         <!-- 5 - BANNER PARTE IZQ: -->
        <div class="banner-parts banner-izq col-xs-6 sin-padding-left ">
            
            <!-- 6 - LOGO : -->
            <a href="../home/home.jsp">
                <img class="img-logo" src="http://viewdevscompany.com:8081/upload/ecpa/backgrounds/logo-recortado-grande-transpa.png" >
            </a>
        </div>
         
        <!-- 7 - BANNER PARTE MID -->
        <div class="banner-parts banner-mid hidden-xs hidden-sm hidden-md hidden-lg sin-padding-left">

            <!-- 8 ADDON BARRA BUSQUEDA:-->
            <div class="contenedor-addon-barra-busqueda">
            </div>
        </div>
        
         <!-- 7 - BANNER PARTE DER -->
        <div class="banner-parts banner-der col-xs-6  sin-padding-left">

            <!-- 8 - BOTON DE LOGIN:-->
            <div class="cuadro-btn-login " ng-show="usuarioLogeado.id == -1"><!--col-xs-12-->
                <button class="btn-login btn btn-default">
                    <span class="glyphicon glyphicon-user"></span>
                    Ingresar
                </button>
            </div>
            
            <!-- 9 - IMPORTAR CUADRO DE USUARIO: -->
            <%@include file="cuadro-usr-logeado.jsp" %>
        </div>
    </div>
</div>

    <!-- MODAL CAMBIAR CONTRASEÑA: -->
    <%@include file="../comun/modal-olv-contraseña.jsp" %>

    <style>
        .wrap-hamb-banner-adm
        {
            display: inline-block;
            margin-left: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
            width: 100px; 
            height: 50px;
            text-align: center;
            //border: solid 1px red;
        }
        .wrap-banner-adm-menos-hamb
        {
            width: calc(100% - 100px);
            display: inline-block;
            margin-left: 0px;
            margin-right: 0px;
            position: fixed;
            right: 0px;
            //border: solid 1px yellow;
            
        }
    </style>
<style>
    .banner
    {
        background-color:var(--principal2);
        height: 50px;
        color: white;
        position: fixed;
        z-index: 2;
        text-align: left;
    }
    body
    {
        background-color: var(--gris2);
    }
    .banner-parts
    {
        padding-top: 8px;
       // border: solid 1px white;
    }
    .banner-der
    {
        text-align: right;
        //border: solid 1px red;
    }
    .img-operador
    {
        background-size: cover;
        background-position: center center;
        background-repeat: no-repeat;
        height: 100px;
        width: 100px;
        margin-top: 12px;
        margin-bottom: 12px;
        cursor: pointer;
    }
    
    .img-menu
    {
        width: 35px;
        height: 35px;
        text-align: center;
        margin-top: 8px;
        //margin-left: 10px;
        cursor: pointer;
    }
    .img-logo
    {
        height: 45px;
        margin-top: -6px;
        cursor: pointer;
        
        //border : solid 1px red;
    }
    .contenedor-addon-barra-busqueda
    {
    }
    .cuadro-btn-login
    {
       display: inline-block; 
    }

    .h-usr-logeado-abajo
    {
        font-size: 24px;
        color: black;
    }
    .img-usr-logeado
    {
        margin: 0px;
        height: 35px;
    }
    .img-usr-logeado-grande
    {
        margin-top: 15px;
        height: 80px;
    }
</style>
<style>
    .panel-dropdown-usuario
    {
        //height: 200px;
        background-color: white;
        border: solid 1px lightgrey;
        border-radius: 6px;
        position: fixed;
        top: 60px;
        right: 12px;
    }
    .borde-gris-der
    {
        border: solid 1px grey;
    }
    .list-group-item
    {
        cursor: pointer;
        text-align: left
    }
</style>