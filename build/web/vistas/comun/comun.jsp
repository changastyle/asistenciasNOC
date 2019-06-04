<meta name="viewport" content="width=device-width, user-scalable=no">
<meta name="theme-color" content="#F38F1F">
<!--<meta name="theme-color" content="#2c3e50">-->

<!-- FAVICON : -->
<link rel="icon" href="../res/img/help.png" />

<!-- CDN LOCAL:-->
<link rel="stylesheet" href="../res/cdn/bootstrap.min.css">
<script src="../res/cdn/jquery.min.js"></script>
<script src="../res/cdn/bootstrap.min.js"></script>
<script src="../res/cdn/angular.min.js"></script>

<!-- CDN REMOTO: -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

<!-- FRAMEWORKS: -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.3.1/dist/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/fomantic-ui@2.7.5/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/fomantic-ui@2.7.5/dist/semantic.min.js"></script>


<!-- FONTS:-->
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<link rel="stylesheet" href='../res/fonts/fuentes.css'>
<link rel="stylesheet" href='../res/frameworks/animate.css'>
<link rel="stylesheet" href='../res/css/snackbar.css'>
<link href="https://fonts.googleapis.com/css?family=Raleway:400,600,700" rel="stylesheet">

<link rel="stylesheet" href="../res/colores/colores.css">

<style>
    .head
    {
        font-weight: bold;
        text-align: center;
        font-family: 'Montserrat', sans-serif;
    }
    .btn-bold
    {
        font-weight: bold;
    }
    .sin-padding
    {
        padding-left:0px;
        padding-right: 0px;
    }
    .sin-padding-left
    {
        padding-left:0px;
    }
    .sin-padding-right
    {
        padding-right: 0px;
    }
    .transparencia
    {
        background-color: rgba(0,0,0,0.25);
        margin-top:0px;
        margin-left: 0px;
        margin-right: 0px;
        position: absolute;
        top:0px;
        left: 0px;
        right: 0px;
        bottom: 0px;
        height: 100%;
        width: 100%;
    }
    .btn-redondito
    {
        border-radius: 25px;
    }
    .izq
    {
        text-align: left;
    }
    .der
    {
        text-align: right;
    }
</style>
<style>
    *
    {
        font-family: 'Montserrat', sans-serif;
    }
    .sin-padding
    {
        padding-left: 0px;
        padding-right: 0px;
    }
    .sin-padding-left
    {
       padding-left: 0px; 
    }
    .sin-padding-right
    {
        padding-right: 0px;
    }
    .hr
    {
        display: block;
        height: 1px;
        border: 0;
        border-top: 1px solid lightgrey;
        margin: 1em 0;
        padding: 0; 
    }
    .contenedor-img-cargando
    {
        background-color: white;
        border-radius: 6px;
        border-radius: solid 1px grey;
        padding: 12px;
    }
    .h-cargando
    {
        
        text-align: center;
    }
    .verde , .verde:hover
    {
        color: #1abc9c;
    }
    .bold
    {
        font-weight: bold;
    }
    .bg-verde , .bg-verde:hover
    {
        background-color: #1abc9c;
        cursor: pointer;
        border: solid 1px #1abc9c;
    }
    .azul
    {
        color: blue;
    }
    .rojo , .rojo:hover
    {
        color: red;
    }
    .bg-rojo , .bg-rojo:hover
    {
        background-color: red;
        cursor: not-allowed;
        border: solid 1px red;
    }
    .amarillo
    {
        color: #f1c40f;
    }
    .contenido
    {
        //z-index: -1;
        //left: 100px;
        //left: 100px;
        top: 50px;
        position: absolute;
        //width: 100%;;
        //width: calc(100% - 100px);
        //height: calc(100% - 50px);
        padding: 25px;
        //border: solid 1px yellow;

    }
    .contenido-ampliado
    {
        width: 100%;
        margin-left: 0px;
        transition: 1s;
    }
    .contenido-achicado
    {
        width: calc(100% - 100px);
        margin-left: 100px;
        transition: 1s;
    }
    .center
    {
        text-align: center;
    }
    .yellow
    {
        color: #f39c12;
    }
</style>
<style>
    .h-separador-2
    {
        margin-top: 0px;
        margin-bottom: 12px;
        height: 50px;
        overflow: hidden;
        padding: 0px;
        //border: solid 1px red;
    }
    .campo-0-h-separador-2
    {
        background-color: #14967C;
        color: white;
        text-align: center;
        font-weight: bold;
        padding: 12px;
        font-size: 24px;
        cursor:pointer;
        height: 50px;
    }
    .campo-1-h-separador-2
    {
        background-color: var(--verde);
        color: white;
        text-align: left;
        font-weight: bold;
        padding: 12px;
        font-size: 24px;
        cursor:pointer;
        overflow: hidden;
        text-overflow: ellipsis;
        word-wrap: break-word;
        height: 50px;
    }
    .campo-2-h-separador-2
    {
        background-color: #14967C;
        color: white;
        text-align: center;
        font-weight: bold;
        padding: 12px;
        font-size: 24px;
        overflow: hidden;
        text-overflow: ellipsis;
        word-wrap: break-word;
        height: 50px;
    }
    .campo-2-h-separador-2-rojo
    {
        background-color: var(--rojo);
        color: white;
        text-align: center;
        font-weight: bold;
        padding: 12px;
        font-size: 24px;
        overflow: hidden;
        text-overflow: ellipsis;
        word-wrap: break-word;
        height: 50px;
    }
    .campo-2-h-separador-2-verde
    {
        background-color: #14967C;
        color: white;
        text-align: center;
        font-weight: bold;
        padding: 12px;
        font-size: 24px;
        overflow: hidden;
        text-overflow: ellipsis;
        word-wrap: break-word;
        height: 50px;
    }
</style>