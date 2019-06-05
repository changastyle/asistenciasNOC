<div class="col-xs-9 sin-padding-left">
    
    <div class="col-xs-12 sin-padding form-group">
        <label>Motivo</label>
        <select class="combos form-control" ng-model="motivoSelected">
            <!--<optgroup label="{{provincia.nombre}}" >ng-repeat="motivo in arrMotivos"-->
                <option value="{{motivo}}"  ng-repeat="motivo in arrMotivos">{{motivo.motivo}}</option>
            <!--</optgroup>-->
        </select>
    </div>
    {{motivoSelected}}
</div>