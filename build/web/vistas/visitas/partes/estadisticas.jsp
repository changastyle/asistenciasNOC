<div class="contenedor-de-contador-hash col-xs-12 ">
    
    
    <!-- CONTADORES DE HASHTASGS: -->
    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4" ng-repeat="contador in mesConVisitas.contadorHashtagMesList">
        <div class="item-contador-hash col-xs-12">
            {{contador.hashtag.hash}}
            <br>
            <div class="cantidad-clicks">
                {{contador.contador}} CLICK
                <span ng-show="contador.contador > 1">
                    S
                </span>
            </div>
            <div class="porcentaje-click">
                {{ ((contador.contador / mesConVisitas.contadoresDelMes) * 100) | number : 0}} %
            </div>
        </div>
    </div>
    
</div>
<style>
    .contenedor-de-contador-hash
    {
        background-color: lightgrey;
        padding: 25px;
        margin-bottom: 25px;
    }
    .item-contador-hash
    {
        background-color: white;
        text-align: center;
        margin-bottom: 25px;
        font-size: 24px;
        font-weight: bold;
        padding: 25px;
    }
    .cantidad-clicks
    {
        color: #e74c3c;
        font-size: 24px;
        font-weight: bold;
    }
    .porcentaje-click
    {
        color: #1abc9c;
        font-size: 24px;
        font-weight: bold;
    }
</style>