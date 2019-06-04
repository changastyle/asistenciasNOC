
<div class="col-xs-12 sin-padding">
    <!-- 1 - HEADER MES Y AÑO ACTUAL CON FLECHITAS:-->
    <h3 class="h-separador-2 col-xs-12 sin-padding" >

        <!-- FLECHA IZQ MES: -->
        <div class="campo-0-h-separador-2 col-xs-2 col-sm-1" ng-click="desAumentar()">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </div>

        <!-- TITULO MES ACTUAL: -->
        <div class="campo-1-h-separador-2 col-xs-8 col-sm-10" style="text-align: center;">
            {{mesConVisitas.nombre | uppercase }} - {{mesConVisitas.year}}
        </div>

        <!-- FLECHA DERECHA MES: -->
        <div class="campo-2-h-separador-2 col-xs-2 col-sm-1" ng-click="aumentar()" style="cursor:pointer;">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </div>

    </h3>



    <!-- 2 - ESTE ES EL GRAFICO ESTADISTICO: -->
    <div class="col-xs-12 sin-padding">
        <div id="container" >
        </div>
    </div>


    <!-- 3 - CONTADOR TOTAL DE VISITAS DEL MES: -->
    <h3 class="h-separador-2 col-xs-12 " style="margin-top: 12px">
        <div class="campo-1-h-separador-2 col-xs-12 col-sm-12" style="text-align: center;">
            {{mesConVisitas.contadoresDelMes}} Visitantes
        </div>
    </h3>
    <!-- AQUI TERMINA CHARTS: -->
</div>