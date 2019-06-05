<!DOCTYPE html>
<html>
    <head>
        <!-- SEO : -->
        <title>Asistencias</title>
        <!-- FIN SEO -->
        
        <%@include file="../comun/comun.jsp" %>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-sanitize.js"></script>

        
        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.7/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.7/js/select2.min.js"></script>
    </head>
    <body ng-app="app" ng-controller="asistencias" ng-init="init()" ng-cloak>

        <div class="container">
            
            <%@include file="partes/combo-persona.jsp" %>
            
            <%@include file="partes/combo-motivo.jsp" %>
            
            <%@include file="partes/combo-minutos.jsp" %>
            
            <div class="col-xs-9 sin-padding-left">
                <label>Agencia</label>
                <!--<input type="text" ng-model="ag" class="form-control" placeholder="Agencia..">-->
                <select id="combo-ag" class="combos form-control" ng-model="agSelected">
                    <option value="{{sitio.ip}}"  ng-repeat="sitio in arrSitiosEncontrados" >
                        {{sitio.nombre}}
                    </option>
                </select>
            </div>
            <div class="col-xs-3 sin-padding">
                <button class="btn btn-default col-xs-12 sin-padding" ng-click="dameIpDeAg()" style="margin-top: 25px;">
                    <span class="glyphicon glyphicon-ok"></span>
                    CONSULTAR
                </button>
            </div>
            
            <div class="ip-agencia col-xs-12">
                <div class="col-xs-12">{{agSelected}}</div>
            </div>
<!--            <div class="col-xs-12 sin-padding">
                <ul class="list-group">
                    <li class="list-group-item" ng-repeat="sitio in arrSitiosEncontrados">
                        {{sitio.nombre}}
                        <br>
                        {{sitio.ip}}
                    </li>
                </ul>
            </div>-->
           
        
        
        
        <!-- SNACKBAR:-->
        <div id="snackbar">Some text some message..</div>
        
        
        
        
    </body>
    <style>
        .ip-agencia
        {
            background-color: #10ac84;
            border-radius: 50px;
            height: 60px;
            color: white;
            font-size: 32px;
            text-align: center;
            padding: 12px;
            margin-top: 25px;
        }
    </style>
    <script>
        app = angular.module('app', []);

        app.controller('asistencias', function($scope)
        {
            <%@include file="../../funciones/MotivoAsistencia-fn.js" %>
            <%@include file="../../funciones/Provincia-fn.js" %>
            <%@include file="../../funciones/Persona-fn.js" %>
                
            $scope.arrMinutos = [
                {"id":1,"valor":5,"valorMostrable": "5 Min"},
                {"id":2,"valor":10,"valorMostrable": "10 Min"},
                {"id":3,"valor":15,"valorMostrable": "15 Min"},
                {"id":4,"valor":20,"valorMostrable": "20 Min"},
                {"id":5,"valor":30,"valorMostrable": "30 Min"},
                {"id":6,"valor":45,"valorMostrable": "45 Min"},
                {"id":7,"valor":60,"valorMostrable": "60 Min"}
            ];
            
            $scope.init = function()
            {
                console.log("inicio");
                $scope.iniciarTimer();
                $scope.findMotivos();
                $scope.findProvincias();
                $scope.findPersonas();
                $scope.findSitios();
                
                $(document).ready(function() 
                {
                    $('.combos').select2();
                    $("#combo-minutos").val('2').trigger('change');
                });
                
            }
            /*$scope.dameIpDeAg = function()
            {
                $scope.cargando = false;
                $.ajax(
                {
                    url:"../../dameIpDeAg",
                    data:
                    {
                        "ag":$scope.agSelected
                    },
                    beforeSend: function (xhr) 
                    {
                        $scope.cargando = true;
                    },
                    success: function (resultado, textStatus, jqXHR) 
                    {
                        $scope.arrSitiosEncontrados = resultado;
                        $scope.cargando = false;
                        $scope.$evalAsync();
                    }
                });
            }*/
            $scope.findSitios = function()
            {
                $scope.cargando = false;
                $.ajax(
                {
                    url:"../../findSitios",
                    beforeSend: function (xhr) 
                    {
                        $scope.cargando = true;
                    },
                    success: function (resultado, textStatus, jqXHR) 
                    {
                        $scope.arrSitiosEncontrados = resultado;
                        $scope.cargando = false;
                        $scope.$evalAsync();
                    }
                });
            }
            
            $scope.iniciarTimer = function()
            {
                $scope.horaInicio = new Date();
            }
            $scope.cerrarTimer = function()
            {
                $scope.horaFin = new Date();
            }
            $scope.puto = function()
            {
                console.log("puto");
            }
            $scope.seleccionarProvincia = function(provincia)
            {
                $scope.provinciaSelected = provincia;
                $scope.$evalAsync();
            };
            $scope.seleccionarPersona = function(persona) 
            {
                $scope.personaSelected = persona;
                
                for(i = 0 ; i < $scope.arrProvincias.length; i++)
                {
                    actual = $scope.arrProvincias[i];
                    if(actual != null)
                    {
                        if(actual.id == $scope.personaSelected.fkProvinciaPadre)
                        {
                            $scope.provinciaSelected = actual;
                            break;
                        }
                    }
                }
                
                $scope.$evalAsync();
            };
            $scope.changeComboPersonas = function()
            {
                val = $('#combo-personas').val(); 
                //$('#mySelect2').trigger('change');
                
                console.log("Persona selected: " + val  + " | " + JSON.stringify($scope.personaSelected));
                
                for(i = 0 ; i < $scope.arrProvincias.length; i++)
                {
                    actual = $scope.arrProvincias[i];
                    if(actual != null)
                    {
                        if(actual.id == $scope.personaSelected.fkProvinciaPadre)
                        {
                            $scope.provinciaSelected = actual;
                            break;
                        }
                    }
                }
                $scope.$evalAsync();
            }
        });
    </script>
</style>
</html>
