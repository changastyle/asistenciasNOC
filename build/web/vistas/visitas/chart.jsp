<html>
    <head>
        <%@include file="../comun/comun.jsp" %>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="https://code.highcharts.com/highcharts.js"></script>
        
    </head>
    <body ng-app="app" ng-controller="chart" ng-init="init()" ng-cloak>
        
        <!-- 1 - ESTE ES EL GRAFICO ESTADISTICO: -->
        <div id="container">
        </div>
    
        <!-- 2 - HEADER MES Y AÑO ACTUAL CON FLECHITAS: -->
        <div class="contenedor-visitantes-totales-de-la-semana-1 col-xs-12">
            
            <!-- 3 - FLECHA IZQUIERDA: -->
            <div class="flecha col-xs-1" ng-click="desAumentar()">
                <span class="glyphicon glyphicon-arrow-left"></span>
            </div>
            
            <!-- 4 - TEXTO MES Y AÑO: -->
            <div class="col-xs-10">
                {{mesConVisitas.nombre}} {{mesConVisitas.year}}
            </div>
            
            <!-- 5 - FLECHA DERECHA: -->
            <div class="flecha col-xs-1" ng-click="aumentar()">
                <span class="glyphicon glyphicon-arrow-right"></span>
            </div>
        </div
        
        <!-- CANTIDAD VISITANTES ULTIMA SEMANA: -->
        <div class="contenedor-visitantes-totales-de-la-semana col-xs-12">
            {{mesConVisitas.contadoresDelMes}} Visitantes
        </div>

        <!-- LISTA IZQUIERDA DE DIAS:-->
        <div class="col-xs-3">
            <ul class="list-group" style="margin-top:25px;margin-bottom:25px;">
                <li class="list-group-item botones-dias" id="boton-dia-{{$index}}" ng-click="mostrarVisitasDelDia($index)" ng-repeat="dia in arrayDuplicado">
                    {{dia.nombreDia +" "+ dia.diaNum + "/" + dia.mesNum}}
                    <br>
                    
                    <span class="cantidad-visitantes-del-dia">
                        {{dia.visitasList.length}} Visitantes
                    </span>
                    
                </li>
            </ul>
        </div>
        
        
        <!-- INFO DE LAS SEMANAS: -->
        <div class="semana col-xs-12" ng-repeat="semana in mesConVisitas.semanasList">
            {{semana.numeroSemanaEnElMes}}
            <br>
            {{semana.principioSemana.nombre}}
            PRIMER DIA:{{semana.primerDiaSemana.date | date}}
            <BR>
            ULTIMO DIA:{{semana.ultimoDiaSemana.date | date}}
            
            <div class="dias-de-la-semana col-xs-12" ng-repeat="diaSemana in semana.diasList">
                {{diaSemana}}
            </div>
        </div>
        
        
        
        
        <!-- LISTADO DETALLADO DE VISITANTES:-->
        <div class="col-xs-9">
            
            <!--  ITEM VISITA: -->
            <div class="visita-item" ng-repeat="visita in visitasDelDiaSeleccionado">

                <!-- LOGOS LAPTOP O SMARTPHONE 
                <img src="../res/img/iconos/laptop.png" class="img-dispositivo" ng-show="visita.sistemaOperativo.indexOf('win')">
                <img src="../res/img/iconos/smartphone.png" class="img-dispositivo" ng-hide="visita.sistemaOperativo.indexOf('win')">

                <!-- TIPOS DE DISPOSITIVOS: 
                <span ng-show="visita.sistemaOperativo.indexOf('win')">Laptop</span>
                <span ng-hide="visita.sistemaOperativo.indexOf('win')">SmartPhone</span>
                -->

                <!-- TIMESTAMP VISITANTE: -->
                <span>
                    a las {{visita.timestamp | date : "hh:mm"}} hs 
                </span>
            </div>
        </div>
        <!-- AQUI TERMINA -->
            
</body>
<script>
    
    app = angular.module('app', []);
    app.controller('nvoChart', function($scope, $http) 
    {
        $scope.aumentoEnMeses = 0;
        $scope.init = function()
        {
            // 1 - PIDO LISTADO DE VISISTANTES DE LA ULTIMA SEMANA:
            $scope.findClicksDelMes();
        }
        
        $scope.mesConVisitas = [];
        $scope.findClicksDelMes = function()
        {
            $scope.cargando = false;
            $.ajax(
            {
                url:"../../findClicksDelMesPorAumento",
                data:
                {
                    "aumento":$scope.aumentoEnMeses
                },
                beforeSend: function (xhr) 
                {
                    $scope.arrCategoriasChart = [];
                    $scope.cargando = true;
                },
                success: function (resultado, textStatus, jqXHR) 
                {
                    $scope.mesConVisitas = resultado;
                    $scope.array = resultado;
                    console.log("res ws ->mesConVisitas(): " + $scope.mesConVisitas.length);
                    $scope.cargando = false;
                    $scope.$evalAsync();
                    
                    $scope.procesar();

                }
            });
        }
        $scope.arrCategoriasChart  = [];
        $scope.procesar = function()
        {
            // ACA SE HACE LA CONVERSION A HIGHCHARTS:
            $scope.arrFormatoEstadisticas = [];
            for( i = 0 ; i < $scope.mesConVisitas.semanasList.length ; i++)
            {
                semanaLoop = $scope.mesConVisitas.semanasList[i];
                //console.log("Loop: " + JSON.stringify(semanaLoop));
                
                console.log("Loop: " + semanaLoop.numeroSemanaEnElMes + " | " + semanaLoop.contadoresDeLaSemana);
                //$scope.arrFormatoEstadisticas.push({name: "'" + semanaLoop.numeroSemanaEnElMes +"'",data: [semanaLoop.contadoresDeLaSemana]})
                
                str =  semanaLoop.numeroSemanaEnElMes + "<br>" + semanaLoop.contadoresDeLaSemana; 
                $scope.arrFormatoEstadisticas.push(semanaLoop.contadoresDeLaSemana);
                
                // ARMO EL ARRAY DE CATEGORIAS DEL CHART:
                console.log("SEMANA [" + (i+1) + "]: " + JSON.stringify(semanaLoop));
                str = "SEMANA "+ (i+1);
                str += "<br>" + semanaLoop.primerDiaSemana.strTimestampInicioDia + " - ";
                str += "" + semanaLoop.ultimoDiaSemana.strTimestampFinDia;
                str += "<br>" + semanaLoop.contadoresDeLaSemana + " visitantes";
                $scope.arrCategoriasChart.push(str);
                
                
                /*dia = $scope.parsearDia(dia);
                visitas = $scope.array[i].visitasList.length;
                $scope.arrayCantidades.push(visitas);
                $scope.arrayDias.push(dia);
                
                $scope.totalVisitantesDeLaSemana += visitas;*/
                
            }
            $scope.$apply();
            // TERMINA LA CONVERSION DE HIGHCHARTS
            
            Highcharts.chart('container', 
            {
                chart: {
                    type: 'line'
                },
                title: {
                    text: 'Estadisticas del ultimo mes' 
                },
                subtitle: {
                    text: 'En Semanas'
                },
                xAxis: {
                    categories: $scope.arrCategoriasChart
                    //categories: ["Semana 1", "Semana 2" ,"Semana 3" , "Semana 4"]
                },
                yAxis: {
                    title: {
                        text: 'Visitantes (Cantidad)'
                    }
                },
                plotOptions: {
                    line: {
                        dataLabels: {
                            enabled: true
                        },
                        enableMouseTracking: false
                    }
                },
                series: [{
                    name: 'Visitantes por Semana',
                    data: $scope.arrFormatoEstadisticas
                }]
            });
        }
        
        
        $scope.aumentar = function()
        {
            $scope.aumentoEnMeses++;
            $scope.$evalAsync();
            $scope.findClicksDelMes();
        }
        $scope.desAumentar = function()
        {
            $scope.aumentoEnMeses--;
            $scope.$evalAsync();
            $scope.findClicksDelMes();
        }
    });

</script>
<style>
    #container 
    {
        height: 500px;
        min-width: 310px;
        max-width: 98%;
        text-align: center;
    }
    .contenedor-visitantes-totales-de-la-semana
    {
        text-align: center;
        font-size: 56px;
        color:white;
        background-color:#18BB9C;
    }
    .contenedor-visitantes-totales-de-la-semana-1
    {
        text-align: center;
        font-size: 56px;
        color:white;
        background-color:#2D3E50;
        margin-top: 50px;
    }
    .botones-dias
    {
       // margin-top: 25px;
    }
    .botones-dias-selected , .botones-dias-selected:active , .botones-dias-selected:hover , .botones-dias-selected:focus
    {
        background-color: #18BB9C;
        color:white;
    }
    .visita-item
    {
        border-bottom: solid 1px grey;
        padding:12px;
        font-size: 22px;
    }
    .img-dispositivo
    {
        width: 50px;
        margin-right: 15px;
    }
    .cantidad-visitantes-del-dia
    {
        text-align: center;
        color: lightgray;
    }
    .flecha
    {
        cursor:pointer;
        margin-top: 12px;
    }
    .semana
    {
        border: solid 1px red;
    }
    .dias-de-la-semana
    {
         border: solid 1px blue;
    }
</style>
</html>