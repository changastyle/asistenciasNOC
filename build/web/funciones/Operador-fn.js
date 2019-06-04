$scope.arrOperadors = [];
$scope.findOperadors = function()
{
    $scope.cargando = false;
    $.ajax(
    {
        url:"../../findOperadors",
        data:
        {

        },
        beforeSend: function (xhr) 
        {
            $scope.cargando = true;
        },
        success: function (resultado, textStatus, jqXHR) 
        {
            $scope.arrOperadors = resultado;
            $scope.cargando = false;
            $scope.$evalAsync();
        }
    });
}


//AJAX SAVE
$scope.guardarOperador = function()
{
    guardo = false;
    $scope.cargando = false;
    
    $.ajax(
    {
        url:"../../guardarOperador",
        async: false,
        data:
        {
            "strOperador": JSON.stringify($scope.operador)
        },
        beforeSend: function (xhr) 
        {
            $scope.cargando = true;
        },
        success: function (resultado, textStatus, jqXHR) 
        {
            console.log("res WS -> guardarOperador : " + resultado);
            $scope.cargando = false;
            guardo = resultado;
            
            if(guardo)
            {
                $scope.snack("Guardado con exito!");
                $scope.findOperadors();
            }
            $scope.$evalAsync();
        }

    });
    
    return guardo;
}
//AJAX GET
$scope.operador = {};
$scope.getOperador = function(idOperador)
{
   $scope.cargando = false;
   $.ajax(
   {
       url:"../../getOperador",
       async: false,
       data:
       {
            "idOperador":idOperador
       },
       beforeSend: function (xhr) 
       {
           $scope.cargando = true;
       },
       success: function (resultado, textStatus, jqXHR) 
       {
           $scope.operador = resultado;
           $scope.cargando = false;
           $scope.$evalAsync();
       }
   });
}

//AJAX GET - EMPTY
$scope.operadorEmpty = {};
$scope.getOperadorEmpty = function()
{
   $scope.cargando = false;
   $.ajax(
   {
       url:"../../getOperadorEmpty",
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
           $scope.operadorEmpty = resultado;
           $scope.cargando = false;
           $scope.$evalAsync();
       }
   });
}
//VALIDAR
$scope.validarOperador = function()
{
   $scope.todoOK = false;
   $scope.comprobarNombre = $scope.operador.nombre != null && $scope.operador.nombre.length > 1;
   if($scope.comprobarNombre)
   {
       $scope.operador.nombre = $scope.pasaraMayusPrimerLetra($scope.operador.nombre);
       $scope.$evalAsync();
   }
   
   $scope.comprobarClave = $scope.operador.clave != null && $scope.operador.clave.length > 1;
   if($scope.comprobarClave)
   {
       $scope.operador.clave = $scope.pasaraMayusPrimerLetra($scope.operador.clave);
       $scope.$evalAsync();
   }
   
   //COMPROBACION FINAL
   if( $scope.comprobarNombre && $scope.comprobarClave )
   {
       console.log("TODO VALIDADO");
       $scope.todoOK = true;
       $scope.$evalAsync();
   }
		
}
