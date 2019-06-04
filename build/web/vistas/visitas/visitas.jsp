<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="../comun/comun-adm.jsp" %>
        <%@include file="../comun/comun.jsp" %>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-sanitize.js"></script>
        
        <!-- HIGHCHARTS CDN: -->
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="https://code.highcharts.com/highcharts.js"></script>
        
    </head>  
    <body ng-app="app" ng-controller="chart" ng-init="init()" ng-cloak>
        
        <!-- FORMATO COMUN ADM : -->
        <%@include file="../formato-comun/formato-comun-adm.jsp" %>
        
            <!-- 4 - CHART: -->
            <%@include file="partes/chart.jsp" %>
            
            
            <!-- 5 - ESTADISTICAS: -->
            <%@include file="partes/estadisticas.jsp" %>
            
            <!-- 6 - LISTADO DETALLADO DE VISITANTES:-->
            <%@include file="partes/listado-visitas.jsp" %>

        <!-- FIN FORMATO COMUN ADM : -->
        <%@include file="../formato-comun/fin-formato-comun-adm.jsp" %>

        
        
    </body>
    <script>
        app = angular.module('app', ['ngSanitize']);
        
        app.controller('chart', function($scope)
        {
            
            $scope.ths = 
            [
                {"clave":"ID","valor":"id"},
                {"clave":"SECCIONES","valor":"nombreSeccion"},
                {"clave":"SUB - HEADER ","valor":"subHeaderSeccion"},
                {"clave":"IMG - ICONO","valor":"imgIcono"},
                {"clave":"IMG - BACKGROUND","valor":"imgBG"},
                {"clave":"CANT.SERVICIOS","valor":"serviciosList"},
                {"clave":"BORRAR","valor":""}
            ];
            
            <%@include file="../../funciones/fn-secciones.js" %>
            <%@include file="../../funciones/fn-barra-lateral.js" %>
            <%@include file="../../funciones/fn-navegacion.js" %>
            <%@include file="../../funciones/Login-fn.js" %>
                
            $scope.aumentoEnMeses = 0;
            $scope.init = function()
            {
                // 1 - PIDO LISTADO DE VISISTANTES DE LA ULTIMA SEMANA:
                $scope.findClicksDelMes();
                $scope.comprobarUsuarioLogeado();
                $scope.pintameVentanaActual();
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
            
            
            
            
            
            
            
            
            
            
            /// ARRANCA TODO LO DEL DETALLE: 
            $scope.diaSeleccionado = null;
            $scope.semanaSeleccionada = null;
            $scope.seleccionarSemana = function(semana)
            {
                console.log("seleccionando semana...");
                $scope.semanaSeleccionada = semana;
                $scope.$evalAsync();
            }
            $scope.seleccionarDia = function(dia)
            {
                console.log("seleccionando dia...");
                $scope.diaSeleccionado = dia;
                $scope.$evalAsync();
            }
            
        });
    </script>
    <style>
        #container 
        {
            height: 500px;
            min-width: 310px;
            max-width: 100%;
            text-align: center;
        }
        .contenedor-visitantes-totales-de-la-semana
        {
            text-align: center;
            font-size: 56px;
            color:white;
            background-color:#18BB9C;
            margin-top:12px;
        }
        .contenedor-visitantes-totales-de-la-semana-1
        {
            text-align: center;
            font-size: 24px;
            color:white;
            background-color:#2D3E50;
            //margin-top: 50px;
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