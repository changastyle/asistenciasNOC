<div class="seccion-persona-provincia col-xs-12 sin-padding">
    <div class="col-xs-12 sin-padding form-group">
        <label>Persona</label>
        <select class="combos form-control"  ng-model="personaSelected">
            <optgroup label="{{provincia.nombre}}" ng-repeat="provincia in arrProvincias">
                <option value="{{persona}}"  ng-repeat="persona in provincia.personasList">{{persona.nombre}}</option>
            </optgroup>
        </select>
    </div>
<!--    
         PERSONA: 
        <div class="form-group">
            <label>Persona</label>

             COMBO PROVINCIA: 
            <div class="ui fluid search selection dropdown">
            <input ng-model="provinciaSelected">
                <i class="dropdown icon" ></i>
                <div class="default text">
                    Seleccionar Persona
                </div>

                <div class="menu" >
                    <div class="scrolling menu" ng-repeat="provincia in arrProvincias">
                        <div class="header" >
                            {{provincia.nombre}}
                        </div>
                        <div class="divider"></div>
                        <div class="item" ng-repeat="persona in provincia.personasList" ng-click="seleccionarPersona(persona)">
                            <i class="af flag"></i>
                            {{persona.nombre}}
                        </div>
                    </div>
                </div>
            </div>
            <br>
            {{personaSelected}}
        </div>
    </div>
</div>-->

<!--
<div class="seccion-persona-provincia col-xs-12 sin-padding">
    <div class="col-xs-12 sin-padding">
    
         PERSONA: 
        <div class="form-group">
            <label>Persona 2</label>
            
            <select class="selectpicker show-tick form-control" ng-model="tuVieja" data-live-search="true">
                <optgroup label="t" data-subtext="optgroup subtext" ng-repeat="provincia in arrProvincias">
                    <option value="{{persona}}" ng-repeat="persona in provincia.personasList">
                        {{persona.nombre}}
                    </option>
                </optgroup>
            </select>
        </div>
        {{tuVieja}}
    </div>
</div>-->

<style>
    .seccion-persona-provincia
    {
        margin-top: 25px;
    }
</style>