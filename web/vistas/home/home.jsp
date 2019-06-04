<!DOCTYPE html>
<html>
    <head>
        <!-- SEO : -->
        <title>Asistencias</title>
        <!-- FIN SEO -->
        
        <%@include file="../comun/comun.jsp" %>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-sanitize.js"></script>

    </head>
    <body ng-app="app" ng-controller="asistencias" ng-init="init()" ng-cloak>

        <div class="container">
            
            <%@include file="partes/seccion-provincia-persona.jsp" %>
            
            <!--MOTIVO-->
            <div class="form-group">
                <label>Motivo Llamado</label>
                <select class='input-tags form-control' ng-change="cambioComboEdicion()" ng-model='motivoSelected' ng-options="motivo as motivo.motivo for motivo in arrMotivos">
                </select>
            </div>
            
            <!--HORA-->
            <div class="form-group">
                <label>Incio Consulta</label>
                {{horaInicio | date:'HH:mm:ss'}}
                <br>
                <label>Incio Consulta</label>{{horaFin | date:'HH:mm:ss'}}
                <br>
                <button class="btn btn-default" ng-click="cerrarTimer()">Iniciar Timer</button>
                <button class="btn btn-default" ng-click="changeComboPersonas()">combo</button>
            </div>
        </div>
        
        
        
        <!-- SNACKBAR:-->
        <div id="snackbar">Some text some message..</div>
        
        
        
        
    </body>
    <script>
        app = angular.module('app', []);

        app.controller('asistencias', function($scope)
        {
            <%@include file="../../funciones/MotivoAsistencia-fn.js" %>
            <%@include file="../../funciones/Provincia-fn.js" %>
            <%@include file="../../funciones/Persona-fn.js" %>
                
            $scope.init = function()
            {
                console.log("inicio");
                $scope.iniciarTimer();
                $scope.findMotivos();
                $scope.findProvincias();
                $scope.findPersonas();
                
                
//                $(document).ready(function() 
//                {
//                    $('.input-tags').select2();
//                });
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
