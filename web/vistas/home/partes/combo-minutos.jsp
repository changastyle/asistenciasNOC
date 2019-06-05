<div class="col-xs-3 sin-padding">
    
    <div class="col-xs-12 sin-padding form-group">
        <label>Tiempo Destinado</label>
        <select id="combo-minutos" class="combos form-control" ng-model="minutosSelected">
            <option value="{{min}}"  ng-repeat="min in arrMinutos" >{{min.valorMostrable}}</option>
        </select>
    </div>
    <!--{{minutosSelected}}-->
</div>