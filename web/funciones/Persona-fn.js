$scope.arrPersonas = [];
$scope.findPersonas = function()
{
    $scope.cargando = false;
    $.ajax(
    {
        url:"../../findPersonas",
        data:
        {

        },
        beforeSend: function (xhr) 
        {
            $scope.cargando = true;
        },
        success: function (resultado, textStatus, jqXHR) 
        {
            $scope.arrPersonas = resultado;
            $scope.cargando = false;
            $scope.$evalAsync();
        }
    });
}


//AJAX SAVE
$scope.guardarPersona = function()
{
    guardo = false;
    $scope.cargando = false;
    
    $.ajax(
    {
        url:"../../guardarPersona",
        async: false,
        data:
        {
            "strPersona": JSON.stringify($scope.persona)
        },
        beforeSend: function (xhr) 
        {
            $scope.cargando = true;
        },
        success: function (resultado, textStatus, jqXHR) 
        {
            console.log("res WS -> guardarPersona : " + resultado);
            $scope.cargando = false;
            guardo = resultado;
            
            if(guardo)
            {
                $scope.snack("Guardado con exito!");
                $scope.findPersonas();
            }
            $scope.$evalAsync();
        }

    });
    
    return guardo;
}
//AJAX GET
$scope.persona = {};
$scope.getPersona = function(idPersona)
{
   $scope.cargando = false;
   $.ajax(
   {
       url:"../../getPersona",
       async: false,
       data:
       {
            "idPersona":idPersona
       },
       beforeSend: function (xhr) 
       {
           $scope.cargando = true;
       },
       success: function (resultado, textStatus, jqXHR) 
       {
           $scope.persona = resultado;
           $scope.cargando = false;
           $scope.$evalAsync();
       }
   });
}

//AJAX GET - EMPTY
$scope.personaEmpty = {};
$scope.getPersonaEmpty = function()
{
   $scope.cargando = false;
   $.ajax(
   {
       url:"../../getPersonaEmpty",
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
           $scope.personaEmpty = resultado;
           $scope.cargando = false;
           $scope.$evalAsync();
       }
   });
}
//VALIDAR
$scope.validarPersona = function()
{
   $scope.todoOK = false;
   $scope.comprobarNombre = $scope.persona.nombre != null && $scope.persona.nombre.length > 1;
   if($scope.comprobarNombre)
   {
       $scope.persona.nombre = $scope.pasaraMayusPrimerLetra($scope.persona.nombre);
       $scope.$evalAsync();
   }
   
   $scope.comprobarClave = $scope.persona.clave != null && $scope.persona.clave.length > 1;
   if($scope.comprobarClave)
   {
       $scope.persona.clave = $scope.pasaraMayusPrimerLetra($scope.persona.clave);
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
