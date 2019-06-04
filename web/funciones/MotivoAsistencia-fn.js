$scope.arrMotivoAsistencias = [];
$scope.findMotivos = function()
{
    $scope.cargando = false;
    $.ajax(
    {
        url:"../../findMotivos",
        data:
        {

        },
        beforeSend: function (xhr) 
        {
            $scope.cargando = true;
        },
        success: function (resultado, textStatus, jqXHR) 
        {
            $scope.arrMotivos = resultado;
            $scope.cargando = false;
            $scope.$evalAsync();
        }
    });
}


//AJAX SAVE
$scope.guardarMotivoAsistencia = function()
{
    guardo = false;
    $scope.cargando = false;
    
    $.ajax(
    {
        url:"../../guardarMotivoAsistencia",
        async: false,
        data:
        {
            "strMotivoAsistencia": JSON.stringify($scope.motivoAsistencia)
        },
        beforeSend: function (xhr) 
        {
            $scope.cargando = true;
        },
        success: function (resultado, textStatus, jqXHR) 
        {
            console.log("res WS -> guardarMotivoAsistencia : " + resultado);
            $scope.cargando = false;
            guardo = resultado;
            
            if(guardo)
            {
                $scope.snack("Guardado con exito!");
                $scope.findMotivoAsistencias();
            }
            $scope.$evalAsync();
        }

    });
    
    return guardo;
}
//AJAX GET
$scope.motivoAsistencia = {};
$scope.getMotivoAsistencia = function(idMotivoAsistencia)
{
   $scope.cargando = false;
   $.ajax(
   {
       url:"../../getMotivoAsistencia",
       async: false,
       data:
       {
            "idMotivoAsistencia":idMotivoAsistencia
       },
       beforeSend: function (xhr) 
       {
           $scope.cargando = true;
       },
       success: function (resultado, textStatus, jqXHR) 
       {
           $scope.motivoAsistencia = resultado;
           $scope.cargando = false;
           $scope.$evalAsync();
       }
   });
}

//AJAX GET - EMPTY
$scope.motivoAsistenciaEmpty = {};
$scope.getMotivoAsistenciaEmpty = function()
{
   $scope.cargando = false;
   $.ajax(
   {
       url:"../../getMotivoAsistenciaEmpty",
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
           $scope.motivoAsistenciaEmpty = resultado;
           $scope.cargando = false;
           $scope.$evalAsync();
       }
   });
}
//VALIDAR
$scope.validarMotivoAsistencia = function()
{
   $scope.todoOK = false;
   $scope.comprobarMotivo = $scope.motivoAsistencia.motivo != null && $scope.motivoAsistencia.motivo.length > 1;
   if($scope.comprobarMotivo)
   {
       $scope.motivoAsistencia.motivo = $scope.pasaraMayusPrimerLetra($scope.motivoAsistencia.motivo);
       $scope.$evalAsync();
   }
   
   //COMPROBACION FINAL
   if( $scope.comprobarMotivo )
   {
       console.log("TODO VALIDADO");
       $scope.todoOK = true;
       $scope.$evalAsync();
   }
		
}
