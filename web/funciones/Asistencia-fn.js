$scope.arrAsistencias = [];
$scope.findAsistencias = function()
{
    $scope.cargando = false;
    $.ajax(
    {
        url:"../../findAsistencias",
        data:
        {

        },
        beforeSend: function (xhr) 
        {
            $scope.cargando = true;
        },
        success: function (resultado, textStatus, jqXHR) 
        {
            $scope.arrAsistencias = resultado;
            $scope.cargando = false;
            $scope.$evalAsync();
        }
    });
}


//AJAX SAVE
$scope.guardarAsistencia = function()
{
    guardo = false;
    $scope.cargando = false;
    
    $.ajax(
    {
        url:"../../guardarAsistencia",
        async: false,
        data:
        {
            "strAsistencia": JSON.stringify($scope.asistencia)
        },
        beforeSend: function (xhr) 
        {
            $scope.cargando = true;
        },
        success: function (resultado, textStatus, jqXHR) 
        {
            console.log("res WS -> guardarAsistencia : " + resultado);
            $scope.cargando = false;
            guardo = resultado;
            
            if(guardo)
            {
                $scope.snack("Guardado con exito!");
                $scope.findAsistencias();
            }
            $scope.$evalAsync();
        }

    });
    
    return guardo;
}
//AJAX GET
$scope.asistencia = {};
$scope.getAsistencia = function(idAsistencia)
{
   $scope.cargando = false;
   $.ajax(
   {
       url:"../../getAsistencia",
       async: false,
       data:
       {
            "idAsistencia":idAsistencia
       },
       beforeSend: function (xhr) 
       {
           $scope.cargando = true;
       },
       success: function (resultado, textStatus, jqXHR) 
       {
           $scope.asistencia = resultado;
           $scope.cargando = false;
           $scope.$evalAsync();
       }
   });
}

//AJAX GET - EMPTY
$scope.asistenciaEmpty = {};
$scope.getAsistenciaEmpty = function()
{
   $scope.cargando = false;
   $.ajax(
   {
       url:"../../getAsistenciaEmpty",
       async: false,
       data:
       {

       },
       beforeSend: function (xhr) 
       {
           $scope.cargando = true;
       },
       success: function (resultado, textStatus, jqXHR) 
       {
           $scope.asistenciaEmpty = resultado;
           $scope.cargando = false;
           $scope.$evalAsync();
       }
   });
}
//VALIDAR
$scope.validarAsistencia = function()
{
   $scope.todoOK = false;
   $scope.comprobarTitulo = $scope.asistencia.titulo != null && $scope.asistencia.titulo.length > 1;
   if($scope.comprobarTitulo)
   {
       $scope.asistencia.titulo = $scope.pasaraMayusPrimerLetra($scope.asistencia.titulo);
       $scope.$evalAsync();
   }
   
   $scope.comprobarDescripcion = $scope.asistencia.descripcion != null && $scope.asistencia.descripcion.length > 1;
   if($scope.comprobarDescripcion)
   {
       $scope.asistencia.descripcion = $scope.pasaraMayusPrimerLetra($scope.asistencia.descripcion);
       $scope.$evalAsync();
   }
   
   $scope.comprobarMotivo = $scope.asistencia.motivo != null && $scope.asistencia.motivo.length > 1;
   if($scope.comprobarMotivo)
   {
       $scope.asistencia.motivo = $scope.pasaraMayusPrimerLetra($scope.asistencia.motivo);
       $scope.$evalAsync();
   }
   
   $scope.comprobarOperador = $scope.asistencia.operador != null && $scope.asistencia.operador.length > 1;
   if($scope.comprobarOperador)
   {
       $scope.asistencia.operador = $scope.pasaraMayusPrimerLetra($scope.asistencia.operador);
       $scope.$evalAsync();
   }
   
   $scope.comprobarHora = $scope.asistencia.hora != null && $scope.asistencia.hora.length > 1;
   if($scope.comprobarHora)
   {
       $scope.asistencia.hora = $scope.pasaraMayusPrimerLetra($scope.asistencia.hora);
       $scope.$evalAsync();
   }
   
   $scope.comprobarDuracionMinutos = $scope.asistencia.duracionMinutos != null && $scope.asistencia.duracionMinutos.length > 1;
   if($scope.comprobarDuracionMinutos)
   {
       $scope.asistencia.duracionMinutos = $scope.pasaraMayusPrimerLetra($scope.asistencia.duracionMinutos);
       $scope.$evalAsync();
   }
   
   //COMPROBACION FINAL
   if( $scope.comprobarTitulo && $scope.comprobarDescripcion && $scope.comprobarMotivo && $scope.comprobarOperador && $scope.comprobarHora && $scope.comprobarDuracionMinutos )
   {
       console.log("TODO VALIDADO");
       $scope.todoOK = true;
       $scope.$evalAsync();
   }
		
}
