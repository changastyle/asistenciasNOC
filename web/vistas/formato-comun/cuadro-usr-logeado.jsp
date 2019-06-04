<!-- 9 - CUADRO CON DATOS DEL USUARIO LOGEADO: -->
<div class="cuadro-usr-logeado hidden-xs " ng-hide="usuarioLogeado.id == -1" ng-click="activarPanelOpciones()" ><!--col-xs-12-->

    <!-- IMG MINIATURA:-->
    <div class="img-operador-miniatura img img-circle " style="background-image:url('{{usuarioLogeado.img}}')">
    </div>

    <!--<img ng-src="{{usuarioLogeado.img}}" class="img-usr-logeado img img-circle">-->
    <div class="h-usr-logeado hidden-sm hidden-xs">
        {{usuarioLogeado.nombre}} {{ usuarioLogeado.apellido}}
    </div>
    <span class="glyphicon glyphicon-menu-down" ></span>
</div>
<style>
    .cuadro-usr-logeado
    {
        cursor: pointer;
        display: inline-block;
        text-align: center;
        padding-left: 12px;
        padding-right: 12px;
        margin-right: 50px;
        //border: solid 1px red;
    }
    .img-operador-miniatura
    {
        background-size: cover;
        background-position: center center;
        background-repeat: no-repeat;
        height: 30px;
        width: 30px;
        display: inline-block;
    }
    .h-usr-logeado
    {
        display: inline-block;
        font-size: 24px;
        text-align: center;
        //border: solid 1px red;
    }
</style>


<!-- PANEL OPCIONES USUARIO DROPDOWN: -->
<div class="panel-dropdown-usuario col-md-3 col-lg-3 " ng-show="panelOpcionesActivo">

    <div class="col-xs-12">

        <!-- LADO IZQ PANEL DROPDOWN:-->
        <div class="col-xs-12 sin-padding " >


            <!-- UPLOAD IMG-PERFIL: -->
            <form id="formulario-upload-foto-perfil" class="col-xs-12 sin-padding" enctype="multipart/form-data" method="POST">

                <!-- UP3: INPUT FILE:-->
                <input type="file" name="foto" style="display: none;" id="input-upload-foto-perfil" class="inputs-upload-foto-perfil"
                       ng-model="usuarioLogeado.img"

                       accept="image/jpg,image/jpeg">

                <label class="col-xs-12" id='lbl-foto-perfil' for="input-upload-foto-perfil" 
                       ng-click='uploadFotoPerfil("formulario-upload-foto-perfil")'>

                    <div class="img-operador img img-circle center-block" style="background-image:url('{{usuarioLogeado.img}}')">
                    </div>
                    
                </label>
            </form>


            <hr class="hr" style="margin-top: 5px; margin-bottom: 5px;">
            <div class="h-usr-logeado-abajo" style="text-align: center;">{{usuarioLogeado.nombre}} {{ usuarioLogeado.apellido}}</div>
            <h5 class="" style="color: grey;text-align: center;">Operador</h5>
        </div>

        <!-- LADO DER PANEL DROPDOWN:-->
        <div class=" col-xs-12 sin-padding" >
            <!--<h3 style="color: grey;margin-bottom:0px;">Acciones</h3>-->
            <hr class="hr" style="margin-top:5px;margin-bottom: 15px;">
            <ul class="list-group" style="color: black">
                <li class="list-group-item" ng-click="abrirModalCambiarContrasena()">
                    <span class="glyphicon glyphicon-asterisk"></span>
                    Cambiar contraseña
                </li>
                <li class="list-group-item" ng-click="ayuda()">
                    <span class="glyphicon glyphicon-flag"></span>
                    Ayuda
                </li>
                <li class="list-group-item" ng-click="exit()">
                    <span class="glyphicon glyphicon-scissors"></span>
                    Salir
                </li>
            </ul>
        </div>
    </div>            
</div>