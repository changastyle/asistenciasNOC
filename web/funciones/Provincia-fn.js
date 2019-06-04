$scope.arrProvincias = [];
$scope.findProvincias = function()
{
    $scope.cargando = false;
    $.ajax(
    {
        url:"../../findProvincias",
        data:
        {

        },
        beforeSend: function (xhr) 
        {
            $scope.cargando = true;
        },
        success: function (resultado, textStatus, jqXHR) 
        {
            $scope.arrProvincias = resultado;
            $scope.cargando = false;
            $scope.$evalAsync();
            $('.ui.dropdown').dropdown(
            {
                onChange: function(value, text, $selectedItem) 
                {
                    console.log(JSON.stringify(value));
                }
            });
        }
    });
}


//AJAX SAVE
$scope.guardarProvincia = function()
{
    guardo = false;
    $scope.cargando = false;
    
    $.ajax(
    {
        url:"../../guardarProvincia",
        async: false,
        data:
        {
            "strProvincia": JSON.stringify($scope.provincia)
        },
        beforeSend: function (xhr) 
        {
            $scope.cargando = true;
        },
        success: function (resultado, textStatus, jqXHR) 
        {
            console.log("res WS -> guardarProvincia : " + resultado);
            $scope.cargando = false;
            guardo = resultado;
            
            if(guardo)
            {
                $scope.snack("Guardado con exito!");
                $scope.findProvincias();
            }
            $scope.$evalAsync();
        }

    });
    
    return guardo;
}
//AJAX GET
$scope.provincia = {};
$scope.getProvincia = function(idProvincia)
{
   $scope.cargando = false;
   $.ajax(
   {
       url:"../../getProvincia",
       async: false,
       data:
       {
            "idProvincia":idProvincia
       },
       beforeSend: function (xhr) 
       {
           $scope.cargando = true;
       },
       success: function (resultado, textStatus, jqXHR) 
       {
           $scope.provincia = resultado;
           $scope.cargando = false;
           $scope.$evalAsync();
       }
   });
}

//AJAX GET - EMPTY
$scope.provinciaEmpty = {};
$scope.getProvinciaEmpty = function()
{
   $scope.cargando = false;
   $.ajax(
   {
       url:"../../getProvinciaEmpty",
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
           $scope.provinciaEmpty = resultado;
           $scope.cargando = false;
           $scope.$evalAsync();
       }
   });
}
//VALIDAR
$scope.validarProvincia = function()
{
   $scope.todoOK = false;
   $scope.comprobarNombre = $scope.provincia.nombre != null && $scope.provincia.nombre.length > 1;
   if($scope.comprobarNombre)
   {
       $scope.provincia.nombre = $scope.pasaraMayusPrimerLetra($scope.provincia.nombre);
       $scope.$evalAsync();
   }
   
   //COMPROBACION FINAL
   if( $scope.comprobarNombre )
   {
       console.log("TODO VALIDADO");
       $scope.todoOK = true;
       $scope.$evalAsync();
   }
		
}
