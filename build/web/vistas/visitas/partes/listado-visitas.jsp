
<!-- 1 - CONTENEDOR DETALLADO VISITANTES : -->
<div class="contenedor-detallado-visitantes col-xs-12 sin-padding">
    
    
    <!-- 2 - APARTADO IZQUIERDO (SEMANAS) : -->
    <div class="apartado-contenedor-detallado-visitantes izq-detallado-visitantes col-xs-12 col-sm-12 col-md-12 col-lg-4">
    
        <h3 style="text-align: center;">Semanas</h3>
        <hr class="hr">
        
        <!-- 3 - CADA SEMANA DEL MES: -->
        <div class="semana-del-mes col-xs-12 sin-padding" ng-repeat="semana in mesConVisitas.semanasList"
             ng-click="seleccionarSemana(semana)" 
             ng-class="{'true':'semana-del-mes-seleccionada'}[semana.numeroSemanaEnElMes == semanaSeleccionada.numeroSemanaEnElMes]" >

            <!-- 4 - CONTENEDOR TITULOS IZQ DE CADA SEMANA: -->
            <div class="contenedor-headers-semanas-del-mes col-xs-9">
                
                <!-- 5 - TITULAR PRINCIPAL CON EL NOMBRE DE LA SEMANA: -->
                <h3 class="h-semana-del-mes">
                    {{mesConVisitas.nombre}} - Semana {{semana.numeroSemanaEnElMes}}
                </h3>
                
                <!-- 6 - SUB - TITULAR CON LAS FECHAS COMPRENDIDAS DE LA SEMANA: -->
                <div class="fechas-semana-del-mes col-xs-12">
                    {{semana.primerDiaSemana.strTimestampInicioDia}} -
                    {{semana.ultimoDiaSemana.strTimestampFinDia}}
                </div>
            </div>
            
            <!-- 7 - VISUALIZADOR DE VISITANTES EN ESA SEMANA: -->
            <div class="contador-visitantes-semana-del-mes col-xs-3" 
                ng-class="{'true':'contador-visitantes-semana-del-mes-verde','false':'contador-visitantes-semana-del-mes-rojo' }[semana.contadoresDeLaSemana > 0]" >
                
                <!-- 8 - FLECHITA HACIA ARRIBA CONTADORES: --->
                <span class="glyphicon glyphicon-menu-up" ng-show="semana.contadoresDeLaSemana > 0">
                </span>
                
                <!-- 9 - FLECHITA HACIA ABAJO CONTADORES: --->
                <span class="glyphicon glyphicon-menu-down" ng-hide="semana.contadoresDeLaSemana > 0">
                </span>
                
                {{semana.contadoresDeLaSemana }}
                <br>
                Visitantes
            </div>


            <br>

            <!--{{semana}}-->
        </div>
    </div>
    
    
    
    
    
    
    
    
    
    <!-- 3 - APARTADO DEL MEDIO (DIAS) : -->
    <div class="wrap-apartado-contenedor-detallado-visitantes col-xs-12 col-sm-12 col-md-12 col-lg-4" ng-show="semanaSeleccionada != null">
        <div class="apartado-contenedor-detallado-visitantes col-xs-12">
            
            <h3 style="text-align: center;">Dias</h3>
            <hr class="hr">
            <!--{{semanaSeleccionada}}-->
            
            <div class="dias-semana col-xs-12 sin-padding" ng-repeat="dia in semanaSeleccionada.diasList" 
             ng-click="seleccionarDia(dia)" 
             ng-class="{'true':'dias-semana-seleccionado'}[dia.numeroDiaEnElMes == diaSeleccionado.numeroDiaEnElMes]">
                <div class="contenedor-headers-semanas-del-mes col-xs-9">
                
                    <!-- 5 - TITULAR PRINCIPAL CON EL NOMBRE DE LA SEMANA: -->
                    <h3 class="h-semana-del-mes">
                        {{dia.nombre + " " + dia.numeroDiaEnElMes}}
                    </h3>
                </div>
                <div class="contador-visitantes-semana-del-mes col-xs-3" 
                    ng-class="{'true':'contador-visitantes-semana-del-mes-verde','false':'contador-visitantes-semana-del-mes-rojo' }[dia.clicksList.length > 0]" >

                    <!-- 8 - FLECHITA HACIA ARRIBA CONTADORES: --->
                    <span class="glyphicon glyphicon-menu-up" ng-show="dia.clicksList.length> 0">
                    </span>

                    <!-- 9 - FLECHITA HACIA ABAJO CONTADORES: --->
                    <span class="glyphicon glyphicon-menu-down" ng-hide="dia.clicksList.length > 0">
                    </span>

                    {{dia.clicksList.length}}
                    <br>
                    Visitantes
                </div>
            </div>
        </div>
    </div>
    
    
    
    
    
    
    <!-- 4 - APARTADO DER (CLICKS) : -->
    <div class="apartado-contenedor-detallado-visitantes col-xs-12 col-sm-12 col-md-12 col-lg-4" ng-show="diaSeleccionado != null">
            
        <h3 style="text-align: center;">Visitantes</h3>
        <hr class="hr">
        <!--{{semanaSeleccionada}}-->

        <div class="clicks col-xs-12 sin-padding" ng-repeat="click in diaSeleccionado.clicksList">
            
            <div class="wrap-img-so col-xs-3 sin-padding">
                
                <div class="h-so col-xs-12 sin-padding">
                    {{click.sistemaOperativo.nombre}}
                </div>
                
                <!-- IMGS SISTEMAS OPERATIVOS: -->
                <img class="img-so img img-responsive center-block " src="../res/img/iconos/windowsw.png" ng-show="click.sistemaOperativo.id == 1">
                <img class="img-so img img-responsive center-block " src="../res/img/iconos/linux.png" ng-show="click.sistemaOperativo.id == 2">
                <img class="img-so img img-responsive center-block " src="../res/img/iconos/mac.png" ng-show="click.sistemaOperativo.id == 3">
                <img class="img-so img img-responsive center-block " src="../res/img/iconos/android.png" ng-show="click.sistemaOperativo.id == 4">
                
            </div>
            
            <div class="contenedor-headers-semanas-del-mes col-xs-6 ">

                <!-- 5 - TITULAR PRINCIPAL CON EL NOMBRE DE LA SEMANA: -->
                <h3 class="h-semana-del-mes col-xs-12">
                    {{click.direccionIP}}
                </h3>
                <div class="fechas-semana-del-mes col-xs-12">
                    {{click.strTimestamp}}
                </div>
            </div>
            
            <div class="seccion-click col-xs-3 " >
                <span class="glyphicon glyphicon-globe"></span>
                <br>
                {{click.seccion.nombreSeccion}}
            </div>
        </div>
    </div>
    
</div>













<style>
    .contenedor-tabla
    {
        background-color: white;
        border-radius: 6px;
        //overflow-x: scroll;
    }
    .apartado-contenedor-detallado-visitantes
    {
        background-color: white;
        padding:12px;
        margin-bottom: 25px;
       
        //overflow-x: scroll;
    }
    .tabla-clientes th , .tabla-clientes
    {
        text-align: center;
    }
    .img-fullBG
    {
        height: 50px;
    }
    .img-icono
    {
        height: 50px;
    }
    .semana-del-mes
    {
        margin-bottom: 25px;
        background-color: white;
        cursor: pointer;
        border: solid 1px lightgrey;
        overflow: hidden;
        height: 80px;
        text-overflow:ellipsis;
        transition: 1s;
    }
    .semana-del-mes:hover
    {
        transform: scale(1.05);
        transition: 1s;
    }
    .semana-del-mes-seleccionada
    {
        background-color: #f1c40f;
        color: white;
    }
    .contador-visitantes-semana-del-mes
    {
        text-align: center;
        color: white;
        height: 80px;
        padding-top: 18px;
        overflow: hidden;
        text-overflow:ellipsis;
    }
    .contador-visitantes-semana-del-mes-verde
    {
        background-color: #f1c40f;
    }
    .contador-visitantes-semana-del-mes-rojo
    {
        background-color: #e74c3c;
    }
    .fechas-semana-del-mes
    {
        color: grey;
        font-size: 12px;
    }
    .hr
    {
        border: solid 1px lightgrey;
        width: 50%;
        margin-top: 5px;
    }
</style>
<style>
    .dias-semana
    {
         margin-bottom: 25px;
        background-color: white;
        cursor: pointer;
        border: solid 1px lightgrey;
         transition: 1s;
    }
    .dias-semana:hover
    {
        transform: scale(1.05);
        transition: 1s;
    }
    .dias-semana-seleccionado
    {
        background-color: #f1c40f;
        color: white;
    }
</style>
<style>
    .wrap-img-so
    {
        background-color: black;
        height: 80px;;
        text-align: center;
    }
    .img-so
    {
        display: inline-block;
        text-align: center;
        height: 50px;
    }
    .h-so
    {
        z-index: 2;
        color: white;
        text-align: center;
    }
       
    .seccion-click
    {
        background-color: #e74c3c;
        text-align: center;
        color: white;
        height: 80px;
        padding-top: 18px;
        text-overflow: ellipsis;
        overflow: hidden;
    }
    .clicks
    {
         margin-bottom: 25px;
        background-color: white;
        border: solid 1px lightgrey;
        cursor: default;
         transition: 1s;
    }
    .clicks:hover
    {
        transform: scale(1.05);
        transition: 1s;
    }
</style>